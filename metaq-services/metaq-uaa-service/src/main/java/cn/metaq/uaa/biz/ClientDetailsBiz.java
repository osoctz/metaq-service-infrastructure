package cn.metaq.uaa.biz;

import cn.metaq.data.Biz;
import cn.metaq.data.QueryBiz;
import cn.metaq.uaa.domain.ClientDetails;
import cn.metaq.uaa.dto.AuthorityDTO;
import cn.metaq.uaa.dto.ClientDetailsDTO;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

/**
 * ClientDetailsBiz
 *
 * @author tz
 * @date 2020/12/14 下午4:14
 * @since 1.0
 */
public interface ClientDetailsBiz extends Biz<ClientDetailsDTO, Long>, QueryBiz<ClientDetailsDTO, Specification> {

    ClientDetails loadClientByClientId(String clientId);


    Set<String> loadAuthorityByClientId(String clientId);
}
