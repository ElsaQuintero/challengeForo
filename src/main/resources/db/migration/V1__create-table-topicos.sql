create table topicos(
        id bigint not null auto_increment,
        titulo varchar(100) not null,
        mensaje varchar(100) not null,
        status varchar(100) not null,
        curso varchar(100) not null,
        nombre varchar(100) not null,
        email varchar(100) not null,
        password varchar(100) not null,

        primary key(id)
);