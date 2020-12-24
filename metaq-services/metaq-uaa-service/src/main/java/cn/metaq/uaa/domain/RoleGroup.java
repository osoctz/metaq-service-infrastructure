package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role_group")
@Setter
@Getter
public class RoleGroup implements IEntity<Long>{

	private static final long serialVersionUID =  3421917631455682913L;

	@Column(name = "id" )
	@Id
	private Long id;

	@Column(name = "role_id" )
	private Long roleId;

	@Column(name = "group_id" )
	private Long groupId;

}
