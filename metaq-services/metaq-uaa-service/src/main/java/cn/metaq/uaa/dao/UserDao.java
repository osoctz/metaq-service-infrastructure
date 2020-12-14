package cn.metaq.uaa.dao;

import cn.metaq.data.jpa.BaseRepository;
import cn.metaq.uaa.domain.User;
import org.springframework.stereotype.Repository;

/**
 * UserDao
 *
 * @author tz
 * @date 2020/12/14 下午2:53
 * @since 1.0
 */
@Repository
public interface UserDao extends BaseRepository<User, Long> {
}
