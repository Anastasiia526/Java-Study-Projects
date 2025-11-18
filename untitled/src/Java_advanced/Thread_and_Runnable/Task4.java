package Java_advanced.Thread_and_Runnable;

public class Task4 {
    public static void main(String[] args) {

        MyThread1 threadOne = new MyThread1();
        MyThread2 threadTwo = new MyThread2();

        threadOne.start();
        threadTwo.start();

    }

    private static class MyThread1 extends Thread {

        @Override
        public void run() {
//            synchronized (MyThread1.class) {
            System.out.println("MyThread1 started...");

            try {
                MyThread1.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThread1 Waiting MyThread2");
            System.out.println("MyThread1 finished");
        }
//            synchronized (MyThread2.class) {
//                System.out.println("MyThread1: Hold MyThread1 and MyThread2");
//            }
//        }

    }

    private static class MyThread2 extends Thread {

        @Override
        public void run() {
//            synchronized (MyThread2.class) {
            System.out.println("MyThread2 started...");
            try {
                MyThread2.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("MyThread2 Waiting MyThread1");
            System.out.println("MyThread2 finished");
        }
//            synchronized (MyThread1.class) {
//                System.out.println("MyThread2: Hold MyThread1 and MyThread2");
//
//            }
//        }
    }
}
