package spring.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(HelloWorldController.class);
	
	@RequestMapping("/helloWorld")
	public ModelAndView helloWorld(
			@RequestParam(defaultValue = "Maailm") String name) {
		
		String message = "Jou, " + name + "!";
		
		LOGGER.info("Premared a message - " + message);
		
		return new ModelAndView("helloworld", "message", message);
		
	} // -helloWorld
	
}
