package cn.metaq.common.area.dao;

import cn.metaq.common.area.domain.Area;
import cn.metaq.data.jpa.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * AreaDao
 *
 * @author tz
 * @date 2020/11/27 下午3:57
 * @since 1.0
 */
@Repository
public interface AreaDao extends BaseRepository<Area,Long> {
}
