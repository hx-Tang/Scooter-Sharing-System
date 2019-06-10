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


class TestPayFine{
	
	@Test
	public void testPayfine() {
		assertEquals(true, sys.isblocked(161194911));
		sys.payfine(161194911);
		assertEquals(false, sys.isblocked(161194911));
	}
}