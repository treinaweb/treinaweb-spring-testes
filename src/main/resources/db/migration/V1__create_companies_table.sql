CREATE TABLE IF NOT EXISTS `companies` (
    `id` BINARY(16) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `website` VARCHAR(255) NOT NULL,
    `description` TEXT NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,

    `id_text` VARCHAR(36) GENERATED ALWAYS AS
    (INSERT(
        INSERT(
        INSERT(
            INSERT(hex(`id`),9,0,'-'),
            14,0,'-'),
        19,0,'-'),
        24,0,'-')
    ) VIRTUAL,

    CONSTRAINT `companies_pk` PRIMARY KEY (`id`),
    CONSTRAINT `companies_name_unique` UNIQUE (`name`),
    CONSTRAINT `companies_email_unique` UNIQUE (`email`)
);