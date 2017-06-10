package controller;

import java.sql.Connection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	InstrumentDAO instrumentDAO = new InstrumentDAO();
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping(value = "/instruments/search", method = RequestMethod.GET)
	public ModelAndView search(	@RequestParam(value = "builder") String builder,
								@RequestParam(value = "type") String type,
								@RequestParam(value = "topWood") String topWood,
								@RequestParam(value = "backWood") String backWood) {
		
		instrumentDAO.setConnection((Connection)context.getAttribute("conn"));
		try {
			instrumentDAO.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(builder);
		System.out.println(type);
		System.out.println(topWood);
		System.out.println(backWood);
		
		Inventory inventory = new InstrumentDAO().selectAll();

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
	    
	    
	    System.out.println(whatBryanLikes.toSQL());
//	    for( Instrument instrument : (LinkedList<Instrument>)matchingInstruments ){
//	    	instrument.printProperties();
//	    }
		
		ModelAndView mv = new ModelAndView("search");
		mv.addObject("instruments", matchingInstruments);
		
		return mv;
	}
	
	@RequestMapping(value = "/instruments", method = RequestMethod.GET)
	public ModelAndView viewIndexPage() {
		
		Inventory inventory = new InstrumentDAO().selectAll();
//		inventory.printAllInstruments();
		List<Instrument> instruments = inventory.getAllInstruments();
		instrumentDAO.setConnection((Connection)context.getAttribute("conn"));
		
		ModelAndView mv = new ModelAndView("index");
		try {
			mv.addObject("instruments", instrumentDAO.select());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/instruments/{serialNumber}/edit", method = RequestMethod.GET)
	public ModelAndView viewEditPage(@PathVariable(value = "serialNumber") String serialNumber) {
		
		System.out.println(serialNumber);
		
		ModelAndView mv = new ModelAndView("edit");
		return mv;
	}
	
	@RequestMapping(value = "/instruments/new", method = RequestMethod.GET)
	public String viewNewPage() {
		return "new";
	}
	
	@RequestMapping(value = "/instruments", method = RequestMethod.POST)
	public ModelAndView processAddInstrument(	@RequestParam(value = "serialNumber") String serialNumber,
												@RequestParam(value = "model") String model,
												@RequestParam(value = "builder") String builder,
												@RequestParam(value = "type") String type,
												@RequestParam(value = "topWood") String topWood,
												@RequestParam(value = "backWood") String backWood) {
		
		System.out.println("생성되었습니다");
		
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(value = "/instruments/{serialNumber}", method = RequestMethod.PUT)
	public String processEditInstrument(	@PathVariable(value = "serialNumber") String serialNumber) {

		System.out.println(serialNumber + "가 수정되었습니다");
		
		return "redirect:/instruments";
	}
	
	@RequestMapping(value = "/instruments/{serialNumber}", method = RequestMethod.DELETE)
	public String processDeleteInstrument(@PathVariable(value = "serialNumber") String serialNumber) {
		
		System.out.println(serialNumber + "가 삭제되었습니다");
		
		return "redirect:/instruments";
	}
}
