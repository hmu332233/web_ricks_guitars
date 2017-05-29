package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.InstrumentDAO;
import model.Instrument;
import model.Inventory;

@Controller
public class InstrumentsController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView home() {
		
		Inventory inventory = new InstrumentDAO().selectAll();
		inventory.printAllInstruments();
		List<Instrument> instruments = inventory.getAllInstruments();
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("instruments", instruments);
		
		return mv;
	}

}
