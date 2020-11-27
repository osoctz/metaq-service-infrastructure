package cn.metaq.common.area.dto;

import cn.metaq.common.core.IDto;
import lombok.Getter;
import lombok.Setter;

/**
 * AreaDTO
 *
 * @author tz
 * @date 2020/11/27 下午4:03
 * @since 1.0
 */
@Setter
@Getter
public class AreaDTO implements IDto {

    private String code;
    private String name;

    private  String parent;

    private String level;
    private String order;
}
