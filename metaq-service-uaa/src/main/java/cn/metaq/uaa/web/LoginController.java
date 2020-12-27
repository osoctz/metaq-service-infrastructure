package cn.metaq.uaa.web;

import cn.metaq.common.web.dto.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

@RestController
@Log4j2
public class LoginController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    @GetMapping("/current")
    public Result user(Principal user) {
        return Result.ok(user);
    }

    @PostMapping("/login")
    public Result<OAuth2AccessToken> login(@RequestBody Map<String, String> parameters){
        try {
            parameters.put(OAuth2Utils.GRANT_TYPE,parameters.get(OAuth2Utils.GRANT_TYPE));//设置授权类型为密码模式
            parameters.put(OAuth2Utils.CLIENT_ID,parameters.get(OAuth2Utils.CLIENT_ID));
            parameters.put("client_secret",parameters.get("client_secret"));
            Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
            //grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));//此处不能为空
            ResponseEntity<OAuth2AccessToken> responseEntity= tokenEndpoint.postAccessToken(
                    new UsernamePasswordAuthenticationToken(
                            parameters.get(OAuth2Utils.CLIENT_ID),
                            parameters.get("client_secret"),
                            grantedAuthorities),parameters);

            SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return  Result.ok(responseEntity.getBody());
        }catch (InvalidGrantException e){
            log.error("login error  用户名密码不正确 ....",e);
            return Result.error(e.getMessage());
        }
        catch (Exception e){
            log.error("login error ....",e);
            return  Result.error(e.getMessage());
        }
    }
}
