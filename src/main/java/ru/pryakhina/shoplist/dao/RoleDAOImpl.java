package ru.pryakhina.shoplist.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.pryakhina.shoplist.entity.Role;
import java.util.List;
/**
 * Реализация интерфейса DAO ролей
 * @author elena
 */
@Repository
public class RoleDAOImpl implements RoleDAO {
    /** Внедрение зависимости EntityManager*/
    @PersistenceContext
    private EntityManager entityManager;

    /** Функция получения списка всех ролей из БД
     * @return List<Role>*/
    @Override
    public List<Role> getAllRoles() {

        Session session = entityManager.unwrap(Session.class);
        List<Role> roles = session.createQuery("from Role", Role.class)
                .getResultList();
        return roles;
    }

    /** Процедура сохранения Role в БД
     * @param role*/
    @Override
    public void saveRole(Role role) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(role);
    }

    /** Процедура уладения Role из БД
     * @param role*/
    @Override
    public void delRole(Role role) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(role);
    }

    /** Функция получения Role из БД по его ID
     * @param roleId
     * @return role*/
    @Override
    public Role getRole(int roleId) {
        Session session = entityManager.unwrap(Session.class);
        Role role = session.get(Role.class, roleId);
        return role;
    }
}
