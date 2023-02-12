public class TestClass {


    @Common(priority = 10)
    @BeforeSuite
    public static void before() {
        System.out.println(1);
    }

    @Common(priority = 9)
    @Test
    public static void test1() {
        System.out.println(2);

    }

    @Common(priority = 8)
    @Test
    public static void test2() {
        System.out.println(3);

    }

    @Common(priority = 7)
    @Test
    public static void test3() {
        System.out.println(4);
    }

    @Common(priority = 6)
    @Test
    public static void test4() {
        System.out.println(5);
    }

    @Common(priority = 5)
    @Test
    public static void test5() {
        System.out.println(6);
    }

    @Common(priority = 4)
    @Test
    public static void test6() {
        System.out.println(7);
    }

    @Common(priority = 3)
    @Test
    public static void test7() {
        System.out.println(8);
    }

    @Common(priority = 2)
    @Test
    public static void test8() {
        System.out.println(9);
    }

    @Common(priority = 1)
    @AfterSuite
    public static void after() {
        System.out.println(10);
    }
}
