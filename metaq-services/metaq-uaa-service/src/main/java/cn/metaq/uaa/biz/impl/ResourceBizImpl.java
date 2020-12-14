package cn.metaq.uaa.biz.impl;

import cn.metaq.data.jpa.BaseBiz;
import cn.metaq.uaa.biz.ResourceBiz;
import cn.metaq.uaa.dao.ResourceDao;
import cn.metaq.uaa.domain.Resource;
import cn.metaq.uaa.dto.ResourceDTO;
import org.springframework.stereotype.Service;

/**
 * ResourceBizImpl
 *
 * @author tz
 * @date 2020/12/14 下午3:27
 * @since 1.0
 */
@Service
public class ResourceBizImpl extends BaseBiz<Resource, ResourceDTO, Long, ResourceDao> implements ResourceBiz {
}
