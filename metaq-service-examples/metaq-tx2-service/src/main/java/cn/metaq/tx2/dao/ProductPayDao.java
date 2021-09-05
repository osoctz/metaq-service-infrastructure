package cn.metaq.tx2.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.tx2.domain.ProductPay;
import org.springframework.stereotype.Repository;

/**
 * ProductOrderDao
 *
 * @author tz
 * @date 2020/12/11 下午2:05
 * @since 1.0
 */
@Repository
public interface ProductPayDao extends BaseDao<ProductPay,Long> {
}
