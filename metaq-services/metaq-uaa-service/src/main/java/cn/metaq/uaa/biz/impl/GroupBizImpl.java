package cn.metaq.uaa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.uaa.biz.GroupBiz;
import cn.metaq.uaa.dao.GroupDao;
import cn.metaq.uaa.domain.Group;
import cn.metaq.uaa.dto.GroupDTO;
import org.springframework.stereotype.Service;

/**
 * GroupBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午3:27
 * @since 1.0
 */
@Service
public class GroupBizImpl extends BaseBiz<Group, GroupDTO, Long, GroupDao> implements GroupBiz {
}
