import RPi.GPIO as GPIO
from time import sleep
GPIO.setmode(GPIO.BCM)
import RPi.GPIO as GPIO
GPIO.setup(18, GPIO.OUT)
while 1:
	GPIO.output(18, False)
	sleep(1)
	GPIO.output(18, True)
	sleep(1)
#18 ya
#17 ya
#22 
#23
