create table SYS_API_MENU_MAP(
	IDX_SYS_MENU bigint not null,
	IDX_SYS_API bigint not null,
	CREATE_TIME DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    constraint SYS_API_MENU_MAP_UNIQUE_0 unique(IDX_SYS_MENU, IDX_SYS_API)
);

insert into SYS_API_MENU_MAP (IDX_SYS_MENU, IDX_SYS_API) values (1, 1);
insert into SYS_API_MENU_MAP (IDX_SYS_MENU, IDX_SYS_API) values (1, 2);



