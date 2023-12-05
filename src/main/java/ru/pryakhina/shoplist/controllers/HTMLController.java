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

    /** Внедрение сервиса */
    @Autowired
    private ShopListService shopListService;

    /** Отображение стартовой страницы - редирект на /roles */
    @GetMapping("/")
    public String showStartPage(){
        return "redirect:/roles";

    }
    /** Вывод списка ролей с возможностью добавлять,
     * удалять роли, а также смотреть списки продуктов
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
            @PathVariable("roleid") int roleid,
            Model model) {
        List<Item> itemList =  shopListService.getRoleItems(roleid);
        model.addAttribute("allItems", itemList);
        model.addAttribute("role", shopListService.getRole(roleid));
        return "items";
    }

    /** Добавление нового продукта в список
     * продуктов для роли c выбранным id
     * @param roleid
     * */
    @GetMapping("/itemadd/{id}")
    public String itemadd(
            @PathVariable("id") int roleid,
            Model model) {
        model.addAttribute("roleid", roleid);
        model.addAttribute("newitem", new Item());
        return "itemadd";
    }
    /** Обновление существующего продукта в списоке
     * продуктов для роли c выбранным id
     * @param id
     * */
    @GetMapping("/updateItem/{id}")
    public String updateItem (
            @PathVariable("id") int id,
            Model model
    ) {
        Item upItem = shopListService.getItem(id);
        int roleId = upItem.getRole().getId();
        model.addAttribute("newitem", upItem);
        model.addAttribute("roleid", roleId);
        return "itemadd";
    }

    /** Сохранение item для текущей ролиО
     * @param item
     * @param roleid
     * */
    @PostMapping("/saveitem/{roleid}")
    public String saveItem (
            @ModelAttribute("newitem") Item item,
            @PathVariable("roleid") int roleid) {
        item.setRole(shopListService.getRole(roleid));
        shopListService.saveItem(item);
        return "redirect:/items/" + roleid;
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
    /** Удаление продукта из БД
     * @param id  */
    @GetMapping("/deleteitem/{id}")
    public String deleteItem (@PathVariable("id") int id) {
        int roleid = shopListService.getItem(id).getRole().getId();
        shopListService.delItem(shopListService.getItem(id));
        return "redirect:/items/" + roleid;
    }

    /** Удаление роли из БД
     * @param id  */
    @GetMapping("/deleteRole/{id}")
    public String deleteRole (@PathVariable("id") int id) {
        Role deleteRole = shopListService.getRole(id);
        shopListService.delRole(deleteRole);
        return "redirect:/roles";
    }
}