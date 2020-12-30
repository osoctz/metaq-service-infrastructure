package cn.metaq.uaa.dto;

import cn.metaq.common.core.IDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroupDTO implements IDto{

	private Long id;

	private String type;

	private String nameCn;

	private String nameEn;

	private String priority;

	private Long pid;

}
