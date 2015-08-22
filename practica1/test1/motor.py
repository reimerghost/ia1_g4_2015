
import RPi.GPIO as GPIO
from time import sleep
#Inicializando GPIO a modo BCM
GPIO.setmode(GPIO.BCM)

#Inicializando pines
GPIO.setup(17, GPIO.OUT)
GPIO.setup(18, GPIO.OUT)
GPIO.setup(22, GPIO.OUT)
GPIO.setup(23, GPIO.OUT)


#while 1:
GPIO.output(17, True)
GPIO.output(18, True)

GPIO.output(23, True)
GPIO.output(22, True)
#18 ya
#17 ya
#22
#23

