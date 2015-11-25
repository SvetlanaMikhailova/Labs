package ru.az.sample.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by smikhailova on 24.11.2015.
 */


public class Basket {

    private Item nameItemBasket;
    private Integer kolvoItemBasket;

    public Basket(Item item) {
        this.nameItemBasket = item;
        this.kolvoItemBasket = 1;
    }

    public Integer getCount() {
        return kolvoItemBasket;
    }

    public Double getSum(){
        return Math.round(this.nameItemBasket.getPrice() * this.kolvoItemBasket * 100d)/100d;
    }

    public boolean itemEquals(Item item){
        return this.nameItemBasket.getId().equals(item.getId());
    }

    public void addCount(){
        if(this.nameItemBasket.getKolvo() > this.kolvoItemBasket) {
            this.kolvoItemBasket++;
        }
    }

    public String getItemTitle(){
        return nameItemBasket.getNameItem();
    }

    public Item getItem() {
        return nameItemBasket;
    }
}
