package coding.challenge.steps;

import coding.challenge.config.GlobalConfig;
import io.cucumber.java.Before;


public class ConfigHook {

    @Before
    public void setUpFramework(){
        GlobalConfig.setUp();
    }
}
