package ru.az.sample.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.az.sample.model.Basket;
import ru.az.sample.model.Item;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by smikhailova on 24.11.2015.
 */

@Repository
public class InMemoryBasketDao implements BasketDao{

    private Collection<Basket> basketItems = new ArrayList<Basket>();



    public void addToBasket (Item item) {
        for(Basket basket : basketItems){
            if(basket.itemEquals(item)){
                basket.addCount();
                return;
            }
        }
        if(item.getKolvo() > 0) {
            basketItems.add(new Basket(item));
        }

    }

    public List<Basket> getAllItemsBasket() {
        return (List<Basket>) this.basketItems;
    }

    public List<String> getPositions() {
       List<String> res = new ArrayList<String>();
       for(Basket basketItem : basketItems){
           res.add(basketItem.getItemTitle() + "  |  " + basketItem.getCount() + "  |  " + basketItem.getSum());
       }
       return res;
   }

    public List<Basket> getList() {
        return (List<Basket>) this.basketItems;
    }

    public Double getSum() {
        Double sum = 0d;
        for(Basket item : basketItems){
            sum += item.getSum();
        }
        return Math.round(sum*100d)/100d;
    }
    public void clear() {

        this.basketItems = new ArrayList<Basket>();
    }
}
