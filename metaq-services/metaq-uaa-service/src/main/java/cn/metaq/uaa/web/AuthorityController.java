package cn.metaq.uaa.web;

import cn.metaq.common.web.BaseController;
import cn.metaq.common.web.annotation.IgnoreResultWrapper;
import cn.metaq.uaa.biz.AuthorityBiz;
import cn.metaq.uaa.domain.Authority;
import cn.metaq.uaa.dto.AuthorityDTO;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class AuthorityController extends BaseController<AuthorityBiz> {

    @GetMapping(value = "users/authorities")
    @IgnoreResultWrapper
    public Set<String> loadAuthorityByUsername(@RequestParam String username) {

        return baseBiz.loadAuthorityByUsername(username);
    }

    @GetMapping(value = "authorities")
    @IgnoreResultWrapper
    public List<Authority> loadAuthorityByClientId() {

        return  baseBiz.list();
    }
}
