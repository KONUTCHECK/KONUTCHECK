package com.SeniorProject.konutcheck.app.home.service;

import com.SeniorProject.konutcheck.app.general.exceptionEnums.GeneralErrorMessage;
import com.SeniorProject.konutcheck.app.general.exceptions.InvalidInformationExceptions;
import com.SeniorProject.konutcheck.app.general.exceptions.ItemNotFoundExceptions;
import com.SeniorProject.konutcheck.app.home.converter.GeneralHomeInfoMapperConverter;
import com.SeniorProject.konutcheck.app.home.converter.Ho_HomeMapperConverter;
import com.SeniorProject.konutcheck.app.home.dto.*;
import com.SeniorProject.konutcheck.app.home.entity.GeneralHomeInfo;
import com.SeniorProject.konutcheck.app.home.entity.Ho_Home;
import com.SeniorProject.konutcheck.app.home.entity.HomeAddress;
import com.SeniorProject.konutcheck.app.home.enums.Cities;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import com.SeniorProject.konutcheck.app.home.service.entityService.GeneralHomeInfoEntityService;
import com.SeniorProject.konutcheck.app.home.service.entityService.Ho_HomeEntityService;
import com.SeniorProject.konutcheck.app.home.service.entityService.HomeAddressEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Ho_HomeService {
    private final Ho_HomeEntityService hoHomeEntityService;
    private final GeneralHomeInfoEntityService generalHomeInfoEntityService;
    private final HomeAddressEntityService homeAddressEntityService;

    public Ho_HomeDto saveHome(Ho_HomeSaveDto hoHomeSaveDto){
        isGeneralHomeInfosExist(hoHomeSaveDto);
        isHomeAddressExist(hoHomeSaveDto);
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

    public HomeAddressDto saveHomeAddress(HomeAddressSaveDto homeAddressSaveDto){
        HomeAddress homeAddress = Ho_HomeMapperConverter.INSTANCE.convertToHomeAddressFromHomeAddressSaveDto(homeAddressSaveDto);
        homeAddress = homeAddressEntityService.save(homeAddress);

        HomeAddressDto homeAddressDto = Ho_HomeMapperConverter.INSTANCE.convertToHomeAddressDtoFromHomeAddress(homeAddress);
        return homeAddressDto;
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

    public List<Ho_HomeDetails> getAllHomesByCity(Cities city){
        List<Ho_HomeDetails> homeDetailsList = homeAddressEntityService.findByCity(city);
        return homeDetailsList;
    }

    public List<Ho_HomeDetails> getAllHomesByCityAndDistrict(Cities city, String district){
        List<Ho_HomeDetails> homeDetailsList = homeAddressEntityService.findByCityAndDistrict(city, district);
        return homeDetailsList;
    }

    public List<Ho_HomeDetails> getAllHomesByCityAndDistrictAndNeighborhood(Cities city, String district, String neighborhood){
        List<Ho_HomeDetails> homeDetailsList = homeAddressEntityService.findByCityAndDistrictAndNeighborHood(city, district, neighborhood);
        return homeDetailsList;
    }

    public List<Ho_HomeDetails> getAllHomesByCityAndDistrictAndNeighborhoodAndStreet(Cities city, String district, String neighborhood, String street){
        List<Ho_HomeDetails> homeDetailsList = homeAddressEntityService.findByCityAndDistrictAndNeighborHoodAndStreet(city, district, neighborhood, street);
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
            throw new ItemNotFoundExceptions(GeneralErrorMessage.HOME_INFOS_NOT_FOUND);
        }

        GeneralHomeInfoDto generalHomeInfoDtoUpdate = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoFromGeneralHomeInfo(generalHomeInfo);
        return generalHomeInfoDtoUpdate;
    }

    public void deleteHome(Long id){
        Ho_Home hoHome = hoHomeEntityService.getIdWithControl(id);
        GeneralHomeInfo generalHomeInfo = generalHomeInfoEntityService.getIdWithControl(hoHome.getGeneralHomeInfoId());
        HomeAddress homeAddress = homeAddressEntityService.getIdWithControl(hoHome.getHomeAddressId());
        generalHomeInfoEntityService.delete(generalHomeInfo);
        homeAddressEntityService.delete(homeAddress);
        hoHomeEntityService.delete(hoHome);
    }



   private Boolean isGeneralHomeInfosExist(Ho_HomeSaveDto hoHomeSaveDto){
        Long id = hoHomeSaveDto.getGeneralHomeInfoId();
        Boolean isExist = generalHomeInfoEntityService.existById(id);

        if(isExist){
            return true;
        }else{
            throw new ItemNotFoundExceptions(GeneralErrorMessage.HOME_INFOS_NOT_FOUND);
        }
   }

   private Boolean isHomeAddressExist(Ho_HomeSaveDto hoHomeSaveDto){
        Long id = hoHomeSaveDto.getHomeAddressId();
        Boolean isExist = homeAddressEntityService.existById(id);

        if(isExist){
            return true;
        }else{
            throw new ItemNotFoundExceptions(GeneralErrorMessage.HOME_ADDRESS_NOT_FOUND);
        }
   }

   private boolean validationOfGeneralHomeInfos(GeneralHomeInfoSaveDto generalHomeInfoSaveDto){
        BigDecimal amount = generalHomeInfoSaveDto.getAmount();
        BigDecimal deposit = generalHomeInfoSaveDto.getDeposit();
        BigDecimal dues = generalHomeInfoSaveDto.getDues();
        int floor = generalHomeInfoSaveDto.getFloor();
        BigDecimal homeSize = generalHomeInfoSaveDto.getHomeSize();

        if(amount.compareTo(BigDecimal.ZERO) < 0 || deposit.compareTo(BigDecimal.ZERO) < 0 || dues.compareTo(BigDecimal.ZERO) < 0 || floor < 0 || homeSize.compareTo(BigDecimal.ZERO) < 0){
            throw new InvalidInformationExceptions(GeneralErrorMessage.CANNOT_BE_NEGATIVE);
        }else{
            return true;
        }
   }

}
