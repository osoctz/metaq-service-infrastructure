package cn.metaq.uaa.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.uaa.domain.Resource;
import org.springframework.stereotype.Repository;

/**
 * ResourceDao
 *
 * @author tz
 * @date 2020/12/14 下午3:07
 * @since 1.0
 */
@Repository
public interface ResourceDao extends BaseDao<Resource, Long> {
}
