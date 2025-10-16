package Java_advanced.Thread_and_Runnable;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Task5 {
    public static void main(String[] args) {
        Daemon normal = new Daemon();
        Daemon daemon = new Daemon();
        daemon.setDaemon(true);
        daemon.start();
        normal.start();

        displayInfo(daemon);

    }
    private static class Daemon extends Thread{

        @Override
        public void run() {

            try {
                if(isDaemon()){
                    System.out.println("Daemon Thread started");
                    Daemon.sleep(1000);

                }else {
                    System.out.println("Normal Thread started");

                    sleep(10);
                }
            }catch (InterruptedException e){
                System.out.println(e);
            }finally {
                if(!isDaemon()){
                    System.out.println("Normal Thread finished");
                }else {
                    System.out.println("Daemon Thread finished");
                }
            }
        }
    }
    public static void displayInfo(Thread thread){

        Class<?> clazz = Thread.class;
        System.out.println("Інформація про потік: " + thread.getName());
        System.out.println("Ім'я класу " + clazz.getName() + " та назва потоку: " + clazz.getSimpleName());
        System.out.println("Інтерфейси:");
        for(Class<?> temp : clazz.getInterfaces()){
            System.out.println("- " + temp.getName());
        }
        System.out.println("Методи:");
        for(Method tmp : clazz.getDeclaredMethods()){
            System.out.println(" - " + Modifier.toString(tmp.getModifiers()) + " " +
                    tmp.getReturnType().getSimpleName() + " " + tmp.getName() + "()");
        }
        System.out.println(" - Ім'я: " + thread.getName());
        System.out.println(" - Чи є демон: " + thread.isDaemon());
        System.out.println(" - Чи активний: " + thread.isAlive());
        System.out.println(" - Пріоритет: " + thread.getPriority());
        System.out.println(" - Стан: " + thread.getState());
    }
}
