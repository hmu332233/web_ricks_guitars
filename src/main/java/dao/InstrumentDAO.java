package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Builder;
import model.Instrument;
import model.InstrumentSpec;
import model.InstrumentType;
import model.Inventory;
import model.Type;
import model.Wood;

public class InstrumentDAO {
	Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Inventory selectAll() {
		Inventory inventory = new Inventory();
		initializeInventory(inventory);
		return inventory;
	}

	private static void initializeInventory(Inventory inventory) {
		Map properties = new HashMap();
		properties.put("instrumentType", InstrumentType.GUITAR);
		properties.put("builder", Builder.COLLINGS);
		properties.put("model", "CJ");
		properties.put("type", Type.ACOUSTIC);
		properties.put("numStrings", 6);
		properties.put("topWood", Wood.INDIAN_ROSEWOOD);
		properties.put("backWood", Wood.SITKA);
		inventory.addInstrument("11277", 3999.95, new InstrumentSpec(properties));

		properties.put("builder", Builder.MARTIN);
		properties.put("model", "D-18");
		properties.put("topWood", Wood.MAHOGANY);
		properties.put("backWood", Wood.ADIRONDACK);
		inventory.addInstrument("122784", 5495.95, new InstrumentSpec(properties));

		properties.put("builder", Builder.FENDER);
		properties.put("model", "Stratocastor");
		properties.put("type", Type.ELECTRIC);
		properties.put("topWood", Wood.ALDER);
		properties.put("backWood", Wood.ALDER);
		inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(properties));
		inventory.addInstrument("V9512", 1549.95, new InstrumentSpec(properties));

		properties.put("builder", Builder.GIBSON);
		properties.put("model", "Les Paul");
		properties.put("topWood", Wood.MAPLE);
		properties.put("backWood", Wood.MAPLE);
		inventory.addInstrument("70108276", 2295.95, new InstrumentSpec(properties));

		properties.put("model", "SG '61 Reissue");
		properties.put("topWood", Wood.MAHOGANY);
		properties.put("backWood", Wood.MAHOGANY);
		inventory.addInstrument("82765501", 1890.95, new InstrumentSpec(properties));

		properties.put("instrumentType", InstrumentType.MANDOLIN);
		properties.put("type", Type.ACOUSTIC);
		properties.put("model", "F-5G");
		properties.put("backWood", Wood.MAPLE);
		properties.put("topWood", Wood.MAPLE);
		properties.remove("numStrings");
		inventory.addInstrument("9019920", 5495.99, new InstrumentSpec(properties));

		properties.put("instrumentType", InstrumentType.BANJO);
		properties.put("model", "RB-3 Wreath");
		properties.remove("topWood");
		properties.put("numStrings", 5);
		inventory.addInstrument("8900231", 2945.95, new InstrumentSpec(properties));
	}

	// 디비코드 작성
	public List<Instrument> select() throws Exception {
		
		Statement stmt = null;
	    ResultSet rs = null;

	    try {
	      stmt = connection.createStatement();
	      rs = stmt.executeQuery("SELECT * FROM INSTRUMENTS");

	      ArrayList<Instrument> instruments = new ArrayList<Instrument>();
	      
	      while(rs.next()) {
	  		Map properties = new HashMap();
			properties.put("instrumentType", rs.getString("instrumentType"));
			properties.put("builder", rs.getString("builder"));
			properties.put("model", rs.getString("model"));
			properties.put("type", rs.getString("type"));
			properties.put("numStrings", rs.getString("numStrings"));
			properties.put("topWood", rs.getString("topWood"));
			properties.put("backWood", rs.getString("backWood"));
			instruments.add(new Instrument(rs.getString("serialNumber"), rs.getDouble("price"), new InstrumentSpec(properties)));
	      }
	      
	      return instruments;

	    } catch (Exception e) {
	      throw e;
	    } finally {
	      try {if (rs != null) rs.close();} catch(Exception e) {}
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	    }
		
	}

	public List<Instrument> select(InstrumentSpec instrumentSpec) {
		return new Inventory().getAllInstruments();
	}

	public void update(Instrument instrument) {

	}

	public void delete() {

	}

	public void insert(Instrument instrument) {

		String serialNumber = instrument.getSerialNumber();
		double price = instrument.getPrice();
		InstrumentSpec spec = instrument.getSpec();

		// try {
		// stmt = connection.prepareStatement(
		// "INSERT INTO
		// INSTRUMENTS(serialNumber,price,instrumentType,builder,model,type,numStrings,topWood,backWood)"
		// + " VALUES (?,?,?,?,?,?,?,?,?)"));
		// stmt.setString(1, serialNumber);
		// stmt.setString(2, price);
		// stmt.setString(3, spec.get("instrumentType"));
		// stmt.setString(4, spec.get("builder"));
		// stmt.setString(5, spec.get("model"));
		// stmt.setString(6, spec.get("type"));
		// stmt.setString(7, spec.get("numStrings"));
		// stmt.setString(8, spec.get("topWood"));
		// stmt.setString(9, spec.get("backWood"));
		// return stmt.executeUpdate();
		// }
	}

}
