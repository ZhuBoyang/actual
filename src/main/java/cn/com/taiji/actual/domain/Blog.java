package cn.com.taiji.actual.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Barry
 * @version v1.0
 * @description 博客实体类
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

    private byte[] bContent;

    private Date createDate;

    private String state;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "userInfo")
    private UserInfo userInfo;

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", bName='" + bName + '\'' +
                ", bContent=" + Arrays.toString(bContent) +
                ", createDate=" + createDate +
                ", state='" + state + '\'' +
                '}';
    }
}
