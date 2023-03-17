package comp;

public class Clock extends Thread{

    private final int delay;

    private boolean running = true;

    private Comp comp;

    public Clock(int freq, Comp comp) {
        this.delay = 1000000000 / freq;
        this.comp = comp;
    }

    public void run(){
        try {
            while (running) {
                Thread.sleep(delay/1000000, delay%1000000);
                comp.alu.doSomething();
                comp.counter.advance();
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("clock interrupted");
        }
    }

    void halt(){
        running = false;
    }

}
