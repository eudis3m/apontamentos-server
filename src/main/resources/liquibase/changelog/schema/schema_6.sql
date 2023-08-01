--liquibase formatted sql

--changeset versao:1


	
	-----------------------------------------------------------------------------------------------


CREATE TABLE db_projetos_ib.empresa
(
    oid bigserial NOT NULL ,
    ds_rua character varying(100) COLLATE pg_catalog."default" NOT NULL,
    ds_bairro character varying(100) COLLATE pg_catalog."default" NOT NULL,
    ds_cidade character varying(100) COLLATE pg_catalog."default" NOT NULL,
    ds_numero bigint NOT NULL,
    ds_complemento character varying(50) COLLATE pg_catalog."default",
    nm_empresa character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nr_cnpj character varying(20) COLLATE pg_catalog."default" NOT NULL,
    nr_telefone character varying(20) COLLATE pg_catalog."default" NOT NULL,
	DT_CADASTRO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de cadastro do registro.
    DT_ALTERACAO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de alteração do registro.
    OID_USUARIO_CADASTRO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de cadastro do registro.
    OID_USUARIO_ALTERACAO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de alteração do registro.
    ID_ATIVO character varying(1) NOT NULL DEFAULT 'S', -- Campo para verificar se a linha está ativa
	nm_usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT empresa_pkey_seq PRIMARY KEY (oid)
);

	
	---------------------------------------------------------------------------------------------------


CREATE TABLE db_projetos_ib.centro_custo
(
    oid bigserial NOT NULL,
    ds_centro_custo character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nm_projeto character varying(100) COLLATE pg_catalog."default" NOT NULL,
    vr_custo_aprovado NUMERIC(9,2) NOT NULL,
    vr_custo_previsto NUMERIC(9,2) NOT NULL,
	DT_CADASTRO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de cadastro do registro.
    DT_ALTERACAO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de alteração do registro.
    OID_USUARIO_CADASTRO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de cadastro do registro.
    OID_USUARIO_ALTERACAO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de alteração do registro.
    ID_ATIVO character varying(1) NOT NULL DEFAULT 'S', -- Campo para verificar se a linha está ativa
	nm_usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT centro_custo_pkey PRIMARY KEY (oid)
);

----------------------------------------------------------------------------------------


CREATE TABLE db_projetos_ib.recursos
(
    oid bigserial NOT NULL,
    nm_recursos character varying(100) COLLATE pg_catalog."default" NOT NULL,
	DT_CADASTRO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de cadastro do registro.
    DT_ALTERACAO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de alteração do registro.
    OID_USUARIO_CADASTRO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de cadastro do registro.
    OID_USUARIO_ALTERACAO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de alteração do registro.
    ID_ATIVO character varying(1) NOT NULL DEFAULT 'S', -- Campo para verificar se a linha está ativa
	nm_usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT recursos_pkey PRIMARY KEY (oid)
);

	
---------------------------------------------------------------


CREATE TABLE db_projetos_ib.tipo_atividades
(
   oid bigserial NOT NULL,
    nm_tipo_atividade character varying(100) COLLATE pg_catalog."default" NOT NULL,
    vr_atividade NUMERIC(9,2) NOT NULL,
	DT_CADASTRO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de cadastro do registro.
    DT_ALTERACAO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de alteração do registro.
    OID_USUARIO_CADASTRO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de cadastro do registro.
    OID_USUARIO_ALTERACAO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de alteração do registro.
    ID_ATIVO character varying(1) NOT NULL DEFAULT 'S', -- Campo para verificar se a linha está ativa
	nm_usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tipo_atividades_pkey PRIMARY KEY (oid)
);
	---------------------------------------------------------------------------
	
