CREATE TABLE Measurement
(
  id SERIAL NOT NULL,
  time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  humidity FLOAT,
  illuminance FLOAT,
  pressure FLOAT,
  temperature FLOAT,
  uva FLOAT,
  uvb FLOAT,
  uvindex FLOAT,
  location VARCHAR(40),
  sensorid VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);