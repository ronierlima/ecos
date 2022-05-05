ALTER TABLE modelo
    ADD COLUMN IF NOT EXISTS privado boolean default false;

ALTER TABLE modelo_aud
    ADD COLUMN IF NOT EXISTS privado boolean default false;