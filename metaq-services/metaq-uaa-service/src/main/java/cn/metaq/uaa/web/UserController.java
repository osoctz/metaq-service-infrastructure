package cn.metaq.uaa.web;

import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import cn.metaq.uaa.biz.UserBiz;
import cn.metaq.uaa.domain.User;
import cn.metaq.uaa.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 *
 * @author tz
 * @date 2020/12/14 下午3:33
 * @since 1.0
 */
@RestController
public class UserController extends BaseController<UserBiz> {

    @PostMapping("users/pages")
    public Pagination<User> list(@RequestBody UserDTO userDTO, int offset, int limit) {

        return baseBiz.list(userDTO, offset, limit);
    }

    @GetMapping("users")
    public User loadUserByUsername(@RequestParam String username){

        return baseBiz.loadUserByUsername(username);
    }
}
