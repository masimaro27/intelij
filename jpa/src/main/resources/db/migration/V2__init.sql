drop table address if exists;

create table address (
    id bigint not null auto_increment,
    addr varchar(255),
    sub_addr varchar(255),
    user_idx bigint not null,
    primary key (id)
);

insert into ADDRESS(ADDR, SUB_ADDR, USER_IDX) values ('addr', 'subaddr', 1);