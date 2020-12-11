package cn.metaq.tx2.web;

import cn.metaq.common.web.BaseController;
import cn.metaq.common.web.annotation.IgnoreResultWrapper;
import cn.metaq.common.web.dto.Result;
import cn.metaq.tx2.biz.ProductPayBiz;
import cn.metaq.tx2.domain.ProductPay;
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
public class ProductPayController extends BaseController<ProductPayBiz> {

    @PostMapping("add")
    @IgnoreResultWrapper
    public Result add(@RequestBody ProductPay productPay){

        baseBiz.save(productPay);

        return Result.ok();
    }
}
