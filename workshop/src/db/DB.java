package db;

import java.util.ArrayList;

import storage.*;

public interface DB {
	
//	public String readXML();
//	public String writeXML();
	/**
	 * Order
	 */
	public Order getOrder(int id); //read order by id.
	public Order getOrderbyUser(int userid); //read the latest order of user,pass user id as parameter.
	ArrayList<Order>  getOrderAll(); //read all orders.
	public ArrayList<Order> getOrderbyUserAll(int userid);//read all orders of one user,pass user id as parameter.
	public void setOrder(Order order);//save order
	
	/**
	 * Scooter
	 */
	public Scooter getScooter(int id);//read scooter by id.
	public ArrayList<Scooter> getScooterAll();//read all scooter.
	public void setScooter(Scooter scooter);//save scooter.
	
	/**
	 * Slot
	 */
	public ArrayList<Slot> getSlotAll(); //read all slots：read slot objects from arraylist of corresponding station,and provide an api for console to display.
	
	/**
	 * Station
	 */
	public Station getStation(int id);//read station by id
	public ArrayList<Station> getStationAll();//read all stations.
	public void setStation(Station station);//save station.
	
	/**
	 * user
	 */
	public boolean hasUser(int id);//check whether user exists.
	public User getUser(int id);//read user by id.
	public ArrayList<User> getUserAll();//read all users.	
	public void setUser(User user); //save user	.
	
}
