package ru.pryakhina.shoplist.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pryakhina.shoplist.entity.Item;
import ru.pryakhina.shoplist.entity.Role;
import ru.pryakhina.shoplist.service.ShopListService;

import java.util.List;

/**
 * Класс контроллер
 * @author elena
 */
@Controller
public class HTMLController {

    @Autowired
    private ShopListService shopListService;

    /** Отображение стартовой страницы */
    @GetMapping("/")
    public String showStartPage(){
        return "index";

    }
    /** Вывод списка ролей с возможностью добавлять, удалять роли, а также смотреть списки продуктов
     * для каждой роли*/
    @GetMapping("/roles")
    public String getRoles(
            Model model){
        List<Role> roleList =  shopListService.getAllRoles();
        model.addAttribute("allRoles", roleList);
       return "roles";
    }

    /** Вывод списка продуктов у конкретной роли
     * @param roleid
     * */
    @GetMapping("/items/{roleid}")
    public String getItems(
//            @RequestParam("roleId") int roleId,
            @PathVariable("roleid") int roleid,
            Model model) {
        List<Item> itemList =  shopListService.getRoleItems(roleid);
        model.addAttribute("allItems", itemList);
        model.addAttribute("role", shopListService.getRole(roleid));
        return "items";
    }

    @GetMapping("/itemadd")
    public String itemadd(
//            @RequestParam("roleId") int roleId,
            @ModelAttribute("roleId") int roleId,
            Model model) {
        Item newitem = new Item();
        model.addAttribute("newitem", newitem);
        newitem.setId(roleId);
        shopListService.saveItem(newitem);
        return "itemadd";
    }
    @GetMapping("/updateItem")
    public String updateItem (
            @ModelAttribute("newitem") Item item,
            @ModelAttribute("roleId") int roleId,
            Model model
    ) {
        Item upItem = shopListService.getItem(item.getId());
        model.addAttribute("newitem", upItem);
        model.addAttribute("roleId", roleId);
        return "itemadd";
    }
    @PostMapping("/saveitem")
    public String saveItem (
            @ModelAttribute("newitem") Item item,
            Model model) {
        model.addAttribute("item", item);
        shopListService.saveItem(item);
        return "redirect:/items/{id}";
    }

    /** Вывод страницы с полями для ввода новой роли */
    @GetMapping("/addrole")
    public String roleAdd (Model model) {
        model.addAttribute("newrole", new Role());
        return "addrole";
    }
    /** Сохраниение новой роли в БД */
    @PostMapping("/saverole")
    public String saveRole (
            @ModelAttribute Role newrole,
            Model model) {
//        model.addAttribute("newrole", newrole);
        shopListService.saveRole(newrole);
        return "redirect:/roles";
    }



    @GetMapping("/deleteitem")
    public String deleteItem (@ModelAttribute("newitem") Item delItem) {
        Item deleteItem = shopListService.getItem(delItem.getId());
        shopListService.delItem(deleteItem);
        return "redirect:/items";
    }

    @GetMapping("/deleterRole/{id}")
    public String deleteRole (
//            @RequestParam("roleId") int roleId,
            @PathVariable("id") int id,
            Model model) {
        Role deleteRole = shopListService.getRole(id);
        shopListService.delRole(deleteRole);
        return "redirect:/roles";
    }


}