package cn.metaq.uaa.dto;

import cn.metaq.common.core.IDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRoleDTO implements IDto {


	private static final long serialVersionUID =  6993072715102672000L;

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 角色ID
	 */
	private Long roleId;
}
