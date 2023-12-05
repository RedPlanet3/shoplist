package ru.pryakhina.shoplist.dao;

import ru.pryakhina.shoplist.entity.Role;

import java.util.List;

/**
 * Интерфейс DAO ролей
 * @author elena
 */
public interface RoleDAO {

    /** Получение списка всех ролей из БД
     * @return List<Role>*/
    public List<Role> getAllRoles();

    /** Сохранение Role в БД
     * @param role*/
    public void saveRole(Role role);

    /** Уладение Role из БД
     * @param role*/
    public void delRole(Role role);
    /** Получение Role из БД по его ID
     * @param roleId
     * @return role*/
    public Role getRole(int roleId);

}