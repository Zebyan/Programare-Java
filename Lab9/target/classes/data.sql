CREATE DATABASE IF NOT EXISTS masinaDB;
USE masinaDB;

CREATE TABLE IF NOT EXISTS masini (
                                      nr_inmatriculare VARCHAR(10) PRIMARY KEY,
                                      marca VARCHAR(50),
                                      an_fabricatie INT,
                                      culoare VARCHAR(20),
                                      km INT
);