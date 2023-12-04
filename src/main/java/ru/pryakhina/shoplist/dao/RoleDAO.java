package ru.pryakhina.shoplist.dao;

import ru.pryakhina.shoplist.entity.Role;

import java.util.List;

/**
 * Интерфейс DAO ролей
 * @author elena
 */
public interface RoleDAO {
    public List<Role> getAllRoles();
    public void saveRole(Role role);
    public void delRole(Role role);
    public Role getRole(int roleId);

}