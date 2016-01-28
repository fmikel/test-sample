package com.sample.app.model.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "InventoryElement", indexes = {
        @Index(columnList = "code", name = "code_idx")
})
public class InventoryElement implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer code;

    @Column
    private String name;

    @Column
    private Double cost;

    @Column
    private Date date;

    public InventoryElement() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
