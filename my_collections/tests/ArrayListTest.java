package my_collections.tests;

import my_collections.implementations.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArrayListTest {

    private final ArrayList<String> l = new ArrayList<>();

    @After
    public void after() {
        System.out.println("After : " + l);
    }

    @Before
    public void before() {
        System.out.println("Before : " + l);
    }

    @Test
    public void test1() {
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (int i = 0; i < 10; i++) {
            l.add(Integer.toString(i));
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(l.get(i), Integer.toString(i));
        }
    }

    @Test
    public void test2() {
        for (int i = 10; i < l.getCapacity(); i++) {
            assertNull(l.get(i));
        }
    }

    @Test
    public void test3() {
        // 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9
        for (int i = 0; i < 20; i += 2) {
            l.add(Integer.toString(i / 2), i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(l.get(i), l.get(i + 1));
        }
    }

    @Test
    public void test4() {
        // 5, 5, 6, 6, 7, 7, 8, 8, 9, 9
        for (int i = 0; i < 10; i++) {
            l.remove(i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(l.get(i), Integer.toString(5 + i / 2));
        }
    }

    @Test
    public void test5() {
        // 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9
        for (int i = 0; i < 10; i++) {
            l.add(Integer.toString(i / 2), i);
        }

        for (int i = 0; i < 20; i++) {
            assertEquals(l.get(i), l.get(i + 1));
        }
    }

    @Test
    public void test6() {
        // 0, 1, 2, 3, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9
        for (int i = 0; i < 5; i++) {
            l.removeFirst(Integer.toString(i));
        }

        for (int i = 0; i < 5; i++) {
            assertEquals(l.get(i), Integer.toString(i));
        }

        for (int i = 5; i < 15 - 1; i++) {
            assertEquals(l.get(i), l.get(i + 1));
        }
    }

    @Test
    public void test7() {
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (int i = 5; i < 10; i++) {
            l.removeLast(Integer.toString(i));
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(l.get(i), Integer.toString(i));
        }
    }

    @Test
    public void test8() {
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        for (int i = 0; i < 10; i++) {
            l.add("0");
        }

        // 1, 2, 3, 4, 5, 6, 7, 8, 9
        l.removeAll("0");

        for (int i = 1; i < 10; i++) {
            assertEquals(l.get(i), Integer.toString(i));
        }

        assertEquals(l.size(), 9);
    }

    @Test
    public void test9() {
        String[] arr = l.toArray();
        for (int i = 0; i < 10; i++) {
            assertEquals(l.get(i), arr[i]);
        }
    }

    @Test
    public void test10() {
        // none
        for (int i = 0; i < 10; i++) {
            assertEquals(l.remove(0), Integer.toString(i));
        }
    }
}
