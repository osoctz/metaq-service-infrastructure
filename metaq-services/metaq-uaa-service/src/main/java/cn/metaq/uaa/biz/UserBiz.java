package cn.metaq.uaa.biz;

import cn.metaq.data.Biz;
import cn.metaq.uaa.domain.User;
import cn.metaq.uaa.dto.UserDTO;

/**
 * UserBiz
 *
 * @author tz
 * @date 2020/12/14 下午3:14
 * @since 1.0
 */
public interface UserBiz extends Biz<User, UserDTO, Long> {

    User loadUserByUsername(String username);
}
