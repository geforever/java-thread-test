import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
//    测试
    private static final AtomicInteger threadNumber = new AtomicInteger(1);

    private static class Task implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "_" + LocalTime.now());
                Thread.currentThread().sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    private static class MyThreadFactory implements ThreadFactory {
//
//        private final String namePrefix;
//
//        public MyThreadFactory(String namePrefix) {
//            this.namePrefix = namePrefix;
//        }
//
//        @Override
//        public Thread newThread(Runnable runnable) {
//            return new Thread(runnable, namePrefix + "_" + threadNumber.getAndIncrement());
//        }
//    }

    private static final ExecutorService executorService = new ThreadPoolExecutor(
            5,
            20, 30, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(50),
//            new MyThreadFactory("MyThreadFromPool"),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            executorService.submit(task);
        }
        executorService.shutdown();

//
//        Task r1 = new Task();
//        Task r2 = new Task();
//        Task r3 = new Task();
//        Task r4 = new Task();
//        Task r5 = new Task();
//
//        Future future = executorService.submit(r1);
//        System.out.println("r1 is Done ?" + future.isDone());
//
//        executorService.execute(r2);
//        executorService.execute(r3);
//        executorService.execute(r4);
//        executorService.execute(r5);
//
//        executorService.shutdown();

    }


}
