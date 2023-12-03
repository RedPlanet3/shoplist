package ru.pryakhina.shoplist.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void addItemToRole(Item item){
        if (this.items == null)
            this.items = new ArrayList<>();
        this.items.add(item);
        item.setRole(this);
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role() {
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

}