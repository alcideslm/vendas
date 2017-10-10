create database banco;
use banco;

create table cliente (
	cod int not null auto_increment,
    nome character(100),
    email character (100),
    senha character (100),
    telefone character (30),
    primary key (cod)
);

insert into cliente (nome,email,senha)
values ('Alcides','a@a.com','senha');

create table produto (
	cod int not null auto_increment,
    nome character(100),
    descricao text (400),
    valor numeric (7,2),
    primary key (cod)
);

insert into produto (nome,descricao,valor)
values 	('Produto 1','Descrição do produto 1',10.99),
		('Produto 2','Descrição do produto 2',15.99),
		('Produto 3','Descrição do produto 3',10.99),
		('Produto 4','Descrição do produto 4',15.99),
		('Produto 5','Descrição do produto 5',15.99);

select * from produto;

create table pedido(
	cod int not null auto_increment,
    cliente int not null,
    estado int,
    data_pedido timestamp default current_timestamp,
    primary key (cod),
    foreign key (cliente) references cliente(cod)
);

create table itempedido(
	pedido int not null,
    produto int not null,
    quantidade int not null,
    valorUnit numeric (7,2),
    primary key (pedido,produto),
    foreign key (pedido) references pedido(cod),
    foreign key (produto) references produto(cod)
);