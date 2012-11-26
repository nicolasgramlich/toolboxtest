package org.nicolasgramlich.toolbox.test.adt.data;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.nicolasgramlich.toolbox.adt.data.BitVector;


/**
 * @author Nicolas Gramlich
 * @since Nov 20, 2012
 */
public class BitVectorTest {
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
	public void testConstructorByteMultiple() {
		final BitVector bitVector = new BitVector(8);

		Assert.assertEquals(8, bitVector.getSize());
		Assert.assertEquals(1, bitVector.getByteSize());
	}

	@Test
	public void testConstructorNonByteMultiple() {
		final BitVector bitVector = new BitVector(7);

		Assert.assertEquals(7, bitVector.getSize());
		Assert.assertEquals(1, bitVector.getByteSize());
	}

	@Test
	public void testConstructorByteArray() {
		final byte[] bitData = { BitVectorTest.parseByte("11111111"), BitVectorTest.parseByte("11111111") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(2 * Byte.SIZE, bitVector.getSize());
		Assert.assertEquals(2, bitVector.getByteSize());
	}

	@Test(expected = NullPointerException.class)
	public void testConstructorByteArrayNull() {
		new BitVector(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorByteArrayTooSmall() {
		final byte[] bitData = { BitVectorTest.parseByte("11111111"), BitVectorTest.parseByte("11111111") };

		new BitVector(1 + 2 * Byte.SIZE, bitData);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorByteArrayTooLarge() {
		final byte[] bitData = { BitVectorTest.parseByte("11111111"), BitVectorTest.parseByte("11111111") };

		new BitVector(1 * Byte.SIZE, bitData);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetBitTooLow() {
		final byte[] bitData = { BitVectorTest.parseByte("11111111"), BitVectorTest.parseByte("11111111") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.getBit(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetBitTooHigh() {
		final byte[] bitData = { BitVectorTest.parseByte("11111111"), BitVectorTest.parseByte("11111111") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.getBit(1 + 2 * Byte.SIZE);
	}

	@Test
	public void testGetBitAllFalse() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(0));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(1));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(2));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(3));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(4));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(5));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(6));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(7));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(8));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(9));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(10));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(11));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(12));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(13));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(14));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(15));
	}

	@Test
	public void testGetBitAllTrue() {
		final byte[] bitData = { BitVectorTest.parseByte("11111111"), BitVectorTest.parseByte("11111111") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(0));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(1));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(2));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(3));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(4));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(5));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(6));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(7));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(8));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(9));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(10));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(11));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(12));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(13));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(14));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(15));
	}

	@Test
	public void testGetBit() {
		final byte[] bitData = { BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(0));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(1));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(2));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(3));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(4));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(5));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(6));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(7));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(8));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(9));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(10));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(11));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(12));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(13));
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(14));
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(15));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetBitTooLow() {
		final byte[] bitData = { BitVectorTest.parseByte("11111111"), BitVectorTest.parseByte("11111111") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBit(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetBitTooHigh() {
		final byte[] bitData = { BitVectorTest.parseByte("11111111"), BitVectorTest.parseByte("11111111") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBit(1 + 2 * Byte.SIZE);
	}

	@Test
	public void testSetBit() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(0));
		bitVector.setBit(0, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(0));
		bitVector.setBit(0, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(0));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(1));
		bitVector.setBit(1, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(1));
		bitVector.setBit(1, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(1));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(2));
		bitVector.setBit(2, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(2));
		bitVector.setBit(2, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(2));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(3));
		bitVector.setBit(3, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(3));
		bitVector.setBit(3, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(3));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(4));
		bitVector.setBit(4, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(4));
		bitVector.setBit(4, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(4));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(5));
		bitVector.setBit(5, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(5));
		bitVector.setBit(5, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(5));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(6));
		bitVector.setBit(6, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(6));
		bitVector.setBit(6, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(6));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(7));
		bitVector.setBit(7, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(7));
		bitVector.setBit(7, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(7));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(8));
		bitVector.setBit(8, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(8));
		bitVector.setBit(8, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(8));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(9));
		bitVector.setBit(9, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(9));
		bitVector.setBit(9, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(9));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(10));
		bitVector.setBit(10, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(10));
		bitVector.setBit(10, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(10));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(11));
		bitVector.setBit(11, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(11));
		bitVector.setBit(11, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(11));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(12));
		bitVector.setBit(12, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(12));
		bitVector.setBit(12, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(12));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(13));
		bitVector.setBit(13, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(13));
		bitVector.setBit(13, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(13));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(14));
		bitVector.setBit(14, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(14));
		bitVector.setBit(14, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(14));

		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(15));
		bitVector.setBit(15, true);
		Assert.assertEquals(BitVector.TRUE, bitVector.getBit(15));
		bitVector.setBit(15, false);
		Assert.assertEquals(BitVector.FALSE, bitVector.getBit(15));
	}

	@Test
	public void testGetByteByteMultiple() {
		final byte[] bitData = { BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVectorTest.parseByte("01010101"), bitVector.getByte(0));
		Assert.assertEquals(BitVectorTest.parseByte("10101010"), bitVector.getByte(Byte.SIZE));
	}

	@Test
	public void testGetByteNonByteMultiple() {
		final byte[] bitData = { BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVectorTest.parseByte("01010101"), bitVector.getByte(0));
		Assert.assertEquals(BitVectorTest.parseByte("10101011"), bitVector.getByte(1));
		Assert.assertEquals(BitVectorTest.parseByte("01010110"), bitVector.getByte(2));
		Assert.assertEquals(BitVectorTest.parseByte("10101101"), bitVector.getByte(3));
		Assert.assertEquals(BitVectorTest.parseByte("01011010"), bitVector.getByte(4));
		Assert.assertEquals(BitVectorTest.parseByte("10110101"), bitVector.getByte(5));
		Assert.assertEquals(BitVectorTest.parseByte("01101010"), bitVector.getByte(6));
		Assert.assertEquals(BitVectorTest.parseByte("11010101"), bitVector.getByte(7));
		Assert.assertEquals(BitVectorTest.parseByte("10101010"), bitVector.getByte(8));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetByteTooLow() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.getByte(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetByteTooHigh() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.getByte(1 + 1 * Byte.SIZE);
	}

	@Test
	public void testSetBitsInByte() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		BitVector.setBitsInByte(bitVector.getByte(0), 4, BitVectorTest.parseByte("11111111"), 3, 2);
	}

	@Test
	public void testSetByteByteMultiple() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setByte(0, BitVectorTest.parseByte("01010101"));
		Assert.assertEquals(BitVectorTest.parseByte("01010101"), bitVector.getByte(0));

		bitVector.setByte(Byte.SIZE, BitVectorTest.parseByte("10101010"));
		Assert.assertEquals(BitVectorTest.parseByte("10101010"), bitVector.getByte(Byte.SIZE));
	}

	@Test
	public void testSetByteNonByteMultiple() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setByte(0, BitVectorTest.parseByte("01010101"));
		Assert.assertEquals(BitVectorTest.parseByte("01010101"), bitVector.getByte(0));

		bitVector.setByte(1, BitVectorTest.parseByte("01010101"));
		Assert.assertEquals(BitVectorTest.parseByte("01010101"), bitVector.getByte(1));

		bitVector.setByte(2, BitVectorTest.parseByte("01010101"));
		Assert.assertEquals(BitVectorTest.parseByte("01010101"), bitVector.getByte(2));

		bitVector.setByte(3, BitVectorTest.parseByte("01010101"));
		Assert.assertEquals(BitVectorTest.parseByte("01010101"), bitVector.getByte(3));

		bitVector.setByte(4, BitVectorTest.parseByte("01010101"));
		Assert.assertEquals(BitVectorTest.parseByte("01010101"), bitVector.getByte(4));

		bitVector.setByte(5, BitVectorTest.parseByte("01010101"));
		Assert.assertEquals(BitVectorTest.parseByte("01010101"), bitVector.getByte(5));

		bitVector.setByte(6, BitVectorTest.parseByte("01010101"));
		Assert.assertEquals(BitVectorTest.parseByte("01010101"), bitVector.getByte(6));

		bitVector.setByte(7, BitVectorTest.parseByte("01010101"));
		Assert.assertEquals(BitVectorTest.parseByte("01010101"), bitVector.getByte(7));

		bitVector.setByte(8, BitVectorTest.parseByte("01010101"));
		Assert.assertEquals(BitVectorTest.parseByte("01010101"), bitVector.getByte(8));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetByteTooLow() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setByte(-1, BitVectorTest.parseByte("00000000"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetByteTooHigh() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setByte(1 + 1 * Byte.SIZE, BitVectorTest.parseByte("00000000"));
	}

	@Test
	public void testGetShortByteMultiple() {
		final byte[] bitData = { BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010"), BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(0));
		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(Short.SIZE));
	}

	@Test
	public void testGetShortNonByteMultiple() {
		final byte[] bitData = { BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010"), BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(0));
		Assert.assertEquals(BitVectorTest.parseShort("1010101101010100"), bitVector.getShort(1));
		Assert.assertEquals(BitVectorTest.parseShort("0101011010101001"), bitVector.getShort(2));
		Assert.assertEquals(BitVectorTest.parseShort("1010110101010010"), bitVector.getShort(3));
		Assert.assertEquals(BitVectorTest.parseShort("0101101010100101"), bitVector.getShort(4));
		Assert.assertEquals(BitVectorTest.parseShort("1011010101001010"), bitVector.getShort(5));
		Assert.assertEquals(BitVectorTest.parseShort("0110101010010101"), bitVector.getShort(6));
		Assert.assertEquals(BitVectorTest.parseShort("1101010100101010"), bitVector.getShort(7));
		Assert.assertEquals(BitVectorTest.parseShort("1010101001010101"), bitVector.getShort(8));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetShortTooLow() {
		final byte[] bitData = { BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.getShort(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetShortTooHigh() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.getShort(1 + 1 * Short.SIZE);
	}

	@Test
	public void testSetShortByteMultiple() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setShort(0, BitVectorTest.parseShort("0101010110101010"));
		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(0));

		bitVector.setShort(Short.SIZE, BitVectorTest.parseShort("0101010110101010"));
		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(Short.SIZE));
	}

	@Test
	public void testSetShortNonByteMultiple() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setShort(0, BitVectorTest.parseShort("0101010110101010"));
		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(0));

		bitVector.setShort(1, BitVectorTest.parseShort("0101010110101010"));
		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(1));

		bitVector.setShort(2, BitVectorTest.parseShort("0101010110101010"));
		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(2));

		bitVector.setShort(3, BitVectorTest.parseShort("0101010110101010"));
		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(3));

		bitVector.setShort(4, BitVectorTest.parseShort("0101010110101010"));
		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(4));

		bitVector.setShort(5, BitVectorTest.parseShort("0101010110101010"));
		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(5));

		bitVector.setShort(6, BitVectorTest.parseShort("0101010110101010"));
		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(6));

		bitVector.setShort(7, BitVectorTest.parseShort("0101010110101010"));
		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(7));

		bitVector.setShort(8, BitVectorTest.parseShort("0101010110101010"));
		Assert.assertEquals(BitVectorTest.parseShort("0101010110101010"), bitVector.getShort(8));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetShortTooLow() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setShort(-1, BitVectorTest.parseShort("0000000000000000"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetShortTooHigh() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setShort(1 + 1 * Short.SIZE, BitVectorTest.parseShort("0000000000000000"));
	}

	@Test
	public void testGetIntByteMultiple() {
		final byte[] bitData = { BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010"), BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVectorTest.parseInt("01010101101010100101010110101010"), bitVector.getInt(0));
	}

	@Test
	public void testGetIntNonByteMultiple() {
		final byte[] bitData = { BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010"), BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010"), BitVectorTest.parseByte("01010101") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVectorTest.parseInt("01010101101010100101010110101010"), bitVector.getInt(0));
		Assert.assertEquals(BitVectorTest.parseInt("10101011010101001010101101010100"), bitVector.getInt(1));
		Assert.assertEquals(BitVectorTest.parseInt("01010110101010010101011010101001"), bitVector.getInt(2));
		Assert.assertEquals(BitVectorTest.parseInt("10101101010100101010110101010010"), bitVector.getInt(3));
		Assert.assertEquals(BitVectorTest.parseInt("01011010101001010101101010100101"), bitVector.getInt(4));
		Assert.assertEquals(BitVectorTest.parseInt("10110101010010101011010101001010"), bitVector.getInt(5));
		Assert.assertEquals(BitVectorTest.parseInt("01101010100101010110101010010101"), bitVector.getInt(6));
		Assert.assertEquals(BitVectorTest.parseInt("11010101001010101101010100101010"), bitVector.getInt(7));
		Assert.assertEquals(BitVectorTest.parseInt("10101010010101011010101001010101"), bitVector.getInt(8));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetIntTooLow() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.getInt(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetIntTooHigh() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.getInt(1 + 1 * Integer.SIZE);
	}

	@Test
	public void testSetIntByteMultiple() {
		final byte[] bitData = { BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010"), BitVectorTest.parseByte("01010101"), BitVectorTest.parseByte("10101010") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVectorTest.parseInt("01010101101010100101010110101010"), bitVector.getInt(0));
	}

	@Test
	public void testSetIntNonByteMultiple() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setInt(0, BitVectorTest.parseInt("01010101101010100101010110101010"));
		Assert.assertEquals(BitVectorTest.parseInt("01010101101010100101010110101010"), bitVector.getInt(0));

		bitVector.setInt(1, BitVectorTest.parseInt("01010101101010100101010110101010"));
		Assert.assertEquals(BitVectorTest.parseInt("01010101101010100101010110101010"), bitVector.getInt(1));

		bitVector.setInt(2, BitVectorTest.parseInt("01010101101010100101010110101010"));
		Assert.assertEquals(BitVectorTest.parseInt("01010101101010100101010110101010"), bitVector.getInt(2));

		bitVector.setInt(3, BitVectorTest.parseInt("01010101101010100101010110101010"));
		Assert.assertEquals(BitVectorTest.parseInt("01010101101010100101010110101010"), bitVector.getInt(3));

		bitVector.setInt(4, BitVectorTest.parseInt("01010101101010100101010110101010"));
		Assert.assertEquals(BitVectorTest.parseInt("01010101101010100101010110101010"), bitVector.getInt(4));

		bitVector.setInt(5, BitVectorTest.parseInt("01010101101010100101010110101010"));
		Assert.assertEquals(BitVectorTest.parseInt("01010101101010100101010110101010"), bitVector.getInt(5));

		bitVector.setInt(6, BitVectorTest.parseInt("01010101101010100101010110101010"));
		Assert.assertEquals(BitVectorTest.parseInt("01010101101010100101010110101010"), bitVector.getInt(6));

		bitVector.setInt(7, BitVectorTest.parseInt("01010101101010100101010110101010"));
		Assert.assertEquals(BitVectorTest.parseInt("01010101101010100101010110101010"), bitVector.getInt(7));

		bitVector.setInt(8, BitVectorTest.parseInt("01010101101010100101010110101010"));
		Assert.assertEquals(BitVectorTest.parseInt("01010101101010100101010110101010"), bitVector.getInt(8));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetIntTooLow() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setInt(-1, BitVectorTest.parseInt("00000000000000000000000000000000"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetIntTooHigh() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setInt(1 + 1 * Integer.SIZE, BitVectorTest.parseInt("00000000000000000000000000000000"));
	}

	@Test
	public void testSetBitsByte() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBits(0, BitVectorTest.parseByte("11100000"), 0, 3);
		Assert.assertEquals(BitVectorTest.parseByte("11100000"), bitVector.getByte(0));
	}

	@Test
	public void testSetBitsByteWithIndex() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBits(1, BitVectorTest.parseByte("11100000"), 0, 3);
		Assert.assertEquals(BitVectorTest.parseByte("01110000"), bitVector.getByte(0));
	}

	@Test
	public void testSetBitsByteWithBitIndex() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBits(2, BitVectorTest.parseByte("01010000"), 1, 3);
		Assert.assertEquals(BitVectorTest.parseByte("00101000"), bitVector.getByte(0));
	}

	@Test
	public void testSetBitsByteAcrossBytesWithBitIndex() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBits(2, BitVectorTest.parseByte("01010000"), 1, 3);
		Assert.assertEquals(BitVectorTest.parseByte("00101000"), bitVector.getByte(0));
	}

	@Test
	public void testSetBitsShortHigherByteOnly() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBits(0, BitVectorTest.parseShort("1110011100111010"), 0, 6);
		Assert.assertEquals(BitVectorTest.parseByte("11100100"), bitVector.getByte(0));
		Assert.assertEquals(BitVectorTest.parseByte("00000000"), bitVector.getByte(Byte.SIZE));
	}

	@Test
	public void testSetBitsShortAcrossBytes() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBits(0, BitVectorTest.parseShort("1110011100111010"), 0, 12);
		Assert.assertEquals(BitVectorTest.parseByte("11100111"), bitVector.getByte(0));
		Assert.assertEquals(BitVectorTest.parseByte("00110000"), bitVector.getByte(Byte.SIZE));
	}

	@Test
	public void testSetBitsShortLowerByteOnly() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBits(0, BitVectorTest.parseShort("1110011100111010"), 10, 5);
		Assert.assertEquals(BitVectorTest.parseByte("11101000"), bitVector.getByte(0));
		Assert.assertEquals(BitVectorTest.parseByte("00000000"), bitVector.getByte(Byte.SIZE));
	}

	@Test
	public void testSetBitsShortLowerByteOnlyWithIndex() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBits(1, BitVectorTest.parseShort("1110011100111010"), 10, 5);
		Assert.assertEquals(BitVectorTest.parseByte("01110100"), bitVector.getByte(0));
		Assert.assertEquals(BitVectorTest.parseByte("00000000"), bitVector.getByte(Byte.SIZE));
	}

	@Test
	public void testSetBitsShortLowerByteOnlyWithIndexAcrossBytes() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBits(6, BitVectorTest.parseShort("0000000000111110"), 10, 5);
		Assert.assertEquals(BitVectorTest.parseByte("00000011"), bitVector.getByte(0));
		Assert.assertEquals(BitVectorTest.parseByte("11100000"), bitVector.getByte(Byte.SIZE));
	}

	@Test
	public void testSetBitsShortAcrossBytesWithIndexAcrossBytes() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBits(5, BitVectorTest.parseShort("0000001111100000"), 6, 5);
		Assert.assertEquals(BitVectorTest.parseByte("00000111"), bitVector.getByte(0));
		Assert.assertEquals(BitVectorTest.parseByte("11000000"), bitVector.getByte(Byte.SIZE));
	}

	@Test
	public void testSetBitsIntegerAcrossBytesWithIndexAcrossBytes() {
		final byte[] bitData = { BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000"), BitVectorTest.parseByte("00000000") };

		final BitVector bitVector = new BitVector(bitData);

		bitVector.setBits(1, BitVectorTest.parseInt("01111111111111111111111111111110"), 1, 30);
		Assert.assertEquals(BitVectorTest.parseByte("01111111"), bitVector.getByte(0 * Byte.SIZE));
		Assert.assertEquals(BitVectorTest.parseByte("11111111"), bitVector.getByte(1 * Byte.SIZE));
		Assert.assertEquals(BitVectorTest.parseByte("11111111"), bitVector.getByte(2 * Byte.SIZE));
		Assert.assertEquals(BitVectorTest.parseByte("11111110"), bitVector.getByte(3 * Byte.SIZE));
	}

	@Test
	public void testGetBits() {
		final byte[] bitData = { BitVectorTest.parseByte("11100000") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVectorTest.parseInt("111"), bitVector.getBits(0, 3));
	}

	@Test
	public void testGetBitsWithIndex() {
		final byte[] bitData = { BitVectorTest.parseByte("00111000") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVectorTest.parseInt("111"), bitVector.getBits(2, 3));
	}

	@Test
	public void testGetBitsWithIndexAcrossBytes() {
		final byte[] bitData = { BitVectorTest.parseByte("000000011"), BitVectorTest.parseByte("11000000") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVectorTest.parseInt("1111"), bitVector.getBits(6, 4));
	}

	@Test
	public void testGetBitsWithIndexAcrossBytes2() {
		final byte[] bitData = { BitVectorTest.parseByte("000000011"), BitVectorTest.parseByte("11111111"), BitVectorTest.parseByte("11111111"), BitVectorTest.parseByte("11000000") };

		final BitVector bitVector = new BitVector(bitData);

		Assert.assertEquals(BitVectorTest.parseInt("11111111111111111111"), bitVector.getBits(6, 20));
	}

	private static final byte parseByte(final String pString) {
		return (byte)Short.parseShort(pString, 2);
	}

	private static final short parseShort(final String pString) {
		return (short)Integer.parseInt(pString, 2);
	}

	private static final int parseInt(final String pString) {
		return (int)Long.parseLong(pString, 2);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
