create table if not exists promocodes_info
(
    id        int8 primary key,
    promocode varchar(255),
    used   boolean,
    user_id   int
);

insert into promocodes_info (id, promocode, used, user_id)
values (1, 'test', false, 0)