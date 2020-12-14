package cn.metaq.uaa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.uaa.biz.AuthorityBiz;
import cn.metaq.uaa.dao.AuthorityDao;
import cn.metaq.uaa.domain.Authority;
import cn.metaq.uaa.dto.AuthorityDTO;
import org.springframework.stereotype.Service;

/**
 * AuthorityBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午3:27
 * @since 1.0
 */
@Service
public class AuthorityBizImpl extends BaseBiz<Authority, AuthorityDTO, Long, AuthorityDao> implements AuthorityBiz {
}
