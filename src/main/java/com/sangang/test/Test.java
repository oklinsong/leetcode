package com.sangang.test;

import com.sangang.test.OutterClass;

public class Test {
    public void doTest(){
        OutterClass outterClass = new OutterClass();
        OutterClass.SubClass subClass = outterClass.new SubClass();
    }
}
