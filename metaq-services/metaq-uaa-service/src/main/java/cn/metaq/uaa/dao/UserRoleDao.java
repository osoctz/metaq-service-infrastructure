package cn.metaq.uaa.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.uaa.domain.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao extends BaseDao<UserRole,Long> {
}
