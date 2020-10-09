public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BLUE + "Hello from " + currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {
            System.out.println(ThreadColor.ANSI_BLUE + "Another thread woke me up");
            exception.printStackTrace();
            return;
        }

        System.out.println(ThreadColor.ANSI_BLUE + "Three seconds have passed and I'm awake");
    }
}
