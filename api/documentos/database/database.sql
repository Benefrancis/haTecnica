--------------------------------------------------------
--  Arquivo criado - sábado-dezembro-24-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table HT_CIDADE
--------------------------------------------------------

  CREATE TABLE "HT_CIDADE" 
   (	"ID_CIDADE" NUMBER(19,0), 
	"NOME" VARCHAR2(255 CHAR), 
	"ID_ESTADO" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table HT_CLIENTE
--------------------------------------------------------

  CREATE TABLE "HT_CLIENTE" 
   (	"ID_CLIENTE" NUMBER(19,0), 
	"EMAIL" VARCHAR2(255 CHAR), 
	"NASCIMENTO" DATE, 
	"NOME" VARCHAR2(255 CHAR), 
	"DDD" VARCHAR2(255 CHAR), 
	"DDI" VARCHAR2(255 CHAR), 
	"NUMERO" VARCHAR2(255 CHAR), 
	"ID_TIPO_CLIENTE" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table HT_DOCUMENTO
--------------------------------------------------------

  CREATE TABLE "HT_DOCUMENTO" 
   (	"ID_DOCUMENTO" NUMBER(19,0), 
	"DT_EMISSAO" DATE, 
	"NUMERO" VARCHAR2(255 CHAR), 
	"DT_VALIDADE" DATE, 
	"ID_CLIENTE" NUMBER(19,0), 
	"ID_TIPO_DOCUMENTO" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table HT_ENDERECO
--------------------------------------------------------

  CREATE TABLE "HT_ENDERECO" 
   (	"ID_ENDERECO" NUMBER(19,0), 
	"BAIRRO" VARCHAR2(255 CHAR), 
	"CEP" VARCHAR2(255 CHAR), 
	"COMPLEMENTO" VARCHAR2(255 CHAR), 
	"LOGRADOURO" VARCHAR2(255 CHAR), 
	"NUMERO" VARCHAR2(255 CHAR), 
	"ID_CIDADE" NUMBER(19,0), 
	"ID_CLIENTE" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table HT_EQUIPAMENTO
--------------------------------------------------------

  CREATE TABLE "HT_EQUIPAMENTO" 
   (	"ID_EQUIPAMENTO" NUMBER(19,0), 
	"NR_SERIE" VARCHAR2(255 CHAR), 
	"ID_CLIENTE" NUMBER(19,0), 
	"ID_TIPO_EQUIPAMENTO" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table HT_ESTADO
--------------------------------------------------------

  CREATE TABLE "HT_ESTADO" 
   (	"ID_ESTADO" NUMBER(19,0), 
	"NOME" VARCHAR2(255 CHAR), 
	"SIGLA" VARCHAR2(255 CHAR), 
	"ID_PAIS" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table HT_PAIS
--------------------------------------------------------

  CREATE TABLE "HT_PAIS" 
   (	"ID_PAIS" NUMBER(19,0), 
	"NOME" VARCHAR2(255 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Table HT_SERVICO
--------------------------------------------------------

  CREATE TABLE "HT_SERVICO" 
   (	"ID_SERVICO" NUMBER(19,0), 
	"DT_AUTORIZACAO" TIMESTAMP (6), 
	"DT_CONCLUSAO" TIMESTAMP (6), 
	"DT_INICIO" TIMESTAMP (6), 
	"DESCRICAO" VARCHAR2(255 CHAR), 
	"VALOR" FLOAT(53), 
	"ID_EQUIPAMENTO" NUMBER(19,0), 
	"ID_TIPO_SERVICO" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table HT_TIPO_CLIENTE
--------------------------------------------------------

  CREATE TABLE "HT_TIPO_CLIENTE" 
   (	"ID_TIPO_CLIENTE" NUMBER(19,0), 
	"NOME" VARCHAR2(255 CHAR), 
	"SIGLA" VARCHAR2(255 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Table HT_TIPO_DOCUMENTO
--------------------------------------------------------

  CREATE TABLE "HT_TIPO_DOCUMENTO" 
   (	"ID_TIPO_DOCUMENTO" NUMBER(19,0), 
	"NOME" VARCHAR2(255 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Table HT_TIPO_EQUIPAMENTO
--------------------------------------------------------

  CREATE TABLE "HT_TIPO_EQUIPAMENTO" 
   (	"ID_TIPO_EQUIPAMENTO" NUMBER(19,0), 
	"NOME" VARCHAR2(255 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Table HT_TIPO_SERVICO
--------------------------------------------------------

  CREATE TABLE "HT_TIPO_SERVICO" 
   (	"ID_TIPO_SERVICO" NUMBER(19,0), 
	"NOME" VARCHAR2(255 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Table HT_USUARIO
--------------------------------------------------------

  CREATE TABLE "HT_USUARIO" 
   (	"ID_USUARIO" NUMBER(19,0), 
	"PASSWORD" VARCHAR2(255 CHAR), 
	"USERNAME" VARCHAR2(255 CHAR)
   ) ;
REM INSERTING into HT_CIDADE
SET DEFINE OFF;
REM INSERTING into HT_CLIENTE
SET DEFINE OFF;
REM INSERTING into HT_DOCUMENTO
SET DEFINE OFF;
REM INSERTING into HT_ENDERECO
SET DEFINE OFF;
REM INSERTING into HT_EQUIPAMENTO
SET DEFINE OFF;
REM INSERTING into HT_ESTADO
SET DEFINE OFF;
REM INSERTING into HT_PAIS
SET DEFINE OFF;
REM INSERTING into HT_SERVICO
SET DEFINE OFF;
REM INSERTING into HT_TIPO_CLIENTE
SET DEFINE OFF;
REM INSERTING into HT_TIPO_DOCUMENTO
SET DEFINE OFF;
REM INSERTING into HT_TIPO_EQUIPAMENTO
SET DEFINE OFF;
REM INSERTING into HT_TIPO_SERVICO
SET DEFINE OFF;
REM INSERTING into HT_USUARIO
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C0011781
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011781" ON "HT_CIDADE" ("ID_CIDADE") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0011786
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011786" ON "HT_CLIENTE" ("ID_CLIENTE") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_NOME_CLIENTE
--------------------------------------------------------

  CREATE INDEX "IDX_NOME_CLIENTE" ON "HT_CLIENTE" ("NOME") 
  ;
--------------------------------------------------------
--  DDL for Index UK_EMAIL_CLIENTE
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_EMAIL_CLIENTE" ON "HT_CLIENTE" ("EMAIL") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0011788
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011788" ON "HT_DOCUMENTO" ("ID_DOCUMENTO") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_NUMERO_DOCUMENTO
--------------------------------------------------------

  CREATE INDEX "IDX_NUMERO_DOCUMENTO" ON "HT_DOCUMENTO" ("NUMERO") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0011790
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011790" ON "HT_ENDERECO" ("ID_ENDERECO") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0011792
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011792" ON "HT_EQUIPAMENTO" ("ID_EQUIPAMENTO") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_EQUIPAMENTO_NR_SERIE
--------------------------------------------------------

  CREATE INDEX "IDX_EQUIPAMENTO_NR_SERIE" ON "HT_EQUIPAMENTO" ("NR_SERIE") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0011795
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011795" ON "HT_ESTADO" ("ID_ESTADO") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0011798
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011798" ON "HT_PAIS" ("ID_PAIS") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0011801
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011801" ON "HT_SERVICO" ("ID_SERVICO") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_DATAS_SERVICO
--------------------------------------------------------

  CREATE INDEX "IDX_DATAS_SERVICO" ON "HT_SERVICO" ("DT_AUTORIZACAO", "DT_INICIO", "DT_CONCLUSAO") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0011804
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011804" ON "HT_TIPO_CLIENTE" ("ID_TIPO_CLIENTE") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_NOME_TIPO_CLIENTE
--------------------------------------------------------

  CREATE INDEX "IDX_NOME_TIPO_CLIENTE" ON "HT_TIPO_CLIENTE" ("NOME") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0011807
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011807" ON "HT_TIPO_DOCUMENTO" ("ID_TIPO_DOCUMENTO") 
  ;
--------------------------------------------------------
--  DDL for Index UK_NOME_TIPO_DOCUMENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_NOME_TIPO_DOCUMENTO" ON "HT_TIPO_DOCUMENTO" ("NOME") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0011810
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011810" ON "HT_TIPO_EQUIPAMENTO" ("ID_TIPO_EQUIPAMENTO") 
  ;
--------------------------------------------------------
--  DDL for Index UK_NOME_TIPO_EQUIPAMENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_NOME_TIPO_EQUIPAMENTO" ON "HT_TIPO_EQUIPAMENTO" ("NOME") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0011813
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011813" ON "HT_TIPO_SERVICO" ("ID_TIPO_SERVICO") 
  ;
--------------------------------------------------------
--  DDL for Index UK_NOME_TIPO_SERVICO
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_NOME_TIPO_SERVICO" ON "HT_TIPO_SERVICO" ("NOME") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0011817
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011817" ON "HT_USUARIO" ("ID_USUARIO") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_PASSWORD
--------------------------------------------------------

  CREATE INDEX "IDX_PASSWORD" ON "HT_USUARIO" ("PASSWORD") 
  ;
--------------------------------------------------------
--  DDL for Index UK_USERNAME_USER
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_USERNAME_USER" ON "HT_USUARIO" ("USERNAME") 
  ;
--------------------------------------------------------
--  Constraints for Table HT_CIDADE
--------------------------------------------------------

  ALTER TABLE "HT_CIDADE" MODIFY ("ID_CIDADE" NOT NULL ENABLE);
  ALTER TABLE "HT_CIDADE" ADD PRIMARY KEY ("ID_CIDADE")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table HT_CLIENTE
--------------------------------------------------------

  ALTER TABLE "HT_CLIENTE" MODIFY ("ID_CLIENTE" NOT NULL ENABLE);
  ALTER TABLE "HT_CLIENTE" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "HT_CLIENTE" MODIFY ("DDD" NOT NULL ENABLE);
  ALTER TABLE "HT_CLIENTE" MODIFY ("NUMERO" NOT NULL ENABLE);
  ALTER TABLE "HT_CLIENTE" ADD PRIMARY KEY ("ID_CLIENTE")
  USING INDEX  ENABLE;
  ALTER TABLE "HT_CLIENTE" ADD CONSTRAINT "UK_EMAIL_CLIENTE" UNIQUE ("EMAIL")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table HT_DOCUMENTO
--------------------------------------------------------

  ALTER TABLE "HT_DOCUMENTO" MODIFY ("ID_DOCUMENTO" NOT NULL ENABLE);
  ALTER TABLE "HT_DOCUMENTO" ADD PRIMARY KEY ("ID_DOCUMENTO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table HT_ENDERECO
--------------------------------------------------------

  ALTER TABLE "HT_ENDERECO" MODIFY ("ID_ENDERECO" NOT NULL ENABLE);
  ALTER TABLE "HT_ENDERECO" ADD PRIMARY KEY ("ID_ENDERECO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table HT_EQUIPAMENTO
--------------------------------------------------------

  ALTER TABLE "HT_EQUIPAMENTO" MODIFY ("ID_EQUIPAMENTO" NOT NULL ENABLE);
  ALTER TABLE "HT_EQUIPAMENTO" ADD PRIMARY KEY ("ID_EQUIPAMENTO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table HT_ESTADO
--------------------------------------------------------

  ALTER TABLE "HT_ESTADO" MODIFY ("ID_ESTADO" NOT NULL ENABLE);
  ALTER TABLE "HT_ESTADO" MODIFY ("SIGLA" NOT NULL ENABLE);
  ALTER TABLE "HT_ESTADO" ADD PRIMARY KEY ("ID_ESTADO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table HT_PAIS
--------------------------------------------------------

  ALTER TABLE "HT_PAIS" MODIFY ("ID_PAIS" NOT NULL ENABLE);
  ALTER TABLE "HT_PAIS" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "HT_PAIS" ADD PRIMARY KEY ("ID_PAIS")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table HT_SERVICO
--------------------------------------------------------

  ALTER TABLE "HT_SERVICO" MODIFY ("ID_SERVICO" NOT NULL ENABLE);
  ALTER TABLE "HT_SERVICO" MODIFY ("VALOR" NOT NULL ENABLE);
  ALTER TABLE "HT_SERVICO" ADD PRIMARY KEY ("ID_SERVICO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table HT_TIPO_CLIENTE
--------------------------------------------------------

  ALTER TABLE "HT_TIPO_CLIENTE" MODIFY ("ID_TIPO_CLIENTE" NOT NULL ENABLE);
  ALTER TABLE "HT_TIPO_CLIENTE" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "HT_TIPO_CLIENTE" ADD PRIMARY KEY ("ID_TIPO_CLIENTE")
  USING INDEX  ENABLE;
  ALTER TABLE "HT_TIPO_CLIENTE" ADD CONSTRAINT "UK_NOME_TIPO_CLIENTE" UNIQUE ("NOME")
  USING INDEX "IDX_NOME_TIPO_CLIENTE"  ENABLE;
--------------------------------------------------------
--  Constraints for Table HT_TIPO_DOCUMENTO
--------------------------------------------------------

  ALTER TABLE "HT_TIPO_DOCUMENTO" MODIFY ("ID_TIPO_DOCUMENTO" NOT NULL ENABLE);
  ALTER TABLE "HT_TIPO_DOCUMENTO" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "HT_TIPO_DOCUMENTO" ADD PRIMARY KEY ("ID_TIPO_DOCUMENTO")
  USING INDEX  ENABLE;
  ALTER TABLE "HT_TIPO_DOCUMENTO" ADD CONSTRAINT "UK_NOME_TIPO_DOCUMENTO" UNIQUE ("NOME")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table HT_TIPO_EQUIPAMENTO
--------------------------------------------------------

  ALTER TABLE "HT_TIPO_EQUIPAMENTO" MODIFY ("ID_TIPO_EQUIPAMENTO" NOT NULL ENABLE);
  ALTER TABLE "HT_TIPO_EQUIPAMENTO" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "HT_TIPO_EQUIPAMENTO" ADD PRIMARY KEY ("ID_TIPO_EQUIPAMENTO")
  USING INDEX  ENABLE;
  ALTER TABLE "HT_TIPO_EQUIPAMENTO" ADD CONSTRAINT "UK_NOME_TIPO_EQUIPAMENTO" UNIQUE ("NOME")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table HT_TIPO_SERVICO
--------------------------------------------------------

  ALTER TABLE "HT_TIPO_SERVICO" MODIFY ("ID_TIPO_SERVICO" NOT NULL ENABLE);
  ALTER TABLE "HT_TIPO_SERVICO" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "HT_TIPO_SERVICO" ADD PRIMARY KEY ("ID_TIPO_SERVICO")
  USING INDEX  ENABLE;
  ALTER TABLE "HT_TIPO_SERVICO" ADD CONSTRAINT "UK_NOME_TIPO_SERVICO" UNIQUE ("NOME")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table HT_USUARIO
--------------------------------------------------------

  ALTER TABLE "HT_USUARIO" MODIFY ("ID_USUARIO" NOT NULL ENABLE);
  ALTER TABLE "HT_USUARIO" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "HT_USUARIO" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "HT_USUARIO" ADD PRIMARY KEY ("ID_USUARIO")
  USING INDEX  ENABLE;
  ALTER TABLE "HT_USUARIO" ADD CONSTRAINT "UK_USERNAME_USER" UNIQUE ("USERNAME")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HT_CIDADE
--------------------------------------------------------

  ALTER TABLE "HT_CIDADE" ADD CONSTRAINT "FK_ESTADO_CIDADE" FOREIGN KEY ("ID_ESTADO")
	  REFERENCES "HT_ESTADO" ("ID_ESTADO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HT_CLIENTE
--------------------------------------------------------

  ALTER TABLE "HT_CLIENTE" ADD CONSTRAINT "FK_TIPO_CLIENTE" FOREIGN KEY ("ID_TIPO_CLIENTE")
	  REFERENCES "HT_TIPO_CLIENTE" ("ID_TIPO_CLIENTE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HT_DOCUMENTO
--------------------------------------------------------

  ALTER TABLE "HT_DOCUMENTO" ADD CONSTRAINT "FK_CLIENTE_DOCUMENTO" FOREIGN KEY ("ID_CLIENTE")
	  REFERENCES "HT_CLIENTE" ("ID_CLIENTE") ENABLE;
  ALTER TABLE "HT_DOCUMENTO" ADD CONSTRAINT "FK_TIPO_DOCUMENTO_CLIENTE" FOREIGN KEY ("ID_TIPO_DOCUMENTO")
	  REFERENCES "HT_TIPO_DOCUMENTO" ("ID_TIPO_DOCUMENTO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HT_ENDERECO
--------------------------------------------------------

  ALTER TABLE "HT_ENDERECO" ADD CONSTRAINT "FK_CIDADE_ENDERECO" FOREIGN KEY ("ID_CIDADE")
	  REFERENCES "HT_CIDADE" ("ID_CIDADE") ENABLE;
  ALTER TABLE "HT_ENDERECO" ADD CONSTRAINT "FK_CLIENTE_ENDERECO" FOREIGN KEY ("ID_CLIENTE")
	  REFERENCES "HT_CLIENTE" ("ID_CLIENTE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HT_EQUIPAMENTO
--------------------------------------------------------

  ALTER TABLE "HT_EQUIPAMENTO" ADD CONSTRAINT "FK_CLIENTE_EQUIPAMENTO" FOREIGN KEY ("ID_CLIENTE")
	  REFERENCES "HT_CLIENTE" ("ID_CLIENTE") ENABLE;
  ALTER TABLE "HT_EQUIPAMENTO" ADD CONSTRAINT "FK_TIPO_EQUIPAMENTO" FOREIGN KEY ("ID_TIPO_EQUIPAMENTO")
	  REFERENCES "HT_TIPO_EQUIPAMENTO" ("ID_TIPO_EQUIPAMENTO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HT_ESTADO
--------------------------------------------------------

  ALTER TABLE "HT_ESTADO" ADD CONSTRAINT "FK_PAIS_ESTADO" FOREIGN KEY ("ID_PAIS")
	  REFERENCES "HT_PAIS" ("ID_PAIS") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HT_SERVICO
--------------------------------------------------------

  ALTER TABLE "HT_SERVICO" ADD CONSTRAINT "FK_EQUIPAMENTO_SERVICO" FOREIGN KEY ("ID_EQUIPAMENTO")
	  REFERENCES "HT_EQUIPAMENTO" ("ID_EQUIPAMENTO") ENABLE;
  ALTER TABLE "HT_SERVICO" ADD CONSTRAINT "FK_TIPO_SERVICO" FOREIGN KEY ("ID_TIPO_SERVICO")
	  REFERENCES "HT_TIPO_SERVICO" ("ID_TIPO_SERVICO") ENABLE;
