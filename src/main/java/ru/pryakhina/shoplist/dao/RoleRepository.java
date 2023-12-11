package ru.pryakhina.shoplist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pryakhina.shoplist.entity.Role;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс DAO ролей
 * @author elena
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("select r from Role r join fetch r.items where r.id=:id") //jpql
    Optional<Role> findByIdWithItems(Integer id);

}