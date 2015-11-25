package ru.az.sample.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.az.sample.web.services.BasketService;
import ru.az.sample.web.services.ItemService;

/**
 * Created by smikhailova on 24.11.2015.
 */

@Controller
public class BascketController {
    @Autowired
    BasketService basketService;
    @Autowired
    ItemService itemsService;

    @RequestMapping("item/add/{itemId}")
    public ModelAndView buyItem(@PathVariable Long itemId) {
        basketService.addToBasket(itemsService.findById(itemId));
        return new ModelAndView("redirect:/List");}

    @RequestMapping("/basketOut")
    public String basket(ModelMap model) {
        model.addAttribute("rows", basketService.getPositions());
        model.addAttribute("sum", basketService.getSum());
        return "ListBasket";}

    @RequestMapping("/buyitem")
    public ModelAndView buyitem(){
        basketService.buyitems();
        return new ModelAndView("redirect:/List");}
}
