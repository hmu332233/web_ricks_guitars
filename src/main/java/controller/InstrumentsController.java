package controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.InstrumentDAO;
import model.*;

@Controller
public class InstrumentsController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		
		Inventory inventory = new InstrumentDAO().selectAll();
//		inventory.printAllInstruments();
		List<Instrument> instruments = inventory.getAllInstruments();
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("instruments", instruments);
		
		return mv;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(	@RequestParam(value = "builder") String builder,
								@RequestParam(value = "type") String type,
								@RequestParam(value = "topWood") String topWood,
								@RequestParam(value = "backWood") String backWood) {
		
		System.out.println(builder);
		System.out.println(type);
		System.out.println(topWood);
		System.out.println(backWood);
		
		Inventory inventory = new InstrumentDAO().selectAll();
		List<Instrument> instruments = inventory.getAllInstruments();
		
		HashMap properties = new HashMap();
		properties.put("builder", builder);
	    properties.put("type", type);
	    properties.put("topWood", topWood);
	    properties.put("backWood", backWood);
	    InstrumentSpec whatBryanLikes = new InstrumentSpec(properties);
	    List matchingInstruments = inventory.search(whatBryanLikes);
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("instruments", matchingInstruments);
		
		return mv;
	}
	
	

}
