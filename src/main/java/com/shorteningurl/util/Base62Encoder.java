package com.shorteningurl.util;

public class Base62Encoder {
	private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String encode(long value) {
		if (value == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		while (value > 0) {
			int remainder = (int) (value % 62);
			sb.append(BASE62.charAt(remainder));
			value /= 62;
		}
		return sb.reverse().toString();
	}
}
