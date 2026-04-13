-- Schema for H2
-- 1. Insert People (since Schedule and Menu depend on them)
INSERT INTO person (name, created_at) VALUES ('Bob', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Jim', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Sandra', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Tom', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Violet', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Catriona', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Xaden', CURRENT_TIMESTAMP);

-- 2. Insert Menu 
-- Coffee Classics
INSERT INTO menu (name, price, size, created_at) VALUES ('Black Coffee', 2.00, 'Small', CURRENT_TIMESTAMP);
INSERT INTO menu (name, price, size, created_at) VALUES ('Espresso', 2.75, 'Small', CURRENT_TIMESTAMP);
INSERT INTO menu (name, price, size, created_at) VALUES ('Americano', 3.25, 'Medium', CURRENT_TIMESTAMP);
INSERT INTO menu (name, price, size, created_at) VALUES ('Cappuccino', 4.00, 'Medium', CURRENT_TIMESTAMP);
INSERT INTO menu (name, price, size, created_at) VALUES ('Latte', 4.50, 'Large', CURRENT_TIMESTAMP);
INSERT INTO menu (name, price, size, created_at) VALUES ('Flat White', 4.00, 'Small', CURRENT_TIMESTAMP);

-- Cold Brew & Specialty
INSERT INTO menu (name, price, size, created_at) VALUES ('Cold Brew', 4.75, 'Large', CURRENT_TIMESTAMP);
INSERT INTO menu (name, price, size, created_at) VALUES ('Nitro Cold Brew', 5.50, 'Medium', CURRENT_TIMESTAMP);
INSERT INTO menu (name, price, size, created_at) VALUES ('Caramel Macchiato', 5.25, 'Large',CURRENT_TIMESTAMP);
INSERT INTO menu (name, price, size, created_at) VALUES ('Mocha', 4.95, 'Large', CURRENT_TIMESTAMP);

-- Seasonal / Tea
INSERT INTO menu (name, price, size, created_at) VALUES ('Chai Latte', 4.50, 'Medium', CURRENT_TIMESTAMP);
INSERT INTO menu (name, price, size, created_at) VALUES ('Matcha Latte', 5.00, 'Medium', CURRENT_TIMESTAMP);
INSERT INTO menu (name, price, size, created_at) VALUES ('Earl Grey Tea', 3.00, 'Large', CURRENT_TIMESTAMP);

-- 3. Insert people_items
INSERT INTO person_items (person_id, menu_id) VALUES (1, 4);
--INSERT INTO person_items (person_id, menu_id) VALUES (1, 6);

INSERT INTO person_items (person_id, menu_id) VALUES (2, 1);

--INSERT INTO person_items (person_id, menu_id) VALUES (3, 9);
INSERT INTO person_items (person_id, menu_id) VALUES (3, 11);

INSERT INTO person_items (person_id, menu_id) VALUES (4, 11);

INSERT INTO person_items (person_id, menu_id) VALUES (5, 12);


INSERT INTO person_items (person_id, menu_id) VALUES (6, 11);

INSERT INTO person_items (person_id, menu_id) VALUES (7, 12);

