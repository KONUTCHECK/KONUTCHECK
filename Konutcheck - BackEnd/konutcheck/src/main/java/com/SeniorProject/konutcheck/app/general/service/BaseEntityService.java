package com.SeniorProject.konutcheck.app.general.service;

import com.SeniorProject.konutcheck.app.general.exceptionEnums.GeneralErrorMessage;
import com.SeniorProject.konutcheck.app.general.exceptions.ItemNotFoundExceptions;
import com.SeniorProject.konutcheck.app.securityGeneral.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E, D extends JpaRepository>{

    private final D dao;
    private AuthenticationService authenticationService;

    //Circular dependency
    @Autowired
    public void setAuthenticationService(@Lazy AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public E save(E entity){
       // setAdditionalFields(entity);
        return (E) dao.save(entity);
    }

    /*private void setAdditionalFields(E entity) {
        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();
        Long currentUserId = getCurrentUser();

        if(baseAdditionalFields == null){
            baseAdditionalFields = new BaseAdditionalFields();
            entity.setBaseAdditionalFields(baseAdditionalFields);
        }

        if(entity.getId() == null){
            baseAdditionalFields.setCreateDate(new Date());
            baseAdditionalFields.setCreatedBy(currentUserId);
        }

        baseAdditionalFields.setUpdateDate(new Date());
        baseAdditionalFields.setUpdatedBy(currentUserId);
    }*/

    public List<E> findAll(){
        return dao.findAll();
    }

    public Optional<E> findById(Long id){
        return dao.findById(id);
    }

    public void delete(E entity){
        dao.delete(entity);
    }

    public Long getCurrentUser(){
        Long currentUserId = authenticationService.getCurrentUserId();
        return currentUserId;
    }

    public boolean existById(Long id){
        return dao.existsById(id);
    }

    public E getIdWithControl(Long id){
        Optional<E> entityOptional = findById(id);

        E entity;
        if(entityOptional.isPresent()){
            entity = entityOptional.get();
        }else{
            throw new ItemNotFoundExceptions(GeneralErrorMessage.ID_NOT_FOUND);
        }

        return entity;
    }
}
