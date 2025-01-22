create table if not exists apartment_attachment
(
    id        int8 primary key,
    size      int8,
    directory varchar(255),
    name      varchar(255),
    type      varchar(255),
    photo     bytea
);

create sequence apartment_attachment_sequence start 2 increment 1;

insert into apartment_attachment (id, size, directory, name, type, photo)
values (1, null, null, 'myPhoto', 'jpeg', null);

