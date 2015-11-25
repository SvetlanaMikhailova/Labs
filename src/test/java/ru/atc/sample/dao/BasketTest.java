package ru.atc.sample.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.az.sample.model.Item;
import ru.az.sample.web.services.BasketService;
import ru.az.sample.web.services.ItemService;

import static org.junit.Assert.*;
/**
 * Created by smikhailova on 25.11.2015.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BasketTest {
    private static final Logger logger = LoggerFactory.getLogger(StudentDaoServiceTest.class);

    @Autowired
    BasketService basketService;
    @Autowired
    ItemService itemService;

    @Test
    public void addItemAndSummTest() {
        Item item = itemService.findById((long) 22);
        assertNotNull(item);
        basketService.addToBasket(item);
        assertEquals(basketService.getPositions().size(), 1);
        assertEquals(basketService.getSum(),(Double)(item.getPrice()));
    }


}
