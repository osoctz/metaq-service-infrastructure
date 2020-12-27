package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT_AUTHORITY")
@Setter
@Getter
public class ClientAuthority implements IEntity<Long> {

    @Column(name = "ID" )
    @Id
    private Long id;

    @Column(name = "CLIENT_ID" )
    private Long clientId;

    @Column(name = "AUTHORITY_ID" )
    private Long authorityId;
}
