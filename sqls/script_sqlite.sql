CREATE TABLE IF NOT EXISTS funcionarios(
    id INTEGER PRIMARY KEY, 
    nome TEXT NOT NULL, 
    telefone TEXT NOT NULL,
    endereco TEXT NOT NULL,
    sexo TEXT NOT NULL,
    dataNascimento INTEGER,
    telefoneEmergencia TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS usuario (
    id_usuario int AUTO_INCREMENT PRIMARY KEY,
    nome_usuario varchar(45),
    senha_usuario varchar(45)
);

CREATE TABLE IF NOT EXISTS areas(
    id INTEGER PRIMARY KEY, 
    nome TEXT NOT NULL
);

INSERT INTO usuario (nome_usuario, senha_usuario) VALUES ('admin', '1234');
INSERT INTO funcionarios (id, nome, telefone, endereco, sexo, dataNascimento, telefoneEmergencia) VALUES ('1','teste', '1234567', 'teste', 'F', null, '1234567');
