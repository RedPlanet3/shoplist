package ru.pryakhina.shoplist.service;

import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pryakhina.shoplist.dao.ItemDAO;
import ru.pryakhina.shoplist.dao.RoleDAO;
import ru.pryakhina.shoplist.entity.Item;
import ru.pryakhina.shoplist.entity.Role;
import java.util.List;

/**
 * Реализация интерфейса Service
 * @author elena
 */
@Service
public class ShopListServiceImpl implements ShopListService {

    private ItemDAO itemDAO;
    private RoleDAO roleDAO;

    @Autowired
    public ShopListServiceImpl(ItemDAO itemDAO, RoleDAO roleDAO) {
        this.itemDAO = itemDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public List<Item> getRoleItems(int roleId) {
        return itemDAO.getRoleItems(roleId);
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    @Transactional
    public void saveItem(Item item) {
        itemDAO.saveItem(item);
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }

    @Override
    @Transactional
    public void delRole(Role role) {
        roleDAO.delRole(role);
    }

    @Override
    @Transactional
    public void delItem(Item item) {
        itemDAO.delItem(item);
    }

    @Override
    @Transactional
    public Item getItem(int itemId) {
        return itemDAO.getItem(itemId);
    }

    @Override
    @Transactional
    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }

}
