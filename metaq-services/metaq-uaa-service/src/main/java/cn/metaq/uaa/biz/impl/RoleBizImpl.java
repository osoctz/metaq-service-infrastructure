package cn.metaq.uaa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.data.jpa.BaseTemplate;
import cn.metaq.uaa.biz.RoleBiz;
import cn.metaq.uaa.dao.RoleDao;
import cn.metaq.uaa.domain.Role;
import cn.metaq.uaa.dto.RoleDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RoleBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午3:27
 * @since 1.0
 */
@Service
public class RoleBizImpl extends BaseBiz<Role, RoleDTO, Long, RoleDao> implements RoleBiz {

    @Resource
    private BaseTemplate template;

    @Override
    public void save(RoleDTO entity) {

        Role role = new Role();

        role.setNameCn(entity.getNameCn());
        role.setNameEn(entity.getNameEn());

        repository.save(role);
    }

    @Override
    public void update(RoleDTO entity) {

        Role role = repository.getOne(entity.getId());

        role.setNameCn(entity.getNameCn());
        role.setNameEn(entity.getNameEn());

        repository.save(role);
    }

    @Override
    public List<RoleDTO> listRoleByGroup(Long groupId) {

        String jql = "select new cn.metaq.uaa.dto.RoleDTO(role.id,role.nameCn,role.nameEn) from Role role " +
                "left join RoleGroup rolegroup on role.id=rolegroup.roleId " +
                "where rolegroup.groupId=:groupId";

        Map<String, Object> params = new HashMap<>();
        params.put("groupId", groupId);

        List<RoleDTO> roles = template.list(RoleDTO.class, jql, params);

        return roles;
    }
}
