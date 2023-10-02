CREATE TABLE phone_contact (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50),
    birth_date DATE,
    phone_number VARCHAR(20),
    secondary_phone_number VARCHAR(20),
    creation_date DATE
);


INSERT INTO phone_contact (name, birth_date, phone_number, secondary_phone_number, creation_date)
VALUES ('Ерасыл', '2000-05-01', '87004001478', '87005002424', current_date);
INSERT INTO phone_contact (name, birth_date, phone_number, secondary_phone_number, creation_date)
VALUES ('Тима', '2001-01-02', '87476597898', '87477002222', current_date);
INSERT INTO phone_contact (name, birth_date, phone_number, secondary_phone_number, creation_date)
VALUES ('Магжан', '2002-04-01', '87756254884', '87775554444', current_date);
INSERT INTO phone_contact (name, birth_date, phone_number, secondary_phone_number, creation_date)
VALUES ('Асель', '2003-01-07', '87056974477', '87776663929', current_date);
INSERT INTO phone_contact (name, birth_date, phone_number, secondary_phone_number, creation_date)
VALUES ('Назерке', '2004-05-01', '87754585225', '87471118855', current_date);