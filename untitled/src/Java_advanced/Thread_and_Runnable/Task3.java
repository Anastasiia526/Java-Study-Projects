package Java_advanced.Thread_and_Runnable;

public class Task3 {
    public static void main(String[] args) {

        MyThreadOne threadOne = new MyThreadOne();
        MyThreadTwo threadTwo = new MyThreadTwo();

        threadOne.start();
        threadTwo.start();

    }
    static class MyThreadOne extends Thread{

        @Override
        public void run() {
            synchronized (MyThreadOne.class) {
                System.out.println("MyThreadOne started...");

                try {
                    MyThreadOne.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("MyThreadOne Waiting MyThreadTwo");
            }
            synchronized (MyThreadTwo.class){
                System.out.println("MyThreadOne: Hold MyThreadOne and MyThreadTwo");
            }
        }
    }
    private static class MyThreadTwo extends Thread{

        @Override
        public void run() {
            synchronized (MyThreadTwo.class){
                System.out.println("MyThreadTwo started...");
                try {
                    MyThreadTwo.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("MyThreadTwo Waiting MyThreadOne");
            }
            synchronized (MyThreadOne.class){
                System.out.println("MyThreadTwo: Hold MyThreadTwo and MyThreadOne");

            }        }
    }
}
