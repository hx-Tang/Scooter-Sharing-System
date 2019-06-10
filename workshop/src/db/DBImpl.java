package db;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.*;
import org.dom4j.xpath.*;

import org.jaxen.dom4j.*;

import storage.*;

/**
 * XML-general database operation class
 */
public class DBImpl implements DB {
	
	//path of database.
	private final String OrderXML = "./XML/Order.xml";
	private final String ScooterXML = "./XML/Scooter.xml";
	private final String StationXML = "./XML/Station.xml";
	private final String UserXML = "./XML/User.xml";
	
	// read/write lock
	private static synchronized void lock() {
		
	}
	
	// read XML
	private Document loadXML(String url) {
		lock();
		Document document;
		try {
			SAXReader reader = new SAXReader();
			document = reader.read(url);
			return document;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// write XML
	private synchronized void writeXML(Document document, String url) {
		lock();
		try (FileWriter fileWriter = new FileWriter(url)) {
		    OutputFormat format = OutputFormat.createPrettyPrint();  
		    format.setEncoding("UTF-8");  
			XMLWriter writer = new XMLWriter(fileWriter,format);
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * order相关
	 */

	// encapsulate object.
	private Order assmOrder(Element Elem) {
		Order order = new Order();
		order.setId(Integer.parseInt(Elem.attributeValue("id")));
		order.setUserid(Integer.parseInt(Elem.element("userid").getText()));
		order.setScooterid(Integer.parseInt(Elem.element("scooterid").getText()));
		order.setInitstation(Integer.parseInt(Elem.element("initstation").getText()));
		order.setInittime(Elem.element("inittime").getText());
		order.setEndstation(Integer.parseInt(Elem.element("endstation").getText()));
		order.setEndtime(Elem.element("endtime").getText());
		return order;
	}
	// all order of users.
	@Override
	public ArrayList<Order> getOrderbyUserAll(int userid) {
		// load XML
		Document document = loadXML(OrderXML);

		// read the order of all user.
		List<Node> nodes = document.selectNodes("/root//Order[userid="+userid+"]");
		if (nodes.isEmpty())
			return null;

		// encapsulate objects.
		ArrayList<Order> Orderlist = new ArrayList<Order>();

		for (Iterator<Node> iter = nodes.iterator(); iter.hasNext();) {
			Element Elem = (Element) iter.next();

			Order order = assmOrder(Elem);

			Orderlist.add(order);
		}
		return Orderlist;
	}

	// read order
	@Override
	public Order getOrder(int id) {
		// load XML
		Document document = loadXML(OrderXML);

		// read order
		Node node = document.selectSingleNode("/root//Order[@id=" + id + "]");
		if (node == null)
			return null;

		// encapsulate
		Element Elem = (Element) node;
		Order order = assmOrder(Elem);

		return order;
	}

	// the last order of user.
	@Override
	public Order getOrderbyUser(int userid) {
		// load XML
		Document document = loadXML(OrderXML);

		// read all orders of user.
		List<Node> nodes = document.selectNodes("/root//Order[userid=" + userid + "]");
		if (nodes.isEmpty())
			return null;

		// select the last order of user.
		Element Elem = (Element) nodes.get(0);
		for (Iterator<Node> iter = nodes.iterator(); iter.hasNext();) {
			Element tmpElem = (Element) iter.next();
			if (Integer.parseInt(tmpElem.attributeValue("id")) > Integer.parseInt(Elem.attributeValue("id")))
				Elem = tmpElem;
		}

		// encapsulate object.
		Order order = assmOrder(Elem);

		return order;
	}

	//read all orders.	
	public ArrayList<Order> getOrderAll() {
		// load XML
		Document document = loadXML(OrderXML);
		// read all Order node
		List<Node> nodes = document.selectNodes("/root//Order");
		if (nodes.isEmpty())
			return null;
		//encapsulate object
		ArrayList<Order> Orderlist = new ArrayList<Order>();

		for (Iterator<Node> iter = nodes.iterator(); iter.hasNext();) {
			Element Elem = (Element) iter.next();

			Order order = assmOrder(Elem);

			Orderlist.add(order);
		}
		return Orderlist;
	}

	// revise /write into  order.
	public synchronized void setOrder(Order order) {

		int id = order.getId();

		// load XML
		Document document = loadXML(OrderXML);

		// new order-0，old order has number.
		if (id == 0) {

			// get maximal order id.
			List<Node> nodes = document.selectNodes("/root//Order");
			int lastid = 1;
			for (Iterator<Node> iter = nodes.iterator(); iter.hasNext();) {
				Element tmpElem = (Element) iter.next();
				int tmpid = Integer.parseInt(tmpElem.attributeValue("id"));
				if (tmpid > lastid)
					lastid = tmpid;
			}
			lastid += 1;

			// add order.
			Element rootElm = document.getRootElement();
			Element OrderElm = rootElm.addElement("Order");
			OrderElm.addAttribute("id", "" + lastid);
			OrderElm.addElement("userid").setText("" + order.getUserid());
			OrderElm.addElement("scooterid").setText("" + order.getScooterid());
			OrderElm.addElement("initstation").setText("" + order.getInitstation());
			OrderElm.addElement("inittime").setText("" + order.getInittime());
			OrderElm.addElement("endstation").setText("" + order.getEndstation());
			OrderElm.addElement("endtime").setText("" + order.getEndtime());

		} else {
			// select corresponding Order node.
			Node node = document.selectSingleNode("/root//Order[@id=" + id + "]");
			// revise
			Element Elem = (Element) node;
			Elem.element("endstation").setText("" + order.getEndstation());
			Elem.element("endtime").setText(order.getEndtime());
		}
		// write back
		writeXML(document, OrderXML);
	}

	/**
	 * Scooter
	 */
	private Scooter assmScooter(Element Elem) {
		Scooter scooter = new Scooter();
		scooter.setId(Integer.parseInt(Elem.attributeValue("id")));
		scooter.setStatus(Integer.parseInt(Elem.element("status").getText()));
		return scooter;
	}

	// read all Scooter

	public ArrayList<Scooter> getScooterAll() {
		// load XML
		Document document = loadXML(ScooterXML);
		// select all Scooter node.
		List<Node> nodes = document.selectNodes("/root//Scooter");
		// encapsulate object.
		ArrayList<Scooter> Scooterlist = new ArrayList<Scooter>();

		for (Iterator<Node> iter = nodes.iterator(); iter.hasNext();) {
			Element Elem = (Element) iter.next();
			Scooter scooter = assmScooter(Elem);
			Scooterlist.add(scooter);
		}
		return Scooterlist;
	}

	// read one of the Scooter
	
	public Scooter getScooter(int id) {
		// load XML
		Document document = loadXML(ScooterXML);
		// select one Scooter node.
		Node node = document.selectSingleNode("/root//Scooter[@id=" + id + "]");

		Element Elem = (Element) node;
		Scooter scooter = assmScooter(Elem);

		return scooter;
	}

	// revise Scooter
	
	public synchronized void setScooter(Scooter scooter) {
		int id = scooter.getId();
		// load XML
		Document document = loadXML(ScooterXML);
		// select Scooter node.
		Node node = document.selectSingleNode("/root//Scooter[@id=" + id + "]");
		Element Elem = (Element) node;
		Elem.element("status").setText("" + scooter.getStatus());
		// write back
		writeXML(document, ScooterXML);
	}

	/**
	 * Slot
	 */
	private Slot assmSlot(Element Elem) {
		Slot slot = new Slot();
		slot.setId(Integer.parseInt(Elem.attributeValue("id")));
		slot.setStation(Integer.parseInt(Elem.element("station").getText()));
		slot.setStatus(Integer.parseInt(Elem.element("status").getText()));
		return slot;
	}

	@Override
	public ArrayList<Slot> getSlotAll() {
		// load XML
		Document document = loadXML(StationXML);
		// select all Slot node.
		List<Node> nodes = document.selectNodes("/root/Station//slot");
		// encapsulate object.
		ArrayList<Slot> Slotlist = new ArrayList<Slot>();

		for (Iterator<Node> iter = nodes.iterator(); iter.hasNext();) {
			Element Elem = (Element) iter.next();
			Slot slot = assmSlot(Elem);
			Slotlist.add(slot);
		}
		return Slotlist;
	}

	/**
	 * Station
	 */
	private Station assmStation(Element Elem) {
		Station station = new Station();
		station.setId(Integer.parseInt(Elem.attributeValue("id")));
		return station;
	}

	// read all information of station
	@Override
	public ArrayList<Station> getStationAll() {
		// load XML
		Document document = loadXML(StationXML);
		// select all Station node.
		List<Node> nodes = document.selectNodes("/root//Station");

		ArrayList<Station> Stationlist = new ArrayList<Station>();

		for (Iterator<Node> iter = nodes.iterator(); iter.hasNext();) {
			Element Elem = (Element) iter.next();
			Station station = assmStation(Elem);

			// select Slot node.
			List<Node> Slotnodes = document.selectNodes("/root//Station[@id=" + station.getId() + "]//slot");
			ArrayList<Slot> Slotlist = new ArrayList<Slot>();
			for (Iterator<Node> iter1 = Slotnodes.iterator(); iter1.hasNext();) {
				Element slotElem = (Element) iter1.next();
				Slot slot = assmSlot(slotElem);
				Slotlist.add(slot);
			}
			station.setSlots(Slotlist);

			Stationlist.add(station);
		}

		return Stationlist;
	}

	// read one station's information.
	@Override
	public Station getStation(int id) {
		// load XML
		Document document = loadXML(StationXML);
		// select one Station node.
		Node node = document.selectSingleNode("/root//Station[@id=" + id + "]");

		// encapsulate station
		Element Elem = (Element) node;
		Station station = assmStation(Elem);

		// select Slot node.
		List<Node> nodes = document.selectNodes("/root//Station[@id=" + id + "]/slot");

		// encapsulate object
		ArrayList<Slot> Slotlist = new ArrayList<Slot>();

		for (Iterator<Node> iter = nodes.iterator(); iter.hasNext();) {
			Element slotElem = (Element) iter.next();
			Slot slot = assmSlot(slotElem);
			Slotlist.add(slot);
		}
		station.setSlots(Slotlist);
		return station;
	}

	// revise/write into station
	@Override
	public synchronized void setStation(Station station) {
		int id = station.getId();
		ArrayList<Slot> slots = station.getSlots();

		// load XML
		Document document = loadXML(StationXML);

		for (Iterator<Slot> iter = slots.iterator(); iter.hasNext();) {
			Slot slot = iter.next();
			Node slotnode = document.selectSingleNode("/root/Station[@id=" + id + "]//slot[@id=" + slot.getId() + "]");
			Element Elem = (Element) slotnode;
			Elem.element("status").setText("" + slot.getStatus());
		}
		// write back.
		writeXML(document, StationXML);
	}

	/**
	 * User
	 */
	private User assmUser(Element Elem) {
		User user = new User();
		user.setId(Integer.parseInt(Elem.attributeValue("id")));
		user.setEmail(Elem.element("email").getText());
		user.setName(Elem.element("name").getText());
		user.setStatus(Integer.parseInt(Elem.element("status").getText()));
		return user;
	}

	// check whether user exists.
	@Override
	public boolean hasUser(int id) {
		// load XML
		Document document = loadXML(UserXML);
		// select one user node.
		Node node = document.selectSingleNode("/root//User[@id=" + id + "]");
		if (node == null)
			return false;
		return true;
	}
	
	//read all users.
	@Override
	public ArrayList<User> getUserAll() {
		// load XML
		Document document = loadXML(UserXML);
		
		// select one user node.
		List<Node> nodes = document.selectNodes("/root//User");
		
		ArrayList<User> Userlist = new ArrayList<User>();
		
		for (Iterator<Node> iter = nodes.iterator(); iter.hasNext();) {
			Element Elem = (Element)iter.next();
			User user = assmUser(Elem);
			Userlist.add(user);
		}
		return Userlist;
	}
	//get user
	@Override
	public User getUser(int id) {
		// load XML
		Document document = loadXML(UserXML);
		// select one user node.
		Node node = document.selectSingleNode("/root//User[@id=" + id + "]");
		if (node == null)
			return null;
		Element Elem = (Element) node;
		User user = assmUser(Elem);
		return user;
	}

	// add /revise user. 
	@Override
	public synchronized void setUser(User user) {
		int id = user.getId();

		// load XML
		Document document = loadXML(UserXML);
		Node node = document.selectSingleNode("/root//User[@id=" + id + "]");
		// old user change status operation.
		if (node != null) {
			Element Elem = (Element) node;
			Elem.element("status").setText("" + user.getStatus());
		}
		// new user register.
		else {
			Element rootElm = document.getRootElement();
			Element OrderElm = rootElm.addElement("User");
			OrderElm.addAttribute("id", "" + id);
			OrderElm.addElement("name").setText("" + user.getName());
			OrderElm.addElement("email").setText("" + user.getEmail());
			OrderElm.addElement("status").setText("" + user.getStatus());
		}
		// write back.
		writeXML(document, UserXML);
	}

}
