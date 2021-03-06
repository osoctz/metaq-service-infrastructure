package cn.metaq.uaa.security.details;

import cn.metaq.uaa.client.UaaServiceClient;
import cn.metaq.uaa.dto.UserDTO;
import cn.metaq.uaa.provider.domain.CustomGrantedAuthority;
import cn.metaq.uaa.provider.domain.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UaaServiceClient uaaServiceClient;

    @Cacheable(cacheNames = {"uaa.userDetails"}, key = "#username")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO user = uaaServiceClient.loadUserByUsername(username);

        Set<String> authoritySet = uaaServiceClient.loadAuthorityByUsername(username);

        User userDetails = new User(user.getUsername(),user.getPassword(),user.isEnabled(),true,true,true, new HashSet<>());

        log.info("user:{}",user);
//        userDetails.setEnabled(user.isEnabled());
//        userDetails.setUsername(user.getUsername());
//        userDetails.setPassword(user.getPassword());
//        userDetails.setName(user.getName());


        if (!CollectionUtils.isEmpty(authoritySet)) {

            userDetails = new User(user.getUsername(),
                    user.getPassword(),
                    user.isEnabled(),true,true,true,
                    authoritySet.stream().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toSet()));

//            userDetails.setAuthorities(authoritySet.stream().map(authority -> {
//
//                CustomGrantedAuthority grantedAuthority = new CustomGrantedAuthority();
//                grantedAuthority.setAuthority(authority);
//
//                return grantedAuthority;
//            }).collect(Collectors.toSet()));

        }
        return userDetails;
    }
}
