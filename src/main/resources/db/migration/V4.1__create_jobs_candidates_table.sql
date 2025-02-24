CREATE TABLE IF NOT EXISTS `jobs_candidates` (
    `job_id` binary(16) NOT NULL,
    `candidates_id` binary(16) NOT NULL,

    `job_id_text` VARCHAR(36) GENERATED ALWAYS AS
    (INSERT(
        INSERT(
        INSERT(
            INSERT(hex(`job_id`),9,0,'-'),
            14,0,'-'),
        19,0,'-'),
        24,0,'-')
    ) VIRTUAL,
    `candidates_id_text` VARCHAR(36) GENERATED ALWAYS AS
    (INSERT(
        INSERT(
        INSERT(
            INSERT(hex(`job_id`),9,0,'-'),
            14,0,'-'),
        19,0,'-'),
        24,0,'-')
    ) VIRTUAL,
    
    CONSTRAINT `jobs_candidates_pk` PRIMARY KEY (`job_id`, `candidates_id`),
    CONSTRAINT `jobs_candidates_fk_job_id` FOREIGN KEY (`job_id`) REFERENCES `jobs`(`id`),
    CONSTRAINT `jobs_candidates_fk_candidates_id` FOREIGN KEY (`candidates_id`) REFERENCES `candidates`(`id`)
);