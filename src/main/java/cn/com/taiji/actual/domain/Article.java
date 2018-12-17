package cn.com.taiji.actual.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Barry
 * @version v1.0
 * @description
 * @date created on 2018/12/17 15:24
 */

@Entity
@Table(name = "article")
@Data
public class Article {

    @Id
    @GeneratedValue
    private Integer aid;

    private String aName;

    private String aContent;

    private Date createDate;

    private String state;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "userInfo")
    private UserInfo userInfo;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "DisGroup")
    private DiscussionGroup DisGroup;

}
