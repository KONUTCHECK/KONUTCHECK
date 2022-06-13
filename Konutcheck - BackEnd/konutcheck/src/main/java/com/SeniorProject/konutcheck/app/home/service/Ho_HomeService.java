package com.SeniorProject.konutcheck.app.home.service;

import com.SeniorProject.konutcheck.app.evaluation.entity.HomeEvaluation;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.HomeEvaluationEntityService;
import com.SeniorProject.konutcheck.app.general.exceptionEnums.GeneralErrorMessage;
import com.SeniorProject.konutcheck.app.general.exceptions.InvalidInformationExceptions;
import com.SeniorProject.konutcheck.app.general.exceptions.ItemNotFoundExceptions;
import com.SeniorProject.konutcheck.app.home.converter.GeneralHomeInfoMapperConverter;
import com.SeniorProject.konutcheck.app.home.dto.*;
import com.SeniorProject.konutcheck.app.home.entity.GeneralHomeInfo;
import com.SeniorProject.konutcheck.app.home.enums.Cities;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import com.SeniorProject.konutcheck.app.home.service.entityService.GeneralHomeInfoEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Ho_HomeService {
    private final GeneralHomeInfoEntityService generalHomeInfoEntityService;

    public GeneralHomeInfoDto saveHomeInfos(GeneralHomeInfoSaveDto generalHomeInfoSaveDto){
        validationOfGeneralHomeInfos(generalHomeInfoSaveDto);
        GeneralHomeInfo generalHomeInfo = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoFromGeneralHomeInfoSaveDto(generalHomeInfoSaveDto);
        generalHomeInfo.setAnnouncementDate(LocalDate.now());
        generalHomeInfo.setHomeOwner(generalHomeInfoEntityService.getCurrentUser());
        generalHomeInfo = generalHomeInfoEntityService.save(generalHomeInfo);

        GeneralHomeInfoDto generalHomeInfoDto = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoFromGeneralHomeInfo(generalHomeInfo);
        return generalHomeInfoDto;
    }

    public GeneralHomeInfoDto findById(Long id){
        GeneralHomeInfo generalHomeInfo = generalHomeInfoEntityService.getIdWithControl(id);
        GeneralHomeInfoDto generalHomeInfoDto = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoFromGeneralHomeInfo(generalHomeInfo);
        return generalHomeInfoDto;
    }

    public List<GeneralHomeInfoDto> getAllHomes(){
        List<GeneralHomeInfo> generalHomeInfos = generalHomeInfoEntityService.findAll();
        List<GeneralHomeInfoDto> generalHomeInfoDtoList = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoListFromGeneralHomeInfoList(generalHomeInfos);
        return generalHomeInfoDtoList;
    }

    public List<GeneralHomeInfoDto> gelAllHomesByHomeOwner(){
        Long houseOwnerId = generalHomeInfoEntityService.getCurrentUser();
        List<GeneralHomeInfo> generalHomeInfos = generalHomeInfoEntityService.findAllByHomeOwner(houseOwnerId);
        List<GeneralHomeInfoDto> generalHomeInfoDtoList = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoListFromGeneralHomeInfoList(generalHomeInfos);
        return generalHomeInfoDtoList;
    }

    public List<GeneralHomeInfoDto> getAllHomesByHomeType(HomeTypes homeType){
        List<GeneralHomeInfo> homeDetailsList = generalHomeInfoEntityService.findByHomeType(homeType);
        List<GeneralHomeInfoDto> generalHomeInfoDtoList = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoListFromGeneralHomeInfoList(homeDetailsList);
        return generalHomeInfoDtoList;
    }

    public List<GeneralHomeInfoDto> getAllHomesBetweenDate(LocalDate date1, LocalDate date2){
        List<GeneralHomeInfo> homeDetailsList = generalHomeInfoEntityService.findByAnnouncementDateBetween(date1, date2);
        List<GeneralHomeInfoDto> generalHomeInfoDtoList = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoListFromGeneralHomeInfoList(homeDetailsList);
        return generalHomeInfoDtoList;
    }

    public List<GeneralHomeInfoDto> getAllHomesBetweenAmount(BigDecimal firstAmount, BigDecimal secondAmount){
        List<GeneralHomeInfo> homeDetailsList = generalHomeInfoEntityService.findByBetweenAmount(firstAmount, secondAmount);
        List<GeneralHomeInfoDto> generalHomeInfoDtoList = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoListFromGeneralHomeInfoList(homeDetailsList);
        return generalHomeInfoDtoList;
    }

    public List<GeneralHomeInfoDto> getAllHomesByCity(Cities city){
        List<GeneralHomeInfo> homeDetailsList = generalHomeInfoEntityService.findByCity(city);
        List<GeneralHomeInfoDto> generalHomeInfoDtoList = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoListFromGeneralHomeInfoList(homeDetailsList);
        return generalHomeInfoDtoList;
    }

    public List<GeneralHomeInfoDto> getAllHomesByCityAndDistrict(Cities city, String district){
        List<GeneralHomeInfo> homeDetailsList = generalHomeInfoEntityService.findByCityAndDistrict(city, district);
        List<GeneralHomeInfoDto> generalHomeInfoDtoList = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoListFromGeneralHomeInfoList(homeDetailsList);
        return generalHomeInfoDtoList;
    }

    public List<GeneralHomeInfoDto> getAllHomesByCityAndDistrictAndNeighborhood(Cities city, String district, String neighborhood){
        List<GeneralHomeInfo> homeDetailsList = generalHomeInfoEntityService.findByCityAndDistrictAndNeighborHood(city, district, neighborhood);
        List<GeneralHomeInfoDto> generalHomeInfoDtoList = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoListFromGeneralHomeInfoList(homeDetailsList);
        return generalHomeInfoDtoList;
    }

    public List<GeneralHomeInfoDto> getAllHomesByCityAndDistrictAndNeighborhoodAndStreet(Cities city, String district, String neighborhood, String street){
        List<GeneralHomeInfo> homeDetailsList = generalHomeInfoEntityService.findByCityAndDistrictAndNeighborHoodAndStreet(city, district, neighborhood, street);
        List<GeneralHomeInfoDto> generalHomeInfoDtoList = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoListFromGeneralHomeInfoList(homeDetailsList);
        return generalHomeInfoDtoList;
    }


    public GeneralHomeInfoDto updateHomeInfos(GeneralHomeInfoDto generalHomeInfoDto){
        Long id = generalHomeInfoDto.getId();
        Boolean isExist = generalHomeInfoEntityService.existById(id);

        GeneralHomeInfo generalHomeInfo;
        if(isExist){
            generalHomeInfo = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoFromGeneralHomeInfoDto(generalHomeInfoDto);
            generalHomeInfo.setAnnouncementDate(LocalDate.now());
            generalHomeInfo.setHomeOwner(generalHomeInfoEntityService.getCurrentUser());
            generalHomeInfo = generalHomeInfoEntityService.save(generalHomeInfo);
        }else{
            throw new ItemNotFoundExceptions(GeneralErrorMessage.HOME_INFOS_NOT_FOUND);
        }

        GeneralHomeInfoDto generalHomeInfoDtoUpdate = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoFromGeneralHomeInfo(generalHomeInfo);
        return generalHomeInfoDtoUpdate;
    }

    public void deleteHome(Long id){
        GeneralHomeInfo generalHomeInfo = generalHomeInfoEntityService.getIdWithControl(id);
        generalHomeInfoEntityService.delete(generalHomeInfo);
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
