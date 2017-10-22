package com.yogi.api.util;

import java.util.Collection;

/**
 *
 * @author Krishan Shukla
 * Created by Krishan Shukla on 20/10/2017.
 *
 */
public class Util {

	private static final String[] UNITS = { "KB", "MB", "GB", "TB" };

	/**
	 * Return true if the collection is empty
	 *
	 * @param c
	 * @return
	 */
	public static boolean isEmpty(Collection c) {
		if (c == null)
			return true;
		if (c.size() == 0)
			return true;
		return false;
	}

	/**
	 * return true if the string is empty
	 *
	 * @param c
	 * @return
	 */
	public static boolean isEmpty(String c) {
		if (c == null || c.trim().length() == 0)
			return true;
		return false;
	}

	/**
	 * return true if the string is not empty
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * returns the file size in the units of KB,MB,GB,TB
	 *
	 * @param size
	 * @return
	 */
	public static String getFileSizeInUnits(long size) {
		boolean loop = true;
		int count = 0;
		while (loop) {
			size = size / 1024;
			if (count + 1 < 4 && size > 1024) {
				count++;
				loop = true;
			} else
				loop = false;
		}
		return size + UNITS[count];
	}
}
