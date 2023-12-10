package ru.pryakhina.shoplist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pryakhina.shoplist.entity.Item;

import java.util.List;

/**
 * Интерфейс DAO продуктов
 * @author elena
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
}