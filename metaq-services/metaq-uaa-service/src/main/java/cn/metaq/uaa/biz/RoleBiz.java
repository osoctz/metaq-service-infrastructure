package cn.metaq.uaa.biz;

import cn.metaq.data.Biz;
import cn.metaq.uaa.domain.Role;
import cn.metaq.uaa.dto.RoleDTO;

import java.util.List;

/**
 * RoleBiz
 *
 * @author tz
 * @date 2020/12/14 下午3:23
 * @since 1.0
 */
public interface RoleBiz extends Biz<Role, RoleDTO, Long> {

    List<RoleDTO> listRoleByGroup(Long groupId);
}
