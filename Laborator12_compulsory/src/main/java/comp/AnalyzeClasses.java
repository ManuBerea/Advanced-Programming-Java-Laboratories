package comp;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class AnalyzeClasses {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, MalformedURLException {

        String classLocation = "C:/Users/manub/IdeaProjects/lab12/target/classes/comp/Program.class";
        MyClassLoader myClassLoader = new MyClassLoader();
        File path = new File(classLocation);
        if (path.exists()) { //il parseaza
            URL url = path.toURI().toURL();
            myClassLoader.addURL(url);
        }
        String className = "comp.Program";

        Class clazz = Class.forName(className); // get the instance of this Class with the specified class name
        //prin reflexie afiseaza pachetele
        System.out.println(clazz.getName());
        System.out.println(clazz.getPackage());
        System.out.println(Arrays.toString(clazz.getMethods()));
        System.out.println(clazz.getSuperclass());

        int passed = 0, failed = 0;
        for (Method method : Class.forName(clazz.getName()).getMethods()) { //parcurgem toate metodele din clasa incarcata
            if (method.isAnnotationPresent(Test.class)) {
                try {
//                  System.out.println(method);
                    method.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", method, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);

    }
}
