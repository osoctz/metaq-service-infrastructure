package cn.metaq.clientdetails.biz;

import cn.metaq.clientdetails.domain.ClientDetails;
import cn.metaq.clientdetails.dto.ClientDetailsDTO;
import cn.metaq.data.Biz;

import java.util.Set;

/**
 * ClientDetailsBiz
 *
 * @author tz
 * @date 2020/12/14 下午4:14
 * @since 1.0
 */
public interface ClientDetailsBiz extends Biz<ClientDetails, ClientDetailsDTO, Long> {

    ClientDetails loadClientByClientId(String clientId);


    Set<String> loadAuthorityByClientId(String clientId);
}
