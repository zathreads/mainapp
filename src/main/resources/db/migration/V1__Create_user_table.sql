CREATE TABLE users(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(80) not null,
  email VARCHAR(80) not null,
  encryptedpassword TEXT not null,
  name VARCHAR(80),
  surname VARCHAR(80),
  avata_url TEXT
)