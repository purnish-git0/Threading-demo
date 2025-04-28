Producer and Consumer with synchronization is developed in class BasicThreadingDemo.java

In it there are two locks, both in the Shared Data Structure.

wait and notify methods on these locks are used to inform the Producer and Consumer

about when objects are available to consume, and on producer side,

the consumer notifies when the data structure is empty so that the producer

can then populate it and notify to the Consumer.

In progress, trying to create a Topic publish/subscribe kind of system

similar to Kafka or RabbitMQ. 
