package me.msc.cucumber.features.overview;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by jliu on 3/18/2015.
 */
public class HookStepDef {
    @Before("@Hooks")
    public void setup() {
        System.out.println("Hook Setup");
    }

    @After("@Hooks")
    public void teardown() {
        System.out.println("Hook Teardown");
    }

    @Before("@Invalid")
    public void inValidSetup(){
        System.out.println("Invalid setup");
    }

    @After("@Invalid")
    public void invalidTearDown(){
        System.out.println("Invalid teardown");
    }

    @Before({"@Hooks", "@Invalid"})
    public void invalidHookSetup(){
        System.out.println("Invalid Hook Setup");
    }

    @After({"@Hooks", "@Invalid"})
    public void invalidHookTearDown(){
        System.out.println("Invalid Hook Teardown");
    }
}
