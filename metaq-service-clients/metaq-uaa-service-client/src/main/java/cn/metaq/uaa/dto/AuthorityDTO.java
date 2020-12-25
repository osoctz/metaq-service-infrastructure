package cn.metaq.uaa.dto;

import cn.metaq.common.core.IDto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
