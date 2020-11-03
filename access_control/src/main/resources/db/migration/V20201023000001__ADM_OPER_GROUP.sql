create table ADM_OPER_GROUP(
	DB_IDX bigint  not null auto_increment primary key,
	GROUP_NAME varchar(100) not null,

	constraint ADM_OPER_GROUP_UNIQUE_0 unique(GROUP_NAME)
);

insert into ADM_OPER_GROUP (GROUP_NAME) values ('TEST_GROUP');