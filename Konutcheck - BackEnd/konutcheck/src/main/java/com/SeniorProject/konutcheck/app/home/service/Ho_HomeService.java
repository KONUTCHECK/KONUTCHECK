package com.SeniorProject.konutcheck.app.home.service;

import com.SeniorProject.konutcheck.app.home.converter.Ho_HomeMapperConverter;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDto;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeSaveDto;
import com.SeniorProject.konutcheck.app.home.entity.GeneralHomeInfo;
import com.SeniorProject.konutcheck.app.home.entity.Ho_Home;
import com.SeniorProject.konutcheck.app.home.service.entityService.GeneralHomeInfoEntityService;
import com.SeniorProject.konutcheck.app.home.service.entityService.Ho_HomeEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Ho_HomeService {
    private final Ho_HomeEntityService hoHomeEntityService;
    private final GeneralHomeInfoEntityService generalHomeInfoEntityService;

    public Ho_HomeDto saveHome(Ho_HomeSaveDto hoHomeSaveDto){
        Ho_Home hoHome= Ho_HomeMapperConverter.INSTANCE.convertToHoHomeFromHoHomeSaveDto(hoHomeSaveDto);
        hoHome.setAnnouncementDate(new Date());
        hoHome = hoHomeEntityService.save(hoHome);

        Ho_HomeDto hoHomeDto = Ho_HomeMapperConverter.INSTANCE.convertToHoHomeDtoFromHoHome(hoHome);
        return hoHomeDto;
   }

   public List<Ho_HomeDetails> getAllHomes(){
        List<Ho_HomeDetails> homeDetailsList = hoHomeEntityService.getAllHomes();
        return homeDetailsList;
   }

   public void deleteHome(Long id){
        Ho_Home hoHome = hoHomeEntityService.getIdWithControl(id);
        GeneralHomeInfo generalHomeInfo = generalHomeInfoEntityService.getIdWithControl(hoHome.getGeneralHomeInfoId());
        generalHomeInfoEntityService.delete(generalHomeInfo);
        hoHomeEntityService.delete(hoHome);
   }
}
