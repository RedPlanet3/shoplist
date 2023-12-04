CREATE TABLE roles (
    role_id int PRIMARY KEY generated by default as identity,
    name VARCHAR ( 50 ) UNIQUE NOT NULL
);

CREATE TABLE items (
    item_id int PRIMARY KEY generated by default as identity,
    role_id int references roles(role_id) NOT NULL,
    name VARCHAR ( 150 ) NOT NULL,
    price int
);

INSERT INTO roles(name) VALUES ('Petr');
INSERT INTO roles(name) VALUES ('Vasya');
INSERT INTO roles(name) VALUES ('Egor');
INSERT INTO items (role_id, name, price) VALUES (1, 'milk', 76);
INSERT INTO items (role_id, name, price) VALUES (1, 'bread', 50);
INSERT INTO items (role_id, name, price) VALUES (1, 'onion', 23);
INSERT INTO items (role_id, name, price) VALUES (1, 'chicken', 500);
INSERT INTO items (role_id, name, price) VALUES (2, 'juice', 130);
INSERT INTO items (role_id, name, price) VALUES (2, 'eggs', 45);
INSERT INTO items (role_id, name, price) VALUES (3, 'milk', 350);