create table SYS_API(
	DB_IDX bigint not null auto_increment primary key,
	API_VER VARCHAR(20) not null,
	ACTION_CODE VARCHAR(10) NOT NULL,
	API_URL VARCHAR(200) NOT NULL,
	UPDATE_TIME DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CREATE_TIME DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);


insert into SYS_API (API_VER, ACTION_CODE, API_URL) values ('v1', 'C,R,U,D', '/test/**');
insert into SYS_API (API_VER, ACTION_CODE, API_URL) values ('v1', 'C,R,U,D', '/test2/**');
