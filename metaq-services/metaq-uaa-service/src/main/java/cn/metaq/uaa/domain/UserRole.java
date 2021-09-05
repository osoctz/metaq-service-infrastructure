package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER_ROLE")
@Setter
@Getter
public class UserRole implements IEntity<Long>{


	private static final long serialVersionUID =  6993072715102672000L;

	/**
	 * ID
	 */
	@Column(name = "ID" )
	@Id
	private Long id;
	/**
	 * 用户ID
	 */
	@Column(name = "USER_ID" )
	private Long userId;
	/**
	 * 角色ID
	 */
	@Column(name = "ROLE_ID" )
	private Long roleId;
}
