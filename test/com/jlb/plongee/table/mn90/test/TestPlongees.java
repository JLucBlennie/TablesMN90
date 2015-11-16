/**
 * 
 */
package com.jlb.plongee.table.mn90.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jlb.plongee.datamodel.table.mn90.TablePlongee;
import com.jlb.plongee.datamodel.table.mn90.exception.PalierNonTrouveException;

/**
 * @author VIGILESC
 *
 */
public class TestPlongees {

	/**
	 * Test method for
	 * {@link com.jlb.plongee.datamodel.table.mn90.TablePlongee#getTpsPxxM()}.
	 */
	@Test
	public void testPlongeesSimples() {
		// 6m
		testPlongee(6, 15, 0, 0, 0, 0, 0, 1, "A");
		testPlongee(6, 30, 0, 0, 0, 0, 0, 1, "B");
		testPlongee(6, 45, 0, 0, 0, 0, 0, 1, "C");
		testPlongee(6, 60 + 15, 0, 0, 0, 0, 0, 1, "D");
		testPlongee(6, 60 + 45, 0, 0, 0, 0, 0, 1, "E");
		testPlongee(6, 2 * 60 + 15, 0, 0, 0, 0, 0, 1, "F");
		testPlongee(6, 3 * 60, 0, 0, 0, 0, 0, 1, "G");
		testPlongee(6, 4 * 60, 0, 0, 0, 0, 0, 1, "H");
		testPlongee(6, 5 * 60 + 15, 0, 0, 0, 0, 0, 1, "I");
		testPlongee(6, 6 * 60, 0, 0, 0, 0, 0, 1, "J");
		// 8m
		testPlongee(8, 15, 0, 0, 0, 0, 0, 1, "B");
		testPlongee(8, 30, 0, 0, 0, 0, 0, 1, "C");
		testPlongee(8, 45, 0, 0, 0, 0, 0, 1, "D");
		testPlongee(8, 60, 0, 0, 0, 0, 0, 1, "E");
		testPlongee(8, 60 + 30, 0, 0, 0, 0, 0, 1, "F");
		testPlongee(8, 60 + 45, 0, 0, 0, 0, 0, 1, "G");
		testPlongee(8, 2 * 60 + 15, 0, 0, 0, 0, 0, 1, "H");
		testPlongee(8, 2 * 60 + 45, 0, 0, 0, 0, 0, 1, "I");
		testPlongee(8, 3 * 60 + 15, 0, 0, 0, 0, 0, 1, "J");
		testPlongee(8, 4 * 60 + 15, 0, 0, 0, 0, 0, 1, "K");
		testPlongee(8, 5 * 60, 0, 0, 0, 0, 0, 1, "L");
		testPlongee(8, 6 * 60, 0, 0, 0, 0, 0, 1, "M");
		// 10m
		testPlongee(10, 15, 0, 0, 0, 0, 0, 1, "B");
		testPlongee(10, 30, 0, 0, 0, 0, 0, 1, "C");
		testPlongee(10, 45, 0, 0, 0, 0, 0, 1, "D");
		testPlongee(10, 60, 0, 0, 0, 0, 0, 1, "F");
		testPlongee(10, 60 + 15, 0, 0, 0, 0, 0, 1, "G");
		testPlongee(10, 60 + 45, 0, 0, 0, 0, 0, 1, "H");
		testPlongee(10, 2 * 60, 0, 0, 0, 0, 0, 1, "I");
		testPlongee(10, 2 * 60 + 15, 0, 0, 0, 0, 0, 1, "J");
		testPlongee(10, 2 * 60 + 45, 0, 0, 0, 0, 0, 1, "K");
		testPlongee(10, 3 * 60, 0, 0, 0, 0, 0, 1, "L");
		testPlongee(10, 4 * 60, 0, 0, 0, 0, 0, 1, "M");
		testPlongee(10, 4 * 60 + 15, 0, 0, 0, 0, 0, 1, "N");
		testPlongee(10, 5 * 60 + 15, 0, 0, 0, 0, 0, 1, "O");
		testPlongee(10, 5 * 60 + 30, 0, 0, 0, 0, 0, 1, "P");
		testPlongee(10, 6 * 60, 0, 0, 0, 0, 1, 2, "P");
		// 12m
		testPlongee(12, 5, 0, 0, 0, 0, 0, 1, "A");
		testPlongee(12, 10, 0, 0, 0, 0, 0, 1, "B");
		testPlongee(12, 15, 0, 0, 0, 0, 0, 1, "B");
		testPlongee(12, 20, 0, 0, 0, 0, 0, 1, "C");
		testPlongee(12, 25, 0, 0, 0, 0, 0, 1, "C");
		testPlongee(12, 30, 0, 0, 0, 0, 0, 1, "D");
		testPlongee(12, 35, 0, 0, 0, 0, 0, 1, "D");
		testPlongee(12, 40, 0, 0, 0, 0, 0, 1, "E");
		testPlongee(12, 45, 0, 0, 0, 0, 0, 1, "E");
		testPlongee(12, 50, 0, 0, 0, 0, 0, 1, "F");
		testPlongee(12, 55, 0, 0, 0, 0, 0, 1, "F");
		testPlongee(12, 60, 0, 0, 0, 0, 0, 1, "G");
		testPlongee(12, 60 + 5, 0, 0, 0, 0, 0, 1, "G");
		testPlongee(12, 60 + 10, 0, 0, 0, 0, 0, 1, "H");
		testPlongee(12, 60 + 15, 0, 0, 0, 0, 0, 1, "H");
		testPlongee(12, 60 + 20, 0, 0, 0, 0, 0, 1, "H");
		testPlongee(12, 60 + 25, 0, 0, 0, 0, 0, 1, "I");
		testPlongee(12, 60 + 30, 0, 0, 0, 0, 0, 1, "I");
		testPlongee(12, 60 + 35, 0, 0, 0, 0, 0, 1, "J");
		testPlongee(12, 60 + 40, 0, 0, 0, 0, 0, 1, "J");
		testPlongee(12, 60 + 45, 0, 0, 0, 0, 0, 1, "J");
		testPlongee(12, 60 + 50, 0, 0, 0, 0, 0, 1, "K");
		testPlongee(12, 60 + 55, 0, 0, 0, 0, 0, 1, "K");
		testPlongee(12, 2 * 60, 0, 0, 0, 0, 0, 1, "K");
		testPlongee(12, 2 * 60 + 10, 0, 0, 0, 0, 0, 1, "L");
		testPlongee(12, 2 * 60 + 15, 0, 0, 0, 0, 0, 1, "L");
		testPlongee(12, 2 * 60 + 20, 0, 0, 0, 0, 2, 4, "L");
		testPlongee(12, 2 * 60 + 30, 0, 0, 0, 0, 4, 6, "M");
		testPlongee(12, 2 * 60 + 40, 0, 0, 0, 0, 6, 8, "M");
		testPlongee(12, 2 * 60 + 50, 0, 0, 0, 0, 7, 9, "N");
		testPlongee(12, 3 * 60, 0, 0, 0, 0, 9, 11, "N");
		testPlongee(12, 3 * 60 + 10, 0, 0, 0, 0, 11, 13, "N");
		testPlongee(12, 3 * 60 + 20, 0, 0, 0, 0, 13, 15, "O");
		testPlongee(12, 3 * 60 + 30, 0, 0, 0, 0, 14, 16, "O");
		testPlongee(12, 3 * 60 + 40, 0, 0, 0, 0, 15, 17, "O");
		testPlongee(12, 3 * 60 + 50, 0, 0, 0, 0, 16, 18, "O");
		testPlongee(12, 4 * 60, 0, 0, 0, 0, 17, 19, "O");
		testPlongee(12, 4 * 60 + 10, 0, 0, 0, 0, 18, 20, "P");
		testPlongee(12, 4 * 60 + 15, 0, 0, 0, 0, 19, 21, "P");
		testPlongee(12, 4 * 60 + 30, 0, 0, 0, 0, 22, 24, "P");

		TablePlongee mPlongee;
		// 15m
		testPlongee(15, 5, 0, 0, 0, 0, 0, 1, "A");
		testPlongee(15, 10, 0, 0, 0, 0, 0, 1, "B");
		testPlongee(15, 15, 0, 0, 0, 0, 0, 1, "C");
		testPlongee(15, 20, 0, 0, 0, 0, 0, 1, "C");
		testPlongee(15, 25, 0, 0, 0, 0, 0, 1, "D");
		testPlongee(15, 30, 0, 0, 0, 0, 0, 1, "E");
		testPlongee(15, 35, 0, 0, 0, 0, 0, 1, "E");
		testPlongee(15, 40, 0, 0, 0, 0, 0, 1, "F");
		testPlongee(15, 45, 0, 0, 0, 0, 0, 1, "G");
		testPlongee(15, 50, 0, 0, 0, 0, 0, 1, "G");
		testPlongee(15, 55, 0, 0, 0, 0, 0, 1, "H");
		testPlongee(15, 60, 0, 0, 0, 0, 0, 1, "H");
		testPlongee(15, 60 + 5, 0, 0, 0, 0, 0, 1, "I");
		testPlongee(15, 60 + 10, 0, 0, 0, 0, 0, 1, "I");
		testPlongee(15, 60 + 15, 0, 0, 0, 0, 0, 1, "J");
		testPlongee(15, 60 + 20, 0, 0, 0, 0, 2, 4, "J");
		testPlongee(15, 60 + 25, 0, 0, 0, 0, 4, 6, "K");
		testPlongee(15, 60 + 30, 0, 0, 0, 0, 6, 8, "K");
		testPlongee(15, 60 + 35, 0, 0, 0, 0, 8, 10, "L");
		testPlongee(15, 60 + 40, 0, 0, 0, 0, 11, 13, "L");
		testPlongee(15, 60 + 45, 0, 0, 0, 0, 13, 15, "L");
		testPlongee(15, 60 + 50, 0, 0, 0, 0, 15, 17, "M");
		testPlongee(15, 60 + 55, 0, 0, 0, 0, 17, 19, "M");
		testPlongee(15, 2 * 60, 0, 0, 0, 0, 18, 20, "M");
		// 18m
		testPlongee(18, 5, 0, 0, 0, 0, 0, 2, "B");
		testPlongee(18, 10, 0, 0, 0, 0, 0, 2, "B");
		testPlongee(18, 15, 0, 0, 0, 0, 0, 2, "C");
		testPlongee(18, 20, 0, 0, 0, 0, 0, 2, "D");
		testPlongee(18, 25, 0, 0, 0, 0, 0, 2, "E");
		testPlongee(18, 30, 0, 0, 0, 0, 0, 2, "F");
		testPlongee(18, 35, 0, 0, 0, 0, 0, 2, "F");
		testPlongee(18, 40, 0, 0, 0, 0, 0, 2, "G");
		testPlongee(18, 45, 0, 0, 0, 0, 0, 2, "H");
		testPlongee(18, 50, 0, 0, 0, 0, 0, 2, "H");
		testPlongee(18, 55, 0, 0, 0, 0, 1, 3, "I");
		testPlongee(18, 60, 0, 0, 0, 0, 5, 7, "J");
		testPlongee(18, 60 + 5, 0, 0, 0, 0, 8, 10, "J");
		testPlongee(18, 60 + 10, 0, 0, 0, 0, 11, 13, "K");
		testPlongee(18, 60 + 15, 0, 0, 0, 0, 14, 16, "K");
		testPlongee(18, 60 + 20, 0, 0, 0, 0, 17, 19, "L");
		testPlongee(18, 60 + 25, 0, 0, 0, 0, 21, 23, "L");
		testPlongee(18, 60 + 30, 0, 0, 0, 0, 23, 25, "M");
		testPlongee(18, 60 + 35, 0, 0, 0, 0, 26, 28, "M");
		testPlongee(18, 60 + 40, 0, 0, 0, 0, 28, 30, "M");
		testPlongee(18, 60 + 45, 0, 0, 0, 0, 31, 33, "N");
		testPlongee(18, 60 + 50, 0, 0, 0, 0, 34, 36, "N");
		testPlongee(18, 60 + 55, 0, 0, 0, 0, 36, 38, "N");
		testPlongee(18, 2 * 60, 0, 0, 0, 0, 38, 40, "O");
		// 20m
		testPlongee(20, 5, 0, 0, 0, 0, 0, 2, "B");
		testPlongee(20, 10, 0, 0, 0, 0, 0, 2, "B");
		testPlongee(20, 15, 0, 0, 0, 0, 0, 2, "D");
		testPlongee(20, 20, 0, 0, 0, 0, 0, 2, "D");
		testPlongee(20, 25, 0, 0, 0, 0, 0, 2, "E");
		testPlongee(20, 30, 0, 0, 0, 0, 0, 2, "F");
		testPlongee(20, 35, 0, 0, 0, 0, 0, 2, "G");
		testPlongee(20, 40, 0, 0, 0, 0, 0, 2, "H");
		testPlongee(20, 45, 0, 0, 0, 0, 1, 3, "I");
		testPlongee(20, 50, 0, 0, 0, 0, 4, 6, "I");
		testPlongee(20, 55, 0, 0, 0, 0, 9, 11, "J");
		testPlongee(20, 60, 0, 0, 0, 0, 13, 15, "K");
		testPlongee(20, 60 + 5, 0, 0, 0, 0, 16, 18, "K");
		testPlongee(20, 60 + 10, 0, 0, 0, 0, 20, 22, "L");
		testPlongee(20, 60 + 15, 0, 0, 0, 0, 24, 26, "L");
		testPlongee(20, 60 + 20, 0, 0, 0, 0, 27, 29, "M");
		testPlongee(20, 60 + 25, 0, 0, 0, 0, 30, 32, "M");
		testPlongee(20, 60 + 30, 0, 0, 0, 0, 34, 36, "M");
		// 22m
		testPlongee(22, 5, 0, 0, 0, 0, 0, 2, "B");
		testPlongee(22, 10, 0, 0, 0, 0, 0, 2, "C");
		testPlongee(22, 15, 0, 0, 0, 0, 0, 2, "D");
		testPlongee(22, 20, 0, 0, 0, 0, 0, 2, "E");
		testPlongee(22, 25, 0, 0, 0, 0, 0, 2, "F");
		testPlongee(22, 30, 0, 0, 0, 0, 0, 2, "G");
		testPlongee(22, 35, 0, 0, 0, 0, 0, 2, "H");
		testPlongee(22, 40, 0, 0, 0, 0, 2, 4, "I");
		testPlongee(22, 45, 0, 0, 0, 0, 7, 9, "I");
		testPlongee(22, 50, 0, 0, 0, 0, 12, 14, "J");
		testPlongee(22, 55, 0, 0, 0, 0, 16, 18, "K");
		testPlongee(22, 60, 0, 0, 0, 0, 20, 22, "K");
		testPlongee(22, 60 + 5, 0, 0, 0, 0, 25, 27, "L");
		testPlongee(22, 60 + 10, 0, 0, 0, 0, 29, 31, "L");
		testPlongee(22, 60 + 15, 0, 0, 0, 0, 33, 35, "M");
		testPlongee(22, 60 + 20, 0, 0, 0, 0, 37, 39, "M");
		testPlongee(22, 60 + 25, 0, 0, 0, 0, 41, 43, "N");
		testPlongee(22, 60 + 30, 0, 0, 0, 0, 44, 46, "N");
		// 25m
		testPlongee(25, 5, 0, 0, 0, 0, 0, 2, "B");
		testPlongee(25, 10, 0, 0, 0, 0, 0, 2, "C");
		testPlongee(25, 15, 0, 0, 0, 0, 0, 2, "D");
		testPlongee(25, 20, 0, 0, 0, 0, 0, 2, "E");
		testPlongee(25, 25, 0, 0, 0, 0, 1, 3, "F");
		testPlongee(25, 30, 0, 0, 0, 0, 2, 4, "H");
		testPlongee(25, 35, 0, 0, 0, 0, 5, 7, "I");
		testPlongee(25, 40, 0, 0, 0, 0, 10, 12, "J");
		testPlongee(25, 45, 0, 0, 0, 0, 16, 18, "J");
		testPlongee(25, 50, 0, 0, 0, 0, 21, 23, "K");
		testPlongee(25, 55, 0, 0, 0, 0, 27, 29, "L");
		testPlongee(25, 60, 0, 0, 0, 0, 32, 34, "L");
		testPlongee(25, 60 + 5, 0, 0, 0, 0, 37, 39, "M");
		testPlongee(25, 60 + 10, 0, 0, 0, 1, 41, 45, "M");
		testPlongee(25, 60 + 15, 0, 0, 0, 4, 43, 50, "N");
		testPlongee(25, 60 + 20, 0, 0, 0, 7, 45, 55, "N");
		testPlongee(25, 60 + 25, 0, 0, 0, 9, 48, 60, "O");
		testPlongee(25, 60 + 30, 0, 0, 0, 11, 50, 64, "O");
		// 28m
		testPlongee(28, 5, 0, 0, 0, 0, 0, 2, "B");
		testPlongee(28, 10, 0, 0, 0, 0, 0, 2, "D");
		testPlongee(28, 15, 0, 0, 0, 0, 0, 2, "E");
		testPlongee(28, 20, 0, 0, 0, 0, 1, 4, "F");
		testPlongee(28, 25, 0, 0, 0, 0, 2, 5, "G");
		testPlongee(28, 30, 0, 0, 0, 0, 6, 9, "H");
		testPlongee(28, 35, 0, 0, 0, 0, 12, 15, "I");
		testPlongee(28, 40, 0, 0, 0, 0, 19, 22, "J");
		testPlongee(28, 45, 0, 0, 0, 0, 25, 28, "K");
		testPlongee(28, 50, 0, 0, 0, 0, 32, 35, "L");
		testPlongee(28, 55, 0, 0, 0, 2, 36, 41, "M");
		testPlongee(28, 60, 0, 0, 0, 4, 40, 47, "M");
		testPlongee(28, 60 + 5, 0, 0, 0, 8, 43, 54, "N");
		testPlongee(28, 60 + 10, 0, 0, 0, 11, 46, 60, "N");
		testPlongee(28, 60 + 15, 0, 0, 0, 14, 48, 65, "O");
		testPlongee(28, 60 + 20, 0, 0, 0, 17, 50, 70, "O");
		testPlongee(28, 60 + 25, 0, 0, 0, 20, 53, 76, "O");
		testPlongee(28, 60 + 30, 0, 0, 0, 23, 56, 82, "P");
		// 30m
		testPlongee(30, 5, 0, 0, 0, 0, 0, 2, "B");
		testPlongee(30, 10, 0, 0, 0, 0, 0, 2, "D");
		testPlongee(30, 15, 0, 0, 0, 0, 1, 4, "E");
		testPlongee(30, 20, 0, 0, 0, 0, 2, 5, "F");
		testPlongee(30, 25, 0, 0, 0, 0, 4, 7, "H");
		testPlongee(30, 30, 0, 0, 0, 0, 9, 12, "I");
		testPlongee(30, 35, 0, 0, 0, 0, 17, 20, "J");
		testPlongee(30, 40, 0, 0, 0, 0, 24, 27, "K");
		testPlongee(30, 45, 0, 0, 0, 1, 31, 35, "L");
		testPlongee(30, 50, 0, 0, 0, 3, 36, 42, "M");
		testPlongee(30, 55, 0, 0, 0, 6, 39, 48, "M");
		testPlongee(30, 60, 0, 0, 0, 10, 43, 56, "N");
		testPlongee(30, 60 + 5, 0, 0, 0, 14, 46, 63, "N");
		testPlongee(30, 60 + 10, 0, 0, 0, 17, 48, 68, "O");
		// 32m
		testPlongee(32, 5, 0, 0, 0, 0, 0, 3, "B");
		testPlongee(32, 10, 0, 0, 0, 0, 0, 3, "D");
		testPlongee(32, 15, 0, 0, 0, 0, 1, 4, "E");
		testPlongee(32, 20, 0, 0, 0, 0, 3, 6, "G");
		testPlongee(32, 25, 0, 0, 0, 0, 6, 9, "H");
		testPlongee(32, 30, 0, 0, 0, 0, 14, 17, "I");
		testPlongee(32, 35, 0, 0, 0, 0, 22, 25, "K");
		testPlongee(32, 40, 0, 0, 0, 1, 29, 33, "K");
		testPlongee(32, 45, 0, 0, 0, 4, 34, 41, "L");
		testPlongee(32, 50, 0, 0, 0, 7, 39, 49, "M");
		testPlongee(32, 55, 0, 0, 0, 11, 43, 57, "N");
		testPlongee(32, 60, 0, 0, 0, 15, 46, 64, "N");
		testPlongee(32, 60 + 5, 0, 0, 0, 19, 48, 70, "O");
		testPlongee(32, 60 + 10, 0, 0, 0, 23, 50, 76, "O");
		// 35m
		testPlongee(35, 5, 0, 0, 0, 0, 0, 3, "C");
		testPlongee(35, 10, 0, 0, 0, 0, 0, 3, "D");
		testPlongee(35, 15, 0, 0, 0, 0, 2, 5, "F");
		testPlongee(35, 20, 0, 0, 0, 0, 5, 8, "H");
		testPlongee(35, 25, 0, 0, 0, 0, 11, 14, "I");
		testPlongee(35, 30, 0, 0, 0, 1, 20, 24, "J");
		testPlongee(35, 35, 0, 0, 0, 2, 27, 32, "K");
		testPlongee(35, 40, 0, 0, 0, 5, 34, 42, "L");
		testPlongee(35, 45, 0, 0, 0, 9, 39, 51, "M");
		testPlongee(35, 50, 0, 0, 0, 14, 43, 60, "N");
		testPlongee(35, 55, 0, 0, 0, 18, 47, 68, "N");
		testPlongee(35, 60, 0, 0, 0, 22, 50, 75, "O");
		testPlongee(35, 60 + 5, 0, 0, 2, 26, 52, 84, "*");
		testPlongee(35, 60 + 10, 0, 0, 4, 28, 57, 93, "*");
		// 38m
		testPlongee(38, 5, 0, 0, 0, 0, 0, 3, "C");
		testPlongee(38, 10, 0, 0, 0, 0, 1, 4, "E");
		testPlongee(38, 15, 0, 0, 0, 0, 4, 7, "F");
		testPlongee(38, 20, 0, 0, 0, 0, 8, 11, "H");
		testPlongee(38, 25, 0, 0, 0, 1, 16, 21, "J");
		testPlongee(38, 30, 0, 0, 0, 3, 24, 31, "K");
		testPlongee(38, 35, 0, 0, 0, 5, 33, 42, "L");
		testPlongee(38, 40, 0, 0, 0, 10, 38, 52, "M");
		testPlongee(38, 45, 0, 0, 0, 15, 43, 62, "N");
		testPlongee(38, 50, 0, 0, 0, 20, 47, 71, "N");
		testPlongee(38, 55, 0, 0, 2, 23, 50, 79, "O");
		testPlongee(38, 60, 0, 0, 5, 27, 53, 89, "P");
		testPlongee(38, 60 + 5, 0, 0, 8, 29, 58, 99, "*");
		testPlongee(38, 60 + 10, 0, 0, 11, 31, 62, 108, "*");
		// 40m
		testPlongee(40, 5, 0, 0, 0, 0, 0, 3, "C");
		testPlongee(40, 10, 0, 0, 0, 0, 2, 5, "E");
		testPlongee(40, 15, 0, 0, 0, 0, 4, 7, "G");
		testPlongee(40, 20, 0, 0, 0, 1, 9, 14, "H");
		testPlongee(40, 25, 0, 0, 0, 2, 19, 25, "J");
		testPlongee(40, 30, 0, 0, 0, 4, 28, 36, "K");
		testPlongee(40, 35, 0, 0, 0, 8, 35, 47, "L");
		testPlongee(40, 40, 0, 0, 0, 13, 40, 57, "M");
		testPlongee(40, 45, 0, 0, 1, 18, 45, 68, "N");
		testPlongee(40, 50, 0, 0, 2, 23, 48, 77, "O");
		testPlongee(40, 55, 0, 0, 5, 26, 52, 87, "O");
		testPlongee(40, 60, 0, 0, 8, 29, 57, 98, "P");
		testPlongee(40, 60 + 5, 0, 0, 12, 31, 61, 108, "*");
		testPlongee(40, 60 + 10, 0, 0, 15, 33, 66, 118, "*");
		// 42m
		testPlongee(42, 5, 0, 0, 0, 0, 0, 3, "C");
		testPlongee(42, 10, 0, 0, 0, 0, 2, 6, "E");
		testPlongee(42, 15, 0, 0, 0, 0, 5, 9, "G");
		testPlongee(42, 20, 0, 0, 0, 1, 12, 17, "I");
		testPlongee(42, 25, 0, 0, 0, 3, 22, 29, "J");
		testPlongee(42, 30, 0, 0, 0, 6, 31, 41, "L");
		testPlongee(42, 35, 0, 0, 0, 11, 37, 52, "M");
		testPlongee(42, 40, 0, 0, 1, 16, 43, 64, "N");
		testPlongee(42, 45, 0, 0, 3, 21, 47, 75, "*");
		testPlongee(42, 50, 0, 0, 6, 24, 50, 84, "*");
		testPlongee(42, 55, 0, 0, 8, 29, 55, 96, "*");
		testPlongee(42, 60, 0, 0, 13, 30, 60, 107, "*");
		// 45m
		testPlongee(45, 5, 0, 0, 0, 0, 0, 3, "C");
		testPlongee(45, 10, 0, 0, 0, 0, 3, 7, "F");
		testPlongee(45, 15, 0, 0, 0, 1, 6, 11, "H");
		testPlongee(45, 20, 0, 0, 0, 3, 15, 22, "I");
		testPlongee(45, 25, 0, 0, 0, 5, 25, 34, "K");
		testPlongee(45, 30, 0, 0, 0, 9, 35, 48, "L");
		testPlongee(45, 35, 0, 0, 1, 15, 40, 60, "M");
		testPlongee(45, 40, 0, 0, 3, 20, 46, 73, "N");
		testPlongee(45, 45, 0, 0, 6, 24, 50, 84, "*");
		testPlongee(45, 50, 0, 0, 10, 28, 54, 96, "*");
		testPlongee(45, 55, 0, 0, 14, 30, 60, 108, "*");
		testPlongee(45, 60, 0, 1, 18, 32, 65, 121, "*");
		// 48m
		testPlongee(48, 5, 0, 0, 0, 0, 0, 4, "D");
		testPlongee(48, 10, 0, 0, 0, 0, 4, 8, "F");
		testPlongee(48, 15, 0, 0, 0, 2, 7, 13, "H");
		testPlongee(48, 20, 0, 0, 0, 4, 19, 27, "J");
		testPlongee(48, 25, 0, 0, 0, 7, 30, 41, "K");
		testPlongee(48, 30, 0, 0, 1, 12, 37, 55, "M");
		testPlongee(48, 35, 0, 0, 3, 18, 44, 70, "N");
		testPlongee(48, 40, 0, 0, 6, 23, 48, 82, "O");
		testPlongee(48, 45, 0, 0, 10, 27, 53, 95, "*");
		testPlongee(48, 50, 0, 1, 14, 30, 59, 109, "*");
		testPlongee(48, 55, 0, 2, 18, 32, 64, 121, "*");
		testPlongee(48, 60, 0, 5, 19, 36, 70, 135, "*");
		// 50m
		testPlongee(50, 5, 0, 0, 0, 0, 1, 5, "D");
		testPlongee(50, 10, 0, 0, 0, 0, 4, 8, "F");
		testPlongee(50, 15, 0, 0, 0, 2, 9, 15, "H");
		testPlongee(50, 20, 0, 0, 0, 4, 22, 30, "J");
		testPlongee(50, 25, 0, 0, 1, 8, 32, 46, "L");
		testPlongee(50, 30, 0, 0, 2, 14, 39, 60, "M");
		testPlongee(50, 35, 0, 0, 5, 20, 45, 75, "N");
		testPlongee(50, 40, 0, 0, 9, 24, 50, 88, "O");
		testPlongee(50, 45, 0, 1, 12, 29, 55, 102, "*");
		testPlongee(50, 50, 0, 2, 17, 30, 62, 116, "*");
		testPlongee(50, 55, 0, 5, 19, 34, 67, 130, "*");
		// 52m
		testPlongee(52, 5, 0, 0, 0, 0, 1, 5, "D");
		testPlongee(52, 10, 0, 0, 0, 1, 4, 10, "F");
		testPlongee(52, 15, 0, 0, 0, 3, 10, 18, "I");
		testPlongee(52, 20, 0, 0, 1, 5, 23, 34, "K");
		testPlongee(52, 25, 0, 0, 2, 9, 34, 50, "L");
		testPlongee(52, 30, 0, 0, 4, 15, 41, 65, "M");
		testPlongee(52, 35, 0, 0, 6, 22, 47, 80, "O");
		testPlongee(52, 40, 0, 1, 10, 26, 52, 94, "O");
		testPlongee(52, 45, 0, 2, 15, 29, 59, 110, "*");
		testPlongee(52, 50, 0, 5, 17, 32, 64, 123, "*");
		testPlongee(52, 55, 0, 8, 19, 36, 71, 139, "*");
		// 55m
		testPlongee(55, 5, 0, 0, 0, 0, 1, 5, "D");
		testPlongee(55, 10, 0, 0, 0, 1, 5, 11, "G");
		testPlongee(55, 15, 0, 0, 0, 4, 13, 22, "I");
		testPlongee(55, 20, 0, 0, 1, 6, 27, 39, "K");
		testPlongee(55, 25, 0, 0, 3, 11, 37, 56, "M");
		testPlongee(55, 30, 0, 0, 6, 18, 44, 73, "N");
		testPlongee(55, 35, 0, 1, 9, 23, 50, 88, "O");
		testPlongee(55, 40, 0, 3, 12, 29, 55, 104, "P");
		testPlongee(55, 45, 0, 5, 17, 31, 62, 120, "*");
		testPlongee(55, 50, 0, 8, 19, 35, 69, 136, "*");
		testPlongee(55, 55, 0, 12, 22, 37, 76, 152, "*");
		// 58m
		testPlongee(58, 5, 0, 0, 0, 0, 2, 7, "D");
		testPlongee(58, 10, 0, 0, 0, 2, 5, 12, "G");
		testPlongee(58, 15, 0, 0, 1, 4, 16, 26, "J");
		testPlongee(58, 20, 0, 0, 2, 7, 30, 44, "K");
		testPlongee(58, 25, 0, 0, 4, 13, 40, 62, "M");
		testPlongee(58, 30, 0, 1, 7, 21, 46, 81, "N");
		testPlongee(58, 35, 0, 2, 11, 26, 52, 97, "O");
		testPlongee(58, 40, 0, 5, 15, 30, 59, 115, "P");
		testPlongee(58, 45, 0, 8, 18, 33, 66, 131, "*");
		testPlongee(58, 50, 1, 11, 21, 37, 74, 150, "*");
		testPlongee(58, 55, 3, 14, 23, 39, 83, 168, "*");
		// 60m
		testPlongee(60, 5, 0, 0, 0, 0, 2, 7, "D");
		testPlongee(60, 10, 0, 0, 0, 2, 6, 13, "G");
		testPlongee(60, 15, 0, 0, 1, 4, 19, 29, "J");
		testPlongee(60, 20, 0, 0, 3, 8, 32, 48, "L");
		testPlongee(60, 25, 0, 0, 5, 15, 41, 66, "M");
		testPlongee(60, 30, 0, 1, 8, 22, 48, 85, "O");
		testPlongee(60, 35, 0, 4, 11, 28, 54, 103, "P");
		testPlongee(60, 40, 0, 6, 17, 30, 62, 121, "P");
		testPlongee(60, 45, 1, 9, 19, 35, 69, 139, "*");
		testPlongee(60, 50, 2, 13, 22, 37, 78, 158, "*");
		testPlongee(60, 55, 5, 15, 24, 40, 88, 178, "*");
		// 62m
		testPlongee(62, 5, 0, 0, 0, 0, 2, 7, "*");
		testPlongee(62, 10, 0, 0, 0, 2, 7, 14, "*");
		testPlongee(62, 15, 0, 0, 1, 5, 21, 33, "*");
		// 65m
		testPlongee(65, 5, 0, 0, 0, 0, 3, 8, "*");
		testPlongee(65, 10, 0, 0, 0, 3, 8, 16, "*");
		testPlongee(65, 15, 0, 0, 2, 5, 24, 37, "*");
	}

	private void testPlongee(int profondeur, int temps, int tpsP15M, int tpsP12M, int tpsP9M, int tpsP6M, int tpsP3M,
			int dtr, String GPS) {
		TablePlongee mPlongee;
		try {
			mPlongee = new TablePlongee(profondeur, temps);
			assertEquals("Test P3M -> " + mPlongee, tpsP3M, mPlongee.getTpsP3M());
			assertEquals("Test P6M -> " + mPlongee, tpsP6M, mPlongee.getTpsP6M());
			assertEquals("Test P9M -> " + mPlongee, tpsP9M, mPlongee.getTpsP9M());
			assertEquals("Test P12M -> " + mPlongee, tpsP12M, mPlongee.getTpsP12M());
			assertEquals("Test P15M -> " + mPlongee, tpsP15M, mPlongee.getTpsP15M());
			assertEquals("Test DTR -> " + mPlongee, dtr, mPlongee.getDTR());
			assertEquals("Test GPS -> " + mPlongee, GPS, mPlongee.getGPS());
		} catch (PalierNonTrouveException e) {
			e.printStackTrace();
		}
	}
}
