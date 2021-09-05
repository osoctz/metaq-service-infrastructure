package cn.metaq.uaa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.uaa.biz.GroupBiz;
import cn.metaq.uaa.dao.GroupDao;
import cn.metaq.uaa.domain.Group;
import cn.metaq.uaa.dto.GroupDTO;
import cn.metaq.uaa.dto.GroupNodeDTO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * GroupBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午3:27
 * @since 1.0
 */
@Service
public class GroupBizImpl extends BaseBiz<GroupDTO, Long, GroupDao> implements GroupBiz {
    @Override
    public void save(GroupDTO entity) {

        Group group = new Group();

        group.setNameCn(entity.getNameCn());
        group.setNameEn(entity.getNameEn());
        group.setType(entity.getType());
        group.setPriority(entity.getPriority());
        group.setPid(entity.getPid());

        dao.save(group);
    }

    @Override
    public void update(GroupDTO entity) {

        Group group = dao.findById(entity.getId()).orElseThrow();

        group.setNameCn(entity.getNameCn());
        group.setNameEn(entity.getNameEn());
        group.setType(entity.getType());
        group.setPriority(entity.getPriority());
        group.setPid(entity.getPid());

        dao.save(group);
    }

    @Override
    public List<GroupNodeDTO> listGroupByType(Integer type) {
        //查询根节点 pid=null
        List<Group> groups = dao.findAll((Specification<Group>) (root, cq, cb) -> cb.and(cb.equal(root.get("type"), type), root.get("pid").isNull()));
        //查询子节点
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "priority");
        List<Group> subGroups = dao.findAll((Specification<Group>) (root, cq, cb) -> cb.and(cb.equal(root.get("type"), type), root.get("pid").isNotNull()), Sort.by(order));
        //分组
        Map<Long, List<Group>> subGroupMap = subGroups.stream().collect(Collectors.groupingBy(Group::getPid));

        List<GroupNodeDTO> parents = this.mapToGroupNode(groups);
        for (GroupNodeDTO group : parents) {
            //是否存在子节点
            if (subGroupMap.containsKey(group.getId())) {
                group.setChildren(this.mapToGroupNode(subGroupMap.get(group.getId())));
                //移除当前子节点集合
                subGroupMap.remove(group.getId());
            }
        }

        //subGroupMap.isNotEmpty则说明还有子节点没找到父节点
        if (!subGroupMap.isEmpty()) {

            for (GroupNodeDTO parent : parents) {
                this.recurChildren(parent, subGroupMap);
            }

        }

        return parents;
    }

    /**
     * 递归查找parent的children
     *
     * @param parent
     * @return
     */
    private void recurChildren(GroupNodeDTO parent, Map<Long, List<Group>> subGroupMap) {

        if (subGroupMap.isEmpty()) {
            return;
        }

        List<GroupNodeDTO> children = parent.getChildren();

        for (GroupNodeDTO child : children) {
            //是否存在子节点
            if (CollectionUtils.isEmpty(child.getChildren())) {

                if (subGroupMap.containsKey(child.getId())) {
                    child.setChildren(this.mapToGroupNode(subGroupMap.get(child.getId())));
                    //移除当前子节点集合
                    subGroupMap.remove(child.getId());
                }

            } else {
                this.recurChildren(child, subGroupMap);
            }
        }

    }

    private GroupNodeDTO mapToGroupNode(Group group) {

        GroupNodeDTO groupNodeDTO = new GroupNodeDTO();

        groupNodeDTO.setId(group.getId());
        groupNodeDTO.setNameCn(group.getNameCn());
        groupNodeDTO.setNameEn(group.getNameEn());
        groupNodeDTO.setType(group.getType());
        groupNodeDTO.setPriority(group.getPriority());

        return groupNodeDTO;
    }

    private List<GroupNodeDTO> mapToGroupNode(List<Group> groups) {

        return groups.stream().map(s -> mapToGroupNode(s)).collect(Collectors.toList());
    }
}
