package top.book.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Category)实体类
 *
 * @author makejava
 * @since 2021-04-12 09:32:14
 */
public class Category implements Serializable {
    private static final long serialVersionUID = 165551516336706630L;
    
    private Integer id;
    /**
    * 分类名称
    */
    private String cName;
    
    private Date createTime;
    
    private Date updateTime;

    public Category() {
    }

    public Category(String cName) {
        this.cName = cName;
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return cName;
    }
}