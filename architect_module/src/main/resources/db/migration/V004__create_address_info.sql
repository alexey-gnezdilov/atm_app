create table if not exists address_info
(
    id                int8 primary key,
    registration_date timestamp,
    city              varchar(255),
    house_number      varchar(255),
    street            varchar(255),
    apartment_id      int8 references apartment_info (id)
);

create sequence address_info_sequence start 2 increment 1;

insert into address_info (id, registration_date, city, house_number, street, apartment_id)
values (1, null, 'Irk', '2', 'Lenin', 1);

-- Функция логирования
create or replace function log_apartment_registration()
    returns trigger as
$$
begin
    insert into logs_apartment (message_details)
    values ('Добавлены новые апартаменты по адресу: ' || 'Город ' || NEW.city || 'Улица  ' || NEW.street || 'дом ' ||
            NEW.house_number);
    return NEW;
end;
$$ language plpgsql;

-- Триггер для таблицы address_info
create trigger new_apartment_registration_trigger
    after insert
    on address_info
    for each row
execute function log_apartment_registration();