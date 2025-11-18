package Java_advanced.Thread_and_Runnable;

public class Task1 {
    public static void main(String[] args) {
        MainThread mt = new MainThread();
        FirstThread ft = new FirstThread();
        SecondThread st = new SecondThread();
        mt.start();
        ft.start();
        st.start();
    }
}
class MainThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            Thread.currentThread().setName("MainThread");
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
class FirstThread extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            Thread.currentThread().setName("FirstThread");
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
class SecondThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            Thread.currentThread().setName("SecondThread");
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
