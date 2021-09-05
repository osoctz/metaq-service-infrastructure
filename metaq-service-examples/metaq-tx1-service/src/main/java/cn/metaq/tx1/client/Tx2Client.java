package cn.metaq.tx1.client;

import cn.metaq.common.web.dto.Result;
import cn.metaq.tx1.dto.ProductPayDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Tx2Client
 *
 * @author tz
 * @date 2020/12/11 下午2:33
 * @since 1.0
 */
@FeignClient(name = "tx2")
public interface Tx2Client {

    @RequestMapping(value = "add",method = RequestMethod.POST)
    Result add(@RequestBody ProductPayDTO productPayDTO);
}
