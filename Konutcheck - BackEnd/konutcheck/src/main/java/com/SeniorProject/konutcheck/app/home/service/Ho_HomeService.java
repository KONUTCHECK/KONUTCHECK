package com.SeniorProject.konutcheck.app.home.service;

import com.SeniorProject.konutcheck.app.home.converter.GeneralHomeInfoMapperConverter;
import com.SeniorProject.konutcheck.app.home.converter.Ho_HomeMapperConverter;
import com.SeniorProject.konutcheck.app.home.dto.*;
import com.SeniorProject.konutcheck.app.home.entity.GeneralHomeInfo;
import com.SeniorProject.konutcheck.app.home.entity.Ho_Home;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import com.SeniorProject.konutcheck.app.home.service.entityService.GeneralHomeInfoEntityService;
import com.SeniorProject.konutcheck.app.home.service.entityService.Ho_HomeEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Ho_HomeService {
    private final Ho_HomeEntityService hoHomeEntityService;
    private final GeneralHomeInfoEntityService generalHomeInfoEntityService;

    public Ho_HomeDto saveHome(Ho_HomeSaveDto hoHomeSaveDto){
        isGeneralHomeInfosExist(hoHomeSaveDto);
        Ho_Home hoHome= Ho_HomeMapperConverter.INSTANCE.convertToHoHomeFromHoHomeSaveDto(hoHomeSaveDto);
        hoHome.setAnnouncementDate(LocalDate.now());
        hoHome = hoHomeEntityService.save(hoHome);

        Ho_HomeDto hoHomeDto = Ho_HomeMapperConverter.INSTANCE.convertToHoHomeDtoFromHoHome(hoHome);
        return hoHomeDto;
   }

    public GeneralHomeInfoDto saveHomeInfos(GeneralHomeInfoSaveDto generalHomeInfoSaveDto){
        validationOfGeneralHomeInfos(generalHomeInfoSaveDto);
        GeneralHomeInfo generalHomeInfo = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoFromGeneralHomeInfoSaveDto(generalHomeInfoSaveDto);
        generalHomeInfo = generalHomeInfoEntityService.save(generalHomeInfo);

        GeneralHomeInfoDto generalHomeInfoDto = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoFromGeneralHomeInfo(generalHomeInfo);
        return generalHomeInfoDto;
    }

   public List<Ho_HomeDetails> getAllHomes(){
        List<Ho_HomeDetails> homeDetailsList = hoHomeEntityService.getAllHomes();
        return homeDetailsList;
   }

    public List<Ho_HomeDetails> getAllHomesByHomeType(HomeTypes homeType){
        List<Ho_HomeDetails> homeDetailsList = generalHomeInfoEntityService.findByHomeType(homeType);
        return homeDetailsList;
    }

    public List<Ho_HomeDetails> getAllHomesBetweenDate(LocalDate date1, LocalDate date2){
        List<Ho_HomeDetails> homeDetailsList = hoHomeEntityService.findByAnnouncementDateBetween(date1, date2);
        return homeDetailsList;
    }

    public List<Ho_HomeDetails> getAllHomesBetweenAmount(BigDecimal firstAmount, BigDecimal secondAmount){
        List<Ho_HomeDetails> homeDetailsList = generalHomeInfoEntityService.findByBetweenAmount(firstAmount, secondAmount);
        return homeDetailsList;
    }

    public GeneralHomeInfoDto updateHomeInfos(GeneralHomeInfoDto generalHomeInfoDto){
        Long id = generalHomeInfoDto.getId();
        Boolean isExist = generalHomeInfoEntityService.existById(id);

        GeneralHomeInfo generalHomeInfo;
        if(isExist){
            generalHomeInfo = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoFromGeneralHomeInfoDto(generalHomeInfoDto);
            generalHomeInfo = generalHomeInfoEntityService.save(generalHomeInfo);
        }else{
            throw new RuntimeException("Home ınfos not found");
        }

        GeneralHomeInfoDto generalHomeInfoDtoUpdate = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoFromGeneralHomeInfo(generalHomeInfo);
        return generalHomeInfoDtoUpdate;
    }
   public void deleteHome(Long id){
        Ho_Home hoHome = hoHomeEntityService.getIdWithControl(id);
        GeneralHomeInfo generalHomeInfo = generalHomeInfoEntityService.getIdWithControl(hoHome.getGeneralHomeInfoId());
        generalHomeInfoEntityService.delete(generalHomeInfo);
        hoHomeEntityService.delete(hoHome);
   }

   private boolean isGeneralHomeInfosExist(Ho_HomeSaveDto hoHomeSaveDto){
        Long id = hoHomeSaveDto.getGeneralHomeInfoId();
        Boolean isExist = generalHomeInfoEntityService.existById(id);

        if(isExist){
            return true;
        }else{
            throw new RuntimeException("Home infos not found!");
        }
   }

   private boolean validationOfGeneralHomeInfos(GeneralHomeInfoSaveDto generalHomeInfoSaveDto){
        BigDecimal amount = generalHomeInfoSaveDto.getAmount();
        BigDecimal deposit = generalHomeInfoSaveDto.getDeposit();
        BigDecimal dues = generalHomeInfoSaveDto.getDues();
        int floor = generalHomeInfoSaveDto.getFloor();
        BigDecimal homeSize = generalHomeInfoSaveDto.getHomeSize();

        if(amount.compareTo(BigDecimal.ZERO) < 0 || deposit.compareTo(BigDecimal.ZERO) < 0 || dues.compareTo(BigDecimal.ZERO) < 0 || floor < 0 || homeSize.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Cannot be negative");
        }else{
            return true;
        }
   }

}
