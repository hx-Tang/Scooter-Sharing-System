package storage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Slot {
	private int id;
	private int station;//in which station
	private int status; //0=empty，other number=scooter id
	
	public Slot(int id, char station, int status) {
		super();
		this.id = id;
		this.station = station;
		this.status = status;
	}

	public Slot() {
		// TODO 
	}
	
	public String toString() {
		return "\nid="+id+"\nstation="+station+"\nstatus="+status;
	}
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Station
	 */
	public int getStation() {
		return station;
	}

	/**
	 * @param Station 
	 */
	public void setStation(int station) {
		this.station = station;
	}

	/**
	 * @return status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status 
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	

	
}
