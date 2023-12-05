package ru.pryakhina.shoplist.entity;

import jakarta.persistence.*;

/**
 * Класс продуктов
 * @author elena
 */
@Entity
@Table(name = "items")
public class Item {

        /** Поле ID продукта */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "item_id")
        private int id;

        /** Поле имя продукта */
        @Column(name = "name")
        private String name;

        /** Поле стоимость продукта */
        @Column(name = "price")
        private int price;

        /** Поле ссылка на роль, к кторотой относится текущий продукт */
        @ManyToOne
        @JoinColumn(name = "role_id")
        private Role role;

        /**
         * Конструктор - создание нового объекта с определенными значениями
         * @param name - продукт
         * @param price - цена
         */
        public Item(String name, int price, Role role) {
                this.name = name;
                this.price = price;
                this.role = role;
        }

        /**
         * Конструктор - создание нового объекта
         */
        public Item() {
        }

        /**
         * Функция получения значения поля id {@link Item#id}
         * @return возвращает id продукта
         */
        public int getId() {
                return id;
        }

        /**
         * Процедура заполнения поля id {@link Item#id}
         * @param id
         */
        public void setId(int id) {
                this.id = id;
        }

        /**
         * Функция получения значения поля имя {@link Item#name}
         * @return String
         */
        public String getName() {
                return name;
        }

        /**
         * Процедура заполнения поля {@link Item#name}
         * @param name
         */
        public void setName(String name) {
                this.name = name;
        }

        /**
         * Функция получения значения поля price {@link Item#price}
         * @return String
         */
        public int getPrice() {
                return price;
        }

        /**
         * Процедура заполнения поля price {@link Item#price}
         * @param price
         */
        public void setPrice(int price) {
                this.price = price;
        }

        /**
         * Функция получения значения поля role {@link Item#role}
         * @return String
         */
        public Role getRole() {
                return role;
        }

        /**
         * Процедура заполнения поля role {@link Item#role}
         * @param role
         */
        public void setRole(Role role) {
                this.role = role;
        }
}
