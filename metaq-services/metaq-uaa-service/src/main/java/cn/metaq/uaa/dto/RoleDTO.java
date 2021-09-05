package cn.metaq.uaa.dto;

import cn.metaq.common.core.IDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements IDto{

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 角色名
	 */
	private String nameCn;

	/**
	 * 角色编码
	 */
	private String nameEn;

}
