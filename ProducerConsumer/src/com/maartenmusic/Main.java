package com.maartenmusic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.maartenmusic.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {

        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer myProducer = new MyProducer(buffer, ThreadColor.ANSI_BLUE);
        MyConsumer myConsumer1 = new MyConsumer(buffer, ThreadColor.ANSI_RED);
        MyConsumer myConsumer2 = new MyConsumer(buffer, ThreadColor.ANSI_YELLOW);


        executorService.execute(myProducer);
        executorService.execute(myConsumer1);
        executorService.execute(myConsumer2);

        Future<String> future = executorService.submit(()-> {
            System.out.println(ThreadColor.ANSI_BLACK + "I'm being printed form the Callable");
            return "This is the callable result";
        });



        try {
            System.out.println(ThreadColor.ANSI_BLACK + future.get());
        } catch (ExecutionException | InterruptedException exception) {
            exception.printStackTrace();
        }

        executorService.shutdown();


    }
}

class MyProducer implements Runnable {
    private final ArrayBlockingQueue<String> buffer;
    private final String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] numbers = {"1", "2", "3", "4", "5"};

        for(String number: numbers) {
            try {
                System.out.println(color + "Adding..." + number);
                buffer.put(number);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

        System.out.println(color + "Adding EOF and exiting");
        try {
            buffer.put(EOF);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}

class MyConsumer implements Runnable {
    private final ArrayBlockingQueue<String> buffer;
    private final String color;


    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        synchronized (buffer) {
            while (true) {
                if (buffer.isEmpty()) {
                    continue;
                }
                try {
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}

