INSERT INTO USUARIO(USERNAME, SENHA) VALUES ('Luiz', '1234');
INSERT INTO USUARIO(USERNAME, SENHA) VALUES ('Mariana', '4321');
INSERT INTO USUARIO(USERNAME, SENHA) VALUES ('Thatiane', '1111');

INSERT INTO CONTA(SALDO, USUARIO_ID, DEBITO, CREDITO) VALUES (300, 1, 300, 600);
INSERT INTO CONTA(SALDO, USUARIO_ID, DEBITO, CREDITO) VALUES (500, 2, 1000, 1500);
INSERT INTO CONTA(SALDO, USUARIO_ID, DEBITO, CREDITO) VALUES (200, 3, 300, 500);

INSERT INTO TRANSACOES(CONTA_ID, VALOR, DESCRICAO, CATEGORIA, TIPO_TRANSACAO) VALUES (1, 200, 'TESTE1','testando', 'CREDITO');
INSERT INTO TRANSACOES(CONTA_ID, VALOR, DESCRICAO, CATEGORIA, TIPO_TRANSACAO) VALUES (2, 300, 'TESTE2','testando', 'DEBITO');
INSERT INTO TRANSACOES(CONTA_ID, VALOR, DESCRICAO, CATEGORIA, TIPO_TRANSACAO) VALUES (2, 100, 'TESTE3','testando', 'CREDITO');
INSERT INTO TRANSACOES(CONTA_ID, VALOR, DESCRICAO, CATEGORIA, TIPO_TRANSACAO) VALUES (2, 400, 'TESTE3','testando', 'CREDITO');