CREATE TABLE db_projetos_ib.usuario
(
    oid bigserial NOT NULL ,
    ds_senha character varying(100) COLLATE pg_catalog."default" NOT NULL,
    ds_login character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nm_usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nm_recursos character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nr_cpf character varying(20) COLLATE pg_catalog."default" NOT NULL,
	oid_recursos bigint,
	DT_CADASTRO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de cadastro do registro.
    DT_ALTERACAO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de alteração do registro.
    OID_USUARIO_CADASTRO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de cadastro do registro.
    OID_USUARIO_ALTERACAO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de alteração do registro.
    ID_ATIVO character varying(1) NOT NULL DEFAULT 'S', -- Campo para verificar se a linha está ativa
    CONSTRAINT usuarios_pkey PRIMARY KEY (oid),
    CONSTRAINT FK_USUARIO_PROG FOREIGN KEY (oid_recursos)
        REFERENCES db_projetos_ib.recursos (oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


--------------------------------------------------------------------------------


CREATE TABLE db_projetos_ib.projetos
(
    oid bigserial NOT NULL,
    ds_descricao_projeto character varying(100) COLLATE pg_catalog."default" NOT NULL,
    dt_projeto_final date NOT NULL,
    dt_projeto_inicio date NOT NULL,
    nm_projeto character varying(100) COLLATE pg_catalog."default" NOT NULL,
    oid_centro_custo bigint,
    oid_empresa bigint,
	nm_empresa character varying(100) COLLATE pg_catalog."default" NOT NULL,
	vr_custo_aprovado bigint NOT NULL,
	DT_CADASTRO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de cadastro do registro.
    DT_ALTERACAO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de alteração do registro.
    OID_USUARIO_CADASTRO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de cadastro do registro.
    OID_USUARIO_ALTERACAO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de alteração do registro.
    ID_ATIVO character varying(1) NOT NULL DEFAULT 'S', -- Campo para verificar se a linha está ativa
	nm_usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT projetos_pkey PRIMARY KEY (oid),
    CONSTRAINT fk_prog_projetos_prog FOREIGN KEY (oid_centro_custo)
        REFERENCES db_projetos_ib.centro_custo (oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_projetos_empresa FOREIGN KEY (oid_empresa)
        REFERENCES db_projetos_ib.empresa (oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

------------------------------------------------------------------------------


CREATE TABLE db_projetos_ib.atividades
(
    oid bigserial NOT NULL,
	oid_projetos bigint,
    oid_recursos bigint,
	nr_horas_atividade bigint NOT NULL,
    dt_final date NOT NULL,
    dt_inicio date NOT NULL,
	nm_recursos character varying(100) COLLATE pg_catalog."default" NOT NULL,
	nm_projetos character varying(100) COLLATE pg_catalog."default" NOT NULL,
	DT_CADASTRO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de cadastro do registro.
    DT_ALTERACAO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de alteração do registro.
    OID_USUARIO_CADASTRO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de cadastro do registro.
    OID_USUARIO_ALTERACAO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de alteração do registro.
    ID_ATIVO character varying(1) NOT NULL DEFAULT 'S', -- Campo para verificar se a linha está ativa
	nm_usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT atividades_pkey PRIMARY KEY (oid),
    CONSTRAINT fk_prog_atividades_prog FOREIGN KEY (oid_projetos)
        REFERENCES db_projetos_ib.projetos (oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_atividades_prog FOREIGN KEY (oid_recursos)
        REFERENCES db_projetos_ib.recursos (oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-------------------------------------------------------------------------------


CREATE TABLE db_projetos_ib.apontamentos
(
    oid bigserial NOT NULL,
	nm_projetos character varying(100) COLLATE pg_catalog."default" NOT NULL,
    dt_apontamento date NOT NULL,
    dt_lancamento date NOT NULL,
    nr_apontamento bigint NOT NULL ,
    vr_atividade NUMERIC(9,2) NOT NULL,
    oid_atividade bigint,
    nm_recursos character varying(100) COLLATE pg_catalog."default" NOT NULL,
	DT_CADASTRO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de cadastro do registro.
    DT_ALTERACAO timestamp NOT NULL DEFAULT now(), -- Campo para inserir a data de alteração do registro.
    OID_USUARIO_CADASTRO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de cadastro do registro.
    OID_USUARIO_ALTERACAO bigint NOT NULL DEFAULT 0, -- Campo para inserir o identificador do usuário de alteração do registro.
    ID_ATIVO character varying(1) NOT NULL DEFAULT 'S', -- Campo para verificar se a linha está ativa
	nm_usuario character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT apontamentos_pkey PRIMARY KEY (oid),
    CONSTRAINT fk_apontamentos_prog FOREIGN KEY (oid_atividade)
        REFERENCES db_projetos_ib.atividades (oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
