TRUNCATE agente RESTART IDENTITY CASCADE;
TRUNCATE agente_aud RESTART IDENTITY CASCADE;
TRUNCATE denuncia RESTART IDENTITY CASCADE;
TRUNCATE denuncia_aud RESTART IDENTITY CASCADE;
TRUNCATE denuncia_infrator RESTART IDENTITY CASCADE;
TRUNCATE denuncia_infrator_aud RESTART IDENTITY CASCADE;
TRUNCATE denuncia_notificante RESTART IDENTITY CASCADE;
TRUNCATE denuncia_notificante_aud RESTART IDENTITY CASCADE;
TRUNCATE denuncia_vitima RESTART IDENTITY CASCADE;
TRUNCATE denuncia_vitima_aud RESTART IDENTITY CASCADE;
TRUNCATE instituicao RESTART IDENTITY CASCADE;
TRUNCATE instituicao_aud RESTART IDENTITY CASCADE;
TRUNCATE pessoa RESTART IDENTITY CASCADE;
TRUNCATE pessoa_aud RESTART IDENTITY CASCADE;
TRUNCATE protocolo RESTART IDENTITY CASCADE;
TRUNCATE revinfo RESTART IDENTITY CASCADE;
TRUNCATE usuario RESTART IDENTITY CASCADE;
TRUNCATE usuario_aud RESTART IDENTITY CASCADE;
TRUNCATE grupo RESTART IDENTITY CASCADE;
TRUNCATE grupo_aud RESTART IDENTITY CASCADE;
TRUNCATE permissao RESTART IDENTITY CASCADE;
TRUNCATE permissao_aud RESTART IDENTITY CASCADE;
TRUNCATE grupo_permissao RESTART IDENTITY CASCADE;
TRUNCATE usuario_grupo RESTART IDENTITY CASCADE;

--pessoa
INSERT INTO	public.pessoa (id, codigo, nome, nome_social, nome_mae,	data_nascimento, rg, cpf, nacionalidade, naturalidade, telefone1, tipo_telefone1, telefone2, tipo_telefone2, email, logradouro, numero, 
complemento, cep, latitude, longitude, ativo, data_cadastro, data_atualizacao, ocupacao_id, genero_id, faixaetaria_id, estadocivil_id, racacor_id, grauinstrucao_id, doencarara_id, deficiencia_id, lgbt_id, 
bairro_id) values (nextval('pessoa_id_seq'), 'b451c0c8-198e-4d92-843c-2fbb15f543c0', 'Pessoa 1', 'Nome social pessoa 1', 'Mãe Pessoa 1', '1999-10-10', '433399223', '49518403082', 'Brasileiro', 'Sobral', '454564645', 'fixo', 
'99999999', 'Celular' , 'pessoa1@pessoa1.com.br', 'Rua Antonio augusto', '521', 'Casa A', '60160-130', '-9621021', '203255', true, current_timestamp, current_timestamp, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1);

INSERT INTO	public.pessoa (id, codigo, nome, nome_social, nome_mae,	data_nascimento, rg, cpf, nacionalidade, naturalidade, telefone1, tipo_telefone1, telefone2, tipo_telefone2, email, logradouro, numero, 
complemento, cep, latitude, longitude, ativo, data_cadastro, data_atualizacao, ocupacao_id, genero_id, faixaetaria_id, estadocivil_id, racacor_id, grauinstrucao_id, doencarara_id, deficiencia_id, lgbt_id, 
bairro_id) values (nextval('pessoa_id_seq'), '4daa062b-07d9-4299-9fe2-cd778c498109', 'Pessoa 2', 'Nome social pessoa 2', 'Mãe Pessoa 2', '1999-10-10', '433399223', '49518403082', 'Brasileiro', 'Sobral', '454564645', 'fixo', 
'99999999', 'Celular' , 'pessoa2@pessoa2.com.br', 'Rua Antonio augusto', '521', 'Casa A', '60160-130', '-9621021', '203255', true, current_timestamp, current_timestamp, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1);

