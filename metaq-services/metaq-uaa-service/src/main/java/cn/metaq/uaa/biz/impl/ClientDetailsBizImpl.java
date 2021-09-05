package cn.metaq.uaa.biz.impl;


import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.data.jpa.BaseTemplate;
import cn.metaq.uaa.biz.ClientDetailsBiz;
import cn.metaq.uaa.dao.ClientDetailsDao;
import cn.metaq.uaa.domain.ClientDetails;
import cn.metaq.uaa.dto.ClientDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ClientDetailsBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午4:15
 * @since 1.0
 */
@Service
public class ClientDetailsBizImpl extends BaseBiz<ClientDetailsDTO, Long, ClientDetailsDao> implements ClientDetailsBiz {

    @Resource
    private BaseTemplate template;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(ClientDetailsDTO entity) {

        ClientDetails clientDetails=new ClientDetails();

        clientDetails.setClientId(entity.getClientId());
        clientDetails.setClientSecret(passwordEncoder.encode(entity.getClientSecret()));
        clientDetails.setAccessTokenValiditySeconds(entity.getAccessTokenValiditySeconds());
        clientDetails.setAutoApproveScopes(entity.getAutoApproveScopes());
        clientDetails.setRefreshTokenValiditySeconds(entity.getRefreshTokenValiditySeconds());
        clientDetails.setAdditionalInformation(entity.getAdditionalInformation());
        clientDetails.setAuthorizedGrantTypes(entity.getAuthorizedGrantTypes());
        clientDetails.setResourceIds(entity.getResourceIds());
        clientDetails.setScope(entity.getScope());
        clientDetails.setWebServerRedirectUri(entity.getWebServerRedirectUri());

        dao.save(clientDetails);
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) {

        return dao.findOne(new Specification<ClientDetails>() {
            @Override
            public Predicate toPredicate(Root<ClientDetails> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.equal(root.get("clientId"), clientId);
            }
        }).orElseThrow();
    }


    @Override
    public Set<String> loadAuthorityByClientId(String clientId) {

        String jql = "select a.authority from ClientAuthority ca " +
                "left join ClientDetails c on ca.clientId=c.id " +
                "left join Authority a on a.id=ca.authorityId " +
                "where c.clientId=:clientId";

        Map<String, Object> params = new HashMap<>();
        params.put("clientId", clientId);

        List<String> authorities = template.list(String.class, jql, params);

        if (!CollectionUtils.isEmpty(authorities)) {
            return authorities.stream().collect(Collectors.toSet());
        }
        return Collections.singleton("");
    }
}
