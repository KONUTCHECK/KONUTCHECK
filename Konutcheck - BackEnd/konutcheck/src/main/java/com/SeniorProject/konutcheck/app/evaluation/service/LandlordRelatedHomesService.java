package com.SeniorProject.konutcheck.app.evaluation.service;

import com.SeniorProject.konutcheck.app.evaluation.converter.UserRelatedHomesMapperConverter;
import com.SeniorProject.konutcheck.app.evaluation.dto.LandlordRelatedHomesDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.LandlordRelatedHomesSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.UserHomeDetails;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordRelatedHomes;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.LandlordRelatedHomesEntityService;
import com.SeniorProject.konutcheck.app.securityGeneral.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LandlordRelatedHomesService {
    private final LandlordRelatedHomesEntityService landlordRelatedHomesEntityService;
    private final AuthenticationService authenticationService;

    public LandlordRelatedHomesDto save(LandlordRelatedHomesSaveDto landlordRelatedHomesSaveDto){
        Long landlordId = authenticationService.getCurrentUserId();
        LandlordRelatedHomes landlordRelatedHomes = UserRelatedHomesMapperConverter.INSTANCE.convertToLandlordRelatedHomesFromLandlordRelatedHomesSaveDto(landlordRelatedHomesSaveDto);
        landlordRelatedHomes.setLandlordId(landlordId);
        landlordRelatedHomes = landlordRelatedHomesEntityService.save(landlordRelatedHomes);

        LandlordRelatedHomesDto landlordRelatedHomesDto = UserRelatedHomesMapperConverter.INSTANCE.convertToLandlordRelatedHomesDtoFromLandlordRelatedHomes(landlordRelatedHomes);
        return landlordRelatedHomesDto;
    }

    public List<UserHomeDetails> getLandlordHomeDetails(Long id){
        List<UserHomeDetails> userHomeDetailsList = landlordRelatedHomesEntityService.getLandlordHomeDetails(id);
        return userHomeDetailsList;
    }
}
