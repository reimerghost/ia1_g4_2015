import RPi.GPIO as GPIO
from time import sleep
#Inicializando GPIO a modo BCM
GPIO.setmode(GPIO.BCM)

#Inicializando pines
GPIO.setup(17, GPIO.OUT)
GPIO.setup(18, GPIO.OUT)
GPIO.setup(22, GPIO.OUT)
GPIO.setup(23, GPIO.OUT)

### -- METODOS DE MOVIMIENTO -- ###
def irAdelante():
	GPIO.output(17, True)
	GPIO.output(18, False)
	GPIO.output(23, False)
	GPIO.output(22, True)

def irAtras():
        GPIO.output(17, False)
        GPIO.output(18, True)
        GPIO.output(23, True)
        GPIO.output(22, False)

def irIzquierda():
        GPIO.output(17, False)
        GPIO.output(18, False)
        GPIO.output(23, False)
        GPIO.output(22, True)

def irDerecha():
        GPIO.output(17, True)
        GPIO.output(18, False)
        GPIO.output(23, False)
        GPIO.output(22, False)

def parar():
	GPIO.output(17, False)
	GPIO.output(18, False)
	GPIO.output(23, False)
	GPIO.output(22, False)
#18 ya
#17 ya
#22
#23

#def __init__(self):
#irAdelante()
irAtras()
#irDerecha()
#irIzquierda()
sleep(10)
parar()
