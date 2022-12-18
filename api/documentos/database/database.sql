
    
    create table ht_cidade (
       id_cidade number(19,0) not null,
        nome varchar2(255 char),
        id_estado number(19,0),
        primary key (id_cidade)
    );

    
    create table ht_cliente (
       tipo varchar2(31 char) not null,
        id_cliente number(19,0) not null,
        nome varchar2(255 char),
        ddd varchar2(255 char) not null,
        ddi varchar2(255 char),
        numero varchar2(255 char) not null,
        nascimento date,
        razao_social varchar2(255 char),
        id_endereco number(19,0),
        primary key (id_cliente)
    );

    
    create table ht_documento (
       tipo varchar2(31 char) not null,
        id_documento number(19,0) not null,
        dt_emissao date,
        numero varchar2(255 char),
        dt_validade date,
        id_cliente number(19,0),
        primary key (id_documento)
    );

    
    create table ht_endereco (
       id_endereco number(19,0) not null,
        bairro varchar2(255 char),
        cep varchar2(255 char),
        complemento varchar2(255 char),
        logradouro varchar2(255 char),
        numero varchar2(255 char),
        id_cidade number(19,0),
        primary key (id_endereco)
    );

    
    create table ht_equipamento (
       tipo varchar2(31 char) not null,
        id_equipamento number(19,0) not null,
        nr_serie varchar2(255 char),
        id_cliente number(19,0),
        primary key (id_equipamento)
    );

    
    create table ht_estado (
       id_estado number(19,0) not null,
        nome varchar2(255 char),
        sigla varchar2(255 char) not null,
        id_pais number(19,0),
        primary key (id_estado)
    );

    
    create table ht_pais (
       id_pais number(19,0) not null,
        nome varchar2(255 char) not null,
        primary key (id_pais)
    );

    
    create table ht_servico (
       tipo varchar2(31 char) not null,
        id_servico number(19,0) not null,
        dt_autorizacao timestamp(6),
        dt_conclusao timestamp(6),
        dt_inicio timestamp(6),
        descricao varchar2(255 char),
        valor float(53) not null,
        peca varchar2(255 char),
        id_equipamento number(19,0),
        primary key (id_servico)
    );

    
    create table ht_tipo_cliente (
       id_tipo_cliente number(19,0) not null,
        nome varchar2(255 char) not null,
        sigla varchar2(255 char),
        primary key (id_tipo_cliente)
    );

    
    create table ht_tipo_documento (
       id_tipo_documento number(10,0) not null,
        nome varchar2(255 char) not null,
        primary key (id_tipo_documento)
    );

    
    create table ht_tipo_equipamento (
       id_equipamento number(19,0) not null,
        nome varchar2(255 char) not null,
        primary key (id_equipamento)
    );

    
    create table ht_tipo_servico (
       id_servico number(19,0) not null,
        nome varchar2(255 char) not null,
        primary key (id_servico)
    );

    
    create table ht_usuario (
       id_usuario number(19,0) not null,
        password varchar2(255 char) not null,
        username varchar2(255 char) not null,
        primary key (id_usuario)
    );

    
    alter table ht_estado 
       drop constraint UK_SIGLA_ESTADO;

    
    alter table ht_estado 
       add constraint UK_SIGLA_ESTADO unique (sigla);

    
    alter table ht_pais 
       drop constraint UK_NOME_PAIS;

    
    alter table ht_pais 
       add constraint UK_NOME_PAIS unique (nome);

    
    alter table ht_tipo_cliente 
       drop constraint UK_NOME_TIPO_CLIENTE;

    
    alter table ht_tipo_cliente 
       add constraint UK_NOME_TIPO_CLIENTE unique (nome);

    
    alter table ht_tipo_documento 
       drop constraint UK_NOME_TIPO_DOCUMENTO;

    
    alter table ht_tipo_documento 
       add constraint UK_NOME_TIPO_DOCUMENTO unique (nome);

    
    alter table ht_tipo_equipamento 
       drop constraint UK_NOME_TIPO_EQUIPAMENTO;

    
    alter table ht_tipo_equipamento 
       add constraint UK_NOME_TIPO_EQUIPAMENTO unique (nome);

    
    alter table ht_tipo_servico 
       drop constraint UK_NOME_TIPO_SERVICO;

    
    alter table ht_tipo_servico 
       add constraint UK_NOME_TIPO_SERVICO unique (nome);

    
    alter table ht_usuario 
       drop constraint UK_USERNAME_USER;

    
    alter table ht_usuario 
       add constraint UK_USERNAME_USER unique (username);
	   
