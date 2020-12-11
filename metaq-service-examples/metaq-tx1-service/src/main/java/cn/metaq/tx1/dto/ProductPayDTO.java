package cn.metaq.tx1.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * ProductOrder
 *
 * @author tz
 * @date 2020/12/11 下午2:01
 * @since 1.0
 */
@Setter
@Getter
public class ProductPayDTO  {

    private Long id;
    private Long orderId;
    private BigDecimal amount;
}
