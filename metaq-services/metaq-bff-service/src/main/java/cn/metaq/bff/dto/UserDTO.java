package cn.metaq.bff.dto;

import cn.metaq.common.core.IDto;
import cn.metaq.uaa.dto.RoleDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO implements IDto{

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 登录名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 最近密码重置时间
	 */
	private java.time.LocalDateTime lastPasswordResetDate;

	/**
	 * 是否启用 0-启用 1-禁用
	 */
	private boolean enabled;

	private List<RoleDTO> roles;
}
