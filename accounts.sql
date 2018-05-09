create database accounts;

use accounts;

create table tb_customer_account(
id_customer int not null,
cpf_cnpj varchar(14),
nm_customer varchar(50),
is_active boolean,
vl_total decimal(8, 2),
primary key(id_customer));