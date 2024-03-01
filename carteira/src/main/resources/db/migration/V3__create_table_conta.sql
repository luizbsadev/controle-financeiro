create table CONTA(
    id int AUTO_INCREMENT,
    saldo float,
    debito float,
    credito float,
    FOREIGN KEY (id) references USUARIO(id),
    PRIMARY KEY (id)
);