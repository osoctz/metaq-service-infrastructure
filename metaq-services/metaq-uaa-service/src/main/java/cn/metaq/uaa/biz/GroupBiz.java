package cn.metaq.uaa.biz;

import cn.metaq.data.Biz;
import cn.metaq.uaa.domain.Group;
import cn.metaq.uaa.dto.GroupDTO;
import cn.metaq.uaa.dto.GroupNodeDTO;

import java.util.List;

/**
 * GroupBiz
 *
 * @author tz
 * @date 2020/12/14 下午3:26
 * @since 1.0
 */
public interface GroupBiz extends Biz<Group, GroupDTO, Long> {

    List<GroupNodeDTO> listGroupByType(Integer type);
}
