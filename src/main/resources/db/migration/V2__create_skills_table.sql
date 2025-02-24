CREATE TABLE IF NOT EXISTS `skills` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,

    CONSTRAINT `skills_pk` PRIMARY KEY (`id`),
    CONSTRAINT `skills_name_unique` UNIQUE (`name`)
);