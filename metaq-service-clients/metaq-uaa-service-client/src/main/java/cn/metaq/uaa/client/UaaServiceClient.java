package cn.metaq.uaa.client;

import cn.metaq.uaa.dto.AuthorityDTO;
import cn.metaq.uaa.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@FeignClient(name = "uaa-service")
public interface UaaServiceClient {

    @RequestMapping(value = "users/authorities", method = RequestMethod.GET)
    Set<String> loadAuthorityByUsername(@RequestParam(value = "username") String username);

    @RequestMapping(value = "authorities", method = RequestMethod.GET)
    List<AuthorityDTO> list();

    @RequestMapping(value = "users", method = RequestMethod.GET)
    UserDTO loadUserByUsername(@RequestParam(value = "username") String username);

}
