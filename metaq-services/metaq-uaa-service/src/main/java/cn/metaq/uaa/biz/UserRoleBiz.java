package cn.metaq.uaa.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.uaa.dto.UserDTO;
import cn.metaq.uaa.dto.UserRoleDTO;
import org.springframework.data.jpa.domain.Specification;

public interface UserRoleBiz extends Biz<UserRoleDTO,Long>, QueryBiz<UserRoleDTO, Specification> {
}