INSERT INTO	public.pessoa (id, codigo, nome, nome_social, nome_mae,	data_nascimento, rg, cpf, nacionalidade, naturalidade, telefone1, tipo_telefone1, telefone2, tipo_telefone2, email, logradouro, numero, 
complemento, cep, latitude, longitude, ativo, data_cadastro, data_atualizacao, ocupacao_id, genero_id, faixaetaria_id, estadocivil_id, racacor_id, grauinstrucao_id, doencarara_id, deficiencia_id, lgbt_id, 
bairro_id) values (nextval('pessoa_id_seq'), '80e4022c-9909-4aa7-925f-02a829f57d2c', 'Pessoa 3', 'Nome social pessoa 3', 'Mãe Pessoa 3', '1999-10-10', '433399223', '49518403082', 'Brasileiro', 'Sobral', '454564645', 'fixo', 
'99999999', 'Celular' , 'pessoa3@pessoa3.com.br', 'Rua Antonio augusto', '521', 'Casa A', '60160-130', '-9621021', '203255', true, current_timestamp, current_timestamp, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1);

INSERT INTO	public.pessoa (id, codigo, nome, nome_social, nome_mae,	data_nascimento, rg, cpf, nacionalidade, naturalidade, telefone1, tipo_telefone1, telefone2, tipo_telefone2, email, logradouro, numero, 
complemento, cep, latitude, longitude, ativo, data_cadastro, data_atualizacao, ocupacao_id, genero_id, faixaetaria_id, estadocivil_id, racacor_id, grauinstrucao_id, doencarara_id, deficiencia_id, lgbt_id, 
bairro_id) values (nextval('pessoa_id_seq'), 'ec13ab18-fe4b-4f43-8179-96f03d5a2100', 'Pessoa 4', 'Nome social pessoa 4', 'Mãe Pessoa 4', '1999-10-10', '433399223', '49518403082', 'Brasileiro', 'Sobral', '454564645', 'fixo', 
'99999999', 'Celular' , 'pessoa4@pessoa4.com.br', 'Rua Antonio augusto', '521', 'Casa A', '60160-130', '-9621021', '203255', true, current_timestamp, current_timestamp, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1);

INSERT INTO	public.pessoa (id, codigo, nome, nome_social, nome_mae,	data_nascimento, rg, cpf, nacionalidade, naturalidade, telefone1, tipo_telefone1, telefone2, tipo_telefone2, email, logradouro, numero, 
complemento, cep, latitude, longitude, ativo, data_cadastro, data_atualizacao, ocupacao_id, genero_id, faixaetaria_id, estadocivil_id, racacor_id, grauinstrucao_id, doencarara_id, deficiencia_id, lgbt_id, 
bairro_id) values (nextval('pessoa_id_seq'), 'ff063092-6299-4649-91a3-3b3358a01cbb', 'Pessoa 5', 'Nome social pessoa 4', 'Mãe Pessoa 4', '1999-10-10', '433399223', '49518403082', 'Brasileiro', 'Sobral', '454564645', 'fixo', 
'99999999', 'Celular' , 'pessoa4@pessoa4.com.br', 'Rua Antonio augusto', '521', 'Casa A', '60160-130', '-9621021', '203255', true, current_timestamp, current_timestamp, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1);

INSERT INTO	public.pessoa (id, codigo, nome, nome_social, nome_mae,	data_nascimento, rg, cpf, nacionalidade, naturalidade, telefone1, tipo_telefone1, telefone2, tipo_telefone2, email, logradouro, numero, 
complemento, cep, latitude, longitude, ativo, data_cadastro, data_atualizacao, ocupacao_id, genero_id, faixaetaria_id, estadocivil_id, racacor_id, grauinstrucao_id, doencarara_id, deficiencia_id, lgbt_id, 
bairro_id) values (nextval('pessoa_id_seq'), 'bb13ae82-5594-40b7-a673-6da4cad9b702', 'Pessoa 6', 'Nome social pessoa 4', 'Mãe Pessoa 4', '1999-10-10', '433399223', '49518403082', 'Brasileiro', 'Sobral', '454564645', 'fixo', 
'99999999', 'Celular' , 'pessoa4@pessoa4.com.br', 'Rua Antonio augusto', '521', 'Casa A', '60160-130', '-9621021', '203255', true, current_timestamp, current_timestamp, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1);

