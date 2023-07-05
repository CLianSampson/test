package com.cl.test.patterndesign.behaviour.state;

public class Test {

    public static void main(String[] args) {
        Context c = new Context(new ConcreteStateA());

        c.request();
        c.request();
        c.request();
        c.request();
        c.request();
        c.request();

    }

}
