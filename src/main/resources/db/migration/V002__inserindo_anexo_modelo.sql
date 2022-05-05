ALTER TABLE modelo
    ADD COLUMN IF NOT EXISTS modelo_arquivo_id int8 default null;

ALTER TABLE modelo
    ADD CONSTRAINT modelo_arquivo_id_fk
        FOREIGN KEY (modelo_arquivo_id) REFERENCES anexo;

ALTER TABLE modelo_aud
    ADD COLUMN IF NOT EXISTS modelo_arquivo_id int8 default null;

ALTER TABLE modelo
    ADD COLUMN IF NOT EXISTS preview_id int8 default null;

ALTER TABLE modelo
    ADD CONSTRAINT modelo_preview_id_fk
        FOREIGN KEY (preview_id) REFERENCES anexo;

ALTER TABLE modelo_aud
    ADD COLUMN IF NOT EXISTS preview_id int8 default null;
