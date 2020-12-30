package cn.metaq.uaa.dao;

import cn.metaq.data.jpa.BaseRepository;
import cn.metaq.uaa.domain.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao extends BaseRepository<UserRole,Long> {
}
