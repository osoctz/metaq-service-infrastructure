package cn.metaq.sso1.web;

import cn.metaq.sso1.client.UaaServiceClient;
import cn.metaq.sso1.dto.AuthorityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SsoController {

    @Autowired
    private UaaServiceClient uaaServiceClient;

    @GetMapping(value = "authorities")
    public List<AuthorityDTO> loadAuthorities(){

        return uaaServiceClient.loadAuthorities();
    }
}
