package cn.metaq.common.mobile.dto;

import cn.metaq.common.core.IDto;
import lombok.Getter;
import lombok.Setter;

/**
 * MobileDTO
 *
 * @author tz
 * @date 2020/11/30 下午3:07
 * @since 1.0
 */
@Setter
@Getter
public class MobileDTO implements IDto {

    private String phoneNumber;
    private String province;
    private String city;
    private String zipCode;
    private String areaCode;
    private String phoneType;
}
