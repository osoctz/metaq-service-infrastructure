package cn.metaq.uaa.dto;

import cn.metaq.common.core.IDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceDTO implements IDto{

	private Long id;

	private String nameCn;

	private String nameEn;

	private String type;

	private Long priority;

}
