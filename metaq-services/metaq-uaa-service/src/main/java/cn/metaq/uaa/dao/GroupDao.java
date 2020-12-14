package cn.metaq.uaa.dao;

import cn.metaq.data.jpa.BaseRepository;
import cn.metaq.uaa.domain.Group;
import org.springframework.stereotype.Repository;

/**
 * GroupDao
 *
 * @author tz
 * @date 2020/12/14 下午3:06
 * @since 1.0
 */
@Repository
public interface GroupDao extends BaseRepository<Group, Long> {
}
