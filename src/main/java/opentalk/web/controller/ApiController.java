package opentalk.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ivan Chan on 11/17/2016.
 */

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public abstract class ApiController {
}
