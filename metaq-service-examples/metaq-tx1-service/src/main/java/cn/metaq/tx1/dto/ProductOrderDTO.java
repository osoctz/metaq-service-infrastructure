package cn.metaq.tx1.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * ProductOrderDTO
 *
 * @author tz
 * @date 2020/12/11 下午2:13
 * @since 1.0
 */
@Setter
@Getter
public class ProductOrderDTO {

    private Long id;

    private String name;

    private BigDecimal amount;
}
