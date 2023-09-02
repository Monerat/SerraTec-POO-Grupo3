create database trabpoog3

create schema trab


create table trab.empresa(
	lojaid serial primary key,
	cdloja varchar(4) unique not null,
	razaosocial varchar(100) not null
	)

create table trab.cliente(
	clienteid serial primary key,
	codigo varchar(6) unique not null,
	nome varchar(100) not null
	)

create table trab.produto(
	produtoid serial primary key,
	codigo varchar(6) unique not null,
	descricao varchar(100) not null,
	vluni double precision not null,
	qtdest double precision not null
	)

create table trab.pedido(
	pedidoid serial primary key,
	nrped varchar(6) unique not null,
	qtdped double precision not null,
	vlliq double precision not null,
	dtpedido timestamp not null,
	idcliente int references trab.cliente(clienteid),
	idloja int references trab.empresa(lojaid)
	)

create table trab.pedprod(
	pedprodid serial primary key,
	produtoid int references trab.produto(produtoid),
	qtdped double precision not null,
	vluni double precision not null,
	vlbruto double precision not null,
	vldesc double precision,
	vlacresc double precision,
	pedidoid int references trab.pedido(pedidoid)
	)
	