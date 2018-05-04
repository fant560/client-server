/* hibernate сам создает что-то подобное
CREATE TABLE IF NOT EXISTS person
(
  id LONG AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(40) NOT NULL,
  lastname VARCHAR(40) NOT NULL,
  patronymic VARCHAR(60),
  position VARCHAR(40)
);*/

CREATE SEQUENCE IF NOT EXISTS person_seq
  INCREMENT BY 1
  NO MAXVALUE
  START WITH 1;

INSERT INTO person values (nextval('person_seq'), 'Иван', 'Волков', 'Семенович', 'Продавец');
INSERT INTO person values (nextval('person_seq'), 'Сергей', 'Анисимов', 'Петрович', 'Сторож');
INSERT INTO person values (nextval('person_seq'), 'Алексей', 'Мальцев', 'Семенович', 'Пекарь');
INSERT INTO person values (nextval('person_seq'), 'Никита', 'Бехтерев', 'Алексеевич', 'Программист');
INSERT INTO person values (nextval('person_seq'), 'Катерина', 'Салтыкова', 'Алексеевна', 'Бухгалтер');
INSERT INTO person values (nextval('person_seq'), 'Светлана', 'Ведерникова', 'Семеновна', 'Продавец');
INSERT INTO person values (nextval('person_seq'), 'Марина', 'Волкова', 'Анатольевна', 'Консультант');
INSERT INTO person values (nextval('person_seq'), 'Анатолий', 'Деникин', 'Павлович', 'Директор');