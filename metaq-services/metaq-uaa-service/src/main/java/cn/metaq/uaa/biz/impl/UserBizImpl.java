package cn.metaq.uaa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.uaa.biz.UserBiz;
import cn.metaq.uaa.dao.UserDao;
import cn.metaq.uaa.domain.User;
import cn.metaq.uaa.dto.UserDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * UserBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午3:15
 * @since 1.0
 */
@Service
public class UserBizImpl extends BaseBiz<User, UserDTO, Long, UserDao> implements UserBiz {

    @Override
    public User loadUserByUsername(String username) {

        return repository.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.equal(root.get("username"), username);
            }
        }).orElseThrow();
    }
}
