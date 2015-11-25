package ru.az.sample.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.az.sample.model.Item;
import ru.az.sample.model.User;
import ru.az.sample.web.services.BasketService;
import ru.az.sample.web.services.ItemService;
import ru.az.sample.web.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by smikhailova on 23.11.2015.
 */
@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    BasketService basketService;

    @RequestMapping("/List")
    public String ListItems(ModelMap model) {
       model.addAttribute("items",itemService.getAllItems());
        model.addAttribute("sum", basketService.getSum());
        return "ListItems";

    }

    @RequestMapping("/CardItem")
   public ModelAndView item(@RequestParam(value = "id", required = true)Long id) {
        return new ModelAndView("/CardItem","item",itemService.findById(id));
    }

    /*@RequestMapping("/ListCategory")
    public ModelAndView categ(@RequestParam(value = "id", required = true)Long cat) {
        return new ModelAndView("/ListCategory","categ",itemService.sortByCategory(cat));
    }*/

    @RequestMapping("List/Cat/{catId}")
    public String listCategoryItems(@PathVariable Long catId, ModelMap modelMap) {
        modelMap.addAttribute("items", itemService.getCategoryList(catId));
        modelMap.addAttribute("sum", basketService.getSum());
        return "ListItems";
    }

}
