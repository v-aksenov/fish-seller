DROP TABLE IF EXISTS FISHES;

CREATE TABLE FISHES (
  id IDENTITY AUTO_INCREMENT PRIMARY KEY,
  price DECIMAL NOT NULL,
  title VARCHAR(250) NOT NULL
  description VARCHAR(250) NOT NULL
);