CREATE TABLE Sensor
(
  sensorId VARCHAR(20) NOT NULL,
  sensorName VARCHAR(35) NOT NULL,
  PRIMARY KEY (sensorId)
);

CREATE TABLE Measurement
(
  id SERIAL NOT NULL,
  time timestamp NOT NULL,
  humidity FLOAT,
  illuminance FLOAT,
  pressure FLOAT,
  temperature FLOAT,
  UVA FLOAT,
  UVB FLOAT,
  UVIndex FLOAT,
  location VARCHAR(40),
  sensorId VARCHAR(20),
  PRIMARY KEY (id),
  FOREIGN KEY (sensorId) REFERENCES Sensor(sensorId)
);


-- insert sensor
insert into sensor(sensorId, sensorName)
values ('eui-a8610a32373e7208', 'lora-test-senzor')

-- insert test measurements
insert into measurement(time, humidity, illuminance, pressure, temperature, uva, uvb, uvindex, sensorid)
values ('2022-12-20T14:56:56.182066896Z', 57.39, 10.32, 101.43, 17.58, 6, 0, 0, 'eui-a8610a32373e7208')