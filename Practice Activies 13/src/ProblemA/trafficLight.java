package ProblemA;

class trafficLight implements Runnable {

    private static boolean aBoolean = true;
    public trafficLight(){
        aBoolean = true;
    }

    public static void stop(){
        aBoolean = false;
    }
    @Override
    public void run(){
        while(aBoolean) {
            System.out.println("Green");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exc) {

            }
            System.out.println("Yellow");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException exc) {

            }
            System.out.println("Red");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException exc) {

            }
        }
    }
}
