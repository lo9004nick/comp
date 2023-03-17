package comp;

public class ALU {


    Comp comp;
    private int registerA = 0;
    private int registerB = 0;
    private int outputRegister = 0;

    private int instructionArg = 0;

    private int instruction = 0;

    private int state = 0;

    public ALU(Comp comp) {
        this.comp = comp;
    }

    void doSomething() {

        if (state == 0) {
            instruction = comp.memory.next();
            //System.out.println(instruction);
            state = 1;
        } else {
            instructionArg = comp.memory.next();
            //System.out.println(instructionArg);
            state = 0;

            switch (instruction) {
                case 0:
                    break;
                case 1:
                    comp.memory.write();
                    break;
                case 2:
                    registerA = comp.memory.read();
                    break;
                case 3:
                    registerB = comp.memory.read();
                    break;
                case 4:
                    registerA = outputRegister;
                    break;
                case 5:
                    registerB = outputRegister;
                    break;
                case 6:
                    registerA = registerB;
                    break;
                case 7:
                    registerB = registerA;
                    break;
                case 8:
                    registerA = instructionArg;
                    break;
                case 9:
                    registerB = instructionArg;
                    break;
                case 10:
                    outputRegister =  (registerA + registerB);
                    break;
                case 11:
                    outputRegister =  (registerA - registerB);
                    break;
                case 12:
                    outputRegister =  (registerA & registerB);
                    break;
                case 13:
                    outputRegister =  (registerA ^ registerB);
                    break;
                case 14:
                    outputRegister =  (registerA | registerB);
                    break;
                case 15:
                    outputRegister = registerA ;
                    break;
                case 16:
                    outputRegister = registerB;
                    break;
                case 17:
                    registerA = comp.counter.getCounterRegister();
                    break;
                case 18:
                    comp.counter.setCounterRegister();
                    break;
                case 19:
                    comp.counter.setCounterRegisterToArg();
                    break;
                case 20:
                    if(outputRegister == 0) comp.counter.setCounterRegisterToArg();
                    break;
                case 21:
                    comp.clock.halt();
                    break;
            }
            //System.out.printf("A:%d   B:%d   O:%d", registerA, registerB, outputRegister);
            //System.out.println();
        }
    }


    public int getRegisterA() {
        return registerA;
    }

    public void setRegisterA(int registerA) {
        this.registerA = registerA;
    }

    public int getRegisterB() {
        return registerB;
    }

    public void setRegisterB(int registerB) {
        this.registerB = registerB;
    }

    public int getOutputRegister() {
        return outputRegister;
    }

    public void setOutputRegister(int outputRegister) {
        this.outputRegister = outputRegister;
    }

    public int getInstructionArg() {
        return instructionArg;
    }

    public void setInstructionArg(int instructionArg) {
        this.instructionArg = instructionArg;
    }

    public int getInstruction() {
        return instruction;
    }

    public void setInstruction(int instruction) {
        this.instruction = instruction;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
