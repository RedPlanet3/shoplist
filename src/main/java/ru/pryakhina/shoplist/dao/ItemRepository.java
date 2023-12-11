package ru.pryakhina.shoplist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pryakhina.shoplist.entity.Item;
import ru.pryakhina.shoplist.entity.Role;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс DAO продуктов
 * @author elena
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query("select i from Item i where i.role.id=:roleId")
    List<Item> findByIdWithItems(Integer roleId);
}