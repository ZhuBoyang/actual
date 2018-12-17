package cn.com.taiji.actual.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zxx
 * @version 1.0
 * @date 2018/12/14 16:22
 */

@Entity
@Table(name = "blog")
@Data
public class Blog {

    @Id
    @GeneratedValue
    private Integer bid;

    private String bName;

    private String bAuthor;

    private String bContent;

    private Date createDate;

    private Integer state;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "userInfo")
    private UserInfo userInfo;
}
