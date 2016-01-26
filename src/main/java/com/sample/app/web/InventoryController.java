package com.sample.app.web;

import com.sample.app.model.db.InventoryElement;
import com.sample.app.service.InventoryElementService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class InventoryController {
    private static final Logger logger = Logger.getLogger(InventoryController.class);

    @Autowired
    InventoryElementService inventoryElementService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/allInventoryElements", method = RequestMethod.GET)
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("allInventoryElements");
        modelAndView.addObject("inventoryElements", inventoryElementService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/addInventoryElement", method = RequestMethod.GET)
    public ModelAndView showAddInventoryElementForm() {
        return new ModelAndView("editInventoryElement", "inventoryElement", new InventoryElement());
    }

    @RequestMapping(value = "/editInventoryElement", method = RequestMethod.GET)
    public ModelAndView showEditInventoryElementForm(@RequestParam(required = true) Integer id) {
        return new ModelAndView("editInventoryElement", "inventoryElement", inventoryElementService.get(id));
    }

    @RequestMapping(value = "/deleteInventoryElement", method = RequestMethod.GET)
    public String deleteInventoryElement(@RequestParam(required = true) Integer id) {
        inventoryElementService.remove(id);

        return "redirect:./allInventoryElements";
    }

    @RequestMapping(value = "/saveInventoryElement", method = RequestMethod.POST)
    public String addInventoryElement(@ModelAttribute("inventoryElement") InventoryElement inventoryElement) {
        if(inventoryElement.getId() == null) {
            inventoryElementService.add(inventoryElement);
        } else {
            inventoryElementService.update(inventoryElement);
        }

        return "redirect:./allInventoryElements";
    }
}
