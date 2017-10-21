package osgi_service;

import java.util.ArrayList;
import java.util.Properties;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import osgi_interface.Sikuli;

public class SikuliImpl implements Sikuli {

	public ArrayList<String> readFileProperties(String propertise) {
		ArrayList<String> list = new ArrayList<String>();
		Properties properties = new Properties();
		String user = "";

		try {
			properties.load(SikuliImpl.class.getResourceAsStream(propertise));

			user = properties.getProperty("path0");
			list.add(user);
			user = properties.getProperty("path1");
			list.add(user);
			user = properties.getProperty("path2");
			list.add(user);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public void autoSikuli() {

		SikuliImpl gp = new SikuliImpl();
		ArrayList<String> listpath = gp.readFileProperties("/config.properties");
		Screen s = new Screen();
		try {
			s.click(listpath.get(1));
			s.wait(listpath.get(2), 10000);
			s.type("dxc.technology/vn_vn" + Key.ENTER);

		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

}
