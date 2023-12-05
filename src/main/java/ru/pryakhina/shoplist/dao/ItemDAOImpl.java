package ru.pryakhina.shoplist.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.pryakhina.shoplist.entity.Item;
import ru.pryakhina.shoplist.entity.Role;

import java.util.List;
/**
 * Реализация интерфейса DAO продуктов
 * @author elena
 */
@Repository
public class ItemDAOImpl implements ItemDAO {

    /** Внедрение зависимости EntityManager*/
    @PersistenceContext
    private EntityManager entityManager;

    /** Функция получения списка Items, принадлежащих роли с заданным ID
     * @param roleId
     * @return List<Item>*/
    @Override
    public List<Item> getRoleItems(int roleId) {

        Session session = entityManager.unwrap(Session.class);
        Role role = session.get(Role.class, roleId);
        return role.getItems();
    }

    /** Процедура сохранения Item в БД
     * @param item
     * */
    @Override
    public void saveItem(Item item) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(item);
    }

    /** Процедура уладения Item из БД
     * @param item*/
    @Override
    public void delItem(Item item) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(item);
    }

    /** Функция получения Item из БД по его ID
     * @param itemId
     * @return Item*/
    @Override
    public Item getItem(int itemId) {
        Session session = entityManager.unwrap(Session.class);
        Item item = session.get(Item.class, itemId);
        return item;
    }
}
