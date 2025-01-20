create table if not exists integration_info (
id varchar PRIMARY KEY ,
path varchar,
key varchar,
description varchar
);

insert into integration_info (id,path,key,description)
values ('GEO','https://api.opencagedata.com/geocode/v1/json?q=%s+%s&language=native&key=%s','MGMzNzY2NTFkZjY5NDMwM2I3NDhjMTBhM2NmMWU1ZmU=','Coordinate information');