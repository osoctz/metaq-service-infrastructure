package cn.metaq.uaa.security.details;

import cn.metaq.clientdetails.client.ClientDetailsClient;
import cn.metaq.clientdetails.dto.ClientDetailsDTO;
import cn.metaq.uaa.client.UaaServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Cacheable(cacheNames = {"uaa.clientDetails"}, key = "#clientId")
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        ClientDetailsDTO clientDetails = clientDetailsClient.loadClientByClientId(clientId);

        String resourceIds = clientDetails.getResourceIds();
        String scopes = clientDetails.getScope();
        String grantTypes = clientDetails.getAuthorizedGrantTypes();
//        String authorities = clientDetails.getAuthorities();
        String redirectUris = clientDetails.getWebServerRedirectUri();
        Integer refreshTokenValiditySeconds = clientDetails.getRefreshTokenValiditySeconds();
        Integer accessTokenValiditySeconds = clientDetails.getAccessTokenValiditySeconds();
        String clientSecret = clientDetails.getClientSecret();
        Set<String> authoritySet = clientDetailsClient.loadAuthorityByClientId(clientId);
        String authorities = "";

        if (CollectionUtils.isEmpty(authoritySet)) {
            authorities = authoritySet.stream().collect(Collectors.joining(","));
        }

        BaseClientDetails baseClientDetails = new BaseClientDetails(clientId, resourceIds, scopes, grantTypes, authorities, redirectUris);
        baseClientDetails.setRefreshTokenValiditySeconds(refreshTokenValiditySeconds);
        baseClientDetails.setAccessTokenValiditySeconds(accessTokenValiditySeconds);
        baseClientDetails.setClientSecret(clientSecret);
        baseClientDetails.setAutoApproveScopes(Arrays.stream(clientDetails.getAutoApproveScopes().split("[,]")).collect(Collectors.toList()));

        return baseClientDetails;
    }
}
