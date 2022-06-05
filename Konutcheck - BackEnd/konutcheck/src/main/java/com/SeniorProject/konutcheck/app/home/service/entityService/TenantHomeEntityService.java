package com.SeniorProject.konutcheck.app.home.service.entityService;

import com.SeniorProject.konutcheck.app.home.dao.TenantHomeDao;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.dto.TenantHomeDetails;
import com.SeniorProject.konutcheck.app.home.entity.TenantHome;
import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantHomeEntityService extends BaseEntityService<TenantHome, TenantHomeDao> {
    private TenantHomeDao tenantHomeDao;
    public TenantHomeEntityService(TenantHomeDao dao) {
        super(dao);
        this.tenantHomeDao = dao;
    }

    /*Making list of tenant homes in landlord because of changing status to active from passive.*/
    public List<TenantHomeDetails> getTenantHomeList(Long landlordId){
        return tenantHomeDao.getTenantHomeList(landlordId);
    }

    public List<Ho_HomeDetails> getTenantAllHomesDetails(Long tenantId){
        return tenantHomeDao.homesBelongToTenant(tenantId);
    }

    public List<TenantHomeDetails> getLandlordTenant(Long landlordId){
        return tenantHomeDao.getLandlordsTenant(landlordId);
    }
}
