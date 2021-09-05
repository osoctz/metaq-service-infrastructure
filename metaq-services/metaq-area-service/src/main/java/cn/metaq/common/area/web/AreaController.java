package cn.metaq.common.area.web;

import cn.metaq.common.area.biz.AreaBiz;
import cn.metaq.common.area.domain.Area;
import cn.metaq.common.area.dto.AreaDTO;
import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import cn.metaq.common.web.annotation.IgnoreResultWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
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

        return baseBiz.list(Area.class,areaDTO,offset,limit);
    }

    @GetMapping("{parent}")
    public List<Area> list(@PathVariable String parent){

        AreaDTO areaDTO=new AreaDTO();
        areaDTO.setParent(parent);

        return baseBiz.list(Area.class,areaDTO);
    }

    @GetMapping("/retry")
    @IgnoreResultWrapper
    public String timeout() throws IOException {
        try{
            //睡5秒，网关Hystrix3秒超时，会触发熔断降级操作
//            Thread.sleep(6000);
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new IOException("重试异常");
//        return "retry";
    }
}
