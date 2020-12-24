package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "resource")
@Setter
@Getter
public class Resource implements IEntity<Long>{

	private static final long serialVersionUID =  2309711540457981890L;

	@Column(name = "ID" )
	@Id
	private Long id;

	@Column(name = "NAME" )
	private String name;

	@Column(name = "CODE" )
	private String code;

	@Column(name = "TYPE" )
	private String type;

//	@Column(name = "PATH" )
//	private String path;
//
//	@Column(name = "ICON" )
//	private String icon;

	@Column(name = "PRIORITY" )
	private Long priority;

	@Column(name = "PID" )
	private Long pid;

}
