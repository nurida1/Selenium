package test.day9_testbase_properties_driverUtil;

public class Singleton {
    //Making the constructor private to limit the user access to the object of the class

    private Singleton () {

    }

    private static String word;

    public static String getWord() {
        if (word == null) {
            System.out.println("First call. Word object is null." + "Assigning value to word right now.");
            word = "something";
        } else {
            System.out.println("Word already has value");
        }
        return word;

    }


}
