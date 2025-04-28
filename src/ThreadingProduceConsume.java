import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadingProduceConsume
{

    public static List<Integer> list;

    Object lock1 = new Object();

    Object lock2 = new Object();

    static {
        list = new ArrayList<>();
    }

    private static Integer MAX = 10;

    public static void executeOp() {

//        try {
////            th1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


    }
}
