# azure-eventhub-python

Send messages to Azure EventHub (&amp; ServiceBus) from Python (using Java client, Proton-J, PyJNIus)

You can use Azure SDK for Python to send messages using HTTPS.
However, there is no official Python client which uses AMQP protocol.
It also doesn't work with Qpid Proton Python.

That's why I am using Java client to send messages EventHub from Python :)

It uses [PyJNIus](https://github.com/kivy/pyjnius) to call Java.

## Install

First install Java & follow these steps.

Compile Java code to single jar file (or use one from target dir)
* `mvn clean compile assembly:single`

Install Python dependencies:

* `export JAVA_HOME=/path/to/java/Home`
* `pip install -r requirements.txt`
* `export CLASSPATH='/path/to/sbus-1.0-jar-with-dependencies.jar'`

Replace following env vars with EventHub connection variables:

* `export EVENTHUB_NAMESPACE='namespace' EVENTHUB_NAME='testhub' SAS_KEY_NAME='sas_name' SAS_KEY='key'`

## Try Send Example

* `python sender.py`
