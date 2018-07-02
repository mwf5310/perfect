package com.suite;

import com.test.test1;
import com.test.test2;
import com.test.test3;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;




    @RunWith(Suite.class)
    @Suite.SuiteClasses({

            test1.class,
            test2.class,
            test3.class
    })
/*
@Test
public void fun12(){
        System.out.println("This is test9 @Test fun1 ");
        }
        */

    public class suite {

    }


