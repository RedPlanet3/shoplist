package ru.pryakhina.shoplist.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pryakhina.shoplist.entity.Role;
import java.util.List;
/**
 * Реализация интерфейса DAO ролей
 * @author elena
 */
@Repository
public class RoleDAOImpl implements RoleDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//    @Autowired
//    public RoleDAOImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }


    @Override
    public List<Role> getAllRoles() {

        Session session = entityManager.unwrap(Session.class);

        List<Role> roles = session.createQuery("from Role", Role.class)
                .getResultList();
        return roles;
    }

    @Override
    public void saveRole(Role Role) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(Role);
    }

    @Override
    public void delRole(Role Role) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(Role);
    }

    @Override
    public Role getRole(int RoleId) {
        Session session = entityManager.unwrap(Session.class);
        Role Role = session.get(Role.class, RoleId);
        return Role;
    }
}
