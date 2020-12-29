package cn.metaq.sso1.client;

import cn.metaq.sso1.dto.AuthorityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "uaa-service")
public interface UaaServiceClient {

    @RequestMapping(value = "authorities", method = RequestMethod.GET)
    List<AuthorityDTO> loadAuthorities();
}
