CREATE SEQUENCE seq_ht_cliente START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ht_endereco START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ht_cidade START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ht_estado START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ht_pais START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ht_documento START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ht_tipo_documento START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ht_equipamento START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ht_tipo_equipamento START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ht_servico START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ht_tipo_servico START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ht_usuario START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ht_tipo_cliente START WITH 1 INCREMENT BY 1;

CREATE TABLE ht_tipo_cliente
(
    id_tipo_cliente NUMBER(38, 0) NOT NULL,
    nome            VARCHAR2(255) NOT NULL,
    sigla           VARCHAR2(255),
    CONSTRAINT pk_ht_tipo_cliente PRIMARY KEY (id_tipo_cliente)
);




CREATE TABLE ht_usuario
(
    id_usuario NUMBER(38, 0) NOT NULL,
    username   VARCHAR2(255) NOT NULL,
    password   VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_ht_usuario PRIMARY KEY (id_usuario)
);



CREATE TABLE ht_tipo_servico
(
    id_tipo_servico NUMBER(38, 0) NOT NULL,
    nome            VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_ht_tipo_servico PRIMARY KEY (id_tipo_servico)
);



CREATE TABLE ht_tipo_equipamento
(
    id_tipo_equipamento NUMBER(38, 0) NOT NULL,
    nome                VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_ht_tipo_equipamento PRIMARY KEY (id_tipo_equipamento)
);


CREATE TABLE ht_tipo_documento
(
    id_tipo_documento NUMBER(38, 0) NOT NULL,
    nome              VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_ht_tipo_documento PRIMARY KEY (id_tipo_documento)
);

ALTER TABLE ht_tipo_documento
    ADD CONSTRAINT UK_NOME_TIPO_DOCUMENTO UNIQUE (nome);

CREATE INDEX IDX_NOME_TIPO_DOCUMENTO ON ht_tipo_documento (nome);



CREATE TABLE ht_pais
(
    id_pais NUMBER(38, 0) NOT NULL,
    nome    VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_ht_pais PRIMARY KEY (id_pais)
);


CREATE TABLE ht_estado
(
    id_estado NUMBER(38, 0) NOT NULL,
    nome      VARCHAR2(255),
    sigla     VARCHAR2(255) NOT NULL,
    id_pais   NUMBER(38, 0),
    CONSTRAINT pk_ht_estado PRIMARY KEY (id_estado)
);



CREATE TABLE ht_cidade
(
    id_cidade NUMBER(38, 0) NOT NULL,
    nome      VARCHAR2(255),
    id_estado NUMBER(38, 0),
    CONSTRAINT pk_ht_cidade PRIMARY KEY (id_cidade)
);



CREATE TABLE ht_endereco
(
    id_endereco NUMBER(38, 0) NOT NULL,
    logradouro  VARCHAR2(255),
    numero      VARCHAR2(255),
    complemento VARCHAR2(255),
    bairro      VARCHAR2(255),
    cep         VARCHAR2(255),
    id_cidade   NUMBER(38, 0),
    CONSTRAINT pk_ht_endereco PRIMARY KEY (id_endereco)
);


CREATE TABLE ht_cliente
(
    id_cliente      NUMBER(38, 0) NOT NULL,
    nome            VARCHAR2(255),
    nascimento      date,
    id_endereco     NUMBER(38, 0),
    id_tipo_cliente NUMBER(38, 0),
    ddi             VARCHAR2(255),
    ddd             VARCHAR2(255) NOT NULL,
    numero          VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_ht_cliente PRIMARY KEY (id_cliente)
);




CREATE TABLE ht_documento
(
    id_documento      NUMBER(38, 0) NOT NULL,
    numero            VARCHAR2(255),
    id_cliente        NUMBER(38, 0),
    id_tipo_documento NUMBER(38, 0),
    dt_emissao        date,
    dt_validade       date,
    CONSTRAINT pk_ht_documento PRIMARY KEY (id_documento)
);




CREATE TABLE ht_equipamento
(
    id_equipamento      NUMBER(38, 0) NOT NULL,
    id_cliente          NUMBER(38, 0),
    nr_serie            VARCHAR2(255),
    id_tipo_equipamento NUMBER(38, 0),
    CONSTRAINT pk_ht_equipamento PRIMARY KEY (id_equipamento)
);



CREATE TABLE ht_servico
(
    id_servico      NUMBER(38, 0) NOT NULL,
    descricao       VARCHAR2(255),
    valor           FLOAT(24)     NOT NULL,
    id_tipo_servico NUMBER(38, 0),
    dt_autorizacao  TIMESTAMP,
    dt_inicio       TIMESTAMP,
    dt_conclusao    TIMESTAMP,
    id_equipamento  NUMBER(38, 0),
    CONSTRAINT pk_ht_servico PRIMARY KEY (id_servico)
);



CREATE INDEX IDX_NOME_TIPO_CLIENTE ON ht_tipo_cliente (nome);

ALTER TABLE ht_usuario
    ADD CONSTRAINT UK_USERNAME_USER UNIQUE (username);
	
