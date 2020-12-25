package cn.metaq.clientdetails.client;

import cn.metaq.clientdetails.dto.ClientDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * ClientDetailsClient
 *
 * @author tz
 * @date 2020/12/14 下午4:53
 * @since 1.0
 */
@FeignClient(name = "clientdetails")
public interface ClientDetailsClient {

    @RequestMapping(value = "clientDetails/{clientId}", method = RequestMethod.GET)
    ClientDetailsDTO loadClientByClientId(@PathVariable(name = "clientId") String clientId);

    @RequestMapping(value = "clientDetails/authorities", method = RequestMethod.GET)
    Set<String> loadAuthorityByClientId(@RequestParam(value = "clientId") String clientId);
}
