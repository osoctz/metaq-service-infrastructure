package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_group")
@Setter
@Getter
public class UserGroup implements IEntity<Long>{

	private static final long serialVersionUID =  5418396176391306200L;

	@Column(name = "id" )
	@Id
	private Long id;

	@Column(name = "user_id" )
	private Long userId;

	@Column(name = "group_id" )
	private Long groupId;

}
