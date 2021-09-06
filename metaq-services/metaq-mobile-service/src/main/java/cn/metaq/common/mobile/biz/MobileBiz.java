package cn.metaq.common.mobile.biz;

import cn.metaq.common.mobile.dto.MobileDTO;
import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import org.springframework.data.jpa.domain.Specification;

/**
 * MobileBiz
 *
 * @author tz
 * @date 2020/11/30 下午3:06
 * @since 1.0
 */
public interface MobileBiz extends Biz<MobileDTO, Long>, QueryBiz<MobileDTO, Specification> {
}
