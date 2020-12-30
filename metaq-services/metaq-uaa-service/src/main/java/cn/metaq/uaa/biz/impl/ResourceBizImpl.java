package cn.metaq.uaa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.data.jpa.BaseTemplate;
import cn.metaq.uaa.biz.ResourceBiz;
import cn.metaq.uaa.dao.ResourceDao;
import cn.metaq.uaa.domain.Resource;
import cn.metaq.uaa.dto.ResourceDTO;
import cn.metaq.uaa.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ResourceBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午3:27
 * @since 1.0
 */
@Service
public class ResourceBizImpl extends BaseBiz<Resource, ResourceDTO, Long, ResourceDao> implements ResourceBiz {

    @javax.annotation.Resource
    private BaseTemplate template;

    @Override
    public void save(ResourceDTO entity) {

        Resource resource=new Resource();

        resource.setId(entity.getId());
        resource.setNameCn(entity.getNameCn());
        resource.setNameEn(entity.getNameEn());
        resource.setPriority(entity.getPriority());
        resource.setType(entity.getType());

        repository.save(resource);
    }

    @Override
    public void update(ResourceDTO entity) {

        Resource resource=repository.findById(entity.getId()).orElseThrow();

        resource.setNameCn(entity.getNameCn());
        resource.setNameEn(entity.getNameEn());
        resource.setPriority(entity.getPriority());
        resource.setType(entity.getType());

        repository.save(resource);
    }

    @Override
    public List<ResourceDTO> listResourceByGroup(Long groupId) {

        String jql = "select new cn.metaq.uaa.dto.ResourceDTO(resource.id,resource.nameCn,resource.nameEn,resource.type,resource.priority) " +
                "from Resource resource " +
                "left join ResourceGroup resourcegroup on resource.id=resourcegroup.resourceId " +
                "where resourcegroup.groupId=:groupId";

        Map<String, Object> params = new HashMap<>();
        params.put("groupId", groupId);

        List<ResourceDTO> resources=template.list(ResourceDTO.class,jql,params);
        return resources;
    }
}
