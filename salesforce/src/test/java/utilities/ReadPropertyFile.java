package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static Properties prop = new Properties();

	public static Properties read(String fileLocation) throws IOException {

		// "Read the Property File"
		FileReader fr;
		try {
			fr = new FileReader(fileLocation);

			prop.load(fr);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}

}