ALTER TABLE ht_tipo_servico
    ADD CONSTRAINT UK_NOME_TIPO_SERVICO UNIQUE (nome);

CREATE INDEX IDX_NOME_TIPO_SERVICO ON ht_tipo_servico (nome);



ALTER TABLE ht_servico
    ADD CONSTRAINT FK_HT_SERVICO_ON_ID_EQUIPAMENTO FOREIGN KEY (id_equipamento) REFERENCES ht_equipamento (id_equipamento);

ALTER TABLE ht_servico
    ADD CONSTRAINT FK_HT_SERVICO_ON_ID_TIPO_SERVICO FOREIGN KEY (id_tipo_servico) REFERENCES ht_tipo_servico (id_tipo_servico);

ALTER TABLE ht_tipo_equipamento
    ADD CONSTRAINT UK_NOME_TIPO_EQUIPAMENTO UNIQUE (nome);

CREATE INDEX IDX_NOME_TIPO_EQUIPAMENTO ON ht_tipo_equipamento (nome);


CREATE INDEX idx_equipamento_nr_serie ON ht_equipamento (nr_serie);

ALTER TABLE ht_equipamento
    ADD CONSTRAINT FK_HT_EQUIPAMENTO_ON_ID_CLIENTE FOREIGN KEY (id_cliente) REFERENCES ht_cliente (id_cliente);

ALTER TABLE ht_equipamento
    ADD CONSTRAINT FK_HT_EQUIPAMENTO_ON_ID_TIPO_EQUIPAMENTO FOREIGN KEY (id_tipo_equipamento) REFERENCES ht_tipo_equipamento (id_tipo_equipamento);

ALTER TABLE ht_documento
    ADD CONSTRAINT FK_HT_DOCUMENTO_ON_ID_CLIENTE FOREIGN KEY (id_cliente) REFERENCES ht_cliente (id_cliente);

ALTER TABLE ht_documento
    ADD CONSTRAINT FK_HT_DOCUMENTO_ON_ID_TIPO_DOCUMENTO FOREIGN KEY (id_tipo_documento) REFERENCES ht_tipo_documento (id_tipo_documento);

ALTER TABLE ht_estado
    ADD CONSTRAINT FK_HT_ESTADO_ON_ID_PAIS FOREIGN KEY (id_pais) REFERENCES ht_pais (id_pais);

ALTER TABLE ht_cidade
    ADD CONSTRAINT FK_HT_CIDADE_ON_ID_ESTADO FOREIGN KEY (id_estado) REFERENCES ht_estado (id_estado);

ALTER TABLE ht_endereco
    ADD CONSTRAINT FK_HT_ENDERECO_ON_ID_CIDADE FOREIGN KEY (id_cidade) REFERENCES ht_cidade (id_cidade);

ALTER TABLE ht_cliente
    ADD CONSTRAINT FK_HT_CLIENTE_ON_ID_ENDERECO FOREIGN KEY (id_endereco) REFERENCES ht_endereco (id_endereco);

ALTER TABLE ht_cliente
    ADD CONSTRAINT FK_HT_CLIENTE_ON_ID_TIPO_CLIENTE FOREIGN KEY (id_tipo_cliente) REFERENCES ht_tipo_cliente (id_tipo_cliente);
	
	
	
	
	
REM INSERTING into HT_TIPO_CLIENTE
SET DEFINE OFF;
Insert into HT_TIPO_CLIENTE (ID_TIPO_CLIENTE,NOME,SIGLA) values (SEQ_HT_TIPO_CLIENTE.NEXTVAL,'Pessoa Física','PF');
Insert into HT_TIPO_CLIENTE (ID_TIPO_CLIENTE,NOME,SIGLA) values (SEQ_HT_TIPO_CLIENTE.NEXTVAL,'Pessoa Jurídica','PJ');



REM INSERTING into HT_TIPO_DOCUMENTO
SET DEFINE OFF;
Insert into HT_TIPO_DOCUMENTO (ID_TIPO_DOCUMENTO,NOME) values (SEQ_HT_TIPO_DOCUMENTO.NEXTVAL ,'RG');
Insert into HT_TIPO_DOCUMENTO (ID_TIPO_DOCUMENTO,NOME) values (SEQ_HT_TIPO_DOCUMENTO.NEXTVAL,'CPF');
Insert into HT_TIPO_DOCUMENTO (ID_TIPO_DOCUMENTO,NOME) values (SEQ_HT_TIPO_DOCUMENTO.NEXTVAL,'CNPJ');


