import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Main {

    private static void start(Class c) throws InvocationTargetException, IllegalAccessException {
        int before = 0;
        int after = 0;

        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                before++;
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                after++;
            }
        }

        if (before > 1 || after > 1) {
            throw new RuntimeException("Before or After > 1");
        } else {
            Method[] methods1 = c.getDeclaredMethods();
            for (int i = 0; i < methods1.length; i++) {
                for (int j = 0; j < methods1.length - i - 1; j++) {
                    if (methods1[j].getAnnotation(Common.class).priority() > methods1[j + 1].getAnnotation(Common.class).priority()) {
                        Method temp = methods1[j];
                        methods1[j] = methods1[j + 1];
                        methods1[j + 1] = temp;
                    }
                }
            }

            for (Method m : methods1){
                m.invoke(null);
            }
        }
    }

    public static void main(String[] args) {
        try {
            start(TestClass.class);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
