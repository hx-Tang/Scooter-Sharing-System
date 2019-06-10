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


class TestRegister {

	@Test
	public final void testRegister() {
		sys.register(161194911, "yang", "xxx@qmul.ac.uk");//not registe
		sys.register(161191111, "yang", "xxx@qmul.ac.uk");//has registerd
	}
	
}
