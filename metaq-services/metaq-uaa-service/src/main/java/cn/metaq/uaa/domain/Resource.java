package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RESOURCE")
@Setter
@Getter
public class Resource implements IEntity<Long>{

	private static final long serialVersionUID =  2309711540457981890L;

	@Column(name = "ID" )
	@Id
	private Long id;

	@Column(name = "NAME_CN" )
	private String nameCn;

	@Column(name = "NAME_EN" )
	private String nameEn;

	@Column(name = "TYPE" )
	private String type;

	@Column(name = "PRIORITY" )
	private Long priority;

}
