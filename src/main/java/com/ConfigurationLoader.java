package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationLoader {

	public static void main(String[] args) {
		configurationLoader();
	}

	public static Properties configurationLoader() {

		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = Activator.class.getClassLoader().getResourceAsStream(PawnConstants.CONFIG_PROPERTY_FILE_NAME);
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			System.out.println(prop.getProperty("chequerBoardSize"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop;
	}
}
