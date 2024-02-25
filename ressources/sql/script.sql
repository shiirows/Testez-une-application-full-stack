CREATE TABLE `test`.`TEACHERS` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `last_name` VARCHAR(40),
  `first_name` VARCHAR(40),
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE `test`.`SESSIONS` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(50),
  `description` VARCHAR(2000),
  `date` TIMESTAMP,
  `teacher_id` INT,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE `test`.`USERS` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `last_name` VARCHAR(40),
  `first_name` VARCHAR(40),
  `admin` BOOLEAN NOT NULL DEFAULT false,
  `email` VARCHAR(255),
  `password` VARCHAR(255),
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE `test`.`PARTICIPATE` (
  `user_id` INT, 
  `session_id` INT
);

ALTER TABLE `test`.`SESSIONS` ADD FOREIGN KEY (`teacher_id`) REFERENCES `test`.`TEACHERS` (`id`);
ALTER TABLE `test`.`PARTICIPATE` ADD FOREIGN KEY (`user_id`) REFERENCES `test`.`USERS` (`id`);
ALTER TABLE `test`.`PARTICIPATE` ADD FOREIGN KEY (`session_id`) REFERENCES `test`.`SESSIONS` (`id`);

INSERT INTO `test`.`TEACHERS` (first_name, last_name)
VALUES ('Margot', 'DELAHAYE'),
       ('Hélène', 'THIERCELIN');

INSERT INTO `test`.`USERS` (first_name, last_name, admin, email, password)
VALUES ('Admin', 'Admin', true, 'yoga@studio.com', '$2a$10$.Hsa/ZjUVaHqi0tp9xieMeewrnZxrZ5pQRzddUXE/WjDu2ZThe6Iq');
