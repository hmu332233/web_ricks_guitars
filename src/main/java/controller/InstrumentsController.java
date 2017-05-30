package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.InstrumentDAO;
import model.Instrument;
import model.InstrumentSpec;
import model.Inventory;

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
	
	@RequestMapping(value = "/instruments/search", method = RequestMethod.GET)
	public ModelAndView search(	@RequestParam(value = "builder") String builder,
								@RequestParam(value = "type") String type,
								@RequestParam(value = "topWood") String topWood,
								@RequestParam(value = "backWood") String backWood) {
		
//		System.out.println(builder);
//		System.out.println(type);
//		System.out.println(topWood);
//		System.out.println(backWood);
		
		Inventory inventory = new InstrumentDAO().selectAll();
//		inventory.printAllInstruments();
		List<Instrument> instruments = inventory.getAllInstruments();
		
	    Map properties = new HashMap();
	    
	    if( !builder.equals("Unspecified") )
	    	properties.put("builder", builder);
	    if( !type.equals("Unspecified") )
	    	properties.put("type", type);
	    if( !topWood.equals("Unspecified") )
	    	properties.put("topWood", topWood);
	    if( !backWood.equals("Unspecified") )
	    	properties.put("backWood", backWood);
	    
	    InstrumentSpec whatBryanLikes = new InstrumentSpec(properties);
	    List matchingInstruments = inventory.search(whatBryanLikes);
	    
	    for( Instrument instrument : (LinkedList<Instrument>)matchingInstruments ){
	    	instrument.printProperties();
	    }
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("instruments", matchingInstruments);
		
		return mv;
	}
	
	@RequestMapping(value = "/instruments/{id}/edit", method = RequestMethod.GET)
	public ModelAndView viewEditPage(@PathVariable(value = "id") String id) {
		
		System.out.println(id);
		
		ModelAndView mv = new ModelAndView("edit");
		return mv;
	}
	
	@RequestMapping(value = "/instruments/new", method = RequestMethod.GET)
	public String viewNewPage() {
		return "new";
	}
	
	@RequestMapping(value = "/instruments", method = RequestMethod.POST)
	public ModelAndView processAddInstrument(	@RequestParam(value = "builder") String builder,
								@RequestParam(value = "type") String type,
								@RequestParam(value = "topWood") String topWood,
								@RequestParam(value = "backWood") String backWood) {
		
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(value = "/instruments/{id}", method = RequestMethod.PUT)
	public ModelAndView processEditInstrument(	@RequestParam(value = "builder") String builder,
								@RequestParam(value = "type") String type,
								@RequestParam(value = "topWood") String topWood,
								@RequestParam(value = "backWood") String backWood) {
		
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(value = "/instruments/{id}", method = RequestMethod.DELETE)
	public ModelAndView processDeleteInstrument(	@RequestParam(value = "builder") String builder,
								@RequestParam(value = "type") String type,
								@RequestParam(value = "topWood") String topWood,
								@RequestParam(value = "backWood") String backWood) {
		
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}
