package cn.metaq.tx2.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.tx2.biz.ProductPayBiz;
import cn.metaq.tx2.dao.ProductPayDao;
import cn.metaq.tx2.domain.ProductPay;
import org.springframework.stereotype.Service;

/**
 * ProductOrderBizImpl
 *
 * @author tz
 * @date 2020/12/11 下午2:09
 * @since 1.0
 */
@Service
public class ProductPayBizImpl extends BaseBiz<ProductPay, Long, ProductPayDao> implements ProductPayBiz {
}
