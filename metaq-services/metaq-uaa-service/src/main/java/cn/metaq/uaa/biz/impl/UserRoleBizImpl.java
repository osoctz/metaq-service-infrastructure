package cn.metaq.uaa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.uaa.biz.UserRoleBiz;
import cn.metaq.uaa.dao.UserRoleDao;
import cn.metaq.uaa.domain.UserRole;
import cn.metaq.uaa.dto.UserRoleDTO;
import org.springframework.stereotype.Service;

@Service
public class UserRoleBizImpl extends BaseBiz<UserRole, UserRoleDTO, Long, UserRoleDao> implements UserRoleBiz {

    @Override
    public void save(UserRoleDTO entity) {

        UserRole userRole=new UserRole();

        userRole.setUserId(userRole.getUserId());
        userRole.setRoleId(userRole.getRoleId());

        repository.save(userRole);

        entity.setId(userRole.getId());
    }
}
