DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  zipcode VARCHAR(250) DEFAULT NULL,
  city VARCHAR(25) DEFAULT NULL,
  color VARCHAR(25) DEFAULT NULL
);
