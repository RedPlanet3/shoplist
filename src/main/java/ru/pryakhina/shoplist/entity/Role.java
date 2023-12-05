package ru.pryakhina.shoplist.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс ролей/покупателей
 * @author elena
 */

@Entity
@Table(name = "roles")
public class Role {

    /** Поле ID роли */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    /** Поле имя роли */
    @Column(name = "name")
    private String name;

    /** Поле ссылка на продукты,
     * относящиеся к текущей роли */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<Item> items;

    /**
     * Функция получения значения поля {@link List<Item>#items}
     * @return List<Item>
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Процедура добавления продукта в список продуктов
     * текущей роли {@link List<Item>#items}
     * @param item
     */
    public void addItemToRole(Item item){
        if (this.items == null)
            this.items = new ArrayList<>();
        this.items.add(item);
        item.setRole(this);
    }

    /**
     * Процедура установления списка продуктов для
     * текущей роли {@link List<Item>#items}
     * @param items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param name - имя роли
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * Конструктор - создание нового объекта роли
     */
    public Role() {
    }

    /**
     * Функция получения значения поля id {@link Role#id}
     * @return возвращает id продукта
     */
    public int getId() {
        return id;
    }

    /**
     * Процедура заполнения поля id {@link Role#id}
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Функция получения значения поля name {@link Role#name}
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Процедура заполнения поля name {@link Role#name}
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}