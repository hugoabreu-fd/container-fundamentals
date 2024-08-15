package pt.blip;

import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;

import java.util.Arrays;

public class PrintingMain {


    @QuarkusMain
    public class Main {
        public static void main(String ... args) {
            System.out.printf("Running main method. Received: %s%n", Arrays.asList(args));
            Quarkus.run(args);
        }
    }
}
