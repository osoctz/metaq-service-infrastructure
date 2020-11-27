package cn.metaq.common.area.domain;

import cn.metaq.common.core.IEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Area
 *
 * @author tz
 * @date 2020/11/27 下午3:48
 * @since 1.0
 */
@Table(name = "t_area")
@Entity
@Setter
@Getter
public class Area implements IEntity<Long>, Serializable {

    @Id
    private Long id;

    private String code;
    private String name;

    private  String parent;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "p_code", referencedColumnName = "code")
//    private Area parent;
//
//    @OneToMany(mappedBy="parent",fetch=FetchType.EAGER)
//    @NotFound(action = NotFoundAction.IGNORE)
//    @OrderBy(value="order ASC")
//    private List<Area> children=new ArrayList<Area>();

    private String level;
    private String order;
}
