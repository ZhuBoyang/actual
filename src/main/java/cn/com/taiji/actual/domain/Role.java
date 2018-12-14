package cn.com.taiji.actual.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zxx
 * @date 2018/12/14 15:56
 * @version 1.0
 */
@Entity
@Table(name = "sys_role")
@Data
public class Role {
    @Id
    @GeneratedValue
    private Integer rid;

    private String roleName;

    private String createDate;

    private Integer state;
}
