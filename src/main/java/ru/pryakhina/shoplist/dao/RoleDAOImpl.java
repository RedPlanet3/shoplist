package ru.pryakhina.shoplist.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
        Query query = entityManager.createQuery("from Role", Role.class);
        List<Role> roles = query.getResultList();
        return roles;
    }

    /** Процедура сохранения Role в БД
     * @param role*/
    @Override
    public void saveRole(Role role) {
        Role newRole = entityManager.merge(role);
        role.setId(newRole.getId());
    }

    /** Процедура уладения Role из БД
     * @param role*/
    @Override
    public void delRole(Role role) {
        Query query = entityManager.createQuery("delete from Role where id =:roleid");
        query.setParameter("roleid", role.getId());
        query.executeUpdate();
    }

    /** Функция получения Role из БД по его ID
     * @param roleId
     * @return role*/
    @Override
    public Role getRole(int roleId) {
        Role role = entityManager.find(Role.class, roleId);
        return role;
    }
}
