package reflection;

import com.hgg.model.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 测试反射
 * Created by hgg on 2019/5/6.
 */
public class ReflectionTest {

    @Test
    public void testPerson() throws Exception {

        Class cla =Person.class;
        System.out.println(cla);

        Person person = new Person();
        cla = person.getClass();
        System.out.println(cla);

        try {
            cla = Class.forName("com.hgg.model.Person");
            System.out.println(cla);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Person person1 = (Person) cla.newInstance();
        System.out.println(person.getAge());

        System.out.println(cla.getName());
        System.out.println(cla.getInterfaces());
        System.out.println(cla.getClassLoader());


        Field[] fields = cla.getDeclaredFields();


    }

    @Test
    public void testClassLoader() throws Exception {
//1. 获取一个系统的类加载器(可以获取，当前这个类PeflectTest就是它加载的)
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);


        //2. 获取系统类加载器的父类加载器（扩展类加载器，可以获取）.
        classLoader = classLoader.getParent();
        System.out.println(classLoader);


        //3. 获取扩展类加载器的父类加载器（引导类加载器，不可获取）.
        classLoader = classLoader.getParent();
        System.out.println(classLoader);


        //4. 测试当前类由哪个类加载器进行加载（系统类加载器）:
        classLoader = Class.forName("ReflectionTest")
                .getClassLoader();
        System.out.println(classLoader);


        //5. 测试 JDK 提供的 Object 类由哪个类加载器负责加载（引导类）
        classLoader = Class.forName("java.lang.Object")
                .getClassLoader();
        System.out.println(classLoader);
    }



    @Test
    public void testPersonMethod() throws Exception {

        Class clazz =null;

        clazz = Class.forName("com.hgg.model.Person");
        System.out.println(clazz);

        //不能获取private方法,且获取从父类继承来的所有方法
        Method[] methods  = clazz.getMethods();
        for (Method method:methods) {
            System.out.println(method.getName());
        }

        System.out.println();
        //所有声明的方法，都可以获取到，且只获取当前类的方法
        methods = clazz.getDeclaredMethods();
        for(Method method:methods){
            System.out.print(" "+method.getName());
        }
        System.out.println();

        //
        //  1.3.获取指定的方法
        //  需要参数名称和参数列表，无参则不需要写
        //  对于方法public void setName(String name) {  }
        Method method = clazz.getDeclaredMethod("setName", String.class);
        System.out.println(method);
        //  而对于方法public void setAge(int age) {  }
        method = clazz.getDeclaredMethod("setAge", int.class);
        System.out.println(method);

//
        //2.执行方法
        //  invoke第一个参数表示执行哪个对象的方法，剩下的参数是执行方法时需要传入的参数
        Person obje = (Person) clazz.newInstance();
        //私有方法的执行，必须在调用invoke之前加上一句method.setAccessible（true）;
        method.setAccessible(true);
        System.out.println(method.invoke(obje,2));
        System.out.println(obje.getAge());
    }


    @Test
    public void testFiled() throws Exception {

        Class clazz =null;

        clazz = Class.forName("com.hgg.model.Person");
        System.out.println(clazz);
        //1.获取字段
        //  1.1 获取所有字段 -- 字段数组
        //     可以获取公用和私有的所有字段，但不能获取父类字段
        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            System.out.print(" "+ field.getName());
        }
        System.out.println();
        //  1.2获取指定字段
        Field field = clazz.getDeclaredField("name");
        System.out.println(field.getName());

        Person person = new Person("ABC",12);

        //2.使用字段
        //  2.1获取指定对象的指定字段的值

        field.setAccessible(true);
        System.out.println(field.get(person));
        Object val = field.get(person);
        System.out.println(val);

        //  2.2设置指定对象的指定对象Field值
        field.set(person, "DEF");
        System.out.println(person.getName());

        //  2.3如果字段是私有的，不管是读值还是写值，都必须先调用setAccessible（true）方法
        //     比如Person类中，字段name字段是公用的，age是私有的
        field = clazz.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println(field.get(person));
    }

    @Test
    public void testConstructor() throws Exception{
        String className = "com.hgg.model.Person";
        Class<Person> clazz = (Class<Person>) Class.forName(className);

        //1. 获取 Constructor 对象
        //   1.1 获取全部
        Constructor<Person>[] constructors =
                (Constructor<Person>[]) Class.forName(className).getConstructors();

        for(Constructor<Person> constructor: constructors){
            System.out.println(constructor);
        }

        //  1.2获取某一个，需要参数列表
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);

        //2. 调用构造器的 newInstance() 方法创建对象
        Person obj = constructor.newInstance("zhagn", 1);
        System.out.println(obj.getName());
    }
}
