package model;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class InstrumentSpec {

	private Map properties;

	public InstrumentSpec(Map properties) {
		if (properties == null) {
			this.properties = new HashMap();
		} else {
			this.properties = new HashMap(properties);
		}
	}

	public Object getProperty(String propertyName) {
		return properties.get(propertyName);
	}

	public Map getProperties() {
		return properties;
	}

	public boolean matches(InstrumentSpec otherSpec) {
		for (Iterator i = otherSpec.getProperties().keySet().iterator(); i.hasNext();) {
			String propertyName = (String) i.next();
			if (!properties.get(propertyName).toString().equals(otherSpec.getProperty(propertyName).toString())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		
		String result = "";
		
		for (Iterator i = properties.keySet().iterator(); i.hasNext();) {
			String propertyName = (String) i.next();
			
			//퍼포먼스에 문제가 있으니 나중에 builder로 바꿀것
			result += propertyName + " : " + properties.get(propertyName) + "\n";
		}
		
		return result;
	}
	
	public String toHTML(){
		return toString().replaceAll("(\r\n|\n)", "<br />");
	}
	
	public String toSQL(){
		String propertyNameList = "";
		String valueList = "";
		for (Iterator i = properties.keySet().iterator(); i.hasNext();) {
			String propertyName = (String) i.next();
			
			propertyNameList += propertyName + ",";
			valueList += properties.get(propertyName) + ",";
					
		}
		
		

		
		return "";
	}

	public void printProperties() {

		System.out.println(toString());
	}

}
