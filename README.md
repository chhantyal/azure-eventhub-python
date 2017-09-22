# azure-eventhub-python

Send messages to Azure EventHub (&amp; ServiceBus) from Python (using Java client, Proton-J, PyJNIus)


## Install

First install Java & follow these steps.

Compile Java code to single jar file (or use one from target dir)
* `mvn clean compile assembly:single`

Install Python dependencies:

* `pip install -r requirements.txt`
* `export JAVA_HOME=/path/to/java/Home`
* `export CLASSPATH='/path/to/sbus-1.0-jar-with-dependencies.jar'`

Replace following env vars with EventHub connection variables:

* `export EVENTHUB_NAMESPACE='namespace' EVENTHUB_NAME='testhub' SAS_KEY_NAME='sas_name' SAS_KEY='key'`

## Try Send Example

* `python sender.py`
