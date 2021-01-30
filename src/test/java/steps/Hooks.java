package steps;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void start() {
        BaseTest.setUp();
    }

    @After
    public void tearDown() {
        BaseTest.tearDown();
    }
}