REM INSERTING into HT_TIPO_EQUIPAMENTO
SET DEFINE OFF;
Insert into HT_TIPO_EQUIPAMENTO (ID_TIPO_EQUIPAMENTO,NOME) values (SEQ_HT_TIPO_EQUIPAMENTO.NEXTVAL,'Notebook');
Insert into HT_TIPO_EQUIPAMENTO (ID_TIPO_EQUIPAMENTO,NOME) values (SEQ_HT_TIPO_EQUIPAMENTO.NEXTVAL,'Desktop');
Insert into HT_TIPO_EQUIPAMENTO (ID_TIPO_EQUIPAMENTO,NOME) values (SEQ_HT_TIPO_EQUIPAMENTO.NEXTVAL,'Tablet');
Insert into HT_TIPO_EQUIPAMENTO (ID_TIPO_EQUIPAMENTO,NOME) values (SEQ_HT_TIPO_EQUIPAMENTO.NEXTVAL,'Celular');
Insert into HT_TIPO_EQUIPAMENTO (ID_TIPO_EQUIPAMENTO,NOME) values (SEQ_HT_TIPO_EQUIPAMENTO.NEXTVAL,'Video Game');


REM INSERTING into HT_TIPO_SERVICO
SET DEFINE OFF;
Insert into HT_TIPO_SERVICO (ID_TIPO_SERVICO,NOME) values (SEQ_HT_TIPO_SERVICO.NEXTVAL,'Orçamento');
Insert into HT_TIPO_SERVICO (ID_TIPO_SERVICO,NOME) values (SEQ_HT_TIPO_SERVICO.NEXTVAL,'Limpeza');
Insert into HT_TIPO_SERVICO (ID_TIPO_SERVICO,NOME) values (SEQ_HT_TIPO_SERVICO.NEXTVAL,'Instalação ou Substituição de Peça');
REM INSERTING into HT_USUARIO
SET DEFINE OFF;


REM INSERTING into HT_PAIS
SET DEFINE OFF;
Insert into HT_PAIS (ID_PAIS,NOME) values (SEQ_HT_PAIS.NEXTVAL,'Brasil');



REM INSERTING into HT_ESTADO
SET DEFINE OFF;
Insert into HT_ESTADO (ID_ESTADO,NOME,SIGLA,ID_PAIS) values (SEQ_HT_ESTADO.NEXTVAL,'São Paulo','SP','1');





REM INSERTING into HT_CIDADE
SET DEFINE OFF;
Insert into HT_CIDADE (ID_CIDADE,NOME,ID_ESTADO) values (SEQ_HT_CIDADE.NEXTVAL,'São Paulo','1');
Insert into HT_CIDADE (ID_CIDADE,NOME,ID_ESTADO) values (SEQ_HT_CIDADE.NEXTVAL,'Campinas','1');
Insert into HT_CIDADE (ID_CIDADE,NOME,ID_ESTADO) values (SEQ_HT_CIDADE.NEXTVAL,'Osasco','1');





REM INSERTING into HT_ENDERECO
SET DEFINE OFF;
Insert into HT_ENDERECO (ID_ENDERECO,BAIRRO,CEP,COMPLEMENTO,LOGRADOURO,NUMERO,ID_CIDADE) values (SEQ_HT_ENDERECO.NEXTVAL,'Bela Vista','06086-120','AP81-A','Rua Adolpho Bozzi','505','3');


REM INSERTING into HT_CLIENTE
SET DEFINE OFF;
Insert into HT_CLIENTE (ID_CLIENTE,NASCIMENTO,NOME,DDD,DDI,NUMERO,ID_ENDERECO,ID_TIPO_CLIENTE) values (SEQ_HT_CLIENTE.NEXTVAL,to_date('08/03/77','DD/MM/RR'),'Benefrancis do Nascimento','11','55','982816536','1','1');
Insert into HT_CLIENTE (ID_CLIENTE,NASCIMENTO,NOME,DDD,DDI,NUMERO,ID_ENDERECO,ID_TIPO_CLIENTE) values (SEQ_HT_CLIENTE.NEXTVAL,to_date('15/05/00','DD/MM/RR'),'Bruno Sudré do Nascimento','11','55','982816536','1','1');



REM INSERTING into HT_DOCUMENTO
SET DEFINE OFF;
Insert into HT_DOCUMENTO (ID_DOCUMENTO,DT_EMISSAO,NUMERO,DT_VALIDADE,ID_CLIENTE,ID_TIPO_DOCUMENTO) values (SEQ_HT_DOCUMENTO.NEXTVAL,null,'284739753',null,'1','1');





REM INSERTING into HT_EQUIPAMENTO
SET DEFINE OFF;
Insert into HT_EQUIPAMENTO (ID_EQUIPAMENTO,NR_SERIE,ID_CLIENTE,ID_TIPO_EQUIPAMENTO) values (SEQ_HT_EQUIPAMENTO.NEXTVAL,'0','1','1');

REM INSERTING into HT_SERVICO
SET DEFINE OFF;
Insert into HT_SERVICO (ID_SERVICO,DT_AUTORIZACAO,DT_CONCLUSAO,DT_INICIO,DESCRICAO,VALOR,ID_EQUIPAMENTO,ID_TIPO_SERVICO) values (SEQ_HT_SERVICO.NEXTVAL,to_timestamp('21/12/22 19:55:25,630220000','DD/MM/RR HH24:MI:SSXFF'),null,null,'Verificação dos componenetes substituição da pasta térmica.','100','1','2');

COMMIT;	