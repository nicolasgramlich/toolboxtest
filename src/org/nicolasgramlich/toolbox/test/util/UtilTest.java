package org.nicolasgramlich.toolbox.test.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.nicolasgramlich.toolbox.util.Util;


/**
 * @author Nicolas Gramlich
 * @since Nov 20, 2012
 */
public class UtilTest {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	@Test
	public void testInstantiate() {
		new UtilTest();
	}

	@Test
	public void testCreate() {
		Assert.assertEquals(0, Util.getBitLength(0));

		Assert.assertEquals(1, Util.getBitLength(1));

		Assert.assertEquals(2, Util.getBitLength(2));

		Assert.assertEquals(2, Util.getBitLength(3));
		Assert.assertEquals(3, Util.getBitLength(4));

		Assert.assertEquals(3, Util.getBitLength(7));
		Assert.assertEquals(4, Util.getBitLength(8));

		Assert.assertEquals(4, Util.getBitLength(15));
		Assert.assertEquals(5, Util.getBitLength(16));

		Assert.assertEquals(5, Util.getBitLength(31));
		Assert.assertEquals(6, Util.getBitLength(32));

		Assert.assertEquals(6, Util.getBitLength(63));
		Assert.assertEquals(7, Util.getBitLength(64));

		Assert.assertEquals(7, Util.getBitLength(127));
		Assert.assertEquals(8, Util.getBitLength(128));

		Assert.assertEquals(8, Util.getBitLength(255));
		Assert.assertEquals(9, Util.getBitLength(256));
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
