package com.SeniorProject.konutcheck.app.evaluation.service.entityService;

import com.SeniorProject.konutcheck.app.evaluation.dao.TenantRelatedHomesDao;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantRelatedHomes;
import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class TenantRelatedHomesEntityService extends BaseEntityService<TenantRelatedHomes, TenantRelatedHomesDao> {
    private TenantRelatedHomesDao tenantRelatedHomesDao;
    public TenantRelatedHomesEntityService(TenantRelatedHomesDao dao) {
        super(dao);
        this.tenantRelatedHomesDao = dao;
    }

    public GetHomeIdDto getHomeIdByLandlordId(Long id){
        return tenantRelatedHomesDao.getHomeIdByLandlordId(id);
    }
}
