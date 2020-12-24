package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "RESOURCE_GROUP")
public class ResourceGroup implements IEntity<Long> {

    @Column(name = "ID")
    @Id
    private Long id;

    @Column(name = "RESOURCE_ID")
    private Long resourceId;

    @Column(name = "GROUP_ID")
    private Long groupId;
}
