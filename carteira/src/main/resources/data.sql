INSERT INTO USUARIO(EMAIL, SENHA)
VALUES ('luiz@gmail.com', '$2a$10$sVqcztOwqo8fmtM7TYHmFe9iU5a2i/OmMkZSCHS/8v3yh1kD1eprq'); /*--1234-- */
INSERT INTO USUARIO(EMAIL, SENHA)
VALUES ('mariana@gmail.com', '$2a$10$HHGqTTLUKEyQyX49vod9tumhB5PTectmQPYr22A/RXVOS5rTBI2qu'); /*--4321 */
INSERT INTO USUARIO(EMAIL, SENHA)
VALUES ('thatiane@gmail.com', '$2a$10$6jsa/QTtdHn/xLSo1bxV3.TQd6MH/e6kaL9qupL3SvH1XYivTnQd.'); /*1111 */

INSERT INTO CONTA(SALDO, USUARIO_ID, DEBITO, CREDITO) VALUES (300, 1, 300, 600);
INSERT INTO CONTA(SALDO, USUARIO_ID, DEBITO, CREDITO) VALUES (500, 2, 1000, 1500);
INSERT INTO CONTA(SALDO, USUARIO_ID, DEBITO, CREDITO) VALUES (200, 3, 300, 500);

INSERT INTO TRANSACOES(CONTA_ID, VALOR, DESCRICAO, CATEGORIA, TIPO_TRANSACAO) VALUES (1, 200, 'TESTE1','testando', 'CREDITO');
INSERT INTO TRANSACOES(CONTA_ID, VALOR, DESCRICAO, CATEGORIA, TIPO_TRANSACAO) VALUES (2, 300, 'TESTE2','testando', 'DEBITO');
INSERT INTO TRANSACOES(CONTA_ID, VALOR, DESCRICAO, CATEGORIA, TIPO_TRANSACAO) VALUES (2, 100, 'TESTE3','testando', 'CREDITO');
INSERT INTO TRANSACOES(CONTA_ID, VALOR, DESCRICAO, CATEGORIA, TIPO_TRANSACAO) VALUES (2, 400, 'TESTE3','testando', 'CREDITO');






