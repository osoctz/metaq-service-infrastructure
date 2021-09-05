package cn.metaq.uaa.dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupNodeDTO {

    private Long id;

    private String type;

    private String nameCn;

    private String nameEn;

    private String priority;

    private List<GroupNodeDTO> children;
}
