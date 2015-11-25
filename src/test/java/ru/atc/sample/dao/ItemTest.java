package ru.atc.sample.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.az.sample.model.Item;
import ru.az.sample.web.services.ItemService;

import java.util.Collection;

import static org.junit.Assert.*;
/**
 * Created by smikhailova on 25.11.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ItemTest {

    private static final Logger logger = LoggerFactory.getLogger(StudentDaoServiceTest.class);

    @Autowired
    ItemService itemService;



    @Test
    public void baseNotNull() {
        Item item = itemService.findById((long) 25);
        assertNotNull(item);
        assertEquals((long)item.getId(),25L);
        

    }
    @Test
    public void getAllItemsTest() {
    Collection<Item> allItems = itemService.getAllItems();
    logger.debug("{}", allItems);
    }



}
