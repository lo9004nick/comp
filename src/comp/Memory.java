package comp;

public class Memory {
    Comp comp;
    private volatile int[] memory = new int[1024];

    public Memory(Comp comp) {
        this.comp = comp;
    }

    public int get(int address){
        return memory[address];
    }


    public void writeForFlashOnly(int address, int value){
        memory[address] = value;
    }

    public int readOutputLocation(Output output){
        return memory[comp.output.memoryLocation];
    }

    public void clearOutput(Output output){
        memory[comp.output.memoryLocation] = 0;
    }

    public int read(){
        return memory[comp.alu.getInstructionArg()];
    }

    public void write(){
        memory[comp.alu.getInstructionArg()] = comp.alu.getOutputRegister();
    }

    public int next(){
        return memory[comp.counter.getCounterRegister()];
    }

    public void write(Input input){
        memory[input.memoryLocation] = input.inputRegister;
    }

    public int length(){
        return memory.length;
    }

}
