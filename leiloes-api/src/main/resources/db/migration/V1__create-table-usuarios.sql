create table usuarios(

    id bigint not null auto_increment,
    name varchar(70) not null,
    username varchar(70) not null,
    password varchar(20) not null,

    primary key(id)

);