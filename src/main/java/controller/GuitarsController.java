package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuitarsController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView home() {
		System.out.println("test");

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("name", "한민웅");
		
		System.out.println("한민웅");
		
		return mv;
	}

}
