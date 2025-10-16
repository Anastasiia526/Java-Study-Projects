package Java_advanced.Thread_and_Runnable;

public class Task2 {
    public static void main(String[] args) {
        Thread myThread = new Thread(()->{
            Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
            Thread.currentThread().setName("Main");
            for (int i = 0; i < 50; i++) {

                System.out.println("Name of Thread: " + Thread.currentThread().getName() + " priority: " + Thread.currentThread().getPriority() + " iteration number: " + i);
            }});
        PriorityRunner pr = new PriorityRunner();
        PriorityThread pt = new PriorityThread();

        myThread.start();
        pr.start();
        pt.start();
    }
}
class PriorityRunner extends Thread{
    @Override
    public void run() {
        Thread priorityRunner =  new Thread(new PriorityRunner());
        priorityRunner.setPriority(Thread.MAX_PRIORITY);
        priorityRunner.setName("PriorityRunner");
        for (int i = 0; i < 50; i++) {
            System.out.println("Name of Thread: " + priorityRunner.getName() + " priority: " + priorityRunner.getPriority() + " iteration number: " + i);
        }
    }
}
class PriorityThread extends Thread{

    @Override
    public void run() {
        Thread priorityThread = Thread.currentThread();
        priorityThread.setName("PriorityThread");
        priorityThread.setPriority(1);
        for (int i = 0; i < 50; i++) {
            System.out.println("Name of Thread: " + priorityThread.getName() + " priority: " + priorityThread.getPriority() + " iteration number: " + i);
        }
    }
}
