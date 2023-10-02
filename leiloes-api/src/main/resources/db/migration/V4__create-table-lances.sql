create table lances(

    id bigint not null auto_increment,
    idleilao bigint not null,
    lance decimal not null,

    primary key(id),
    constraint fk_lances_idleilao foreign key(idleilao) references leiloes(id)

);