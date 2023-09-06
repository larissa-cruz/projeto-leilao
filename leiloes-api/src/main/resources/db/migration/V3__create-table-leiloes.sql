create table leiloes(

    id bigint not null auto_increment,
    iduser bigint not null,
    name varchar(100) not null,
    price decimal not null,
    data date not null,

    primary key(id),
    constraint fk_leiloes_iduser foreign key(iduser) references usuarios(id)

);