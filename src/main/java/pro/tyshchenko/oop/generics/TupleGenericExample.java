package pro.tyshchenko.oop.generics;

/**
 * @author Alexander Tyshchenko.
 */
public class TupleGenericExample {

    public static void main(String[] args) {
        TwoTuple<String, Integer>                       tuple1 = getJobResult1();
        ThreeTuple<String, Integer, Vehicle>            tuple2 = getJobResult2();
        FourTuple<String, Integer, Vehicle, Rectangle>  tuple3 = getJobRe1sult3();
    }


    private static TwoTuple<String, Integer> getJobResult1() {
        return new TwoTuple<>("string", 1);
    }

    private static ThreeTuple<String, Integer, Vehicle> getJobResult2() {
        return new ThreeTuple<>("string", 1, new Vehicle());
    }

    private static FourTuple<String, Integer, Vehicle, Rectangle> getJobRe1sult3() {
        return new FourTuple<>("string", 1, new Vehicle(), new Rectangle());
    }

    private static final class Rectangle {}
    private static final class Vehicle {}

    private static class TwoTuple<A, B> {
        public final A first;
        public final B second;

        public TwoTuple(A first, B second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "TwoTuple{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    private static class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
        public final C third;

        public ThreeTuple(A first, B second, C third) {
            super(first, second);
            this.third = third;
        }

        @Override
        public String toString() {
            return "ThreeTuple{" +
                    "first=" + first +
                    ", second=" + second +
                    ", third=" + third +
                    '}';
        }
    }

    private static class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
        public final D fourth;

        public FourTuple(A first, B second, C third, D fourth) {
            super(first, second, third);
            this.fourth = fourth;
        }

        @Override
        public String toString() {
            return "FourTuple{" +
                    "first=" + first +
                    ", second=" + second +
                    ", third=" + third +
                    ", fourth=" + fourth +
                    '}';
        }
    }

}
