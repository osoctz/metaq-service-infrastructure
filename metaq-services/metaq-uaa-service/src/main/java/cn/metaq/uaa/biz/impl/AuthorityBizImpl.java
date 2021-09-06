package cn.metaq.uaa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.data.jpa.BaseTemplate;
import cn.metaq.uaa.biz.AuthorityBiz;
import cn.metaq.uaa.dao.AuthorityDao;
import cn.metaq.uaa.dto.AuthorityDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * AuthorityBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午3:27
 * @since 1.0
 */
@Service
public class AuthorityBizImpl extends BaseBiz<AuthorityDTO, Long, AuthorityDao> implements AuthorityBiz {

    @Resource
    private BaseTemplate template;

    @Override
    public Set<String> loadAuthorityByUsername(String username) {

        String jql = "select a.authority from UserRole ur " +
                "left join User u on ur.userId=u.id " +
                "left join RoleAuthority ra on ur.roleId=ra.roleId left join Authority a on ra.authorityId=a.id " +
                "where u.username=:username";

        Map<String, Object> params = new HashMap<>();
        params.put("username", username);

        List<String> authorities = template.list(String.class, jql, params);
        return authorities.stream().collect(Collectors.toSet());
    }

    @Override
    public Specification map(AuthorityDTO authorityDTO) {
        return null;
    }
}
