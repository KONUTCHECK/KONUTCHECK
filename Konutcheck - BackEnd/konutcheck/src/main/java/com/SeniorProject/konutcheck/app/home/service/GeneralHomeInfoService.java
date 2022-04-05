package com.SeniorProject.konutcheck.app.home.service;

import com.SeniorProject.konutcheck.app.home.converter.GeneralHomeInfoMapperConverter;
import com.SeniorProject.konutcheck.app.home.dto.GeneralHomeInfoDto;
import com.SeniorProject.konutcheck.app.home.dto.GeneralHomeInfoSaveDto;
import com.SeniorProject.konutcheck.app.home.entity.GeneralHomeInfo;
import com.SeniorProject.konutcheck.app.home.service.entityService.GeneralHomeInfoEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneralHomeInfoService {
    private final GeneralHomeInfoEntityService generalHomeInfoEntityService;

    public GeneralHomeInfoDto saveHomeInfos(GeneralHomeInfoSaveDto generalHomeInfoSaveDto){
        GeneralHomeInfo generalHomeInfo = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoFromGeneralHomeInfoSaveDto(generalHomeInfoSaveDto);
        generalHomeInfo = generalHomeInfoEntityService.save(generalHomeInfo);

        GeneralHomeInfoDto generalHomeInfoDto = GeneralHomeInfoMapperConverter.INSTANCE.convertToGeneralHomeInfoDtoFromGeneralHomeInfo(generalHomeInfo);
        return generalHomeInfoDto;
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

}