INSERT INTO	public.pessoa (id, codigo, nome, nome_social, nome_mae,	data_nascimento, rg, cpf, nacionalidade, naturalidade, telefone1, tipo_telefone1, telefone2, tipo_telefone2, email, logradouro, numero, 
complemento, cep, latitude, longitude, ativo, data_cadastro, data_atualizacao, ocupacao_id, genero_id, faixaetaria_id, estadocivil_id, racacor_id, grauinstrucao_id, doencarara_id, deficiencia_id, lgbt_id, 
bairro_id) values (nextval('pessoa_id_seq'), 'eeabd235-acc8-4ecd-8b61-63f8e7436a9a', 'Pessoa 7', 'Nome social pessoa 4', 'Mãe Pessoa 4', '1999-10-10', '433399223', '49518403082', 'Brasileiro', 'Sobral', '454564645', 'fixo', 
'99999999', 'Celular' , 'pessoa4@pessoa4.com.br', 'Rua Antonio augusto', '521', 'Casa A', '60160-130', '-9621021', '203255', true, current_timestamp, current_timestamp, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1);

INSERT INTO	public.pessoa (id, codigo, nome, nome_social, nome_mae,	data_nascimento, rg, cpf, nacionalidade, naturalidade, telefone1, tipo_telefone1, telefone2, tipo_telefone2, email, logradouro, numero, 
complemento, cep, latitude, longitude, ativo, data_cadastro, data_atualizacao, ocupacao_id, genero_id, faixaetaria_id, estadocivil_id, racacor_id, grauinstrucao_id, doencarara_id, deficiencia_id, lgbt_id, 
bairro_id) values (nextval('pessoa_id_seq'), 'b913e6ab-2ff9-44ef-a295-97d84c136a65', 'Pessoa 8', 'Nome social pessoa 4', 'Mãe Pessoa 4', '1999-10-10', '433399223', '49518403082', 'Brasileiro', 'Sobral', '454564645', 'fixo', 
'99999999', 'Celular' , 'pessoa4@pessoa4.com.br', 'Rua Antonio augusto', '521', 'Casa A', '60160-130', '-9621021', '203255', true, current_timestamp, current_timestamp, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1);

INSERT INTO	public.pessoa (id, codigo, nome, nome_social, nome_mae,	data_nascimento, rg, cpf, nacionalidade, naturalidade, telefone1, tipo_telefone1, telefone2, tipo_telefone2, email, logradouro, numero, 
complemento, cep, latitude, longitude, ativo, data_cadastro, data_atualizacao, ocupacao_id, genero_id, faixaetaria_id, estadocivil_id, racacor_id, grauinstrucao_id, doencarara_id, deficiencia_id, lgbt_id, 
bairro_id) values (nextval('pessoa_id_seq'), '96aa7e88-76fa-4b89-976d-4dfc24413a36', 'Pessoa 9', 'Nome social pessoa 4', 'Mãe Pessoa 4', '1999-10-10', '433399223', '49518403082', 'Brasileiro', 'Sobral', '454564645', 'fixo', 
'99999999', 'Celular' , 'pessoa4@pessoa4.com.br', 'Rua Antonio augusto', '521', 'Casa A', '60160-130', '-9621021', '203255', true, current_timestamp, current_timestamp, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1);

INSERT INTO	public.pessoa (id, codigo, nome, nome_social, nome_mae,	data_nascimento, rg, cpf, nacionalidade, naturalidade, telefone1, tipo_telefone1, telefone2, tipo_telefone2, email, logradouro, numero, 
complemento, cep, latitude, longitude, ativo, data_cadastro, data_atualizacao, ocupacao_id, genero_id, faixaetaria_id, estadocivil_id, racacor_id, grauinstrucao_id, doencarara_id, deficiencia_id, lgbt_id, 
bairro_id) values (nextval('pessoa_id_seq'), '3b1493b9-1f42-4215-8fd7-7dc37f66c4db', 'Pessoa 10', 'Nome social pessoa 4', 'Mãe Pessoa 4', '1999-10-10', '433399223', '49518403082', 'Brasileiro', 'Sobral', '454564645', 'fixo', 
'99999999', 'Celular' , 'pessoa4@pessoa4.com.br', 'Rua Antonio augusto', '521', 'Casa A', '60160-130', '-9621021', '203255', true, current_timestamp, current_timestamp, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1);

--instituicao
INSERT INTO public.instituicao (id, codigo, nome, email, hora_atendimento_inicio, hora_atendimento_fim, dias_atendimento, telefone1, telefone2, logradouro, numero, complemento, cep, latitude, longitude,
ativo, data_cadastro, data_atualizacao, tipo_instituicao_id, tema_id, bairro_id ) values (nextval('instituicao_id_seq'), '5d1d8e54-22a5-49ea-85b5-e8792824768e', 'Instituição 1', 'instituicao1@instituicao1.com.br',
current_timestamp, current_timestamp, 'Dias Úteis', '3333333', '222222222', 'Rua João da Silva', '222', ' ', '61809-180', '-421542', '652144', true, current_timestamp, current_timestamp, 1, 1, 1);

