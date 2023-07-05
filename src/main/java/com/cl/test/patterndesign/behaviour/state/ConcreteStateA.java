package com.cl.test.patterndesign.behaviour.state;

public class ConcreteStateA extends State{
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateB());
    }
}
