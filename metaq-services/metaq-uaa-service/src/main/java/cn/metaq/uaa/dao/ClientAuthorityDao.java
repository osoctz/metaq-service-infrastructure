package cn.metaq.uaa.dao;

import cn.metaq.data.jpa.BaseDao;
import cn.metaq.uaa.domain.ClientAuthority;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAuthorityDao extends BaseDao<ClientAuthority,Long> {
}