INSERT INTO public.instituicao (id, codigo, nome, email, hora_atendimento_inicio, hora_atendimento_fim, dias_atendimento, telefone1, telefone2, logradouro, numero, complemento, cep, latitude, longitude,
ativo, data_cadastro, data_atualizacao, tipo_instituicao_id, tema_id, bairro_id ) values (nextval('instituicao_id_seq'), 'f031c9fa-7688-4a63-8f53-271feac6decb', 'Instituição 2', 'instituicao2@instituicao2.com.br',
current_timestamp, current_timestamp, 'Dias Úteis', '3333333', '222222222', 'Rua João da Silva', '222', ' ', '61809-180', '-421542', '652144', true, current_timestamp, current_timestamp, 1, 1, 1);

INSERT INTO public.instituicao (id, codigo, nome, email, hora_atendimento_inicio, hora_atendimento_fim, dias_atendimento, telefone1, telefone2, logradouro, numero, complemento, cep, latitude, longitude,
ativo, data_cadastro, data_atualizacao, tipo_instituicao_id, tema_id, bairro_id ) values (nextval('instituicao_id_seq'), '60a63d0b-1068-4d6b-905b-8c88addd1ddf', 'Instituição 3', 'instituicao3@instituicao3.com.br',
current_timestamp, current_timestamp, 'Dias Úteis', '3333333', '222222222', 'Rua João da Silva', '222', ' ', '61809-180', '-421542', '652144', true, current_timestamp, current_timestamp, 1, 1, 1);

--agente
INSERT INTO public.agente (id, codigo, nome, cargo, email, telefone1, telefone2, ativo, instituicao_id, data_cadastro, data_atualizacao) VALUES (nextval('agente_id_seq'), '1379de78-0ea7-466c-a347-842fbd514341', 'ANTONIO DA SILVA',
 'estágio', 'antonio@antonio.com.be', '(11) 11111-1111', '(11) 11111-1111', true, 1, current_timestamp, current_timestamp);
INSERT INTO public.agente (id, codigo, nome, cargo, email, telefone1, telefone2, ativo, instituicao_id, data_cadastro, data_atualizacao) VALUES (nextval('agente_id_seq'), '1a241f7e-31c1-4178-8f87-fa0b7d099285', 'MARIA DO CARMO',
 'estágio', 'maria@maria.com.be', '(11) 11111-1111', '(11) 11111-1111', true, 1, current_timestamp, current_timestamp);
 INSERT INTO public.agente (id, codigo, nome, cargo, email, telefone1, telefone2, ativo, instituicao_id, data_cadastro, data_atualizacao) VALUES (nextval('agente_id_seq'), '809462b3-0d03-4631-b4c3-88e496a480fd', 'FERNANDO COSTA',
 'estágio', 'fernando@fernando.com.be', '(11) 11111-1111', '(11) 11111-1111', true, 1, current_timestamp, current_timestamp);

