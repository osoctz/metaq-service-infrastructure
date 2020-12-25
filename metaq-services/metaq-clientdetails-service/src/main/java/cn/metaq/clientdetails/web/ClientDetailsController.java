package cn.metaq.clientdetails.web;

import cn.metaq.clientdetails.biz.ClientDetailsBiz;
import cn.metaq.clientdetails.domain.ClientDetails;
import cn.metaq.clientdetails.dto.ClientDetailsDTO;
import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import cn.metaq.common.web.annotation.IgnoreResultWrapper;
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

    @PostMapping("clientDetails/pages")
    public Pagination<ClientDetails> list(@RequestBody ClientDetailsDTO clientDetailsDTO, int offset, int limit) {

        return baseBiz.list(clientDetailsDTO, offset, limit);
    }

    @GetMapping("clientDetails/{clientId}")
    @IgnoreResultWrapper
    public ClientDetails loadClientByClientId(@PathVariable String clientId){

        return baseBiz.loadClientByClientId(clientId);
    }

    @GetMapping("clientDetails/authorities")
    @IgnoreResultWrapper
    public Set<String> loadAuthorityByClientId(@RequestParam String clientId){

        return baseBiz.loadAuthorityByClientId(clientId);
    }
}
