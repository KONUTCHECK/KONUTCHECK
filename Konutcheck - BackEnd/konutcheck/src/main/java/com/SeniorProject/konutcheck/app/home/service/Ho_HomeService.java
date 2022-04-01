package com.SeniorProject.konutcheck.app.home.service;

import com.SeniorProject.konutcheck.app.home.converter.Ho_HomeMapperConverter;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDto;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeSaveDto;
import com.SeniorProject.konutcheck.app.home.entity.Ho_Home;
import com.SeniorProject.konutcheck.app.home.service.entityService.Ho_HomeEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Ho_HomeService {
    private final Ho_HomeEntityService hoHomeEntityService;

    public Ho_HomeDto saveHome(Ho_HomeSaveDto hoHomeSaveDto){
        Ho_Home hoHome= Ho_HomeMapperConverter.INSTANCE.convertToHoHomeFromHoHomeSaveDto(hoHomeSaveDto);
        hoHome = hoHomeEntityService.save(hoHome);

        Ho_HomeDto hoHomeDto = Ho_HomeMapperConverter.INSTANCE.convertToHoHomeDtoFromHoHome(hoHome);
        return hoHomeDto;
}}
