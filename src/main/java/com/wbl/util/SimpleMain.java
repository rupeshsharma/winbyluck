package com.wbl.util;

import java.util.Locale;

public class SimpleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] locales = Locale.getISOCountries();

		for (String countryCode : locales) {

			Locale obj = new Locale("", countryCode);

			System.out.println("Country Code = " + obj.getCountry() 
				+ ", Country Name = " + obj.getDisplayCountry());

		}
	}

}
