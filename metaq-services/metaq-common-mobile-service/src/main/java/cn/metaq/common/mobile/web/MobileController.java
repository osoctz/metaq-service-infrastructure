package cn.metaq.common.mobile.web;

import cn.metaq.common.mobile.biz.MobileBiz;
import cn.metaq.common.mobile.domain.Mobile;
import cn.metaq.common.mobile.dto.MobileDTO;
import cn.metaq.common.web.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * MobileController
 *
 * @author tz
 * @date 2020/11/30 下午3:17
 * @since 1.0
 */
@RestController
public class MobileController extends BaseController<MobileBiz> {

    @GetMapping("mobiles")
    public List<Mobile> list(MobileDTO mobileDTO) {

        return baseBiz.list(mobileDTO);
    }
}
