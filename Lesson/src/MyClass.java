public class MyClass {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }


    public static String getCallerClassAndMethodName() {
        StackTraceElement[] methods = new Exception().getStackTrace();
        if (methods.length < 3) {
            return null;
        }
        return methods[2].getClassName() + "#" + methods[2].getMethodName();
    }
}
    public static void main(String[] args) {
        Human humanOne = new Human();
        Human humanTwo = new Human((byte) 43, "Victor", "Ford", "footbool");
        Human humanThree = new Human((byte) 23, "Helen", "Hant");//TODO your code here
    }

public static class Human {
    private byte age;
    private String name;
    private String secondName;
    private String favoriteSport;

    public Human() {
    }
    public Human(byte age, String name, String secondName) {
        this.age = age;
        this.name = name;
        this.secondName = secondName;
    }

    public Human(byte age, String name, String secondName, String favoriteSport) {
        this(age, name, secondName);
        this.favoriteSport = favoriteSport;
    }

    //TODO your code here
}


