create table TRANSACOES(
      id int AUTO_INCREMENT,
      conta_id int,
      valor float,
      descricao varchar(50),
      categoria varchar(20),
      tipo_transacao varchar(20),
      PRIMARY KEY (id)
);