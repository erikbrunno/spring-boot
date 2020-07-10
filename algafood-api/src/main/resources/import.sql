insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Brasileira');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Restaurante acacia', 4.00, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Restaurante sabor do lima', 6.00, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Liu da carne de sol', 5.00, 2);

insert into estado (nome) values ('Pernambuco');
insert into estado (nome) values ('Paraíba');
insert into estado (nome) values ('Sergipe');

insert into cidade (nome, estado_id) values ('Olinda', 1);
insert into cidade (nome, estado_id) values ('Joao pessoa', 2);