package osgi_client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import osgi_interface.Sikuli;

public class Activator implements BundleActivator {

	private ServiceTracker tracker;
	
	public void start(BundleContext bundleContext) throws Exception {
		
		tracker = new ServiceTracker(bundleContext, Sikuli.class.getName(), null) {
            @Override
            public Object addingService(ServiceReference reference) {
                Object service = super.addingService(reference);
                if (service instanceof Sikuli) {
                   ((Sikuli) service).autoSikuli();
                }
                return service;
            }
        };
        tracker.open();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		tracker.close();
	}

}
