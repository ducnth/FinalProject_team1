package osgi_service;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import osgi_interface.Sikuli;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration registration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {

		Activator.context = bundleContext;

		Dictionary props = new Hashtable();

		props.put("service.exported.interfaces", "*");
		props.put("service.exported.configs", "org.apache.cxf.ws");
		props.put("org.apache.cxf.ws.address", "http://20.203.139.9:9090/sikuli");

		registration = bundleContext.registerService(Sikuli.class.getName(), new SikuliImpl(), props);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		registration.unregister();
	}

}
