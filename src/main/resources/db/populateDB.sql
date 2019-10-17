DELETE FROM meals;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (description, calories, datetime, user_id) VALUES
('Завтрак', 500, '2019-10-16T08:00:00', 100000),
('Обед', 1000, '2019-10-16T12:00:00', 100000),
('Ужин', 600, '2019-10-16T19:00:00', 100000),
('Завтрак', 300, '2019-10-17T07:30:00', 100000),
('Обед', 900, '2019-10-17T13:00:00', 100000),
('Ужин', 600, '2019-10-17T19:30:00', 100000),
('Завтрак админа', 350, '2019-10-16T08:00:00', 100001),
('Обед админа', 1100, '2019-10-16T12:00:00', 100001);

