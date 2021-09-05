package cn.metaq.tx1.domain;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProductOrder
 *
 * @author tz
 * @date 2020/12/11 下午2:01
 * @since 1.0
 */
@Table(name = "product_order")
@Entity
@Setter
@Getter
public class ProductOrder implements IEntity<Long> {

    @Id
    private Long id;
    private String name;
}
