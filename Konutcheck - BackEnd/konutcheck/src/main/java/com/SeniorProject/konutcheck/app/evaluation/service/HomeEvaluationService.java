package com.SeniorProject.konutcheck.app.evaluation.service;

import com.SeniorProject.konutcheck.app.evaluation.converter.EvaluationMapperConverter;
import com.SeniorProject.konutcheck.app.evaluation.dto.*;
import com.SeniorProject.konutcheck.app.evaluation.entity.HomeEvaluation;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.HomeEvaluationEntityService;
import com.SeniorProject.konutcheck.app.general.exceptionEnums.GeneralErrorMessage;
import com.SeniorProject.konutcheck.app.general.exceptions.InvalidInformationExceptions;
import com.SeniorProject.konutcheck.app.home.service.entityService.Ho_HomeEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeEvaluationService {
    private final HomeEvaluationEntityService homeEvaluationEntityService;
    private final Ho_HomeEntityService homeEntityService;

    public List<GetTotalPoint> getTotalPointOfHome(Long id){
        List<GetTotalPoint> getTotalPointList = homeEvaluationEntityService.getTotalPoint(id);
        return getTotalPointList;
    }

    public HomeEvaluationDto saveHomeEvaluation(HomeEvaluationSaveDto homeEvaluationSaveDto) {
        HomeEvaluation homeEvaluation = EvaluationMapperConverter.INSTANCE.convertToHomeEvaluationFromHomeEvaluationSaveDto(homeEvaluationSaveDto);
        validationOfHomeId(homeEvaluationSaveDto);
        homeEvaluation.setHomePoint(calculateHomeSinglePoint(homeEvaluationSaveDto));
        homeEvaluation = homeEvaluationEntityService.save(homeEvaluation);
        HomeEvaluationDto homeEvaluationDto = EvaluationMapperConverter.INSTANCE.convertToHomeEvaluationDtoFromHomeEvaluation(homeEvaluation);
        return homeEvaluationDto;
    }

    private BigDecimal calculateHomeSinglePoint(HomeEvaluationSaveDto homeEvaluationSaveDto) {
        validationGradeOfHomeCleaning(homeEvaluationSaveDto);
        int gradeOfHomeCleaning = homeEvaluationSaveDto.getGradeOfHomeCleaning();

        validationGradeOfHomeReality(homeEvaluationSaveDto);
        int gradeOfHomeReality = homeEvaluationSaveDto.getGradeOfHomeReality();

        validationGradeOfHomeModification(homeEvaluationSaveDto);
        int gradeOfHomeModification = homeEvaluationSaveDto.getGradeOfHomeModification();

        validationGradeOfNetworkInfrastructure(homeEvaluationSaveDto);
        int gradeOfNetworkInfrastructure = homeEvaluationSaveDto.getGradeOfNetworkInfrastructure();

        validationGradeOfPhoneInfrastructure(homeEvaluationSaveDto);
        int gradeOfPhoneInfrastructure = homeEvaluationSaveDto.getGradeOfPhoneInfrastructure();

        validationGradeOfHomeEnvironment(homeEvaluationSaveDto);
        int gradeOfHomeEnvironment = homeEvaluationSaveDto.getGradeOfHomeEnvironment();

        validationGradeOfHomeNeighborliness(homeEvaluationSaveDto);
        int gradeOfHomeNeighborliness = homeEvaluationSaveDto.getGradeOfHomeNeighborliness();

        validationGradeOfHomeClosenessToSomewhere(homeEvaluationSaveDto);
        int gradeOfHomeClosenessToSomewhere= homeEvaluationSaveDto.getGradeOfHomeClosenessToSomewhere();

        int sum = gradeOfHomeCleaning + gradeOfHomeReality + gradeOfHomeModification + gradeOfNetworkInfrastructure + gradeOfPhoneInfrastructure +gradeOfHomeEnvironment+gradeOfHomeNeighborliness+ gradeOfHomeClosenessToSomewhere;
        BigDecimal singlePoint = BigDecimal.valueOf(sum / 8);
        return singlePoint;
    }

    private Boolean validationOfHomeId(HomeEvaluationSaveDto homeEvaluationSaveDto){
        GetHomeIdDto homeId = homeEvaluationEntityService.getHomeId(homeEvaluationSaveDto.getHomeId());
        Boolean isHomeIdExist = homeEntityService.existById(homeId.getHomeId());

        if(isHomeIdExist){
            return true;
        }else {
            throw new InvalidInformationExceptions(GeneralErrorMessage.ID_NOT_MATCH);
        }
    }

    private Boolean validationGradeOfHomeCleaning(HomeEvaluationSaveDto homeEvaluationSaveDto){
        if(homeEvaluationSaveDto.getGradeOfHomeCleaning() > 0 && homeEvaluationSaveDto.getGradeOfHomeCleaning() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfHomeReality(HomeEvaluationSaveDto homeEvaluationSaveDto){
        if(homeEvaluationSaveDto.getGradeOfHomeReality() > 0 && homeEvaluationSaveDto.getGradeOfHomeReality() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfHomeModification(HomeEvaluationSaveDto homeEvaluationSaveDto){
        if(homeEvaluationSaveDto.getGradeOfHomeModification() > 0 && homeEvaluationSaveDto.getGradeOfHomeModification() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfNetworkInfrastructure(HomeEvaluationSaveDto homeEvaluationSaveDto){
        if(homeEvaluationSaveDto.getGradeOfNetworkInfrastructure() > 0 && homeEvaluationSaveDto.getGradeOfNetworkInfrastructure() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfPhoneInfrastructure(HomeEvaluationSaveDto homeEvaluationSaveDto){
        if(homeEvaluationSaveDto.getGradeOfPhoneInfrastructure() > 0 && homeEvaluationSaveDto.getGradeOfPhoneInfrastructure() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfHomeEnvironment(HomeEvaluationSaveDto homeEvaluationSaveDto){
        if(homeEvaluationSaveDto.getGradeOfHomeEnvironment() > 0 && homeEvaluationSaveDto.getGradeOfHomeEnvironment() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfHomeNeighborliness(HomeEvaluationSaveDto homeEvaluationSaveDto){
        if(homeEvaluationSaveDto.getGradeOfHomeNeighborliness() > 0 && homeEvaluationSaveDto.getGradeOfHomeNeighborliness() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfHomeClosenessToSomewhere(HomeEvaluationSaveDto homeEvaluationSaveDto){
        if(homeEvaluationSaveDto.getGradeOfHomeClosenessToSomewhere() > 0 && homeEvaluationSaveDto.getGradeOfHomeClosenessToSomewhere() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

}
