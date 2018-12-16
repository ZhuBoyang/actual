package cn.com.taiji.actual.domain;

import com.mysql.jdbc.Blob;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author zxx
 * @version 1.0
 * @date 2018/12/14 16:22
 */
//@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue
    private Integer bid;

    private String name;


    private String createDate;

    private Integer state;
}
