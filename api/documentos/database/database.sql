 create sequence seq_cep start with 1 increment by 1;
 create sequence seq_cidade start with 1 increment by 1;
 create sequence seq_cliente start with 1 increment by 1;
 create sequence seq_documento start with 1 increment by 1;
 create sequence seq_endereco start with 1 increment by 1;
 create sequence seq_equipamento start with 1 increment by 1;
 create sequence seq_estado start with 1 increment by 1;
 create sequence seq_pais start with 1 increment by 1;
 create sequence seq_servico start with 1 increment by 1;
 create sequence seq_telefone start with 1 increment by 1;
 
    
    create table cep (
       id_cep number(19,0) not null,
        cep varchar2(255 char),
        primary key (id_cep)
    );
 
    
    create table cidade (
       id_cidade number(19,0) not null,
        nome varchar2(255 char),
        id_estado number(19,0),
        primary key (id_cidade)
    );
 
    
    create table cliente (
       tipo varchar2(31 char) not null,
        id_cliente number(19,0) not null,
        nome varchar2(255 char),
        nascimento date,
        razao_social varchar2(255 char),
        id_endereco number(19,0),
        id_telefone number(19,0),
        primary key (id_cliente)
    );
 
    
    create table documento (
       id_documento number(19,0) not null,
        dt_emissao date,
        numero varchar2(255 char),
        tipo number(5,0),
        dt_validade date,
        id_cliente number(19,0),
        primary key (id_documento)
    );
 
    
    create table endereco (
       id_endereco number(19,0) not null,
        bairro varchar2(255 char),
        complemento varchar2(255 char),
        logradouro varchar2(255 char),
        numero varchar2(255 char),
        id_cep number(19,0),
        id_cidade number(19,0),
        primary key (id_endereco)
    );
 
    
    create table equipamento (
       tipo varchar2(31 char) not null,
        id_equipamento number(19,0) not null,
        nr_serie varchar2(255 char),
        id_cliente number(19,0),
        primary key (id_equipamento)
    );
 
    
    create table estado (
       id_estado number(19,0) not null,
        nome varchar2(255 char),
        id_pais number(19,0),
        primary key (id_estado)
    );
 
    
    create table pais (
       id_pais number(19,0) not null,
        nome varchar2(255 char),
        primary key (id_pais)
    );
 
    
    create table servico (
       tipo varchar2(31 char) not null,
        id_servico number(19,0) not null,
        dt_autorizacao timestamp(6),
        dt_conclusao timestamp(6),
        dt_inicio timestamp(6),
        descricao varchar2(255 char),
        valor float(53) not null,
        nome_peca_substituida varchar2(255 char),
        id_equipamento number(19,0),
        primary key (id_servico)
    );
 
    
    create table telefone (
       id_telefone number(19,0) not null,
        ddd varchar2(255 char),
        ddi varchar2(255 char),
        numero varchar2(255 char),
        primary key (id_telefone)
    );
 
    
    alter table cidade 
       add constraint FK_ESTADO_CIDADE 
       foreign key (id_estado) 
       references estado;
 
    
    alter table cliente 
       add constraint FK_ENDERECO_CLIENTE 
       foreign key (id_endereco) 
       references endereco;
 
    
    alter table cliente 
       add constraint FK_TELEFONE_CLIENTE 
       foreign key (id_telefone) 
       references telefone;
 
    
    alter table documento 
       add constraint FK_CLIENTE_DOCUMENTO 
       foreign key (id_cliente) 
       references cliente;
 
    
    alter table endereco 
       add constraint FK_CEP_ENDERECO 
       foreign key (id_cep) 
       references cep;
 
    
    alter table endereco 
       add constraint FK_CIDADE_ENDERECO 
       foreign key (id_cidade) 
       references cidade;
 
    
    alter table equipamento 
       add constraint FK_EQUIPAMENTO_CLIENTE 
       foreign key (id_cliente) 
       references cliente;
 
    
    alter table estado 
       add constraint FK_PAIS_ESTADO 
       foreign key (id_pais) 
       references pais;
 
    
    alter table servico 
       add constraint FK_SERVICO_EQUIPAMENTO 
       foreign key (id_equipamento) 
       references equipamento;