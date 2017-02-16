package executor.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.System.out;

/**
 * JavaDemo
 * executor.demo
 * Created by timothy on 16/8/8.
 */
public class ExecutorApp {

    public static void main(String[] args) {

        Runnable task = getRunable("Hello");
        Thread thread = new Thread(task);
        thread.start();
    }

    public static void runWithThread() {

        Runnable task = () -> {
            try {
                String threadName = Thread.currentThread().getName();
                out.println("Thread Name: " + threadName);
                out.println("...1");
                TimeUnit.SECONDS.sleep(3);
                out.println("...2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        task.run();
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("Task done");
    }

    public static void runWithExecutorService() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            executor.submit( () -> {
                String threadName = Thread.currentThread().getName();
                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                out.println(threadName);
            });
            executor.shutdown();
            if(!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                out.println("Timeout!!!");
            }
        } catch (InterruptedException e) {
            out.println("Interrupted Error");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("Cancel non-finished task");
            }
            executor.shutdownNow();
            out.println("finally shutdown");

        }
    }

    public static void runWithCallable() {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(3);
            return 123;
        };
        Future<Integer> future = executor.submit(task);
        out.println("Future is done ? " + future.isDone());
        try {
            int result = future.get();
            out.println("Future is done ? " + future.isDone());
            out.println("Result is " + result);
            executor.shutdownNow();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }
    }

    public static void runWithInvokeAll() {

        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                () -> "aaaaaaaaa",
                () -> "bbbbbbbbb",
                () -> "ccccccccc",
                () -> "ddddddddd"
        );
        try {
            executor.invokeAll(callables)
                    .stream()
                    .map( future -> {
                        String result = "";
                        try {
                            result = future.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return result;
                    })
                    .forEach(out::println);
            executor.shutdown();
            executor.awaitTermination(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }
    }

    private static void runWithInvokeAny() {

        ExecutorService executor = Executors.newWorkStealingPool();
        try {
            String result = executor.invokeAny(Arrays.asList(
                    () -> {
                        TimeUnit.SECONDS.sleep(1);
                        return "aaaaaaaa";
                    },
                    () -> "bbbbbbbb",
                    () -> "cccccccc",
                    () -> "ddddddd"
            ));
            out.println(result);
            executor.shutdown();
            executor.awaitTermination(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }
    }

    private static void runWithScheduledExecutor() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            out.println("Task begin...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println("Task end...");
        };
        ScheduledFuture future = executor.schedule(task, 5, TimeUnit.SECONDS);
        while (!future.isDone()) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long sec = future.getDelay(TimeUnit.SECONDS);
            if (sec > 0) {
                out.println(sec);
            } else {
                try {
                    future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        if (future.isDone()) {
            executor.shutdown();
            try {
                executor.awaitTermination(6, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                executor.shutdownNow();
            }
        }
    }

    private static Runnable getRunable(String para) {

        return () -> {
          System.out.println(para);
        };
    }
}
