create table if not exists user_personal_data
(
    id                 int8 primary key,
    email_verification boolean,
    registration_date  timestamp,
    birth_date         timestamp,
    email              varchar(255),
    login              varchar(255),
    password           varchar(255),
    token              varchar(255),
    booking_amount     int,
    foreign_citizen    boolean,
    city_from          varchar(255)
);

create sequence user_personal_data_sequence start 2 increment 1;

insert into user_personal_data (id, email_verification, registration_date, email, login, password, token, booking_amount, foreign_citizen, city_from)
values (1, false, null, 'alexey@mail.ru', 'alexey', 'alexey', null, 25, true, 'Irkutsk');

