package ru.pryakhina.shoplist.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pryakhina.shoplist.entity.Item;
import ru.pryakhina.shoplist.entity.Role;

import java.util.List;

@Repository
public class ItemDAOImpl implements ItemDAO {

    private EntityManager entityManager;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public ItemDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Item> getRoleItems(int roleId) {

        Session session = entityManager.unwrap(Session.class);
        Role role = session.get(Role.class, roleId);
        return role.getItems();
    }

    @Override
    public void saveItem(Item item) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(item);
    }

    @Override
    public void delItem(Item item) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(item);
    }

    @Override
    public Item getItem(int itemId) {
        Session session = entityManager.unwrap(Session.class);
        Item item = session.get(Item.class, itemId);
        return item;
    }
}
