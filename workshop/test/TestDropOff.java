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


class TestDropOff{
	
	@Test
	public void testDropOff() {
		sys.dropOff(161194911,9,3,2);
		 
	}

}
