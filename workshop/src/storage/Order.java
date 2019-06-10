package storage;

public class Order {
	private int id = 0;
	private int userid = 2016213111;
	private int scooterid = 1;// scooter id
	private int initstation = 1;// initial station
	private String inittime = "2019.3.17/8:00";// initial time
	private int endstation = 1;// end station
	private String endtime = "2019.3.17/8:30";// end time

	public Order(int userid, int scooterid, int initstation, String inittime) {
		super();
		this.userid = userid;
		this.scooterid = scooterid;
		this.initstation = initstation;
		this.inittime = inittime;
		this.endstation = 0;
		this.endtime = "";
	}

	public Order() {

	}

	public String toString() {
		return "id=" + id + "\nuserid=" + userid + "\nscooterid=" + scooterid + "\ninitstation=" + initstation + "\ninittime="
				+ inittime + "\nendstation=" + endstation + "\nendtime=" + endtime;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param string
	 *            
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * @return scooterid
	 */
	public int getScooterid() {
		return scooterid;
	}

	/**
	 * @param scooterid
	 *            
	 */
	public void setScooterid(int scooterid) {
		this.scooterid = scooterid;
	}

	/**
	 * @return initstation
	 */
	public int getInitstation() {
		return initstation;
	}

	/**
	 * @param initstation
	 *            
	 */
	public void setInitstation(int initstation) {
		this.initstation = initstation;
	}

	/**
	 * @return inittime
	 */
	public String getInittime() {
		return inittime;
	}

	/**
	 * @param inittime
	 *            
	 */
	public void setInittime(String inittime) {
		this.inittime = inittime;
	}

	/**
	 * @return endstation
	 */
	public int getEndstation() {
		return endstation;
	}

	/**
	 * @param endstation
	 *            
	 */
	public void setEndstation(int endstation) {
		this.endstation = endstation;
	}

	/**
	 * @return endtime
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * @param endtime
	 *           
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

}
