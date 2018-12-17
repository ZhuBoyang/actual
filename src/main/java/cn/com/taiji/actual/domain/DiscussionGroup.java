package cn.com.taiji.actual.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author zxx
 * @version 1.0
 * @date 2018/12/14 16:28
 */

@Entity
@Table(name = "discussion_group")
@Data
public class DiscussionGroup {

    @Id
    @GeneratedValue
    private Integer did;

    private String discussionName;

    //private UserInfo leader;

    //private UserInfo leader;

    @ManyToMany
    @JoinTable(name = "Discussion_User",
            joinColumns = {@JoinColumn(name = "did")},
            inverseJoinColumns = {@JoinColumn(name = "uid")})
    private List<UserInfo> users;

    private Date createDate;

    private Integer state;

 /*   @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Article> articles;*/
}
