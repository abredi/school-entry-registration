DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS MANUFACTURER;

CREATE TABLE PRODUCT (
                         id VARCHAR(50)  PRIMARY KEY,
                         title VARCHAR(250) NOT NULL,
                         description VARCHAR(250) NOT NULL,
                         rating VARCHAR(250) ,
                         category VARCHAR(250) ,
                         manufacturer_id VARCHAR(50)
);

CREATE TABLE MANUFACTURER (
                              id VARCHAR(50)  PRIMARY KEY,
                              name VARCHAR(50) NOT NULL,
                              address VARCHAR(50) NOT NULL
);