--denuncia
 INSERT INTO public.denuncia(id, codigo, protocolo, protocolo_externo, descricao, sigilo, prazo_alterado, data_ocorrencia, data_limite, observacao, logradouro, numero, complemento, cep, latitude, longitude, 
 ativo, data_cadastro, data_atualizacao, ano,  mes, dia, dado_externo, status_id, frequencia_id, tema_id, tipoviolacao_id, subtipoviolacao_id, criticidade_id, bairro_id, canal_id, arquivada, justificativa) 
 VALUES (nextval('denuncia_id_seq'), '7b8c8b3a-3467-46ed-a6b6-7fba95ca9648', '2021021800001', NULL, 'Denúncia 1', TRUE, FALSE, NULL, NULL, 'observação', 'Rua Antonio augusto', '521', '', '60740-000', '-9621021', '203255', TRUE, 
 current_timestamp, current_timestamp, 2021, 2, 18, NULL, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL);

 INSERT INTO public.denuncia(id, codigo, protocolo, protocolo_externo, descricao, sigilo, prazo_alterado, data_ocorrencia, data_limite, observacao, logradouro, numero, complemento, cep, latitude, longitude, 
 ativo, data_cadastro, data_atualizacao, ano,  mes, dia, dado_externo, status_id, frequencia_id, tema_id, tipoviolacao_id, subtipoviolacao_id, criticidade_id, bairro_id, canal_id, arquivada, justificativa) 
 VALUES (nextval('denuncia_id_seq'), 'fc7a37f4-1887-49d2-a56f-4721cf8b70af', '2021021800002', NULL, 'Denúncia 2', TRUE, FALSE, NULL, NULL, 'observação', 'Rua Antonio augusto', '521', '', '60740-000', '-9621021', '203255', TRUE, 
 current_timestamp, current_timestamp, 2021, 2, 18, NULL, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL);

 INSERT INTO public.denuncia(id, codigo, protocolo, protocolo_externo, descricao, sigilo, prazo_alterado, data_ocorrencia, data_limite, observacao, logradouro, numero, complemento, cep, latitude, longitude, 
 ativo, data_cadastro, data_atualizacao, ano,  mes, dia, dado_externo, status_id, frequencia_id, tema_id, tipoviolacao_id, subtipoviolacao_id, criticidade_id, bairro_id, canal_id, arquivada, justificativa) 
 VALUES (nextval('denuncia_id_seq'), '37a7e9af-b84f-4c46-b2f9-e54411041e11', '2021021800003', NULL, 'Denúncia 3', TRUE, FALSE, NULL, NULL, 'observação', 'Rua Antonio augusto', '521', '', '60740-000', '-9621021', '203255', TRUE, 
 current_timestamp, current_timestamp, 2021, 2, 18, NULL, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL);

 INSERT INTO public.denuncia(id, codigo, protocolo, protocolo_externo, descricao, sigilo, prazo_alterado, data_ocorrencia, data_limite, observacao, logradouro, numero, complemento, cep, latitude, longitude, 
 ativo, data_cadastro, data_atualizacao, ano,  mes, dia, dado_externo, status_id, frequencia_id, tema_id, tipoviolacao_id, subtipoviolacao_id, criticidade_id, bairro_id, canal_id, arquivada, justificativa) 
 VALUES (nextval('denuncia_id_seq'), 'eecb3d4e-f2e2-44c2-9311-2b6d5a4c4377', '2021021800004', NULL, 'Denúncia 4', TRUE, FALSE, NULL, NULL, 'observação', 'Rua Antonio augusto', '521', '', '60740-000', '-9621021', '203255', TRUE, 
 current_timestamp, current_timestamp, 2021, 2, 18, NULL, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL);

 INSERT INTO public.denuncia(id, codigo, protocolo, protocolo_externo, descricao, sigilo, prazo_alterado, data_ocorrencia, data_limite, observacao, logradouro, numero, complemento, cep, latitude, longitude, 
 ativo, data_cadastro, data_atualizacao, ano,  mes, dia, dado_externo, status_id, frequencia_id, tema_id, tipoviolacao_id, subtipoviolacao_id, criticidade_id, bairro_id, canal_id, arquivada, justificativa) 
 VALUES (nextval('denuncia_id_seq'), '351fd5dc-6d72-4ae0-b031-893968951dc2', '2021021800005', NULL, 'Denúncia 5', TRUE, FALSE, NULL, NULL, 'observação', 'Rua Antonio augusto', '521', '', '60740-000', '-9621021', '203255', TRUE, 
 current_timestamp, current_timestamp, 2021, 2, 18, NULL, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL);
 
  INSERT INTO public.denuncia(id, codigo, protocolo, protocolo_externo, descricao, sigilo, prazo_alterado, data_ocorrencia, data_limite, observacao, logradouro, numero, complemento, cep, latitude, longitude, 
 ativo, data_cadastro, data_atualizacao, ano,  mes, dia, dado_externo, status_id, frequencia_id, tema_id, tipoviolacao_id, subtipoviolacao_id, criticidade_id, bairro_id, canal_id, arquivada, justificativa) 
 VALUES (nextval('denuncia_id_seq'), '314a813c-1547-482c-855f-e2bd801470cf', '2021021800005', NULL, 'Denúncia 6', TRUE, FALSE, NULL, NULL, 'observação', 'Rua Antonio augusto', '521', '', '60740-000', '-9621021', '203255', TRUE, 
 current_timestamp, current_timestamp, 2021, 2, 18, NULL, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL);
 
  INSERT INTO public.denuncia(id, codigo, protocolo, protocolo_externo, descricao, sigilo, prazo_alterado, data_ocorrencia, data_limite, observacao, logradouro, numero, complemento, cep, latitude, longitude, 
 ativo, data_cadastro, data_atualizacao, ano,  mes, dia, dado_externo, status_id, frequencia_id, tema_id, tipoviolacao_id, subtipoviolacao_id, criticidade_id, bairro_id, canal_id, arquivada, justificativa) 
 VALUES (nextval('denuncia_id_seq'), '8891094b-c434-4f46-9a79-bf9f66217456', '2021021800005', NULL, 'Denúncia 7', TRUE, FALSE, NULL, NULL, 'observação', 'Rua Antonio augusto', '521', '', '60740-000', '-9621021', '203255', TRUE, 
 current_timestamp, current_timestamp, 2021, 2, 18, NULL, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL);
 
  INSERT INTO public.denuncia(id, codigo, protocolo, protocolo_externo, descricao, sigilo, prazo_alterado, data_ocorrencia, data_limite, observacao, logradouro, numero, complemento, cep, latitude, longitude, 
 ativo, data_cadastro, data_atualizacao, ano,  mes, dia, dado_externo, status_id, frequencia_id, tema_id, tipoviolacao_id, subtipoviolacao_id, criticidade_id, bairro_id, canal_id, arquivada, justificativa) 
 VALUES (nextval('denuncia_id_seq'), '76b1ad75-c6b7-4873-bfe1-577f99ede59f', '2021021800005', NULL, 'Denúncia 8', TRUE, FALSE, NULL, NULL, 'observação', 'Rua Antonio augusto', '521', '', '60740-000', '-9621021', '203255', TRUE, 
 current_timestamp, current_timestamp, 2021, 2, 18, NULL, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL);
 
   INSERT INTO public.denuncia(id, codigo, protocolo, protocolo_externo, descricao, sigilo, prazo_alterado, data_ocorrencia, data_limite, observacao, logradouro, numero, complemento, cep, latitude, longitude, 
 ativo, data_cadastro, data_atualizacao, ano,  mes, dia, dado_externo, status_id, frequencia_id, tema_id, tipoviolacao_id, subtipoviolacao_id, criticidade_id, bairro_id, canal_id, arquivada, justificativa) 
 VALUES (nextval('denuncia_id_seq'), '8b12524f-6cf9-4ace-a78b-a0977f2ec244', '2021021800005', NULL, 'Denúncia 9', TRUE, FALSE, NULL, NULL, 'observação', 'Rua Antonio augusto', '521', '', '60740-000', '-9621021', '203255', TRUE, 
 current_timestamp, current_timestamp, 2021, 2, 18, NULL, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL);
 
   INSERT INTO public.denuncia(id, codigo, protocolo, protocolo_externo, descricao, sigilo, prazo_alterado, data_ocorrencia, data_limite, observacao, logradouro, numero, complemento, cep, latitude, longitude, 
 ativo, data_cadastro, data_atualizacao, ano,  mes, dia, dado_externo, status_id, frequencia_id, tema_id, tipoviolacao_id, subtipoviolacao_id, criticidade_id, bairro_id, canal_id, arquivada, justificativa) 
 VALUES (nextval('denuncia_id_seq'), 'e7fb7d75-5731-4a04-92d3-30881ce68d09', '2021021800005', NULL, 'Denúncia 10', TRUE, FALSE, NULL, NULL, 'observação', 'Rua Antonio augusto', '521', '', '60740-000', '-9621021', '203255', TRUE, 
 current_timestamp, current_timestamp, 2021, 2, 18, NULL, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL);
 
   INSERT INTO public.denuncia(id, codigo, protocolo, protocolo_externo, descricao, sigilo, prazo_alterado, data_ocorrencia, data_limite, observacao, logradouro, numero, complemento, cep, latitude, longitude, 
 ativo, data_cadastro, data_atualizacao, ano,  mes, dia, dado_externo, status_id, frequencia_id, tema_id, tipoviolacao_id, subtipoviolacao_id, criticidade_id, bairro_id, canal_id, arquivada, justificativa) 
 VALUES (nextval('denuncia_id_seq'), '9d46e2cd-ee02-4c28-8198-8e1f12e8bd1b', '2021021800005', NULL, 'Denúncia 11', TRUE, FALSE, NULL, NULL, 'observação', 'Rua Antonio augusto', '521', '', '60740-000', '-9621021', '203255', TRUE, 
 current_timestamp, current_timestamp, 2021, 2, 18, NULL, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL);

