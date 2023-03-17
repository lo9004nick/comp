package comp;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Comp {

    public Clock clock;
    public Counter counter;
    public ALU alu;
    public Memory memory;
    public Output output;

    public Input input;

    HashMap<String, Integer> instructionsMap;

    public static void main(String[] args) {
        Comp comp = new Comp("src/comp/fibTest");

    }

    public Comp(String programFileName) {



        this.clock = new Clock(10, this);
        this.counter = new Counter(this);
        this.alu = new ALU(this);
        this.memory = new Memory(this);
        this.output = new Output(254, this);
        this.input = new Input(253, this);

        instructionsMap = new HashMap<>();
        instructionsMap.put("nop", 0);
        instructionsMap.put("sto", 1);
        instructionsMap.put("lda", 2);
        instructionsMap.put("ldb", 3);
        instructionsMap.put("copyoa", 4);
        instructionsMap.put("copyob", 5);
        instructionsMap.put("copyba", 6);
        instructionsMap.put("copyab", 7);
        instructionsMap.put("ldaarg", 8);
        instructionsMap.put("ldbarg", 9);
        instructionsMap.put("addab", 10);
        instructionsMap.put("subab", 11);
        instructionsMap.put("and", 12);
        instructionsMap.put("xor", 13);
        instructionsMap.put("or", 14);
        instructionsMap.put("copyao", 15);
        instructionsMap.put("copybo", 16);
        instructionsMap.put("copyca", 17);
        instructionsMap.put("jmp", 18);
        instructionsMap.put("goto", 19);
        instructionsMap.put("jmpcond", 20);
        instructionsMap.put("halt", 21);

        try(Scanner scanner = new Scanner(new FileInputStream(programFileName))){
            int i = 0;
            while (scanner.hasNext()){
                String inst = scanner.nextLine();
                memory.writeForFlashOnly(i, instructionsMap.get(inst.substring(0, inst.indexOf(" "))));
                i++;
                memory.writeForFlashOnly(i, Integer.parseInt(inst.substring(inst.indexOf(' ') + 1)));
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        input.setDaemon(true);
        output.setDaemon(true);
        clock.setDaemon(true);

        input.start();
        output.start();
        clock.start();



    }
}
