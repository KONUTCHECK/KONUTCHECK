package com.SeniorProject.konutcheck.app.securityGeneral.security;


import com.SeniorProject.konutcheck.app.user.entity.Us_User;
import com.SeniorProject.konutcheck.app.user.service.entityService.Us_UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private  final Us_UserEntityService usUserEntityService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Us_User usUser = usUserEntityService.findByEmail(email);
       return JwtUserDetails.create(usUser);
    }

    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        Us_User usUser = usUserEntityService.getIdWithControl(id);
        return JwtUserDetails.create(usUser);
    }
}
