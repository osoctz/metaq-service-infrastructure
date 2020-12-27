package cn.metaq.uaa.dao;

import cn.metaq.data.jpa.BaseRepository;
import cn.metaq.uaa.domain.ClientDetails;
import org.springframework.stereotype.Repository;

/**
 * ClientDetailsDao
 *
 * @author tz
 * @date 2020/12/14 下午4:12
 * @since 1.0
 */
@Repository
public interface ClientDetailsDao extends BaseRepository<ClientDetails,Long> {
}
