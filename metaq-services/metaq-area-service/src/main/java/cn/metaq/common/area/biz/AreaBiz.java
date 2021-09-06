package cn.metaq.common.area.biz;

import cn.metaq.common.area.dto.AreaDTO;
import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import org.springframework.data.jpa.domain.Specification;

/**
 * AreaBiz
 *
 * @author tz
 * @date 2020/11/27 下午3:58
 * @since 1.0
 */
public interface AreaBiz extends Biz<AreaDTO, Long>, QueryBiz<AreaDTO, Specification> {
}
