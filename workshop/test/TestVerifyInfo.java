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

class TestVerifyInfo{
	@Test
	public final void testVerifyInfo() {
		boolean a,b;
		a= sys.verifyInfo("161194911","xxx","xxx@qmul.ac.uk");  
		b= sys.verifyInfo("20162120", "yang", "yyy@qmul.ac.uk");  
		assertEquals(true,a);
		assertEquals(false,b);
	}
}