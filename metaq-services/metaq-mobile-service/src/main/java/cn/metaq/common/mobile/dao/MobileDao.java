package cn.metaq.common.mobile.dao;

import cn.metaq.common.mobile.domain.Mobile;
import cn.metaq.data.jpa.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * MobileDao
 *
 * @author tz
 * @date 2020/11/30 下午3:05
 * @since 1.0
 */
@Repository
public interface MobileDao extends BaseDao<Mobile,Long> {
}
