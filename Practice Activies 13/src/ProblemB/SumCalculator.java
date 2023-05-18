package ProblemB;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SumCalculator {
    private final int number;
    private int sum = 0;
    public SumCalculator(int number) {
        this.number = number;
    }
    public void calculateSum() {
        Executor executor = Executors.newFixedThreadPool(5);
        int one_thread_size = number / 5;
        for (int i = 1; i < number; i += one_thread_size){
            int left = (i);
            int right = (Math.min(i + one_thread_size - 1, number));
            SumWorker worker = new SumWorker(left, right);
        }
        executor.execute(new SumWorker(0, number));
        try {
            while (!((ExecutorService) executor).awaitTermination(10, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException exc){

        }
        System.out.println("The sum of all numbers from 1 to " + number + " is " + sum);
    }
    private class SumWorker implements Runnable {
        private final int start;
        private final int end;
        public SumWorker(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public void run() {
            int sum_of_number = 0;
            for (int i = start; i <= end; i++){
                sum_of_number += i;
            }
            System.out.println("The sum of all numbers from 1 to " + number + " is " + sum_of_number);
        }
    }
}

