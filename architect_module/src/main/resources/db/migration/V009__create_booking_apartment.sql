create table if not exists booking_apartment
(
    id           int8 primary key,
    user_id      int8,
    apartment_id int8,
    start_date   timestamp,
    end_date     timestamp,
    product_id   int8,
    total_price  varchar
);

create sequence booking_apartment_sequence start 1 increment 1;

-- insert into promocodes_info (id, promocode, is_used, user_id)
-- values (1, 'test', false, 0)