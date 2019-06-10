package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import db.DBImpl;
import main.SystemImpl;
import storage.Station;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestIsEmpty{
	
	@Test
	public final void testIsEmpty() {
		DBImpl db = new DBImpl();
		Station station =db.getStation(1);
		int a;
		a=sys.isEmpty(station);
		assertEquals(2,a);
	}
}

