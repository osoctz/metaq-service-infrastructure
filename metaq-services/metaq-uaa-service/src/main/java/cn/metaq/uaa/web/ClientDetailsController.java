package cn.metaq.uaa.web;


import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import cn.metaq.common.web.annotation.IgnoreResultWrapper;
import cn.metaq.uaa.biz.ClientDetailsBiz;
import cn.metaq.uaa.domain.ClientDetails;
import cn.metaq.uaa.dto.ClientDetailsDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * ClientDetailsController
 *
 * @author tz
 * @date 2020/12/14 下午4:17
 * @since 1.0
 */
@RestController
public class ClientDetailsController extends BaseController<ClientDetailsBiz> {

    @PostMapping("clients/pages")
    public Pagination<ClientDetails> list(@RequestBody ClientDetailsDTO clientDetailsDTO, int offset, int limit) {

        return baseBiz.list(clientDetailsDTO, offset, limit);
    }

    @PostMapping(value = "clients")
    public void add(@RequestBody ClientDetailsDTO clientDetailsDTO){

        baseBiz.save(clientDetailsDTO);
    }

    @GetMapping("clients/{clientId}")
    @IgnoreResultWrapper
    public ClientDetails loadClientByClientId(@PathVariable String clientId){

        return baseBiz.loadClientByClientId(clientId);
    }

    @GetMapping("clients/authorities")
    @IgnoreResultWrapper
    public Set<String> loadAuthorityByClientId(@RequestParam String clientId){

        return baseBiz.loadAuthorityByClientId(clientId);
    }
}
