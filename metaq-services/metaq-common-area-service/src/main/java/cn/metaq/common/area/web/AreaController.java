package cn.metaq.common.area.web;

import cn.metaq.common.area.biz.AreaBiz;
import cn.metaq.common.area.domain.Area;
import cn.metaq.common.area.dto.AreaDTO;
import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

//    @Resource
//    private AreaBiz areaBiz;

    @PostMapping("pages")
    public Pagination<Area> list(@RequestBody(required = false) AreaDTO areaDTO, int offset, int limit){

        return baseBiz.list(areaDTO,offset,limit);
    }
}
