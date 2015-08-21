import speech_recognition as sr
def callback(recognizer, audio):                          # this is called from the background thread
    try:
        print("Has dicho " + recognizer.recognize(audio))  # received audio data, now need to recognize it
    except LookupError:
        print("Oops! No entendi eso")
r = sr.Recognizer()
m = sr.Microphone()
with m as source: r.adjust_for_ambient_noise(source)      # we only need to calibrate once, before we start listening
stop_listening = r.listen_in_background(m, callback)

import time
for _ in range(50): time.sleep(0.1)                       # we're still listening even though the main thread is blocked - loop runs for about 5 seconds
stop_listening()                                          # call the stop function to stop the background thread
while True: time.sleep(0.1)                               # the background thread stops soon after we call the stop function
