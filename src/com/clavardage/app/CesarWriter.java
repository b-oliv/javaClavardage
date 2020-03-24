package com.clavardage.app;

public class CesarWriter {

	private int indexCrypt;
	private String oldStr;
	private String strCrypt;

	public CesarWriter(String oldStr) {
		this.oldStr = oldStr.toString();
	}

	public CesarWriter defineNumberToCrypt(int indexCrypt) {
		this.indexCrypt = indexCrypt;
		return this;
	}

	public CesarWriter build() {
		for (int i = 0; i < oldStr.length(); i++) {
			int asciiChar = oldStr.charAt(i);
			asciiChar += this.indexCrypt;
			strCrypt += (char) asciiChar;
		}
		return this;
	}

	public String toString() {
		return strCrypt;
	}

}
