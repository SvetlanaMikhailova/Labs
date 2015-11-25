package ru.az.sample.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.az.sample.dao.BasketDao;
import ru.az.sample.dao.InMemoryBasketDao;
import ru.az.sample.dao.InMemoryItemDao;
import ru.az.sample.model.Basket;
import ru.az.sample.model.Item;

import java.util.List;

/**
 * Created by smikhailova on 24.11.2015.
 */

@Service
public class BasketService {

    @Autowired
    BasketDao basketDAO;

    @Autowired
     InMemoryBasketDao itemRepository;

    @Autowired
    ItemService itemsService;


    @Transactional
    public void addToBasket (Item item){
        basketDAO.addToBasket(item);
    };

    public List<String> getPositions() {
        return basketDAO.getPositions();
    }
    public Double getSum() {
        return basketDAO.getSum();
    }

    public void buyitems() {
        List<Basket> basketList = basketDAO.getAllItemsBasket();
        for(Basket basketItem : basketList){
            Item item = basketItem.getItem();
            item.setKolvo(basketItem.getItem().getKolvo() - basketItem.getCount());
            itemsService.save(item);
            basketDAO.clear();
        }
    }
}
