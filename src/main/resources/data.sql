DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(190) NOT NULL,
    email VARCHAR(190) NOT NULL,
    age INT NOT NULL
);

INSERT INTO users (name, email, age) VALUES
('John Doe', 'john@example.com', 28),
('Mary Sue', 'mary@example.com', 62),
('Smith Smith', 'smith@example.com', 12),
('Carel Kruger', 'carel@example.com', 35),
('Klippies Coetzee', 'klippies@example.com', 24);
