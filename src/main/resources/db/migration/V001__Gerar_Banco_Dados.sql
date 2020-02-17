	CREATE TABLE cidades(
		id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		nome VARCHAR(100) NOT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
	
	CREATE TABLE clientes(
		id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		nome VARCHAR(100) NOT NULL,
		cidade_id INT NOT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
	
	ALTER TABLE clientes ADD CONSTRAINT
	FK_cidades_clientes FOREIGN KEY(cidade_id)
	REFERENCES cidades(id);
	
/* Insert */	
	
	INSERT INTO cidades(nome) VALUES('Iguaraçu');
	INSERT INTO cidades(nome) VALUES('Manda-Rosa');
	INSERT INTO cidades(nome) VALUES('Fella dos Santos');
	INSERT INTO cidades(nome) VALUES('Igoarina');
	INSERT INTO cidades(nome) VALUES('Castelo Roxo');
	INSERT INTO cidades(nome) VALUES('Campos Silveira');
	INSERT INTO cidades(nome) VALUES('Macadâmias do Sul');
	INSERT INTO cidades(nome) VALUES('Fluorença');
	INSERT INTO cidades(nome) VALUES('Santanna');
	INSERT INTO cidades(nome) VALUES('Pomodoro');
	
	INSERT INTO clientes(nome, cidade_id) VALUES('Shayenne Souza', 2);
	INSERT INTO clientes(nome, cidade_id) VALUES('Xuliana Moura', 5);
	INSERT INTO clientes(nome, cidade_id) VALUES('Marina Brandão', 8);
	INSERT INTO clientes(nome, cidade_id) VALUES('Perspicada Almeida', 7);
	INSERT INTO clientes(nome, cidade_id) VALUES('Ruan Liro Baihu', 3);
	INSERT INTO clientes(nome, cidade_id) VALUES('Aimeu Coração', 9);
	INSERT INTO clientes(nome, cidade_id) VALUES('Mirno Dontes', 4);
	INSERT INTO clientes(nome, cidade_id) VALUES('Arruán Valdez', 1);
	INSERT INTO clientes(nome, cidade_id) VALUES('Américo Delfin', 6);
	INSERT INTO clientes(nome, cidade_id) VALUES('Paulo Polo', 10);