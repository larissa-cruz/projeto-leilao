create table lances(

    id bigint not null auto_increment,
    idleilao bigint not null,
    iduser bigint not null,
    lance decimal not null,
    datalance TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    primary key(id),
    constraint fk_lances_idleilao foreign key(idleilao) references leiloes(id),
    constraint fk_lances_iduser foreign key(iduser) references usuarios(id)

);