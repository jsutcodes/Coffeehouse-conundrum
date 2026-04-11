-- Schema for H2
-- 1. Insert People (since Schedule and Menu depend on them)
INSERT INTO person (name, created_at) VALUES ('Bob', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Jim', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Sandra', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Tom', CURRENT_TIMESTAMP);
INSERT INTO person (name, created_at) VALUES ('Violet', CURRENT_TIMESTAMP);

-- 2. Insert Menu (Note: store_id must match an existing person ID)
INSERT INTO menu (name, price, size, store_id, created_at) 
VALUES ('Latte', 4.50, 'Large', 1, CURRENT_TIMESTAMP);

-- 3. Insert Schedule
--INSERT INTO schedule (current_payer_index, max_num_of_rounds, created_at) 
--VALUES (0, 10, CURRENT_TIMESTAMP);

-- 4. Map People to Schedule (Join Table)
--INSERT INTO schedule_people (schedule_id, people_id) VALUES (1, 1);
--INSERT INTO schedule_people (schedule_id, people_id) VALUES (1, 2);