-- Schema for H2
-- 1. Insert People (since Schedule and Menu depend on them)
INSERT INTO person (name, created_at) VALUES ('Bob', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Jim', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Sandra', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Tom', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Violet', CURRENT_TIMESTAMP);

-- 2. Insert Menu 
-- Coffee Classics
INSERT INTO menu (name, price, size, created_at) VALUES ('Espresso', 2.75, 'Small', CURRENT_TIMESTAMP);
INSERT INTO menu (name, price, size, created_at) VALUES ('Americano', 3.25, 'Medium', CURRENT_TIMESTAMP);
INSERT INTO menu (name, price, size, created_at) VALUES ('Cappuccino', 4.25, 'Medium', CURRENT_TIMESTAMP);
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

-- 3. Insert Schedule
--INSERT INTO schedule (current_payer_index, max_num_of_rounds, created_at) 
--VALUES (0, 10, CURRENT_TIMESTAMP);

-- 4. Map People to Schedule (Join Table)
--INSERT INTO schedule_people (schedule_id, people_id) VALUES (1, 1);
--INSERT INTO schedule_people (schedule_id, people_id) VALUES (1, 2);