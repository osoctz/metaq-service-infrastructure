package cn.metaq.uaa.dto;

import cn.metaq.common.core.IDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDetailsDTO implements IDto{

	private Long id;

	private String clientId;

	private String clientSecret;

	private String resourceIds;

	private String scope;

	private String authorities;

	/**
	 * authorizedGrantTypes
	 */
	private String authorizedGrantTypes;

	/**
	 * 服务器端登录成功/失败后重定向到的客户端地址webServerRedirectUri
	 */
	private String webServerRedirectUri;

	private String autoApproveScopes;

	private Integer accessTokenValiditySeconds;

	private Integer refreshTokenValiditySeconds;

	private String additionalInformation;

}
