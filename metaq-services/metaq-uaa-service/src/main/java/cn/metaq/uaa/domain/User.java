package cn.metaq.uaa.domain;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * User
 *
 * @author tz
 * @date 2020/12/14 下午2:24
 * @since 1.0
 */
@Entity
@Table(name="user")
@Setter
@Getter
public class User implements IEntity<Long> {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.metaq.data.jpa.id.SnowflakeIdGenerator")
    private Long id;

    private String name;
    private String username;
    private String password;
    private String email;
    private LocalDateTime lastPasswordResetDate;
    private boolean enable;

}
