package cn.metaq.uaa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.uaa.biz.RoleBiz;
import cn.metaq.uaa.dao.RoleDao;
import cn.metaq.uaa.domain.Role;
import cn.metaq.uaa.dto.RoleDTO;
import org.springframework.stereotype.Service;

/**
 * RoleBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午3:27
 * @since 1.0
 */
@Service
public class RoleBizImpl extends BaseBiz<Role, RoleDTO, Long, RoleDao> implements RoleBiz {
}
