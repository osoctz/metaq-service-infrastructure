package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ROLE_GROUP")
@Setter
@Getter
public class RoleGroup implements IEntity<Long>{

	private static final long serialVersionUID =  3421917631455682913L;

	@Column(name = "ID" )
	@Id
	private Long id;

	@Column(name = "ROLE_ID" )
	private Long roleId;

	@Column(name = "GROUP_ID" )
	private Long groupId;

}
