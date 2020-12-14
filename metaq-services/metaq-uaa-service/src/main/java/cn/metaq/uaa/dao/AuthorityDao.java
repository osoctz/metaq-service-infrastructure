package cn.metaq.uaa.dao;

import cn.metaq.data.jpa.BaseRepository;
import cn.metaq.uaa.domain.Authority;
import org.springframework.stereotype.Repository;

/**
 * AuthorityDao
 *
 * @author tz
 * @date 2020/12/14 下午3:07
 * @since 1.0
 */
@Repository
public interface AuthorityDao extends BaseRepository<Authority, Long> {
}
