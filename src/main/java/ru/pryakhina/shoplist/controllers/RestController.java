package ru.pryakhina.shoplist.controllers;


//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.pryakhina.shoplist.entity.Item;
import ru.pryakhina.shoplist.entity.Role;
import ru.pryakhina.shoplist.service.ShopListService;


import java.util.List;

@RequestMapping("/api")
@org.springframework.web.bind.annotation.RestController
public class RestController {
    ShopListService shopListService;


    public RestController(ShopListService shopListService) {
        this.shopListService = shopListService;
    }

    //получение json с данными всех работников
//    @Secured("ADMIN")
    @GetMapping("/roles")
    public List<Role> getRoles() {

        List<Role> autorList =  shopListService.getAllRoles();
        return autorList;
    }

//    @Secured("ADMIN")
    @GetMapping("/api")
    public String check() {

        return "Check!";
    }
    @GetMapping("/items/{id}")
    public List<Item> getItems(@PathVariable int id) {

        List<Item> itemList =  shopListService.getRoleItems(id);
        return itemList;
    }

    //получение id работника из адресной строки с помощью @PathVariable
    @GetMapping("/roles/{id}")
    public Role getRole(@PathVariable int id) {

        Role role =  shopListService.getRole(id);
//        if (role == null)
//        {
//            throw new NoSuchRoleException("There is no role with ID = " + id + " in Database");
//        }
        return role;
    }

//    //получение json с данными работника с помощью @PathVariable
//    @GetMapping("/items/{id}")
//    public ItemDto getItem(@PathVariable int id) {
//
//        ItemDto item =  shopListService.getItemDto(id);
////        if (item == null) {
////            throw new NoSuchRoleException("There is no role with ID = " + id + " in Database");
////        }
//        return item;
//    }
    @PostMapping("/items")
    public int addItem(@RequestBody Item item) {
        shopListService.saveItem(item);
        return item.getId();
    }
    @PutMapping("/items")
    public int updateItem(@RequestBody Item item) {
        shopListService.saveItem(item);
        return item.getId();
    }
    @DeleteMapping("/items/{id}")
    public String deleteItem(@PathVariable int id) {
        Item delItem = shopListService.getItem(id);
        shopListService.delItem(delItem);
        return "The item id = " + id + " deleted!";
    }


    //получение json с данными работника с помощью @PathVariable
    @GetMapping("/items/{id}/wiki")
    public String getWikiItem(@PathVariable int id) {

        final RestTemplate restTemplate = new RestTemplate();
        String itemName = shopListService.getItem(id).getName();

        UriComponents url = UriComponentsBuilder.fromUriString("https://en.wikipedia.org/w/api.php")
                .queryParam("action", "query")
                .queryParam("list", "search")
                .queryParam("srsearch", itemName)
                .queryParam("format", "json")
                .build();

        String forObject = restTemplate.getForObject(url.toUri(), String.class);
        return forObject;
    }
}

//https://en.wikipedia.org/w/api.php?action=query&list=search&srsearch=Nelson_Mandela&utf8=&format=json
//https://en.wikipedia.org/w/api.php?action=query&list=search&srsearch=Nelson_Mandela&format=json