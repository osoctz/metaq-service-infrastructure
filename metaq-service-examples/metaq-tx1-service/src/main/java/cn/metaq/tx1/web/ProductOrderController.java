package cn.metaq.tx1.web;

import cn.metaq.common.util.IdUtils;
import cn.metaq.common.web.BaseController;
import cn.metaq.common.web.annotation.IgnoreResultWrapper;
import cn.metaq.common.web.dto.Result;
import cn.metaq.tx1.biz.ProductOrderBiz;
import cn.metaq.tx1.client.Tx2Client;
import cn.metaq.tx1.domain.ProductOrder;
import cn.metaq.tx1.dto.ProductOrderDTO;
import cn.metaq.tx1.dto.ProductPayDTO;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductOrderController
 *
 * @author tz
 * @date 2020/12/11 下午2:11
 * @since 1.0
 */
@RestController
public class ProductOrderController extends BaseController<ProductOrderBiz> {

    @Autowired
    private Tx2Client tx2Client;

    @GlobalTransactional
    @PostMapping("add")
    @IgnoreResultWrapper
    public Result add(@RequestBody ProductOrderDTO productOrderDTO){

        ProductOrder productOrder=new ProductOrder();
        productOrder.setId(productOrderDTO.getId());
        productOrder.setName(productOrderDTO.getName());
        baseBiz.save(productOrder);

        ProductPayDTO productPayDTO=new ProductPayDTO();

        productPayDTO.setId(IdUtils.getId());
        productPayDTO.setOrderId(productOrder.getId());
        productPayDTO.setAmount(productOrderDTO.getAmount());
        tx2Client.add(productPayDTO);

        return Result.ok();
    }
}
