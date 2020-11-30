package cn.metaq.common.area.web;

import cn.metaq.common.area.biz.AreaBiz;
import cn.metaq.common.area.domain.Area;
import cn.metaq.common.area.dto.AreaDTO;
import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AreaController
 *
 * @author tz
 * @date 2020/11/27 下午4:25
 * @since 1.0
 */
@RestController
@RequestMapping("areas")
public class AreaController extends BaseController<AreaBiz> {

    @PostMapping("pages")
    public Pagination<Area> list(@RequestBody(required = false) AreaDTO areaDTO, int offset, int limit){

        return baseBiz.list(areaDTO,offset,limit);
    }

    @GetMapping("{parent}")
    public List<Area> list(@PathVariable String parent){

        AreaDTO areaDTO=new AreaDTO();
        areaDTO.setParent(parent);

        return baseBiz.list(areaDTO);
    }

}
