package cn.metaq.tx1.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.tx1.biz.ProductOrderBiz;
import cn.metaq.tx1.dao.ProductOrderDao;
import cn.metaq.tx1.domain.ProductOrder;
import org.springframework.stereotype.Service;

/**
 * ProductOrderBizImpl
 *
 * @author tz
 * @date 2020/12/11 下午2:09
 * @since 1.0
 */
@Service
public class ProductOrderBizImpl extends BaseBiz<ProductOrder, ProductOrder, Long, ProductOrderDao> implements ProductOrderBiz {
}
