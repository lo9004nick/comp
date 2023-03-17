package comp;

public class Counter {

    Comp comp;
    private int counterRegister = 0;

    private boolean ignoreNextClockSIgnal = false;

    public Counter(Comp comp) {
        this.comp = comp;
    }

    void advance(){
        if(ignoreNextClockSIgnal){
            ignoreNextClockSIgnal = false;
        }else {
            counterRegister++;
            if (counterRegister >= comp.memory.length()) counterRegister = 0;
            //System.out.println(counterRegister);
        }
    }


    public void setCounterRegister() {
        this.counterRegister = comp.alu.getOutputRegister();
        ignoreNextClockSIgnal = true;
    }

    public void setCounterRegisterToArg(){
        this.counterRegister = comp.alu.getInstructionArg();
        ignoreNextClockSIgnal = true;
    }

    public int getCounterRegister() {
        return counterRegister;
    }
}
