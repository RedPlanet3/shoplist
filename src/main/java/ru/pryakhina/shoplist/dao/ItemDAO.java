package ru.pryakhina.shoplist.dao;

import ru.pryakhina.shoplist.entity.Item;

import java.util.List;


public interface ItemDAO {
    public List<Item> getRoleItems(int roleId);
    public void saveItem(Item item);
    void delItem(Item item);
    public Item getItem(int itemId);
}