package jdk_11.examples;

import java.util.function.Consumer;

public class LocalVariablesInLambda {

    public static void main(String[] args) {
        Consumer<String> dataConsumer = (data) -> System.out.println(data);

        Consumer<String> dataConsumer2 = (@NotNull String data) -> System.out.println(data);

        Consumer<String> dataConsumer3 = (@NotNull var data) -> System.out.println(data);
    }

    static @interface NotNull {

    }

}
