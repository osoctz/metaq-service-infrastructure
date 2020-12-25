package cn.metaq.clientdetails.biz.impl;

import cn.metaq.clientdetails.biz.ClientDetailsBiz;
import cn.metaq.clientdetails.dao.ClientDetailsDao;
import cn.metaq.clientdetails.domain.ClientDetails;
import cn.metaq.clientdetails.dto.ClientDetailsDTO;
import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.data.jpa.BaseTemplate;
import cn.metaq.uaa.client.UaaServiceClient;
import cn.metaq.uaa.dto.AuthorityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
public class ClientDetailsBizImpl extends BaseBiz<ClientDetails, ClientDetailsDTO, Long, ClientDetailsDao> implements ClientDetailsBiz {

    @Resource
    private BaseTemplate template;

    @Autowired
    private UaaServiceClient uaaServiceClient;

    @Override
    public ClientDetails loadClientByClientId(String clientId) {

        return repository.findOne(new Specification<ClientDetails>() {
            @Override
            public Predicate toPredicate(Root<ClientDetails> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.equal(root.get("clientId"), clientId);
            }
        }).orElseThrow();
    }


    @Override
    public Set<String> loadAuthorityByClientId(String clientId) {

        String jql = "select ca.authorityId from ClientAuthority ca " +
                "left join ClientDetails c on ca.clientId=c.id " +
                "where c.clientId=:clientId";

        Map<String, Object> params = new HashMap<>();
        params.put("clientId", clientId);

        List<String> authorityIds = template.list(String.class, jql, params);

        List<AuthorityDTO> authorities = uaaServiceClient.list();

        if (!CollectionUtils.isEmpty(authorities)) {
            return authorities.stream().filter(a -> authorityIds.contains(a.getId())).map(s -> s.getAuthority()).collect(Collectors.toSet());
        }
        return Collections.singleton("");
    }
}
