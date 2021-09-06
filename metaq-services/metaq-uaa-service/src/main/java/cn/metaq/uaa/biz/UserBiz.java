package cn.metaq.uaa.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.uaa.domain.User;
import cn.metaq.uaa.dto.RoleDTO;
import cn.metaq.uaa.dto.UserDTO;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * UserBiz
 *
 * @author tz
 * @date 2020/12/14 下午3:14
 * @since 1.0
 */
public interface UserBiz extends Biz<UserDTO, Long>, QueryBiz<UserDTO, Specification> {

    User loadUserByUsername(String username);

    UserDTO resetPassword(UserDTO userDTO);

    void exchangeStatus(Long id);

    List<UserDTO> listUserByGroup(Long groupId);
}
