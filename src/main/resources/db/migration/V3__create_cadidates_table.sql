CREATE TABLE IF NOT EXISTS `candidates` (
    `id` BINARY(16) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `description` TEXT NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `linkedin` VARCHAR(255) NOT NULL,
    `github` VARCHAR(255) NOT NULL,

    `id_text` VARCHAR(36) GENERATED ALWAYS AS
    (INSERT(
        INSERT(
        INSERT(
            INSERT(hex(`id`),9,0,'-'),
            14,0,'-'),
        19,0,'-'),
        24,0,'-')
    ) VIRTUAL,

    CONSTRAINT `candidates_pk` PRIMARY KEY (`id`),
    CONSTRAINT `candidates_email_unique` UNIQUE (`email`),
    CONSTRAINT `candidates_linkedin_unique` UNIQUE (`linkedin`),
    CONSTRAINT `candidates_github_unique` UNIQUE (`github`)
);