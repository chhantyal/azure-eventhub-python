import json
import datetime

from jnius import autoclass

EventHub = autoclass('net.chhantyal.EventHub')

ehub = EventHub()
client = ehub.getClient()


def send():
    timestamp = datetime.datetime.now().isoformat()
    message = {
        'title': 'Hello from Python client',
        'timestamp': timestamp
    }
    ehub.sendEvent(json.dumps(message), client)
    print("Sent a msg at {0}".format(timestamp))
    

if __name__ == "__main__":
    send()
