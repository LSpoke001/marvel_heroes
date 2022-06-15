
USE marvel_db;

CREATE TABLE marvel_db.images (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(100),
  url varchar(200),
  type varchar(20),
  size int,
  byte longblob,
  PRIMARY KEY (id)
);

CREATE TABLE marvel_db.gender (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(50),
  PRIMARY KEY (id)
);

CREATE TABLE marvel_db.heroes (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(50),
  description varchar(400),
  gender_id int,
  image_id int,
  PRIMARY KEY (id),
  FOREIGN KEY (gender_id) REFERENCES marvel_db.gender(id),
  FOREIGN KEY (image_id) REFERENCES marvel_db.images(id)
);
    
INSERT INTO marvel_db.gender (name)
VALUES
	('female'),
	('male'),
	('other');
	

