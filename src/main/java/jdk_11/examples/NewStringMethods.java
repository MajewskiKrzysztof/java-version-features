package jdk_11.examples;

public class NewStringMethods {

    public static void main(String[] args) {
        print("".isBlank());                            // true
        print("content".isBlank());                     // false

        print("one\ntwo\nthree".lines().count());       // 3
        print("one\ntwo\nthree".lines());               // Stream<String>

        print(" \n \t text \t \n  ".strip());           // "text"
        print(" \n \t text \t \n  ".stripLeading());    // "text \t \n"
        print(" \n \t text \t \n  ".stripTrailing());   // " \n \t text"

        print("x; ".repeat(3));   // "x; x; x; "
    }

    private static void print(Object message) {
        System.out.println(message);
    }

}
