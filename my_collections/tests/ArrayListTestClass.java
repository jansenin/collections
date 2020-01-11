package my_collections.tests;

import my_collections.List;
import my_collections.implementations.ArrayList;
import my_collections.implementations.LinkedList;

public class ArrayListTestClass {

    private static void assertEquals(Object o1, Object o2) {
        if (!o1.equals(o2)) throw new RuntimeException();
    }

    private static void assertNull(Object o) {
        if (o != null) throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception{
        int testsDone = 0;
        try {
            test1();
            testsDone++;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(10);
        }
        try {
            test2();
            testsDone++;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(10);
        }
        try {
            test3();
            testsDone++;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(10);
        }
        try {
            test4();
            testsDone++;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(10);
        }
        try {
            test5();
            testsDone++;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(10);
        }
        try {
            test6();
            testsDone++;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(10);
        }
        try {
            test7();
            testsDone++;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(10);
        }
        try {
            test8();
            testsDone++;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(10);
        }
        try {
            test9();
            testsDone++;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(10);
        }
        try {
            test10();
            testsDone++;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(10);
        }
        System.out.println("tests done : " + testsDone);
    }

    private static final List<String> l = new LinkedList<>();

    public static void test1() {
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (int i = 0; i < 10; i++) {
            l.add(Integer.toString(i));
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(l.get(i), Integer.toString(i));
        }
    }

    public static void test2() {
        // for ArrayList
        if (l instanceof ArrayList) {
            ArrayList<String> temp = (ArrayList) l;
            for (int i = 10; i < temp.getCapacity(); i++) {
                assertNull(l.get(i));
            }
        }
    }

    public static void test3() {
        // 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9
        for (int i = 0; i < 20; i += 2) {
            l.add(Integer.toString(i / 2), i);
        }

        for (int i = 0; i < 10; i += 2) {
            assertEquals(l.get(i), l.get(i + 1));
        }
    }

    public static void test4() {
        // 5, 5, 6, 6, 7, 7, 8, 8, 9, 9
        for (int i = 0; i < 10; i++) {
            l.remove(0);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(l.get(i), Integer.toString(5 + i / 2));
        }
    }

    public static void test5() {
        // 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9
        for (int i = 0; i < 10; i++) {
            l.add(Integer.toString(i / 2), i);
        }

        for (int i = 0; i < 20; i += 2) {
            assertEquals(l.get(i), l.get(i + 1));
        }
    }

    public static void test6() {
        // 0, 1, 2, 3, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9
        for (int i = 0; i < 5; i++) {
            l.removeFirst(Integer.toString(i));
        }

        for (int i = 0; i < 5; i++) {
            assertEquals(l.get(i), Integer.toString(i));
        }

        for (int i = 5; i < 15 - 1; i += 2) {
            assertEquals(l.get(i), l.get(i + 1));
        }
    }

    public static void test7() {
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (int i = 5; i < 10; i++) {
            l.removeLast(Integer.toString(i));
        }

        for (int i = 0; i < 10; i++) {
            String o1 = l.get(i);
            String o2 = Integer.toString(i);
            assertEquals(o1, o2);
        }
    }

    public static void test8() {
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        for (int i = 0; i < 10; i++) {
            l.add("0");
        }

        // 1, 2, 3, 4, 5, 6, 7, 8, 9
        l.removeAll("0");

        for (int i = 1; i < 9; i++) {
            assertEquals(l.get(i - 1), Integer.toString(i));
        }

        assertEquals(l.size(), 9);
    }

    public static void test9() {
        Object[] arr = l.toArray();
        for (int i = 0; i < 9; i++) {
            assertEquals(l.get(i), arr[i]);
        }
    }

    public static void test10() {
        // none
        for (int i = 0; i < 9; i++) {
            assertEquals(l.remove(0), Integer.toString(i + 1));
        }
    }
}