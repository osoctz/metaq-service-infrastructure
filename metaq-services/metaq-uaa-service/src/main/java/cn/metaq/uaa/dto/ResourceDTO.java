package cn.metaq.uaa.dto;

import cn.metaq.common.core.IDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceDTO implements IDto{

	private Long id;

	private String name;

	private String code;

	private String type;

	private Long pid;

}
