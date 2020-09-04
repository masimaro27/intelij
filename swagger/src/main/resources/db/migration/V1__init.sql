drop table account if exists;
drop sequence if exists hibernate_sequence;

create table account (
    id bigint not null auto_increment,
    email varchar(255),
    password varchar(255),
    username varchar(255),
    first_name varchar(255),
    age int,
    primary key (id)
);

insert into ACCOUNT (EMAIL, PASSWORD, USERNAME) values ('test@test.com', 'password', 'username');