package opentalk.web.controller;

import opentalk.domainmodel.InputObject;
import opentalk.domainmodel.OutputObject;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ivanchan on 29/11/2016.
 */
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController {
    //@MessageMapping("/hello")
    //@SendTo("/topic/greetings")
    public OutputObject greeting(InputObject input) throws Exception {
        //Thread.sleep(1000);
        final OutputObject output = new OutputObject();
        output.setOutputField(input.getInputField());
        return output;
    }
                                 
                                 
}
