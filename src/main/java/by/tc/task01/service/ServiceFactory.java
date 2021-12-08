package by.tc.task01.service;

import by.tc.task01.service.impl.ApplianceServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final ApplianceService applianceService = new ApplianceServiceImpl();

	private ServiceFactory() {

	}

	/**
	 * gets appliance service instance.
	 * @return appliance service instance.
	 */
	public ApplianceService getApplianceService() {

		return applianceService;
	}

	/**
	 * gets service factory instance.
	 * @return service factory instance.
	 */
	public static ServiceFactory getInstance() {
		return instance;
	}

}
