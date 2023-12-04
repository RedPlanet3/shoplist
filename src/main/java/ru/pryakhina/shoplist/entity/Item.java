package ru.pryakhina.shoplist.entity;

import jakarta.persistence.*;

/**
 * Класс продуктов
 * @author elena
 */
@Entity
@Table(name = "items")
public class Item {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "item_id")
        private int id;
        @Column(name = "name")
        private String name;
        @Column(name = "price")
        private int price;
        @ManyToOne
        @JoinColumn(name = "role_id")
        private Role role;

        public Item(String name, int price, Role role) {
                this.name = name;
                this.price = price;
                this.role = role;
        }
        public Item() {
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getPrice() {
                return price;
        }

        public void setPrice(int price) {
                this.price = price;
        }

        public Role getRole() {
                return role;
        }

        public void setRole(Role role) {
                this.role = role;
        }
}
