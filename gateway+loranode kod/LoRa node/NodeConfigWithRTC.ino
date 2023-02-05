#include <MKRWAN.h>
#include <Arduino_MKRENV.h>
#include "RTClib.h"

RTC_PCF8523 rtc;
LoRaModem modem;
String appEui;
String appKey;
String devAddr;
String nwkSKey;
String appSKey;
bool my_status;
int PM25;
int PM10;

int pirPin = 5;
int prevStat = LOW;
int val = 0;
int counter = 0;

void setup() {

  pinMode(pirPin, INPUT);
  Serial1.begin(9600);
  delay(5000);
  //while (!Serial);
  if (!modem.begin(EU868)) {
    while (1) {}
  };

  if (!ENV.begin()) {
    while (1);
  }

  int mode = 1;
  // while (mode != 1) {
  //   Serial.println("Press 1 to connect");
  //   while (!Serial.available());
  //   mode = Serial.readStringUntil('\n').toInt();
  // }

  int connected;
  if (mode == 1) {

    appEui = "2462ABFFFEB565E8"; //ovo promijenit na eui od svog gatewaya
    appKey = "E29900A47EEC4BFC31AA499D3CE0614C"; //ovo promijenit na svoj appkey sa things networka
    appKey.trim();
    appEui.trim();
    connected = modem.joinOTAA(appEui, appKey);
  }

  if (!connected) {
    while (1) {}
  }

  my_status = stop_autosend(); 
  // Serial.print("Stop autosend status is ");
  // Serial.println(my_status, BIN);
  // Serial.println(" ");
  delay(500);
  
  my_status = start_measurement(); 
  // Serial.print("Start measurement status is ");
  // Serial.println(my_status, BIN);
  // Serial.println(" ");
  delay(500);

  if (! rtc.begin()) {
    while (1) delay(10);
  }

  if (! rtc.initialized() || rtc.lostPower()) {
    rtc.adjust(DateTime(F(__DATE__), F(__TIME__)));
  }

  rtc.start();  
  delay(5000);
}

void loop() {

  DateTime now = rtc.now();

  val = digitalRead(pirPin);

  if(val == HIGH){
    if(prevStat == LOW){
      prevStat = HIGH;
      counter++;
    }
  }else{
    if(prevStat == HIGH){
      prevStat = LOW;
    }
  }

  if(now.unixtime() % 15 == 5){
  float temperature = ENV.readTemperature();
  float humidity    = ENV.readHumidity();
  float pressure    = ENV.readPressure();

  my_status = read_measurement(); 
  // Serial.print("Stop autosend status is ");
  // Serial.println(my_status, BIN);
  // Serial.println(" ");
  delay(500);

  int16_t temp = (int16_t)(temperature * 100);
  int16_t hum = (int16_t)(humidity * 100);
  int16_t pres = (int16_t)(pressure * 100);
  int16_t pm25 = (int16_t) PM25;
  int16_t pm10 = (int16_t) PM10;
  int16_t cnt = (int16_t) counter;

  // Serial.print("Temperature = ");
  // Serial.print(temperature);
  // Serial.println(" °C");

  // Serial.print("Humidity    = ");
  // Serial.print(humidity);
  // Serial.println(" %");

  // Serial.print("Pressure    = ");
  // Serial.print(pressure);
  // Serial.println(" kPa");

  // Serial.print("Motions detected    = ");
  // Serial.println(counter);

  // Serial.print("PM2.5 concentration    = ");
  // Serial.println(pm25);

  // Serial.print("PM10 concentration    = ");
  // Serial.println(pm10);

  counter = 0;

  int err;
  modem.setPort(3);
  modem.beginPacket();
  modem.write(temp);
  modem.write(hum);
  modem.write(pres);
  modem.write(cnt);
  modem.write(pm25);
  modem.write(pm10);
  err = modem.endPacket(true);
  if (err > 0) {
  } else {
  }
  delay(1000);
  }

}

bool start_measurement(void)
{
  byte start_measurement[] = {0x68, 0x01, 0x01, 0x96 };
  Serial1.write(start_measurement, sizeof(start_measurement));
  while(Serial1.available() < 2);
  char read1 = Serial1.read();
  char read2 = Serial1.read();
  if ((read1 == 0xA5) && (read2 == 0xA5)){
    return 1;
  }
  else if ((read1 == 0x96) && (read2 == 0x96))
  {
    return 0;
  }
  else return 0;
}

bool stop_measurement(void)
{
  byte stop_measurement[] = {0x68, 0x01, 0x02, 0x95 };
  Serial1.write(stop_measurement, sizeof(stop_measurement));
  while(Serial1.available() < 2);
  char read1 = Serial1.read();
  char read2 = Serial1.read();
  if ((read1 == 0xA5) && (read2 == 0xA5)){
    return 1;
  }
  else if ((read1 == 0x96) && (read2 == 0x96))
  {
    return 0;
  }
  else return 0;
}

bool read_measurement (void)
{
  byte read_particle[] = {0x68, 0x01, 0x04, 0x93 };
  Serial1.write(read_particle, sizeof(read_particle));
  while(Serial1.available() < 1);
  byte HEAD = Serial1.read();
  while(Serial1.available() < 1);
  byte LEN = Serial1.read();
  
  if ((HEAD == 0x96) && (LEN == 0x96)){
    return 0;
  }
  else if ((HEAD == 0x40) && (LEN == 0x05))
  {
    while(Serial1.available() < 1);
    byte COMD = Serial1.read();
    while(Serial1.available() < 1);
    byte DF1 = Serial1.read(); 
    while(Serial1.available() < 1);
    byte DF2 = Serial1.read();     
    while(Serial1.available() < 1);
    byte DF3 = Serial1.read();   
    while(Serial1.available() < 1);
    byte DF4 = Serial1.read();     
    while(Serial1.available() < 1);
    byte CS = Serial1.read();      
    // Now we shall verify the checksum
    if (((0x10000 - HEAD - LEN - COMD - DF1 - DF2 - DF3 - DF4) % 0xFF) != CS){
      return 0;
    }
    else
    {
      PM25 = DF1 * 256 + DF2;
      PM10 = DF3 * 256 + DF4;
      return 1;
    }
  }
}

bool stop_autosend(void)
{
  byte stop_autosend[] = {0x68, 0x01, 0x20, 0x77 };
  Serial1.write(stop_autosend, sizeof(stop_autosend));
  while(Serial1.available() < 2);
  char read1 = Serial1.read();
  char read2 = Serial1.read();
  if ((read1 == 0xA5) && (read2 == 0xA5)){
    return 1;
  }
  else if ((read1 == 0x96) && (read2 == 0x96))
  {
    return 0;
  }
  else return 0;
}

bool start_autosend(void)
{
  byte start_autosend[] = {0x68, 0x01, 0x40, 0x57 };
  Serial1.write(start_autosend, sizeof(start_autosend));
  while(Serial1.available() < 2);
  char read1 = Serial1.read();
  char read2 = Serial1.read();
  if ((read1 == 0xA5) && (read2 == 0xA5)){
    return 1;
  }
  else if ((read1 == 0x96) && (read2 == 0x96))
  {
    return 0;
  }
  else return 0;
}

