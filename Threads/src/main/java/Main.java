
public class Main {


    public static void main(String[] args) {

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread.");

        Thread anotherTread = new AnotherThread();
        anotherTread.setName("== Another Thread ==");
        anotherTread.start();

        new Thread() {
            public void run(){
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class");
            }
        }.start();


        Thread myRunnableThread = new Thread(() -> {
            System.out.println(ThreadColor.ANSI_RED + "Hello from the lambda");
            try {
                anotherTread.join(2000);
                System.out.println(ThreadColor.ANSI_RED + "Another thread terminated or timed out, Running again!");
            } catch (InterruptedException exception) {
                System.out.println(ThreadColor.ANSI_RED + "I couldn't wait after all, I was interrupted.");
                exception.printStackTrace();
            }
        });

        myRunnableThread.start();

//        anotherTread.interrupt();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread.");






    }


}
