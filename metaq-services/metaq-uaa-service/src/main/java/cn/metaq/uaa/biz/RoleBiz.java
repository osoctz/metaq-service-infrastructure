package cn.metaq.uaa.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.uaa.dto.ResourceDTO;
import cn.metaq.uaa.dto.RoleDTO;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * RoleBiz
 *
 * @author tz
 * @date 2020/12/14 下午3:23
 * @since 1.0
 */
public interface RoleBiz extends Biz<RoleDTO, Long>, QueryBiz<RoleDTO, Specification> {

    List<RoleDTO> listRoleByGroup(Long groupId);

    List<RoleDTO> list(Long userId);

    List<RoleDTO> list(List<String> usernames);
}
