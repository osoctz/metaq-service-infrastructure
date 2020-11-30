package cn.metaq.common.mobile.biz.impl;

import cn.metaq.common.mobile.biz.MobileBiz;
import cn.metaq.common.mobile.dao.MobileDao;
import cn.metaq.common.mobile.domain.Mobile;
import cn.metaq.common.mobile.dto.MobileDTO;
import cn.metaq.data.jpa.BaseBiz;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * MobileBizImpl
 *
 * @author tz
 * @date 2020/11/30 下午3:08
 * @since 1.0
 */
@Service
public class MobileBizImpl extends BaseBiz<Mobile, MobileDTO, Long, MobileDao> implements MobileBiz {

    public Mobile findOneByPhoneNumber(String phoneNumber) {

        return repository.findOne((Specification<Mobile>) (root, cq, cb)
                -> cb.equal(root.get("phoneNumber"), phoneNumber)).orElseThrow();
    }

    public List<Mobile> findAllByAreaCode(String areaCode) {

        return repository.findAll((Specification<Mobile>) (root, cq, cb)
                -> cb.equal(root.get("areaCode"), areaCode));
    }

    @Override
    public Specification map(MobileDTO mobileDTO) {

        return (Specification<Mobile>) (root, cq, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.isNotEmpty(mobileDTO.getProvince())) {
                predicates.add(cb.equal(root.get("province"), mobileDTO.getProvince()));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
