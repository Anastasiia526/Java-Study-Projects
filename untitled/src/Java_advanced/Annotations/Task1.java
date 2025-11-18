package Java_advanced.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task1 {
    public static void main(String[] args) {
        Operations operations = new Operations();
        Class<?> clazz = operations.getClass();
        Method[]method = clazz.getMethods();
        for (Method temp : method){
            if(temp.isAnnotationPresent(UserAnnotation.class)){
                UserAnnotation user = temp.getAnnotation(UserAnnotation.class);
                int num1 = user.num1();
                int num2 = user.num2();
                try {
                    temp.invoke(operations, num1, num2);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
class Operations {
    @UserAnnotation(num1 = 100, num2 = 200)
    public void add(int a, int b){
        System.out.println(a + b);
    }

}




@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface UserAnnotation{
    int num1();
    int num2();
}