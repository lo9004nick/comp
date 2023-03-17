package comp;

public class Output extends Thread{
    int memoryLocation;

    Comp comp;

    public Output(int memoryLocation, Comp comp) {
        this.comp = comp;
        this.memoryLocation = memoryLocation;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            if (comp.memory.readOutputLocation(this) != 0) {
                System.out.println(comp.memory.readOutputLocation(this));
                comp.memory.clearOutput(this);
            }
        }
    }
}