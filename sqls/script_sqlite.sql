
CREATE TABLE IF NOT EXISTS funcionarios(
    id INTEGER PRIMARY KEY, 
    nome TEXT NOT NULL, 
    telefone TEXT NOT NULL,
    endereco TEXT NOT NULL,
    sexo TEXT NOT NULL,
    dataNascimento INTEGER NOT NULL,
    telefoneEmergencia TEXT NOT NULL,
);