-- Usuários Teste
INSERT INTO usuario (id, codigo, nome, cpf, email, senha, data_cadastro, data_atualizacao, instituicao_id) values
(1, 'be10d120-b990-4914-807d-40a27c6fbf3b', 'ADMINISTRADOR', '73871943002', 'sps@sps.ce.gov.br', '$2y$12$CklwQpzb2s9PCYyWjxMuLO40Fbq4eC.TImDmbonloyKUp/5K7crJa', current_timestamp, current_timestamp, 1);
INSERT INTO usuario (id, codigo, nome, cpf, email, senha, data_cadastro, data_atualizacao, instituicao_id) values
(2, '58a4aa3d-54f0-4131-ac73-e0b778fa7918', 'SPS', '47205403090', 'sps@sps.ce.gov.br', '$2y$12$CklwQpzb2s9PCYyWjxMuLO40Fbq4eC.TImDmbonloyKUp/5K7crJa', current_timestamp, current_timestamp, 1);
INSERT INTO usuario (id, codigo, nome, cpf, email, senha, data_cadastro, data_atualizacao, instituicao_id) values
(3, '1658997c-4fc0-4256-8fa9-e51a867ad4f5', 'INSTITUICAO', '69498530092', 'instituicao@sps.ce.gov.br', '$2y$12$CklwQpzb2s9PCYyWjxMuLO40Fbq4eC.TImDmbonloyKUp/5K7crJa', current_timestamp, current_timestamp, 1);
INSERT INTO usuario (id, codigo, nome, cpf, email, senha, data_cadastro, data_atualizacao, instituicao_id) values
(4, '40ce4423-25f8-4c0f-bb7b-54f5cb1ec539', 'MMDH', '94462293088', 'mmdh@mmdh.ce.gov.br', '$2y$12$CklwQpzb2s9PCYyWjxMuLO40Fbq4eC.TImDmbonloyKUp/5K7crJa', current_timestamp, current_timestamp, 1);

