package cn.metaq.common.mobile.domain;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Mobile
 *
 * @author tz
 * @date 2020/11/30 下午2:53
 * @since 1.0
 */
@Table(name = "t_mobile_location")
@Entity
@Setter
@Getter
public class Mobile implements IEntity<Long>, Serializable {

    @Id
    private Long id;

    private String phoneNumber;
    private String province;
    private String city;
    private String zipCode;
    private String areaCode;
    private String phoneType;
}
