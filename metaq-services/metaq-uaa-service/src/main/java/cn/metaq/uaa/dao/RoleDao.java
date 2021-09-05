package cn.metaq.uaa.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.uaa.domain.Role;
import org.springframework.stereotype.Repository;

/**
 * RoleDao
 *
 * @author tz
 * @date 2020/12/14 下午3:05
 * @since 1.0
 */
@Repository
public interface RoleDao extends BaseDao<Role, Long> {
}
