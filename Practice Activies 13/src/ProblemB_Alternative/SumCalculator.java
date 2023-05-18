package ProblemB_Alternative;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SumCalculator {
    private final int number;
    private int sum;

    public SumCalculator(int number) {
        this.number = number;
    }

    public void calculateSum() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        int chunkSize = number / 5;
        for (int i = 0; i < 5; i++) {
            int start = i * chunkSize + 1;
            int end = (i + 1) * chunkSize;
            if (i == 4) {
                end = number;
            }
            SumWorker worker = new SumWorker(start, end);
            executor.execute(worker);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
            int local_sum = 0;
            for (int i = start; i <= end; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                local_sum += i;
            }
            synchronized (SumCalculator.this) {
                sum += local_sum;
            }
        }
    }
}
