package osgi_service;

import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import osgi_interface.Sikuli;

public class Activator implements BundleActivator {

	private ServiceRegistration registration;

	public void start(BundleContext bundleContext) throws Exception {
		
		Hashtable<String, String> props = new Hashtable();

		props.put("service.exported.interfaces", "*");
		props.put("service.exported.configs", "org.apache.cxf.ws");
		props.put("org.apache.cxf.ws.address", "http://20.203.139.9:9090/sikuli");

		registration = bundleContext.registerService(Sikuli.class.getName(), new SikuliImpl(), props);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		registration.unregister();
	}

}
