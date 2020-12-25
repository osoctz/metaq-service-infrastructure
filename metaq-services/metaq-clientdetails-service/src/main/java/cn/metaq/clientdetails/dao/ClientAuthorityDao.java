package cn.metaq.clientdetails.dao;

import cn.metaq.clientdetails.domain.ClientAuthority;
import cn.metaq.data.jpa.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAuthorityDao extends BaseRepository<ClientAuthority,Long> {
}
