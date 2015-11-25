package ru.az.sample.dao;

import ru.az.sample.model.Basket;
import ru.az.sample.model.Item;

import java.util.List;

/**
 * Created by smikhailova on 24.11.2015.
 */

public interface BasketDao {
    public List<Basket> getAllItemsBasket ();
    public void addToBasket (Item item);
    public List<String> getPositions();
    public Double getSum();
    public void clear();
}
