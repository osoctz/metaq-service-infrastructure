package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AUTHORITY")
@Setter
@Getter
public class Authority implements IEntity<Long>{

	private static final long serialVersionUID =  4958523410019536082L;

	/**
	 * ID
	 */
	@Column(name = "ID" )
	@Id
	private Long id;

	/**
	 * 资源ID
	 */
	@Column(name = "RESOURCE_ID" )
	private Long resourceId;

	/**
	 * 权限 A:B:C
	 */
	@Column(name = "AUTHORITY" )
	private String authority;

}
