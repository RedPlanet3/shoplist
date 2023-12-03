package ru.pryakhina.shoplist.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.pryakhina.shoplist.entity.Item;
import ru.pryakhina.shoplist.entity.Role;
import ru.pryakhina.shoplist.service.ShopListService;

import java.util.List;


@Controller
//@RestController
public class HTMLController {

    @Autowired
//    @Qualifier("itemRep")
    private ShopListService shopListService;

    @GetMapping("/")
    public String showStartPage(HttpServletRequest request, Model model){
//        String roleId = request.getParameter("roleId");
//        roleId = roleId + 100;
//        model.addAttribute("roleId100", roleId);
//        return "src/main/webapp/WEB-INF/view/startpage.jsp";
        return "index";

    }

    @GetMapping("/roles")
    public String getRoles(
//            @RequestParam("roleId") int roleId,
//            @RequestParam("roleName") String roleName,
//            @RequestParam("genre") Genre genre,
//            BindingResult bindingResult,
            Model model){

        List<Role> roleList =  shopListService.getAllRoles();
        model.addAttribute("allRoles", roleList);
       return "roles";
    }

//    @GetMapping("/roles/{id}")
//    public String getRolesId(Model model){
//
//        return "roleid";
//    }
    @GetMapping("/items/{roleid}")
    public String getItems(
//            @RequestParam("roleId") int roleId,
            @PathVariable("roleid") int roleid,
            Model model) {
        List<Item> itemList =  shopListService.getRoleItems(roleid);
        model.addAttribute("allItems", itemList);
        return "items";
    }



    @GetMapping("/itemadd")
    public String itemadd(Model model) {
        Item newitem = new Item();
        model.addAttribute("newitem", newitem);
        return "itemadd";
    }

    @PostMapping("/saveitem")
    public String saveItem (@ModelAttribute("newitem") Item item, Model model) {
        model.addAttribute("item", item);
        shopListService.saveItem(item);
        return "redirect:/items";
    }

    @GetMapping("/addrole")
    public String roleAdd (Model model) {
        model.addAttribute("newrole", new Role());
        return "addrole";
    }

    @PostMapping("/saverole")
    public String saveRole (
//            @ModelAttribute("newrole") Role newrole,
            @ModelAttribute Role newrole,
            Model model) {
//        model.addAttribute("newrole", newrole);
        shopListService.saveRole(newrole);
        return "redirect:/roles";
    }



    @GetMapping("/updateItem")
    public String updateItem (
            @ModelAttribute("newitem") Item item,
            Model model
    ) {
        Item upItem = shopListService.getItem(item.getId());
        model.addAttribute("newitem", upItem);
        return "itemadd";
    }

    @GetMapping("/deleteItem")
    public String deleteItem (@ModelAttribute("newitem") Item delItem) {
        Item deleteItem = shopListService.getItem(delItem.getId());
        shopListService.delItem(deleteItem);
        return "redirect:/items";
    }

    @GetMapping("/deleteRole/{id}")
    public String deleteRole (
//            @RequestParam("roleId") int roleId,
            @PathVariable("id") int id,
            Model model) {
        Role deleteRole = shopListService.getRole(id);
        shopListService.delRole(deleteRole);
        return "redirect:/roles";
    }


}