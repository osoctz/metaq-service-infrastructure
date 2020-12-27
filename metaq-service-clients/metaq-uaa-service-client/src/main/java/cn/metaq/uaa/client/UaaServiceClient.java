package cn.metaq.uaa.client;

import cn.metaq.common.web.annotation.IgnoreResultWrapper;
import cn.metaq.uaa.dto.AuthorityDTO;
import cn.metaq.uaa.dto.ClientDetailsDTO;
import cn.metaq.uaa.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@FeignClient(name = "uaa-service")
public interface UaaServiceClient {

    @RequestMapping(value = "users/authorities", method = RequestMethod.GET)
    Set<String> loadAuthorityByUsername(@RequestParam(value = "username") String username);

    @RequestMapping(value = "clients/authorities", method = RequestMethod.GET)
    Set<String> loadAuthorityByClientId(@RequestParam(value ="clientId") String clientId);

    @RequestMapping(value = "users", method = RequestMethod.GET)
    UserDTO loadUserByUsername(@RequestParam(value = "username") String username);

    @GetMapping("clients/{clientId}")
    ClientDetailsDTO loadClientByClientId(@PathVariable(value ="clientId")  String clientId);
}
