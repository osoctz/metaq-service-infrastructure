package cn.metaq.uaa.web;

import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import cn.metaq.uaa.biz.RoleBiz;
import cn.metaq.uaa.domain.Role;
import cn.metaq.uaa.dto.RoleDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController extends BaseController<RoleBiz> {

    /**
     * 分页查询角色列表
     * @param roleDTO
     * @param offset
     * @param limit
     * @return
     */
    @PostMapping("roles/pages")
    public Pagination<Role> list(@RequestBody RoleDTO roleDTO, int offset, int limit) {

        return baseBiz.list(roleDTO, offset, limit);
    }

    /**
     * 新增角色
     * @param roleDTO
     */
    @PostMapping(value = "roles")
    public void add(@RequestBody RoleDTO roleDTO) {

        baseBiz.save(roleDTO);
    }

    /**
     * 更新角色
     * @param roleDTO
     */
    @PutMapping(value = "roles")
    public void update(@RequestBody RoleDTO roleDTO) {

        baseBiz.update(roleDTO);
    }

    /**
     * 删除角色
     * @param id
     */
    @DeleteMapping(value = "roles/{id}")
    public void delete(@PathVariable Long id) {

        baseBiz.deleteById(id);
    }

    /**
     * 查询分组下的角色
     * @param groupId
     * @return
     */
    @GetMapping(value = "/{groupId}/roles")
    public List<RoleDTO> listRoleByGroup(@PathVariable Long groupId){

        return baseBiz.listRoleByGroup(groupId);
    }
}