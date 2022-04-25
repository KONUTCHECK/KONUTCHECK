package com.SeniorProject.konutcheck.app.securityGeneral.service;

import com.SeniorProject.konutcheck.app.securityGeneral.dto.SecurityLoginRequestDto;
import com.SeniorProject.konutcheck.app.securityGeneral.enums.EnumJwtConstant;
import com.SeniorProject.konutcheck.app.securityGeneral.security.JwtTokenGenerator;
import com.SeniorProject.konutcheck.app.securityGeneral.security.JwtUserDetails;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserSaveDto;

import com.SeniorProject.konutcheck.app.user.service.Us_UserService;
import com.SeniorProject.konutcheck.app.user.service.entityService.Us_UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final Us_UserService usUserService;
    private final Us_UserEntityService usUserEntityService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;

    /* User is saved with this method. */
    public Us_UserDto register(Us_UserSaveDto usUserSaveDto) {
        Us_UserDto usUserDto = usUserService.saveUser(usUserSaveDto);
        return usUserDto;
    }

    public String login(SecurityLoginRequestDto securityLoginRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(securityLoginRequestDto.getEmail(), securityLoginRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);
        String bearer = EnumJwtConstant.BEARER.getConstant();
        return bearer + token;
    }


    public Long getCurrentUserId(){
        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();

        Long jwtUserId = null;
        if(jwtUserDetails != null){
            jwtUserId = jwtUserDetails.getId();
        }
        return jwtUserId;
    }

    private JwtUserDetails getCurrentJwtUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        JwtUserDetails jwtUserDetails = null;
        if(authentication != null && authentication.getPrincipal() instanceof JwtUserDetails){
            jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        }
        return jwtUserDetails;
    }
}
