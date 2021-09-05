package cn.metaq.uaa.web;

import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import cn.metaq.uaa.biz.GroupBiz;
import cn.metaq.uaa.domain.Group;
import cn.metaq.uaa.dto.GroupDTO;
import cn.metaq.uaa.dto.GroupNodeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController extends BaseController<GroupBiz> {

    /**
     * 分页查询分组列表
     * @param groupDTO
     * @param offset
     * @param limit
     * @return
     */
    @PostMapping("groups/pages")
    public Pagination<Group> list(@RequestBody GroupDTO groupDTO, int offset, int limit) {

        return baseBiz.list(Group.class,groupDTO, offset, limit);
    }

    /**
     * 新增分组
     * @param groupDTO
     */
    @PostMapping(value = "groups")
    public void add(@RequestBody GroupDTO groupDTO) {

        baseBiz.save(groupDTO);
    }

    /**
     * 更新角色
     * @param groupDTO
     */
    @PutMapping(value = "groups")
    public void update(@RequestBody GroupDTO groupDTO) {

        baseBiz.update(groupDTO);
    }

    /**
     * 删除角色
     * @param id
     */
    @DeleteMapping(value = "groups/{id}")
    public void delete(@PathVariable Long id) {

        baseBiz.deleteById(id);
    }

    /**
     * 查询指定type的分组
     * @param type
     * @return
     */
    @GetMapping(value = "/{type}/groups")
    public List<GroupNodeDTO> listGroupByType(@PathVariable Integer type){

        return baseBiz.listGroupByType(type);
    }
}
