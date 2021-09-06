package cn.metaq.uaa.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.uaa.dto.GroupDTO;
import cn.metaq.uaa.dto.ResourceDTO;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * ResourceBiz
 *
 * @author tz
 * @date 2020/12/14 下午3:24
 * @since 1.0
 */
public interface ResourceBiz extends Biz<ResourceDTO, Long>, QueryBiz<ResourceDTO, Specification> {

    List<ResourceDTO> listResourceByGroup(Long groupId);
}
