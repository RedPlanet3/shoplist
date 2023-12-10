package ru.pryakhina.shoplist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pryakhina.shoplist.entity.Role;

import java.util.List;

/**
 * Интерфейс DAO ролей
 * @author elena
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}