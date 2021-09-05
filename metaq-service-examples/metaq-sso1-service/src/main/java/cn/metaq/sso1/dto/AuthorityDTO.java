package cn.metaq.sso1.dto;

import cn.metaq.common.core.IDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorityDTO implements IDto{

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 资源ID
	 */
	private Long resourceId;

	/**
	 * 权限 A:B:C
	 */
	private String authority;

}
