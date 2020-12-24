package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "group")
@Setter
@Getter
public class Group implements IEntity<Long>{

	private static final long serialVersionUID =  781118650285121874L;

	@Column(name = "id" )
	@Id
	private Long id;

	@Column(name = "name" )
	private String name;
}