INSERT INTO grupo (id, codigo, nome, data_cadastro, data_atualizacao) values (1, '81dae1de-ae9b-4363-900c-32421fb4a950', 'ADMINISTRADOR', current_timestamp, current_timestamp);
INSERT INTO grupo (id, codigo, nome, data_cadastro, data_atualizacao) values (2, 'd321c10b-4a56-4a44-b533-410211f3468c', 'SPS', current_timestamp, current_timestamp);
INSERT INTO grupo (id, codigo, nome, data_cadastro, data_atualizacao) values (3, 'db93b267-a0a5-471c-ba34-810027a96132', 'INSTITUICAO', current_timestamp, current_timestamp);
INSERT INTO grupo (id, codigo, nome, data_cadastro, data_atualizacao) values (4, 'd4faa94a-c8a1-4be2-81d8-d95792486da5', 'MMDH', current_timestamp, current_timestamp);

INSERT INTO permissao (id, codigo, nome, descricao, data_cadastro, data_atualizacao) values (1, '23d92115-cf29-41b7-93f2-8588bb5a6957', 'ADMINISTRADOR', 'Permite acessar tudo', current_timestamp, current_timestamp);
INSERT INTO permissao (id, codigo, nome, descricao, data_cadastro, data_atualizacao) values (2, '8c0e94af-3e86-4416-8d65-be553851cace', 'SPS', 'Permite acessar dados relacionado a SPS', current_timestamp, current_timestamp);
INSERT INTO permissao (id, codigo, nome, descricao, data_cadastro, data_atualizacao) values (3, 'd8e210da-c6f1-47dd-b970-0607cb956909', 'INSTITUICAO', 'Permite acessar dados relacionado a instituição', current_timestamp, current_timestamp);
INSERT INTO permissao (id, codigo, nome, descricao, data_cadastro, data_atualizacao) values (4, '0b7d246b-d87e-4fce-b05f-031a8f618cea', 'MMDH', 'Permite acessar recursos relacionados a integração com o ETL', current_timestamp, current_timestamp);

INSERT INTO grupo_permissao (grupo_id, permissao_id) values (1, 1);
INSERT INTO grupo_permissao (grupo_id, permissao_id) values (1, 2);
INSERT INTO grupo_permissao (grupo_id, permissao_id) values (1, 3);
INSERT INTO grupo_permissao (grupo_id, permissao_id) values (1, 4);
INSERT INTO grupo_permissao (grupo_id, permissao_id) values (2, 2);
INSERT INTO grupo_permissao (grupo_id, permissao_id) values (3, 3);
INSERT INTO grupo_permissao (grupo_id, permissao_id) values (4, 4);

