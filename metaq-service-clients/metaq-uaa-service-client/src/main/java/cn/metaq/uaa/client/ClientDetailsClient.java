package cn.metaq.uaa.client;

import cn.metaq.uaa.dto.ClientDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
