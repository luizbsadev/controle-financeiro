create table CONTA(
    id int AUTO_INCREMENT,
    saldo float,
    usuario_id int,
    debito float,
    credito float,
    FOREIGN KEY (usuario_id) references USUARIO(id),
    PRIMARY KEY (id)
);