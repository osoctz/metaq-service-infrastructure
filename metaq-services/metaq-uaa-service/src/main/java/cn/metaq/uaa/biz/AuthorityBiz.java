package cn.metaq.uaa.biz;

import cn.metaq.data.Biz;
import cn.metaq.uaa.dto.AuthorityDTO;

import java.util.Set;

/**
 * AuthorityBiz
 *
 * @author tz
 * @date 2020/12/14 下午3:25
 * @since 1.0
 */
public interface AuthorityBiz extends Biz<AuthorityDTO, Long> {

    Set<String> loadAuthorityByUsername(String username);

}
