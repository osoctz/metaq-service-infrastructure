package cn.metaq.uaa.dto;

import cn.metaq.common.core.IDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDTO implements IDto{

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 角色名
	 */
	private String name;

	/**
	 * 角色编码
	 */
	private String code;

}
