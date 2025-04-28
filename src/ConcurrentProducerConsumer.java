import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ConcurrentProducerConsumer {


    public static void startOps() {

    }
}

class SharedData {


    private List<String> data;

    public SharedData(List<String> data) {
        this.data = data;
    }



}

class Topic {


    private String name;

    private UUID topicId;

    private List<Message> messages;

    private List<TopicListener> listeners;

    public Topic(String name) {
        this.name = name;
        this.topicId = UUID.randomUUID();
    }

    public void addListener(TopicListener topicListener) {
        this.listeners.add(topicListener);
    }

}


class Message {

    private UUID messageId;

    public void publish(String message, Topic topic) {

    }
}


class MessageProducer  implements Runnable {


    @Override
    public void run() {

    }
}


class MessageConsumer implements Runnable {


    @Override
    public void run() {

    }
}

class Broker {

    private List<Topic> topics;

    public void createTopic(String topicName) {
        Topic topic = new Topic(topicName);

        this.topics.add(topic);


    }


}

class TopicListener {



    private Topic topic;


}