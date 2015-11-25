package ru.az.sample.dao;

import ru.az.sample.model.Item;

import java.util.Collection;
import java.util.List;

/**
 * Created by smikhailova on 20.11.2015.
 */
public interface ItemDao {

 public List<Item> getAllItems();
 public Item findById(Long id);
 public List sortByCategory(Long catID);
 public void update(Item item);
}
