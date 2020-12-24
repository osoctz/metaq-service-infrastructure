package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GROUP")
@Setter
@Getter
public class Group implements IEntity<Long>{

	private static final long serialVersionUID =  781118650285121874L;

	@Column(name = "ID" )
	@Id
	private Long id;

	@Column(name = "type" )
	private String type;

	@Column(name = "NAME_CN" )
	private String nameCn;

	@Column(name = "NAME_EN" )
	private String nameEn;

	@Column(name = "PRIORITY" )
	private String priority;

	@Column(name = "PID" )
	private Long pid;
}
