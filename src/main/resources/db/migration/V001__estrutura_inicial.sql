CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;

CREATE TABLE public.anexo (
    id bigint NOT NULL,
    codigo uuid,
    content_type character varying(255),
    data_atualizacao timestamp without time zone,
    data_cadastro timestamp without time zone,
    tamanho bigint
);

CREATE TABLE public.anexo_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    codigo uuid,
    content_type character varying(255),
    data_atualizacao timestamp without time zone,
    data_cadastro timestamp without time zone,
    nome_arquivo character varying(255),
    tamanho bigint
);

CREATE SEQUENCE public.anexo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.anexo_id_seq OWNED BY public.anexo.id;

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.modelo (
    id bigint NOT NULL,
    codigo uuid,
    descricao character varying(255),
    titulo character varying(255),
    usuario_id bigint NOT NULL,
    modelo_arquivo_id bigint,
    preview_id bigint,
    privado boolean DEFAULT false,
    data_atualizacao timestamp without time zone,
    data_cadastro timestamp without time zone
);

CREATE TABLE public.modelo_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    codigo uuid,
    descricao character varying(255),
    titulo character varying(255),
    usuario_id bigint,
    modelo_arquivo_id bigint,
    preview_id bigint,
    privado boolean DEFAULT false,
    data_atualizacao timestamp without time zone,
    data_cadastro timestamp without time zone
);

CREATE SEQUENCE public.modelo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.modelo_id_seq OWNED BY public.modelo.id;

CREATE TABLE public.oauth_client_details (
    client_id text NOT NULL,
    resource_ids text,
    client_secret text,
    scope text,
    authorized_grant_types text,
    web_server_redirect_uri text,
    authorities text,
    access_token_validity integer,
    refresh_token_validity integer,
    additional_information text,
    autoapprove text
);

CREATE TABLE public.revinfo (
    id integer NOT NULL,
    "timestamp" bigint NOT NULL,
    codigo_usuario uuid,
    data_cadastro timestamp without time zone,
    nome_usuario character varying(255)
);

CREATE TABLE public.usuario (
    id bigint NOT NULL,
    ativo boolean,
    codigo uuid,
    data_atualizacao timestamp without time zone,
    data_cadastro timestamp without time zone,
    email character varying(255),
    instituicao character varying(255),
    nome character varying(255),
    senha character varying(255)
);

CREATE TABLE public.usuario_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    ativo boolean,
    codigo uuid,
    data_atualizacao timestamp without time zone,
    data_cadastro timestamp without time zone,
    email character varying(255),
    instituicao character varying(255),
    nome character varying(255),
    senha character varying(255)
);


CREATE SEQUENCE public.usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;

ALTER TABLE ONLY public.anexo ALTER COLUMN id SET DEFAULT nextval('public.anexo_id_seq'::regclass);
ALTER TABLE ONLY public.modelo ALTER COLUMN id SET DEFAULT nextval('public.modelo_id_seq'::regclass);
ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);

INSERT INTO public.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('oisol', NULL, '$2a$10$amSG/ddmnEkSAxu/jPm4duuhJ/hTSOmdeOIgAQet.gly6u9Oio74u', 'READ', 'password', NULL, NULL, 21600, 5184000, NULL, NULL);

INSERT INTO public.usuario (ativo, codigo, data_atualizacao, data_cadastro, email, instituicao, nome, senha) VALUES (true, '3fa85f64-5717-4562-b3fc-2c963f66afa6', '2022-04-20 17:30:50.077664', '2022-04-20 08:10:47', 'ronier.lim@gmail.com', 'SPS' , 'Ronier Lima', '$2a$10$zoqIXaTXvHFcc1Xc6N4ruOK3GK9zFQsoIEscWtD0uwPAtGrWkYp9G');
INSERT INTO public.usuario (ativo, codigo, data_atualizacao, data_cadastro, email, instituicao, nome, senha) VALUES (true, '9173a5f5-5abf-4ab3-b2e4-3ac648d6e20e', '2022-06-06 14:13:19.69781', '2022-06-06 14:13:19.697891', 'victor@gmail.com', 'SPS' , 'Ronier teste', '$2a$10$zoqIXaTXvHFcc1Xc6N4ruOK3GK9zFQsoIEscWtD0uwPAtGrWkYp9G');
