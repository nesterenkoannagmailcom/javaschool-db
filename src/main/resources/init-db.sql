create table users (
                       username varchar(45) not null,
                       password varchar(255) not null
);

insert into users (username, password) values ('admin', 'secret');
insert into users (username, password) values ('user', '123');