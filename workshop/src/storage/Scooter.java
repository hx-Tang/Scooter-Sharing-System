package storage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Scooter {
	private int id;
	private int status; //0=available， other number=be used by other users
	
	public Scooter(int id, int status) {
		super();
		this.id = id;
		this.status = status;
	}
	public Scooter() {
		// TODO 
	}
	public String toString() {
		return "\nid="+id+"\nstatus="+status;
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
