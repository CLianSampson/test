package com.cl.test.patterndesign.behaviour.state;

public class Context {

    private State state;

    public Context(State state){
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("当前状态: " + state.getClass());
    }

    public void request(){
        state.handle(this);
    }
}
