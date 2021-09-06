package cn.metaq.uaa.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.uaa.dto.ClientDetailsDTO;
import cn.metaq.uaa.dto.GroupDTO;
import cn.metaq.uaa.dto.GroupNodeDTO;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * GroupBiz
 *
 * @author tz
 * @date 2020/12/14 下午3:26
 * @since 1.0
 */
public interface GroupBiz extends Biz<GroupDTO, Long>, QueryBiz<GroupDTO, Specification> {

    List<GroupNodeDTO> listGroupByType(Integer type);
}
