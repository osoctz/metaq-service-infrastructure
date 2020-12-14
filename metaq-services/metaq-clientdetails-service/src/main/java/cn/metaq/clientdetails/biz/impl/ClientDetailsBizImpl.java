package cn.metaq.clientdetails.biz.impl;

import cn.metaq.clientdetails.biz.ClientDetailsBiz;
import cn.metaq.clientdetails.dao.ClientDetailsDao;
import cn.metaq.clientdetails.domain.ClientDetails;
import cn.metaq.clientdetails.dto.ClientDetailsDTO;
import cn.metaq.data.jpa.BaseBiz;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * ClientDetailsBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午4:15
 * @since 1.0
 */
@Service
public class ClientDetailsBizImpl extends BaseBiz<ClientDetails, ClientDetailsDTO, Long, ClientDetailsDao> implements ClientDetailsBiz {

    @Override
    public ClientDetails loadClientByClientId(String clientId) {

        return repository.findOne(new Specification<ClientDetails>() {
            @Override
            public Predicate toPredicate(Root<ClientDetails> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.equal(root.get("clientId"), clientId);
            }
        }).orElseThrow();
    }
}
