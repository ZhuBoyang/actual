package cn.com.taiji.actual.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Barry
 * @version v1.0
 * @description
 * @date created on 2018/12/17 15:32
 */

@Entity
@Table(name = "comment")
@Data
public class Comment {

    @Id
    @GeneratedValue
    private Integer cid;

    private String cAuthor;

    private String content;

    private Date createDate;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "article")
    private Article article;
}
