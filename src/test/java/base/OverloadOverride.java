package base;

import org.junit.Test;

/**
 * @author LRK
 * @project_name LeetCode
 * @package_name base
 * @date 2019/3/6 18:51
 * @description God Bless, No Bug!
 */
public class OverloadOverride {
    class Super {

        public int f() {
            return 2;
        }
    }

    class SubClass extends Super {
        public SubClass(){
            super();
            System.out.println("hhh");
        }
        public int f() {
            return 3;
        }
        public void test(){
            System.out.println(super.getClass().getName());
            System.out.println(this.getClass().getSuperclass().getName());
        }
    }
    @Test
    public void testGetClass(){
        new SubClass().test(); // final native getClass() 返回此Object的运行时类(实际类型)
    }

    public interface InterfaceA {
        default String f() {
            return "this is InterfaceA";
        }
    }

    public interface InterfaceB {
        default String f() {
            return "this is InterfaceB";
        }
    }

    abstract class ImplClass implements InterfaceA, InterfaceB {

        @Override
        public String f() {
            return "this is ImplClass";
        }
    }

    abstract class AbstractCls {

        abstract int getSum();

//        abstract default int get(); // 不能有default

    }

    @Test
    public void test() {
//        Super s = new SubClass();
//        System.out.println(s.f());
//        System.out.println(new ImplClass().f()); // this is ImplClass
        getClass();
    }

    class Student{
        String name;
        Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    @Test
    public void testFinal(){
        final Student student = new Student("zhangsan",12);
        student.setAge(18);
        System.out.println(student);

        final StringBuilder builder = new StringBuilder("Hello");
//        StringBuilder change = builder;
        builder.append("plus ");
        System.out.println(builder);
    }
}
