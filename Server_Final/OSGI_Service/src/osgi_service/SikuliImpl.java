package osgi_service;

import java.io.IOException;
import java.util.Properties;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import osgi_interface.Sikuli;

public class SikuliImpl implements Sikuli {

	private static String CONFIG_FILE = "/config.properties";
	private static String CHROME = "";
	private static String TEXT = "";
	private static String URL = "";

	public void init() {
		Properties properties = new Properties();
		try {
			properties.load(SikuliImpl.class.getResourceAsStream(CONFIG_FILE));
			CHROME = properties.getProperty("chrome");
			TEXT = properties.getProperty("text");
			URL = properties.getProperty("url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void autoSikuli() {

		init();
		Screen s = new Screen();
		try {
			s.click(CHROME);
			s.wait(TEXT, 10000);
			s.type(URL + Key.ENTER);

		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

}
