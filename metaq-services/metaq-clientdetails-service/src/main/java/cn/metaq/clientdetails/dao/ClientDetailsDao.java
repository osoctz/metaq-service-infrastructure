package cn.metaq.clientdetails.dao;

import cn.metaq.clientdetails.domain.ClientDetails;
import cn.metaq.data.jpa.BaseRepository;
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
