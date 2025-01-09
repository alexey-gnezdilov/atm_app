create table if not exists apartment_info (
                                                  id int8 primary key,
                                                  availability varchar(255),
                                                  price varchar(255),
    rooms_count varchar(255),
    file_id int8 references apartment_attachment(id)
);

create sequence apartment_info_sequence start 2 increment 1;

insert into apartment_info (id, availability, price, rooms_count, file_id)
values (1, 'false', '200', '2', 1);

