package com.ltp.globalsuperstore;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    List<Item> items = new ArrayList<Item>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String itemId){
        model.addAttribute("categories", Constants.CATEGORIES);

        ItemForm itemForm = new ItemForm();
        
        int ind = findItemIndexById(itemId);
        if(ind != -1){
            itemForm = ItemForm.fromItem(items.get(ind));
        }

        model.addAttribute("itemForm", itemForm);

        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model){
        model.addAttribute("items", items);
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String submitItem(ItemForm itemForm, RedirectAttributes redirectAttributes){
        int ind = findItemIndexById(itemForm.getId());
        if(ind != -1){
            if(!within5Days(itemForm.getDate(), items.get(ind).getDate())){
                redirectAttributes.addFlashAttribute("status", Constants.FAILED_STATUS);
                return "redirect:/inventory";
            }
            items.set(ind, Item.fromItemForm(itemForm));
        } else {
            items.add(Item.fromItemForm(itemForm));
        }
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        return "redirect:/inventory";
    }

    private int findItemIndexById(String id){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }

    private boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }
}
