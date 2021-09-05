package cn.metaq.uaa.web;

import cn.metaq.common.web.annotation.IgnoreResultWrapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@Log4j2
public class LoginController {

    @IgnoreResultWrapper
    @GetMapping("/current")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }

    /**
     * 自定义登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 自定义登录页面
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
//    @PostMapping("/login")
//    public Result<OAuth2AccessToken> login(@RequestBody Map<String, String> parameters){
//        try {
//            parameters.put(OAuth2Utils.GRANT_TYPE,parameters.get(OAuth2Utils.GRANT_TYPE));//设置授权类型为密码模式
//            parameters.put(OAuth2Utils.CLIENT_ID,parameters.get(OAuth2Utils.CLIENT_ID));
//            parameters.put("client_secret",parameters.get("client_secret"));
//            Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
//            //grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));//此处不能为空
//            ResponseEntity<OAuth2AccessToken> responseEntity= tokenEndpoint.postAccessToken(
//                    new UsernamePasswordAuthenticationToken(
//                            parameters.get(OAuth2Utils.CLIENT_ID),
//                            parameters.get("client_secret"),
//                            grantedAuthorities),parameters);
//
//            SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            return  Result.ok(responseEntity.getBody());
//        }catch (InvalidGrantException e){
//            log.error("login error  用户名密码不正确 ....",e);
//            return Result.error(e.getMessage());
//        }
//        catch (Exception e){
//            log.error("login error ....",e);
//            return  Result.error(e.getMessage());
//        }
//    }
}
