package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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

	public Instrument findOne(String serialNumber) {

	    try {
	      Statement stmt = connection.createStatement();
	      ResultSet rs = stmt.executeQuery(
	          "SELECT * FROM INSTRUMENTS WHERE serialNumber='"+serialNumber+"'");    
	      
	      Instrument instrument;
	      
	      if (rs.next()) {
	    	  instrument = getInstrumentFromResultSet(rs);
	      } else {
	          instrument= null;
	      }
	      
	      rs.close();
		  stmt.close();

		  return instrument;
		  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    
	    return null;
	}

	public List<Instrument> findAll() {

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM INSTRUMENTS");

			ArrayList<Instrument> instruments = new ArrayList<Instrument>();

			while (rs.next()) {
				Instrument instrument = getInstrumentFromResultSet(rs);
				instruments.add(instrument);
			}

			rs.close();
			stmt.close();
			
			return instruments;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Instrument> findByInstrumentSpec(InstrumentSpec searchSpec) {
	
		List<Instrument> instruments = findAll();
		
		List matchingInstruments = new LinkedList();
		for(Instrument instrument : instruments ) {
			if (instrument.getSpec().matches(searchSpec))
				matchingInstruments.add(instrument);
		}
	
		return matchingInstruments;
	}

	public void update(Instrument instrument) {

		String serialNumber = instrument.getSerialNumber();
		double price = instrument.getPrice();
		InstrumentSpec spec = instrument.getSpec();

		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(
					"UPDATE INSTRUMENTS SET serialNumber=?,price=?," + "instrumentType=?,builder=?,model=?,"
							+ "type=?,numStrings=?,topWood=?,backWood=?" + " WHERE serialNumber=?");
			stmt.setString(1, serialNumber);
			stmt.setDouble(2, price);
			stmt.setString(3, (String) spec.getProperty("instrumentType"));
			stmt.setString(4, (String) spec.getProperty("builder"));
			stmt.setString(5, (String) spec.getProperty("model"));
			stmt.setString(6, (String) spec.getProperty("type"));
			stmt.setString(7, (String) spec.getProperty("numStrings"));
			stmt.setString(8, (String) spec.getProperty("topWood"));
			stmt.setString(9, (String) spec.getProperty("backWood"));
			stmt.setString(10, serialNumber);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
		}
	}

	public void delete(String serialNumber) {

		PreparedStatement stmt = null;
		try {
			stmt = connection
					.prepareStatement( "DELETE FROM INSTRUMENTS"
									+ " WHERE serialNumber='"+serialNumber+"'");

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
		}
	}

	public int insert(Instrument instrument) {

		String serialNumber = instrument.getSerialNumber();
		double price = instrument.getPrice();
		InstrumentSpec spec = instrument.getSpec();

		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement("INSERT INTO "
					+ "INSTRUMENTS(serialNumber,price,instrumentType,builder,model,type,numStrings,topWood,backWood)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)");

			stmt.setString(1, serialNumber);
			stmt.setDouble(2, price);
			stmt.setString(3, (String) spec.getProperty("instrumentType"));
			stmt.setString(4, (String) spec.getProperty("builder"));
			stmt.setString(5, (String) spec.getProperty("model"));
			stmt.setString(6, (String) spec.getProperty("type"));
			stmt.setString(7, (String) spec.getProperty("numStrings"));
			stmt.setString(8, (String) spec.getProperty("topWood"));
			stmt.setString(9, (String) spec.getProperty("backWood"));
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
		}
		return 0;
	}

	
	private Instrument getInstrumentFromResultSet(ResultSet rs) throws SQLException{

		Map properties = new HashMap();
		properties.put("instrumentType", rs.getString("instrumentType"));
		properties.put("builder", rs.getString("builder"));
		properties.put("model", rs.getString("model"));
		properties.put("type", rs.getString("type"));
		properties.put("numStrings", rs.getString("numStrings"));
		properties.put("topWood", rs.getString("topWood"));
		properties.put("backWood", rs.getString("backWood"));
		
		return new Instrument(rs.getString("serialNumber"), rs.getDouble("price"),new InstrumentSpec(properties));
	}
}
