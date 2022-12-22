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

void setup() {

  Serial.begin(115200);
  while (!Serial);
  if (!modem.begin(EU868)) {
    Serial.println("Failed to start module");
    while (1) {}
  };

  if (!ENV.begin()) {
    Serial.println("Failed to initialize MKR ENV shield!");
    while (1);
  }

  int mode = 0;
  while (mode != 1) {
    Serial.println("Press 1 to connect");
    while (!Serial.available());
    mode = Serial.readStringUntil('\n').toInt();
  }

  int connected;
  if (mode == 1) {

    appEui = "2462ABFFFEB565E8";
    appKey = "E29900A47EEC4BFC31AA499D3CE0614C";
    appKey.trim();
    appEui.trim();
    connected = modem.joinOTAA(appEui, appKey);
  }

  if (!connected) {
    Serial.println("Something went wrong; are you indoor? Move near a window and retry");
    while (1) {}
  }

  if (! rtc.begin()) {
    Serial.println("Couldn't find RTC");
    Serial.flush();
    while (1) delay(10);
  }

  if (! rtc.initialized() || rtc.lostPower()) {
    Serial.println("RTC is NOT initialized, let's set the time!");
    rtc.adjust(DateTime(F(__DATE__), F(__TIME__)));
  }

  rtc.start();  
}

void loop() {

  DateTime now = rtc.now();

  if(now.unixtime() % 10 == 5){
    float temperature = ENV.readTemperature();
  float humidity    = ENV.readHumidity();
  float pressure    = ENV.readPressure();
  float illuminance = ENV.readIlluminance();
  float uva         = ENV.readUVA();
  float uvb         = ENV.readUVB();
  float uvIndex     = ENV.readUVIndex(); 

  int16_t temp = (int16_t)(temperature * 100);
  int16_t hum = (int16_t)(humidity * 100);
  int16_t pres = (int16_t)(pressure * 100);
  int16_t ill = (int16_t)(illuminance * 100);
  int16_t a = (int16_t)(uva * 100);
  int16_t b = (int16_t)(uvb * 100);
  int16_t index = (int16_t)(uvIndex * 100);

  Serial.print("Temperature = ");
  Serial.print(temperature);
  Serial.println(" °C");

  Serial.print("Humidity    = ");
  Serial.print(humidity);
  Serial.println(" %");

  Serial.print("Pressure    = ");
  Serial.print(pressure);
  Serial.println(" kPa");

  Serial.print("Illuminance = ");
  Serial.print(illuminance);
  Serial.println(" lx");

  Serial.print("UVA         = ");
  Serial.println(uva);

  Serial.print("UVB         = ");
  Serial.println(uvb);

  Serial.print("UV Index    = ");
  Serial.println(uvIndex);

  int err;
  modem.setPort(3);
  modem.beginPacket();
  modem.write(temp);
  modem.write(hum);
  modem.write(pres);
  modem.write(ill);
  modem.write(a);
  modem.write(b);
  modem.write(index);
  err = modem.endPacket(true);
  if (err > 0) {
    Serial.println("Message sent correctly!");
  } else {
    Serial.println("Error sending message :(");
  }
  Serial.println();
  }

  delay(1000);
}
