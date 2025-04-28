import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class BasicThreadingDemo {


    public static void startOps() {
        MyExecutor.startProducerConsumer();

    }
}

class SharedList {


    private List<Integer> list = new ArrayList<>();

    private final Object LIST_IS_EMPTY = new Object();

    private final Object LIST_NOT_EMPTY = new Object();

    public void waitListIsEmpty() throws InterruptedException {
        synchronized (LIST_IS_EMPTY) {
            LIST_IS_EMPTY.wait();
        }

    }

    public void waitListIsNOTEmpty() throws InterruptedException {
        synchronized (LIST_NOT_EMPTY) {
            LIST_NOT_EMPTY.wait();
        }
    }

    public void notifyListNotEmpty() {
        synchronized (LIST_NOT_EMPTY) {
            LIST_NOT_EMPTY.notify();
        }
    }

    public void notifyListIsEmpty() {
        synchronized (LIST_IS_EMPTY) {
            LIST_IS_EMPTY.notify();
        }
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}

class Producer implements Runnable {

    private SharedList sharedList = new SharedList();

    private volatile boolean running = true;

    public Producer(SharedList sharedList) {
        this.sharedList = sharedList;

    }

    public void produce() {

        while(running) {
            if(!sharedList.getList().isEmpty()) {
                try {
                    sharedList.waitListIsNOTEmpty();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            sharedList.getList().add(1);
            sharedList.notifyListIsEmpty();
        }


    }

    public void stop() {
        this.running = false;
    }

    @Override
    public void run() {
        produce();
    }
}


class Consumer implements Runnable {

    private SharedList sharedList;

    private volatile boolean running = true;

    public Consumer(SharedList sharedList) {
        this.sharedList = sharedList;
    }


    public void consume() throws InterruptedException {

        while (running) {
            if(sharedList.getList().isEmpty()) {
                sharedList.waitListIsEmpty();
            }

            sharedList.getList().clear();
            sharedList.notifyListNotEmpty();

        }

    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        this.running = false;
    }
}


class MyExecutor {

    public static void startProducerConsumer() {

        SharedList list = new SharedList();

        Producer producer = new Producer(list);

        Consumer consumer = new Consumer(list);

        new Thread(producer).start();

        new Thread(consumer).start();

    }
}


