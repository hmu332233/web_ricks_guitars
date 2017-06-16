package controller;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
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

@Controller
public class InstrumentsController {

	InstrumentDAO instrumentDAO = new InstrumentDAO();

	@Autowired
	private ServletContext context;

	@RequestMapping(value = "/instruments/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam Map<String,Object> properties) {
		
		LinkedList<String> removedPropertyNames = new LinkedList<String>();
		for(String propertyName : properties.keySet()){
			if (properties.get(propertyName).toString().equals("Unspecified") || properties.get(propertyName).toString().equals("")) 
				removedPropertyNames.add(propertyName);
		}

		for(String propertyName : removedPropertyNames)
			properties.remove(propertyName);
		
		new InstrumentSpec(properties).printProperties();

		instrumentDAO.setConnection((Connection) context.getAttribute("conn"));
		List<Instrument> matchingInstruments = instrumentDAO.findByInstrumentSpec(new InstrumentSpec(properties));
		
		ModelAndView mv = new ModelAndView("search");
		mv.addObject("instruments", matchingInstruments);

		return mv;
	}

	@RequestMapping(value = "/instruments", method = RequestMethod.GET)
	public ModelAndView viewIndexPage() {

		ModelAndView mv = new ModelAndView("index");
		
		instrumentDAO.setConnection((Connection) context.getAttribute("conn"));
		mv.addObject("instruments", instrumentDAO.findAll());
		
		return mv;
	}

	@RequestMapping(value = "/instruments/{serialNumber}/edit", method = RequestMethod.GET)
	public ModelAndView viewEditPage(@PathVariable(value = "serialNumber") String serialNumber) {

		instrumentDAO.setConnection((Connection) context.getAttribute("conn"));
		Instrument instrument = instrumentDAO.findOne(serialNumber);

		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("instrument", instrument);
		return mv;
	}

	@RequestMapping(value = "/instruments/new", method = RequestMethod.GET)
	public String viewNewPage() {
		return "new";
	}

	@RequestMapping(value = "/instruments", method = RequestMethod.POST)
	public String processAddInstrument(	@RequestParam(value = "serialNumber") String serialNumber,
												@RequestParam(value = "price") double price,
												@RequestParam Map<String,Object> properties) {

		// double 형 타입 안시켜서 넘어오면 버그있음 고칠 것
		Instrument instrument = new Instrument(serialNumber, price, new InstrumentSpec(properties));

		instrumentDAO.setConnection((Connection) context.getAttribute("conn"));
		instrumentDAO.insert(instrument);

		System.out.println(serialNumber + " 생성되었습니다");

		return "redirect:/instruments";
	}

	@RequestMapping(value = "/instruments/{serialNumber}", method = RequestMethod.PUT)
	public String processEditInstrument(	@PathVariable(value = "serialNumber") String serialNumber,
											@RequestParam(value = "price") double price,
											@RequestParam Map<String,Object> properties) {

		// double 형 타입 안시켜서 넘어오면 버그있음 고칠 것
		Instrument instrument = new Instrument(serialNumber, price, new InstrumentSpec(properties));

		instrumentDAO.setConnection((Connection) context.getAttribute("conn"));
		instrumentDAO.update(instrument);
		
		System.out.println(serialNumber + "가 수정되었습니다");
		
		return "redirect:/instruments";
	}

	@RequestMapping(value = "/instruments/{serialNumber}", method = RequestMethod.DELETE)
	public String processDeleteInstrument(@PathVariable(value = "serialNumber") String serialNumber) {

		System.out.println(serialNumber + "가 삭제되었습니다");
		
		instrumentDAO.setConnection((Connection) context.getAttribute("conn"));
		instrumentDAO.delete(serialNumber);

		return "redirect:/instruments";
	}
}
