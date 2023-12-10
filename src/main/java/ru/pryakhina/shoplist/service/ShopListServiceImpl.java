package ru.pryakhina.shoplist.service;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pryakhina.shoplist.dao.ItemRepository;
import ru.pryakhina.shoplist.dao.RoleRepository;
import ru.pryakhina.shoplist.entity.Item;
import ru.pryakhina.shoplist.entity.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Реализация интерфейса Service
 * @author elena
 */
@Service
public class ShopListServiceImpl implements ShopListService {

    /**
     * Поле репозитория продуктов ItemRepository
     */
    private ItemRepository itemRepository;

    /**
     * Поле репозитория ролей RoleRepository
     */
    private RoleRepository roleRepository;

    /**
     * Конструктор - внедрение зависимостей
     * @param itemRepository - продукты
     * @param roleRepository - роли
     */
    @Autowired
    public ShopListServiceImpl(ItemRepository itemRepository, RoleRepository roleRepository) {
        this.itemRepository = itemRepository;
        this.roleRepository = roleRepository;
    }

    /** Функция получения списка Items, принадлежащих роли с заданным ID
     * @param roleId
     * @return List<Item>*/
    @Override
    @Transactional
    public List<Item> getRoleItems(int roleId) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (roleOptional.isEmpty())
            return null;
        List<Item> items = roleOptional.get().getItems();
        return items;
    }

    /** Функция получения списка всех ролей из БД
     * @return List<Role>*/
    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    /** Процедура сохранения Item в БД
     * @param item
     * */
    @Override
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    /** Процедура сохранения Role в БД
     * @param role
     * */
    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    /** Процедура уладения Role из БД
     * @param role*/
    @Override
    @Transactional
    public void delRole(Role role) {
        roleRepository.delete(role);
    }

    /** Процедура уладения Item из БД
     * @param item*/
    @Override
    @Transactional
    public void delItem(Item item) {
        itemRepository.delete(item);
    }

    /** Функция получения Item из БД по его ID
     * @param itemId
     * @return Item*/
    @Override
    @Transactional
    public Item getItem(int itemId) {
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        return itemOptional.orElse(null);
    }

    /** Функция получения Role из БД по его ID
     * @param id
     * @return role*/
    @Override
    @Transactional
    public Role getRole(int id) {
        return roleRepository.findById(id).get();
    }

}
