package cn.metaq.uaa.web;

import cn.metaq.common.core.dto.Pagination;
import cn.metaq.common.web.BaseController;
import cn.metaq.common.web.annotation.IgnoreResultWrapper;
import cn.metaq.uaa.biz.UserBiz;
import cn.metaq.uaa.biz.UserRoleBiz;
import cn.metaq.uaa.domain.User;
import cn.metaq.uaa.dto.UserDTO;
import cn.metaq.uaa.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController
 *
 * @author tz
 * @date 2020/12/14 下午3:33
 * @since 1.0
 */
@RestController
public class UserController extends BaseController<UserBiz> {

    @Autowired
    private UserRoleBiz userRoleBiz;

    /**
     * 分页查询用户列表
     * @param userDTO
     * @param offset
     * @param limit
     * @return
     */
    @PostMapping("users/pages")
    public Pagination<User> list(@RequestBody UserDTO userDTO, int offset, int limit) {

        return baseBiz.list(User.class,userDTO, offset, limit);
    }

    /**
     * 新增用户信息
     * @param userDTO
     * @return
     */
    @PostMapping(value = "users")
    public UserDTO add(@RequestBody UserDTO userDTO) {

        baseBiz.save(userDTO);
        return userDTO;
    }

    /**
     * 更新用户信息
     * @param userDTO
     * @return
     */
    @PutMapping(value = "users")
    public UserDTO update(@RequestBody UserDTO userDTO) {

        baseBiz.update(userDTO);
        return userDTO;
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping(value = "users/{id}")
    public void delete(@PathVariable Long id) {

        baseBiz.deleteById(null,id);
    }

    /**
     * 重置用户密码
     * @param userDTO
     */
    @PutMapping(value = "resetPassword")
    public void resetPassword(@RequestBody UserDTO userDTO) {

        baseBiz.resetPassword(userDTO);
    }

    /**
     * 切换用户启用/禁用状态
     * @param id
     */
    @PutMapping(value = "status/exchange/{id}")
    public void exchangeStatus(@PathVariable Long id){

        baseBiz.exchangeStatus(id);
    }

    /**
     * 给用户添加角色
     * @param userRoleDTO
     */
    @PostMapping("userRoles")
    public void addUserRole(@RequestBody UserRoleDTO userRoleDTO){

        userRoleBiz.save(userRoleDTO);
    }

    @GetMapping(value = "/{groupId}/users")
    public List<UserDTO> listUserByGroup(@PathVariable Long groupId){

        return baseBiz.listUserByGroup(groupId);
    }

    /**
     * 根据用户名获取用户(模块内部使用)
     * @param username
     * @return
     */
    @GetMapping("users")
    @IgnoreResultWrapper
    public User loadUserByUsername(@RequestParam String username) {

        return baseBiz.loadUserByUsername(username);
    }
}
