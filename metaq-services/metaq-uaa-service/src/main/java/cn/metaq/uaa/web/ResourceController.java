package cn.metaq.uaa.web;

import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import cn.metaq.uaa.biz.ResourceBiz;
import cn.metaq.uaa.domain.Resource;
import cn.metaq.uaa.dto.ResourceDTO;
import cn.metaq.uaa.dto.RoleDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController extends BaseController<ResourceBiz> {

    @PostMapping("resources/pages")
    public Pagination<Resource> list(@RequestBody ResourceDTO resourceDTO, int offset, int limit) {

        return baseBiz.list(Resource.class,resourceDTO, offset, limit);
    }

    @PostMapping(value = "resources")
    public void add(@RequestBody ResourceDTO resourceDTO) {

        baseBiz.save(resourceDTO);
    }

    @PutMapping(value = "resources")
    public void update(@RequestBody ResourceDTO resourceDTO) {

        baseBiz.update(resourceDTO);
    }

    @DeleteMapping(value = "resources/{id}")
    public void delete(@PathVariable Long id) {

        baseBiz.deleteById(null,id);
    }

    @GetMapping(value = "/{groupId}/resources")
    public List<ResourceDTO> listResourceByGroup(@PathVariable Long groupId){

        return baseBiz.listResourceByGroup(groupId);
    }
}
