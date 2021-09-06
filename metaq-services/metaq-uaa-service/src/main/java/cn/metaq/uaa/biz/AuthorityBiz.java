package cn.metaq.uaa.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.uaa.dto.AuthorityDTO;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

/**
 * AuthorityBiz
 *
 * @author tz
 * @date 2020/12/14 下午3:25
 * @since 1.0
 */
public interface AuthorityBiz extends Biz<AuthorityDTO, Long>, QueryBiz<AuthorityDTO, Specification> {

    Set<String> loadAuthorityByUsername(String username);

}
