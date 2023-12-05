package ru.pryakhina.shoplist.dao;

import ru.pryakhina.shoplist.entity.Item;

import java.util.List;

/**
 * Интерфейс DAO продуктов
 * @author elena
 */
public interface ItemDAO {

    /** Получение списка Items, принадлежащих роли с заданным ID
     * @param roleId
     * @return List<Item>*/
    public List<Item> getRoleItems(int roleId);

    /** Сохранение Item в БД
     * @param item
     * */
    public void saveItem(Item item);

    /** Уладение Item из БД
     * @param item*/
    void delItem(Item item);

    /** Получение Item из БД по его ID
     * @param itemId
     * @return Item*/
    public Item getItem(int itemId);
}