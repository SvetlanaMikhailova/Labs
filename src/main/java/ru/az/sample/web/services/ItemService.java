package ru.az.sample.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.az.sample.dao.InMemoryItemDao;
import ru.az.sample.dao.ItemDao;
import ru.az.sample.dao.UserDAO;
import ru.az.sample.model.Item;
import ru.az.sample.model.User;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Created by smikhailova on 23.11.2015.
 */
@Service
public class ItemService {
    @Autowired
    private InMemoryItemDao itemRepository;

    @Resource
    private ItemDao daoitem;

    @Transactional
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

@Transactional
    public Item findById(Long id) { return itemRepository.findById(id);
    }



    @Transactional
    public Collection<Item> getCategoryList(Long catID) {
        return itemRepository.sortByCategory(catID);
    }

    @Transactional
    public void save(Item item) {
        daoitem.update(item);}
}

