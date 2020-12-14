package cn.metaq.uaa.security.details;

import cn.metaq.uaa.client.ClientDetailsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * CustomClientDetailsService
 *
 * @author tz
 * @date 2020/12/14 下午5:12
 * @since 1.0
 */
public class CustomClientDetailsService implements ClientDetailsService {

    @Autowired
    private ClientDetailsClient clientDetailsClient;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {


        return null;
    }
}
