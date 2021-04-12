package top.book.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author makejava
 * @since 2021-04-12 09:32:00
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 172384798917493695L;
    
    private Integer id;
    
    private String name;
    /**
    * 图片路径
    */
    private String poster;
    
    private Date createTime;
    
    private Date updateTime;
    
    private Double price;
    
    private Integer score;
    
    private Integer cId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

}