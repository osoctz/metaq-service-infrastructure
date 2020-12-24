package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ROLE_AUTHORITY")
@Setter
@Getter
public class RoleAuthority implements IEntity<Long>{

	private static final long serialVersionUID =  6311698587397790036L;

	@Column(name = "ID" )
	@Id
	private Long id;

	@Column(name = "ROLE_ID" )
	private Long roleId;

	@Column(name = "AUTHORITY_ID" )
	private Long authorityId;

}
