package com.javaexpressintellij.javaexpressclone.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class Prod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodId;

    @Size(min =3, max =100, message="prodName should have at least 3 characters")
    @NotNull
    private String prodName;

    @NotEmpty(message="product description must not be empty")
    private String prodDescription;

    @CreationTimestamp
    private Date createdTime;

    @UpdateTimestamp
    private Date updatedTime;

    public Prod() {

    }

    public Prod(Long prodId, String prodName, String prodDescription, Date createdTime, Date updatedTime) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodDescription = prodDescription;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Long getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Prod{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", prodDescription='" + prodDescription + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
