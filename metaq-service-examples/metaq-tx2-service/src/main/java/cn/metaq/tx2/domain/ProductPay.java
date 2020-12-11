package cn.metaq.tx2.domain;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * ProductOrder
 *
 * @author tz
 * @date 2020/12/11 下午2:01
 * @since 1.0
 */
    @Table(name = "product_pay")
@Entity
@Setter
@Getter
public class ProductPay implements IEntity<Long> {

    @Id
    private Long id;
    private Long orderId;

    private BigDecimal amount;
}
