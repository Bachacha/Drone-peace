# Drone-peace

Groupe Data engineering

Emeric BERTIN
Hassan BACHACHA
Philipe CHEN



# Preliminary questions 

 
### 1) What technical/business constraints should the data storage component of the program architecture meet to fulfill the requirement described by the customer in paragraph «Statistics»? So what kind of component(s) (listed in the lecture) will the architecture need?  

As we are going to create a drone which aim to help government agency to make peace, the drone will be flying around the country, while collecting huge amount of information and data at the same time. Since we are going to collect a lot of data, store the data and transmit it to be used in order to make statistic and improve the Peaceland harmony, we need to be able to store it.  

To do so we decided to use a distributed storage technique, in fact the best solution for us is to use a NoSQL database which offer scalability, high availability and data modelling, it will allow us store huge amount of data and at the same time provide fast response time at real time. So, we are going to use NoSQL databases for this project, in fact It offer us we decide for a document-oriented database which is MongoDB.  

Now that we have found how to collect the huge amount of data. We need to work on the project architecture. 

Our project architecture will be divided in two part, Kafka and Spark which will be in charge of solving flight and drone monitoring problems as our devices will be sending regularly status report as data and mostly at the same time, especially as managing a few drones to many fleets of drones. so, we will have producers and consumers. So, we need an analysis program which will be able to dispatch incoming request for assistance to an agitated person and help him to recover peace, and another one which will write downs data records for drones in a file in the databases. 

Concerning the computing model, we will be using spark, as spark is the fastest big data engine for computing, compact and easy to use. And the language that we will we use is Scala because of its integration with Spark.     

  
### 2) What business constraint should the architecture meet to fulfill the requirement describe in the paragraph «Alert» 

We will need multiple streams and multiple programs who will handle different event. Per example, in case when a human needs assistance, the drone will be able to request an assistance and send data into a Kafka stream. 

### 3) What mistake(s) from Peaceland can explains the failed attempt?  

This is not difficult to receive huge amount of data but it’s better to know how works the data and how to manage them. One mistake must be when we receive a lot of data and it can have negative effect on performance. 

### 4) Peaceland has likely forgotten some technical information in the report sent by the drone. In the future this information could help Peaceland make its peacewatchers much more efficient. Which information ? 

To make the Peacewatchers more efficient we need to add the drone battery consumption which will allows us to take actions based on battery status would be useful, we also can add the disk space, the temperature and its speed that information could provide a better control over the drone. 

# Subject

Peaceland is a country that takes great pride in its effort to bring peace, happyness, and harmony to all its citizens.
To do so they heavily rely on their peacemakers. A governmental agency dedicated to make peace around the country. To do so they bring assistance to any agitated person and help them to recover peace. More generally they help citizen to stay in line with their country harmonious goal. To help its peacemakers squads, Peaceland engineers have created a working autonomous drone called peacewatcher. They need you to create the program that will receive and manage peacewatchers’s data.


 # Implementation 
 
 The goal is to write a poc demonstrating a working architecture of peaceland
 
 ## Architecture
 -Kafka
 -Spark
 
 # How to run our project ?
 
## Requirements
For this part, we need to have installed:

kafka : version 2.12-2.1.0
sbt (to compile scala project code)

### 1. Launch zookeeper instance:
Go to your kafka folder (“kafka_2.12-2.1.0”) and enter the following command:

bin/zookeeper-server-start.sh ./config/zookeeper.properties

### 2. Launch kafka (in another terminal):
Go to your kafka folder (“kafka_2.12-2.1.0”) and enter the following command:

bin/kafka-server-start.sh ./config/server.properties

### 3. Create topic DangerousPeople with a replication factor to 1 and a least 2 partitions (in another terminal).
Go to your kafka folder (“kafka_2.12-2.1.0”) and enter the following command:

bin/kafka-topics.sh --create --zookeeper localhost:9092--replication-factor 1 --partitions 2 --topic DangerousPeople

### 4. Launch the Main file :
sbt run


# Authors
Hassan BACHACHA
Emeric BERTIN
Philipe CHEN
 
