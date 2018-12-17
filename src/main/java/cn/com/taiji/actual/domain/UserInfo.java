package cn.com.taiji.actual.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author zxx
 * @date 2018/12/14 10:52
 * @version 1.0
 */
@Entity
@Table(name = "sys_user")
@Data
public class UserInfo {
    @Id
    @GeneratedValue
    private Integer uid;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private Date createDate;

    private String state;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole",
            joinColumns = {@JoinColumn(name = "uid")},inverseJoinColumns = {@JoinColumn(name = "rid")})
    private List<Role> roles;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "DiscussionUser",
//            joinColumns = {@JoinColumn(name = "uid")},inverseJoinColumns = {@JoinColumn(name = "did")})
//    private List<DiscussionGroup> groups;
}
