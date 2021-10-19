create table users (
   username varchar(45) primary key,
   password varchar(255) not null
);

insert into users (username, password) values ('admin', 'secret');
insert into users (username, password) values ('user', '123');


create table auth_log (
    id bigint primary key generated by default as identity,
    username varchar(45) not null,
    logged_at timestamp with time zone not null
);
alter table auth_log add constraint user_fk foreign key (username)
    references users(username);