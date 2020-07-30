insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Brasileira');

insert into estado (nome) values ('Pernambuco');
insert into estado (nome) values ('Paraíba');
insert into estado (nome) values ('Sergipe');

insert into cidade (nome, estado_id) values ('Olinda', 1);
insert into cidade (nome, estado_id) values ('Joao pessoa', 2);

insert into restaurante (nome, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, endereco_cidade_id, data_cadastro, data_atualizacao) values ('Restaurante acacia', 4.00, 1, '53330470', 'Rua cafeeiro', '40', 'qd a10', 'Ouro Preto', 1, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Restaurante sabor do lima', 6.00, 1, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Liu da carne de sol', 5.00, 2, utc_timestamp, utc_timestamp);

insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');

insert into permissao (id, nome, descricao) values (1, 	'CONSULTAR_COZINHA', 'Permite consultar');
insert into permissao (id, nome, descricao) values (2, 	'Editar_COZINHA', 'Permite editar cozinha');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,1), (1,2), (1,3), (2,2), (2,3);