create sequence seq_ht_cidade start with 1 increment by 1;
create sequence seq_ht_cliente start with 1 increment by 1;
create sequence seq_ht_documento start with 1 increment by 1;
create sequence seq_ht_endereco start with 1 increment by 1;
create sequence seq_ht_equipamento start with 1 increment by 1;
create sequence seq_ht_estado start with 1 increment by 1;
create sequence seq_ht_pais start with 1 increment by 1;
create sequence seq_ht_servico start with 1 increment by 1;
create sequence seq_ht_tipo_cliente start with 1 increment by 1;
create sequence seq_ht_tipo_documento start with 1 increment by 1;
create sequence seq_ht_tipo_equipamento start with 1 increment by 1;
create sequence seq_ht_tipo_servico start with 1 increment by 1;
create sequence seq_ht_usuario start with 1 increment by 1;

    
    alter table ht_cidade 
       add constraint FK_ESTADO_CIDADE 
       foreign key (id_estado) 
       references ht_estado;

    
    alter table ht_cliente 
       add constraint FK_ENDERECO_CLIENTE 
       foreign key (id_endereco) 
       references ht_endereco;

    
    alter table ht_documento 
       add constraint FK_CLIENTE_DOCUMENTO 
       foreign key (id_cliente) 
       references ht_cliente;

    
    alter table ht_endereco 
       add constraint FK_CIDADE_ENDERECO 
       foreign key (id_cidade) 
       references ht_cidade;

    
    alter table ht_equipamento 
       add constraint FK_CLIENTE_EQUIPAMENTO 
       foreign key (id_cliente) 
       references ht_cliente;

    
    alter table ht_estado 
       add constraint FK_PAIS_ESTADO 
       foreign key (id_pais) 
       references ht_pais;

    
    alter table ht_servico 
       add constraint FK_EQUIPAMENTO_SERVICO 
       foreign key (id_equipamento) 
       references ht_equipamento;


 
Insert into HT_CIDADE (ID_CIDADE,NOME,ID_ESTADO) values ('1','Osasco','1');
Insert into HT_CIDADE (ID_CIDADE,NOME,ID_ESTADO) values ('2','São PAulo','1');


Insert into HT_CLIENTE (TIPO,ID_CLIENTE,NOME,DDD,DDI,NUMERO,NASCIMENTO,RAZAO_SOCIAL,ID_ENDERECO) values ('1','1','Benefrancis do Nascimento','11','55','982816536',to_date('08/03/77','DD/MM/RR'),null,'1');
Insert into HT_CLIENTE (TIPO,ID_CLIENTE,NOME,DDD,DDI,NUMERO,NASCIMENTO,RAZAO_SOCIAL,ID_ENDERECO) values ('2','2','FIAP','11','55','33858010',null,'Faculdade de Informatica e Administração Paulista','2');


Insert into HT_ENDERECO (ID_ENDERECO,BAIRRO,CEP,COMPLEMENTO,LOGRADOURO,NUMERO,ID_CIDADE) values ('1','Vila Osasco','06086-120','AP 81-A','Rua Adolpho Bozzi','505','1');
Insert into HT_ENDERECO (ID_ENDERECO,BAIRRO,CEP,COMPLEMENTO,LOGRADOURO,NUMERO,ID_CIDADE) values ('2','Aclimação','01538-001',null,'Av. Lins de Vasconcelos','1222','2');


Insert into HT_ESTADO (ID_ESTADO,NOME,SIGLA,ID_PAIS) values ('1','São Paulo','SP','1');


Insert into HT_PAIS (ID_PAIS,NOME) values ('1','Brasil');


Insert into HT_TIPO_CLIENTE (ID_TIPO_CLIENTE,NOME,SIGLA) values ('1','Pessoa Física','PF');
Insert into HT_TIPO_CLIENTE (ID_TIPO_CLIENTE,NOME,SIGLA) values ('2','Pessoa Jurídica','PJ');


Insert into HT_TIPO_DOCUMENTO (ID_TIPO_DOCUMENTO,NOME) values ('1','RG');
Insert into HT_TIPO_DOCUMENTO (ID_TIPO_DOCUMENTO,NOME) values ('2','CPF');
Insert into HT_TIPO_DOCUMENTO (ID_TIPO_DOCUMENTO,NOME) values ('3','CNPJ');


Insert into HT_TIPO_EQUIPAMENTO (ID_EQUIPAMENTO,NOME) values ('1','Computador');
Insert into HT_TIPO_EQUIPAMENTO (ID_EQUIPAMENTO,NOME) values ('2','Mobile');
Insert into HT_TIPO_EQUIPAMENTO (ID_EQUIPAMENTO,NOME) values ('3','Video Game');


Insert into HT_TIPO_SERVICO (ID_SERVICO,NOME) values ('1','Orçamento');
Insert into HT_TIPO_SERVICO (ID_SERVICO,NOME) values ('2','Limpeza');
Insert into HT_TIPO_SERVICO (ID_SERVICO,NOME) values ('3','Substituicao de Peca');