INSERT INTO usuario_grupo (usuario_id, grupo_id) values (1, 1);
INSERT INTO usuario_grupo (usuario_id, grupo_id) values (2, 2);
INSERT INTO usuario_grupo (usuario_id, grupo_id) values (3, 3);
INSERT INTO usuario_grupo (usuario_id, grupo_id) values (4, 4);

-- Usuários teste observatório
INSERT INTO usuario (id, nome, cpf, email, senha, data_cadastro, data_atualizacao, instituicao_id) values
(5, ' Francisco Humberto Alencar Bezerra', '59367652453', 'humberto.bezerra@sps.ce.gov.br', '$2y$12$CklwQpzb2s9PCYyWjxMuLO40Fbq4eC.TImDmbonloyKUp/5K7crJa', current_timestamp, current_timestamp, 1);
INSERT INTO usuario (id, nome, cpf, email, senha, data_cadastro, data_atualizacao, instituicao_id) values
(6, 'Claudiene de Queiroz Sousa', '96615486334', 'diene.queiroz@sps.ce.gov.br', '$2y$12$CklwQpzb2s9PCYyWjxMuLO40Fbq4eC.TImDmbonloyKUp/5K7crJa', current_timestamp, current_timestamp, 1);
INSERT INTO usuario (id, nome, cpf, email, senha, data_cadastro, data_atualizacao, instituicao_id) values
(7, 'Kécia Guilherme Pereira Rêgo', '00653474393', 'Kecia.guilherme@sps.ce.gov.br', '$2y$12$CklwQpzb2s9PCYyWjxMuLO40Fbq4eC.TImDmbonloyKUp/5K7crJa', current_timestamp, current_timestamp, 1);
INSERT INTO usuario (id, nome, cpf, email, senha, data_cadastro, data_atualizacao, instituicao_id) values
(8, 'Fiona Moraes Botelho', '70915610310', 'fiona.botelho@sps.ce.gov.br', '$2y$12$CklwQpzb2s9PCYyWjxMuLO40Fbq4eC.TImDmbonloyKUp/5K7crJa', current_timestamp, current_timestamp, 1);
INSERT INTO usuario (id, nome, cpf, email, senha, data_cadastro, data_atualizacao, instituicao_id) values
(9, 'Katarine Medeiros Dias', '09731769463', 'katarine.dias@sps.ce.gov.br', '$2y$12$CklwQpzb2s9PCYyWjxMuLO40Fbq4eC.TImDmbonloyKUp/5K7crJa', current_timestamp, current_timestamp, 1);
INSERT INTO usuario (id, nome, cpf, email, senha, data_cadastro, data_atualizacao, instituicao_id) values
(10, 'Marcele Pinho de Arruda Mapurunga', '61511960310', 'marcele.arruda@sps.ce.gov.br', '$2y$12$CklwQpzb2s9PCYyWjxMuLO40Fbq4eC.TImDmbonloyKUp/5K7crJa', current_timestamp, current_timestamp, 1);
INSERT INTO usuario (id, nome, cpf, email, senha, data_cadastro, data_atualizacao, instituicao_id) values
(11, 'Sandro Camilo Carvalho', '57535868304', 'sandro.carvalho@sps.ce.gov.br', '$2y$12$CklwQpzb2s9PCYyWjxMuLO40Fbq4eC.TImDmbonloyKUp/5K7crJa', current_timestamp, current_timestamp, 1);

INSERT INTO usuario_grupo (usuario_id, grupo_id) values (5, 2);
INSERT INTO usuario_grupo (usuario_id, grupo_id) values (6, 2);
INSERT INTO usuario_grupo (usuario_id, grupo_id) values (7, 2);
INSERT INTO usuario_grupo (usuario_id, grupo_id) values (8, 2);
INSERT INTO usuario_grupo (usuario_id, grupo_id) values (9, 2);
INSERT INTO usuario_grupo (usuario_id, grupo_id) values (10, 2);
INSERT INTO usuario_grupo (usuario_id, grupo_id) values (11, 2);

ALTER SEQUENCE usuario_id_seq RESTART WITH 12;
ALTER SEQUENCE grupo_id_seq RESTART WITH 5;
ALTER SEQUENCE permissao_id_seq RESTART WITH 5;
