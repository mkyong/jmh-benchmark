package com.mkyong.benchmark.bk;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LoopForwardReverseTest {

    private static List<String> DATA_FOR_TESTING = Arrays.asList(createArray());

    public static void main(String[] argv) {

        LoopForwardReverseTest obj = new LoopForwardReverseTest();
        obj.forwardLoop();
        obj.reverseLoop();
    }

    public void forwardLoop() {
        System.out.println("\n--------- Forward Loop -------\n");
        long startTime = new Date().getTime();

        for (int i = 0; i < DATA_FOR_TESTING.size(); i++) {
            String s = DATA_FOR_TESTING.get(i);
            //System.out.println(s);
        }

        long endTime = new Date().getTime();
        long difference = endTime - startTime;
        System.out.println("Forward Loop - Elapsed time in milliseconds: " + difference);
    }

    public void reverseLoop() {
        System.out.println("\n--------- Reverse Loop -------\n");
        long startTime = new Date().getTime();

        for (int i = DATA_FOR_TESTING.size() - 1; i >= 0; i--) {
            String s = DATA_FOR_TESTING.get(i);
            //System.out.println(s);
        }

        long endTime = new Date().getTime();
        long difference = endTime - startTime;
        System.out.println("Reverse Loop - Elapsed time in milliseconds: " + difference);
    }


    private static String[] createArray() {
        int N = 10_000_000;

        String sArray[] = new String[N];
        for (int i = 0; i < N; i++) {
            sArray[i] = "Array " + i;
        }
        return sArray;
    }

}
