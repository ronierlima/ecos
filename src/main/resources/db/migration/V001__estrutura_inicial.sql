CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;

CREATE TABLE public.revinfo
(
    id             bigserial NOT NULL,
    "timestamp"    bigint    NOT NULL,
    codigo_usuario uuid,
    data_cadastro  timestamp without time zone,
    nome_usuario   character varying(255),
    constraint revinfo_pkey primary key (id)
);

CREATE TABLE public.anexo
(
    id               bigserial                       NOT NULL,
    codigo           uuid default uuid_generate_v4() not null,
    content_type     character varying(255),
    data_atualizacao timestamp without time zone,
    data_cadastro    timestamp without time zone,
    tamanho          bigint,
    constraint anexo_pkey primary key (id),
    constraint anexo_codigo_key unique (codigo)
);

CREATE TABLE public.anexo_aud
(
    id               bigint  NOT NULL,
    rev              integer NOT NULL,
    revtype          smallint,
    codigo           uuid,
    content_type     character varying(255),
    data_atualizacao timestamp without time zone,
    data_cadastro    timestamp without time zone,
    nome_arquivo     character varying(255),
    tamanho          bigint,
    constraint anexo_aud_pkey primary key (id, rev),
    constraint anexo_aud_rev_fkey foreign key (rev) references revinfo

);
CREATE TABLE public.usuario
(
    id               bigserial                       NOT NULL,
    codigo           uuid default uuid_generate_v4() not null,
    ativo            boolean,
    data_atualizacao timestamp without time zone,
    data_cadastro    timestamp without time zone,
    email            character varying(255),
    instituicao      character varying(255),
    foto_id          bigint,
    nome             character varying(255),
    senha            character varying(255),
    constraint usuario_pkey primary key (id),
    constraint usuario_codigo_key unique (codigo),
    constraint foto_fkey foreign key (foto_id) references anexo
);

CREATE TABLE public.usuario_aud
(
    id               bigint  NOT NULL,
    rev              integer NOT NULL,
    revtype          smallint,
    ativo            boolean,
    codigo           uuid,
    data_atualizacao timestamp without time zone,
    data_cadastro    timestamp without time zone,
    email            character varying(255),
    instituicao      character varying(255),
    foto_id          bigint,
    nome             character varying(255),
    senha            character varying(255),
    constraint usuario_aud_pkey primary key (id, rev),
    constraint usuario_aud_rev_fkey foreign key (rev) references revinfo
);
CREATE TABLE public.modelo
(
    id                bigserial                          NOT NULL,
    codigo            uuid    default uuid_generate_v4() not null,
    descricao         character varying(255),
    titulo            character varying(255),
    usuario_id        bigint                             NOT NULL,
    modelo_arquivo_id bigint,
    preview_id        bigint,
    privado           boolean DEFAULT false,
    data_atualizacao  timestamp without time zone,
    data_cadastro     timestamp without time zone,
    constraint modelo_pkey primary key (id),
    constraint modelo_codigo_key unique (codigo),
    constraint modelo_arquivo_fkey foreign key (modelo_arquivo_id) references anexo,
    constraint preview_fkey foreign key (preview_id) references anexo,
    constraint usuario_fkey foreign key (usuario_id) references usuario
);

CREATE TABLE public.modelo_aud
(
    id                bigint  NOT NULL,
    rev               integer NOT NULL,
    revtype           smallint,
    codigo            uuid,
    descricao         character varying(255),
    titulo            character varying(255),
    usuario_id        bigint,
    modelo_arquivo_id bigint,
    preview_id        bigint,
    privado           boolean DEFAULT false,
    data_atualizacao  timestamp without time zone,
    data_cadastro     timestamp without time zone,
    constraint modelo_aud_pkey primary key (id, rev),
    constraint anexo_aud_rev_fkey foreign key (rev) references revinfo
);

CREATE TABLE public.oauth_client_details
(
    client_id               text NOT NULL,
    resource_ids            text,
    client_secret           text,
    scope                   text,
    authorized_grant_types  text,
    web_server_redirect_uri text,
    authorities             text,
    access_token_validity   integer,
    refresh_token_validity  integer,
    additional_information  text,
    autoapprove             text
);

INSERT INTO public.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types,
                                         web_server_redirect_uri, authorities, access_token_validity,
                                         refresh_token_validity, additional_information, autoapprove)
VALUES ('oisol', NULL, '$2a$10$amSG/ddmnEkSAxu/jPm4duuhJ/hTSOmdeOIgAQet.gly6u9Oio74u', 'READ', 'password', NULL, NULL,
        21600, 5184000, NULL, NULL);

INSERT INTO public.usuario (ativo, codigo, data_atualizacao, data_cadastro, email, instituicao, nome, senha)
VALUES (true, '3fa85f64-5717-4562-b3fc-2c963f66afa6', '2022-04-20 17:30:50.077664', '2022-04-20 08:10:47',
        'ronier.lim@gmail.com', 'SPS', 'Ronier Lima', '$2a$10$zoqIXaTXvHFcc1Xc6N4ruOK3GK9zFQsoIEscWtD0uwPAtGrWkYp9G');
INSERT INTO public.usuario (ativo, codigo, data_atualizacao, data_cadastro, email, instituicao, nome, senha)
VALUES (true, '9173a5f5-5abf-4ab3-b2e4-3ac648d6e20e', '2022-06-06 14:13:19.69781', '2022-06-06 14:13:19.697891',
        'victor@gmail.com', 'SPS', 'Victor Pinheiro', '$2a$10$zoqIXaTXvHFcc1Xc6N4ruOK3GK9zFQsoIEscWtD0uwPAtGrWkYp9G');

CREATE SEQUENCE IF NOT EXISTS public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
