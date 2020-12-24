package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER_GROUP")
@Setter
@Getter
public class UserGroup implements IEntity<Long>{

	private static final long serialVersionUID =  5418396176391306200L;

	@Column(name = "ID" )
	@Id
	private Long id;

	@Column(name = "USER_ID" )
	private Long userId;

	@Column(name = "GROUP_ID" )
	private Long groupId;

}
