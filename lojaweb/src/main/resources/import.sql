
INSERT INTO categoria (nome) VALUES ('Programacao');

INSERT INTO categoria (nome) VALUES ('Mobile');

INSERT INTO categoria (nome) VALUES ('Front-end');

INSERT INTO categoria (nome) VALUES ('Infraestrutura');

INSERT INTO categoria (nome) VALUES ('Business');

INSERT INTO categoria (nome) VALUES ('Design');



INSERT INTO editora (nome) VALUES ('Campus Elsevier');
INSERT INTO editora (nome) VALUES ('Pearson');
INSERT INTO editora (nome) VALUES ('Casa do Codigo');

INSERT INTO assunto (categoria_id, nome) VALUES (1,'Logica');
INSERT INTO assunto (categoria_id, nome) VALUES (1,'Java');
INSERT INTO assunto (categoria_id, nome) VALUES (1,'.NET');
INSERT INTO assunto (categoria_id, nome) VALUES (2,'Android');

INSERT INTO permissao (nome) VALUES ('administrador');
INSERT INTO usuario (nome, username, password) VALUES ('Valdinei', 'admin', '1234');


INSERT INTO livro (autor, assunto_id, descricao, editora_id, imagem, titulo) VALUES ('autor1', 4,'descricao1', 3, '/images/jogos_android.png', 'jogos android');



