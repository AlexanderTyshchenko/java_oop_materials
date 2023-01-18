package pro.tyshchenko.oop.generics;

import java.util.Scanner;

/**
 * @author Alexander Tyshchenko.
 */
public class ContainerGenericExample1 {

    public static void main(String[] args) {
        Container container1 = new Container(new MyClass());
//        Container container2 = new Container("1");


        ContainerOldWay containerOldWay1 = new ContainerOldWay(new MyClass());
        ContainerOldWay containerOldWay2 = new ContainerOldWay("1");
        ContainerOldWay containerOldWay3 = new ContainerOldWay(100);
        ContainerOldWay containerOldWay4 = new ContainerOldWay(1.2);

        System.out.println(containerOldWay4.getObj());

        containerOldWay4.setObj("string");

        System.out.println(containerOldWay4.getObj());
        System.out.println(((String)containerOldWay4.getObj()).length());
//        System.out.println(((Integer)containerOldWay4.getObj())); // ClassCastException

        ContainerGeneric<String> containerGeneric = new ContainerGeneric<>("containerGeneric");
//        containerGeneric.setObj(1); // Compilation error

        System.out.println(containerGeneric.getObj());

        ContainerGeneric2<String, MyClass> containerGeneric2 = new ContainerGeneric2<>("string", new MyClass());

//        containerGeneric2.setObj2(1); // Compilation error

        System.out.println(containerGeneric2);


        // ?????!!!!!
        ContainerGeneric2 containerGeneric3 = new ContainerGeneric2<>("string", new MyClass());
        containerGeneric3.setObj1(1000);
        containerGeneric3.setObj2(new Scanner(System.in));

    }


    private static final class MyClass {
        @Override
        public String toString() {
            return MyClass.class.getSimpleName();
        }
    }

    private static final class Container {
        private MyClass obj;

        public Container(MyClass obj) {
            this.obj = obj;
        }

        public MyClass getObj() {
            return obj;
        }

        public void setObj(MyClass obj) {
            this.obj = obj;
        }
    }

    private static final class ContainerOldWay {
        private Object obj;

        public ContainerOldWay(Object obj) {
            this.obj = obj;
        }

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }
    }

    private static final class ContainerGeneric<T> {
        private T obj;

        public ContainerGeneric(T obj) {
            this.obj = obj;
        }

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }
    }

    private static final class ContainerGeneric2<T, V> {
        private T obj1;
        private V obj2;

        public ContainerGeneric2(T obj1, V obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        public T getObj1() {
            return obj1;
        }

        public void setObj1(T obj1) {
            this.obj1 = obj1;
        }

        public V getObj2() {
            return obj2;
        }

        public void setObj2(V obj2) {
            this.obj2 = obj2;
        }

        @Override
        public String toString() {
            return "ContainerGeneric2{" +
                    "obj1=" + obj1 +
                    ", obj2=" + obj2 +
                    '}';
        }
    }

}
