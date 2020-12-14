package cn.metaq.common.area.biz.impl;

import cn.metaq.common.area.biz.AreaBiz;
import cn.metaq.common.area.dao.AreaDao;
import cn.metaq.common.area.domain.Area;
import cn.metaq.common.area.dto.AreaDTO;
import cn.metaq.data.jpa.BaseBiz;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * AreaBizImpl
 *
 * @author tz
 * @date 2020/11/27 下午4:17
 * @since 1.0
 */
@Service
public class AreaBizImpl extends BaseBiz<Area, AreaDTO, Long, AreaDao> implements AreaBiz {

    @Override
    public Specification<Area> map(AreaDTO areaDTO) {

        return (Specification<Area>) (root, cq, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.isNotEmpty(areaDTO.getName())) {
                predicates.add(cb.equal(root.get("name"), areaDTO.getName()));
            }

            if (StringUtils.isNotEmpty(areaDTO.getCode())) {
                predicates.add(cb.equal(root.get("code"), areaDTO.getCode()));
            }

            if (StringUtils.isNotEmpty(areaDTO.getLevel())) {
                predicates.add(cb.equal(root.get("level"), areaDTO.getLevel()));
            }

            if (StringUtils.isNotEmpty(areaDTO.getParent())) {
                predicates.add(cb.equal(root.get("parent"), areaDTO.getParent()));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
