create table ADM_OPERATOR(
	DB_IDX bigint  not null auto_increment primary key,
	MANAGER_ID varchar(30) not null,
	PASSWORD VARCHAR(80) not null,

	constraint ADM_OPERATOR_UNIQUE_0 unique(MANAGER_ID)
);

insert into ADM_OPERATOR (MANAGER_ID, PASSWORD) values ('test_id', '1111');