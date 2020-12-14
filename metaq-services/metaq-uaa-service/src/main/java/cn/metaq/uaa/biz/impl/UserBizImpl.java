package cn.metaq.uaa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.uaa.biz.UserBiz;
import cn.metaq.uaa.dao.UserDao;
import cn.metaq.uaa.domain.User;
import cn.metaq.uaa.dto.UserDTO;
import org.springframework.stereotype.Service;

/**
 * UserBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午3:15
 * @since 1.0
 */
@Service
public class UserBizImpl extends BaseBiz<User, UserDTO, Long, UserDao> implements UserBiz {
}
