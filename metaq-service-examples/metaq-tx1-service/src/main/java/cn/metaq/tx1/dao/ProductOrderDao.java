package cn.metaq.tx1.dao;

import cn.metaq.data.jpa.BaseRepository;
import cn.metaq.tx1.domain.ProductOrder;
import org.springframework.stereotype.Repository;

/**
 * ProductOrderDao
 *
 * @author tz
 * @date 2020/12/11 下午2:05
 * @since 1.0
 */
@Repository
public interface ProductOrderDao extends BaseRepository<ProductOrder,Long> {
}
