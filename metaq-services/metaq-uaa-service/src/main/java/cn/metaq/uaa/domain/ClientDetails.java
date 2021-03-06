package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "CLIENT_DETAILS")
@Setter
@Getter
public class ClientDetails implements IEntity<Long>{

	private static final long serialVersionUID =  1938419311902243323L;

	@Column(name = "ID" )
	@Id
	@GeneratedValue(generator = "snowflakeId")
	@GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
	private Long id;

	@Column(name = "client_id" )
	private String clientId;

	@Column(name = "client_secret" )
	private String clientSecret;

	@Column(name = "resource_ids" )
	private String resourceIds;

	@Column(name = "scope" )
	private String scope;

	/**
	 * authorizedGrantTypes
	 */
	@Column(name = "authorized_grant_types" )
	private String authorizedGrantTypes;

	/**
	 * 服务器端登录成功/失败后重定向到的客户端地址webServerRedirectUri
	 */
	@Column(name = "web_server_redirect_uri" )
	private String webServerRedirectUri;

	@Column(name = "auto_approve_scopes" )
	private String autoApproveScopes;

	@Column(name = "access_token_validity_seconds" )
	private Integer accessTokenValiditySeconds;

	@Column(name = "refresh_token_validity_seconds" )
	private Integer refreshTokenValiditySeconds;

	@Column(name = "additional_information" )
	private String additionalInformation;

}
