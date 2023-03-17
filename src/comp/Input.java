package comp;

import java.util.Scanner;

public class Input extends Thread{
    Comp comp;
    int memoryLocation;
    Scanner scanner;

    int inputRegister;

    public Input(int memoryLocation, Comp comp) {
        this.comp = comp;
        this.memoryLocation = memoryLocation;
        scanner = new Scanner(System.in);
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            inputRegister = scanner.nextByte();
            comp.memory.write(this);
            //System.out.println(memory.memory[memoryLocation]);
        }
    }
}
