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

    /**
     * Поле репозитория продуктов ItemDAO
     */
    private ItemDAO itemDAO;

    /**
     * Поле репозитория ролей RoleDAO
     */
    private RoleDAO roleDAO;

    /**
     * Конструктор - внедрение зависимостей
     * @param itemDAO - продукты
     * @param roleDAO - роли
     */
    @Autowired
    public ShopListServiceImpl(ItemDAO itemDAO, RoleDAO roleDAO) {
        this.itemDAO = itemDAO;
        this.roleDAO = roleDAO;
    }

    /** Функция получения списка Items, принадлежащих роли с заданным ID
     * @param roleId
     * @return List<Item>*/
    @Override
    @Transactional
    public List<Item> getRoleItems(int roleId) {
        return itemDAO.getRoleItems(roleId);
    }

    /** Функция получения списка всех ролей из БД
     * @return List<Role>*/
    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    /** Процедура сохранения Item в БД
     * @param item
     * */
    @Override
    @Transactional
    public void saveItem(Item item) {
        itemDAO.saveItem(item);
    }

    /** Процедура сохранения Role в БД
     * @param role
     * */
    @Override
    @Transactional
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }

    /** Процедура уладения Role из БД
     * @param role*/
    @Override
    @Transactional
    public void delRole(Role role) {
        roleDAO.delRole(role);
    }

    /** Процедура уладения Item из БД
     * @param item*/
    @Override
    @Transactional
    public void delItem(Item item) {
        itemDAO.delItem(item);
    }

    /** Функция получения Item из БД по его ID
     * @param itemId
     * @return Item*/
    @Override
    @Transactional
    public Item getItem(int itemId) {
        return itemDAO.getItem(itemId);
    }

    /** Функция получения Role из БД по его ID
     * @param id
     * @return role*/
    @Override
    @Transactional
    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }

}
