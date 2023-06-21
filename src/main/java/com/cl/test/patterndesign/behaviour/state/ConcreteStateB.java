package com.cl.test.patterndesign.behaviour.state;

public class ConcreteStateB extends State{
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}
