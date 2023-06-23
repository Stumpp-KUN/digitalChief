INSERT INTO shop.category (name, description, active)
VALUES ('Electronics', 'Electronics category', true);

INSERT INTO shop.category (name, description, active)
VALUES ('Clothing', 'Clothing category', true);

INSERT INTO shop.product (name, description, price, category_id)
VALUES ('Laptop', 'High-performance laptop', 1500.0, 1);

INSERT INTO shop.product (name, description, price, category_id)
VALUES ('Smartphone', 'Latest smartphone model', 800.0, 1);

INSERT INTO shop.product (name, description, price, category_id)
VALUES ('T-Shirt', 'Casual t-shirt', 20.0, 2);

INSERT INTO shop.product (name, description, price, category_id)
VALUES ('Jeans', 'Blue jeans', 50.0, 2);
