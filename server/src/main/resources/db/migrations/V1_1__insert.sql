/* hibernate сам создает что-то подобное
CREATE TABLE IF NOT EXISTS person
(
  id LONG AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(40) NOT NULL,
  lastname VARCHAR(40) NOT NULL,
  patronymic VARCHAR(60),
  position VARCHAR(40)
);*/


INSERT INTO person values (1, 'Иван', 'Волков', 'Семенович', 'Продавец');
INSERT INTO person values (2, 'Сергей', 'Анисимов', 'Петрович', 'Сторож');
INSERT INTO person values (3, 'Алексей', 'Мальцев', 'Семенович', 'Пекарь');
INSERT INTO person values (4, 'Никита', 'Бехтерев', 'Алексеевич', 'Программист');
INSERT INTO person values (5, 'Катерина', 'Салтыкова', 'Алексеевна', 'Бухгалтер');
INSERT INTO person values (6, 'Светлана', 'Ведерникова', 'Семеновна', 'Продавец');
INSERT INTO person values (7, 'Марина', 'Волкова', 'Анатольевна', 'Консультант');
INSERT INTO person values (8, 'Анатолий', 'Деникин', 'Павлович', 'Директор');