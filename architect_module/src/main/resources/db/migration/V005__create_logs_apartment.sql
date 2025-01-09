create table if not exists logs_apartment (
    id BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    registration_date timestamp default now(),
    message_details varchar
);

create sequence logs_apartment_sequence;