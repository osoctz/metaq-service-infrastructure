package cn.metaq.uaa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.data.jpa.BaseTemplate;
import cn.metaq.uaa.biz.UserBiz;
import cn.metaq.uaa.dao.UserDao;
import cn.metaq.uaa.domain.User;
import cn.metaq.uaa.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午3:15
 * @since 1.0
 */
@Service
public class UserBizImpl extends BaseBiz<UserDTO, Long, UserDao> implements UserBiz {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private BaseTemplate template;

    @Override
    public void save(UserDTO entity) {

        User user = new User();

        user.setName(entity.getName());
        user.setUsername(entity.getUsername());
        user.setPassword(passwordEncoder.encode(entity.getPassword()));
        user.setEmail(entity.getEmail());
        user.setLastPasswordResetDate(LocalDateTime.now());
        user.setEnabled(true);

        dao.save(user);
        entity.setId(user.getId());
    }

    @Override
    public void update(UserDTO entity) {

        User user = dao.getOne(entity.getId());

        user.setName(entity.getName());
        user.setUsername(entity.getUsername());
        //user.setPassword(passwordEncoder.encode(entity.getPassword()));
        user.setEmail(entity.getEmail());
        user.setLastPasswordResetDate(LocalDateTime.now());
        //user.setEnabled(true);

        dao.save(user);
    }

    @Override
    public User loadUserByUsername(String username) {

        return dao.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.equal(root.get("username"), username);
            }
        }).orElseThrow();
    }

    @Override
    public UserDTO resetPassword(UserDTO userDTO) {

        User user = this.loadUserByUsername(userDTO.getUsername());

        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setLastPasswordResetDate(LocalDateTime.now());

        dao.save(user);

        return userDTO;
    }

    @Override
    public void exchangeStatus(Long id) {

        User user = this.getOneById(User.class,id);
        user.setEnabled(!user.isEnabled());

        dao.save(user);
    }

    @Override
    public List<UserDTO> listUserByGroup(Long groupId) {

        String jql = "select new cn.metaq.uaa.dto.UserDTO(user.id,user.name,user.username,user.password,user.email,user.lastPasswordResetDate,user.enabled) " +
                "from User user " +
                "left join UserGroup usergroup on user.id=usergroup.userId " +
                "where usergroup.groupId=:groupId";

        Map<String, Object> params = new HashMap<>();
        params.put("groupId", groupId);

        List<UserDTO> users=template.list(UserDTO.class,jql,params);
        return users;
    }
}
