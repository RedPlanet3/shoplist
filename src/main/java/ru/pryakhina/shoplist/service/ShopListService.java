package ru.pryakhina.shoplist.service;


import jakarta.transaction.Transactional;
import ru.pryakhina.shoplist.entity.Item;
import ru.pryakhina.shoplist.entity.Role;
import java.util.List;

/**
 * Интерфейс Service
 * @author elena
 */
public interface ShopListService {
    public List<Item> getRoleItems(int roleId);
    public List<Role> getAllRoles();
    public void saveItem(Item item);
    public void saveRole(Role role);

    void delRole(Role role);
    public void delItem(Item item);
    public Item getItem(int itemId);
    public Role getRole(int id);

//    @Transactional
//    RoleDto getRoleDto(int id);
}
