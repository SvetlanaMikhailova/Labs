package ru.az.sample.model;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.jar.Attributes;

/**
 * Created by smikhailova on 23.11.2015.
 */
@Entity


public class Item {

    @Id
    private Long id;
    private Long article;
    @ManyToOne
    @JoinColumn(name="category_id")

    private Category category;
    private String nameItem;
    private Integer kolvo;
    private Double price;

    public Item() {
    }

    public Item(Long id,String category) {
        this.id = id;

    }

    public Long getId() {
        return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;}

public void setCategory(Category category) {
        this.category = category;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public void setKolvo(Integer kolvo) {
        this.kolvo = kolvo;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getArticle() {
        return article;
    }

    public void setArticle(Long article) {
        this.article = article;
    }

    public Integer getKolvo() {
        return kolvo;
    }
    public double getPrice() {
        return price;
    }

}
