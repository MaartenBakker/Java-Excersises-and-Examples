package com.maartenmusic;

public class Main {

    public static void main(String[] args) {
	// write your code here


        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);

        final SharedResource sharedResource = new SharedResource(worker1);

        new Thread(()-> {
            worker1.work(sharedResource, worker2);
        }).start();

        new Thread(()-> {
            worker2.work(sharedResource, worker1);
        }).start();

    }


}
