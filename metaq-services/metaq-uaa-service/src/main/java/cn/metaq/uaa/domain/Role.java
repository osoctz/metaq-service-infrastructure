package cn.metaq.uaa.domain;

import javax.persistence.*;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ROLE")
@Setter
@Getter
public class Role implements IEntity<Long> {


	private static final long serialVersionUID =  4536043035605821868L;

	/**
	 * ID
	 */
	@Column(name = "ID" )
	@Id
	private Long id;

	/**
	 * 角色名
	 */
	@Column(name = "NAME_CN" )
	private String nameCn;

	/**
	 * 角色编码
	 */
	@Column(name = "NAME_EN" )
	private String nameEn;
}
