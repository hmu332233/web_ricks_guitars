package controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InstrumentsController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView home() {
		System.out.println("test");

		ModelAndView mv = new ModelAndView("index");
		
		
		ArrayList<String> list = new ArrayList<String>();

		list.add("test");
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");
		
		
		mv.addObject("name", "한민웅");
		mv.addObject("list", list);
		
		return mv;
	}

}
