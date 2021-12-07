package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {

	/**
	 * gets info about appliance.
	 * @param appliances appliance to get info
	 */
	public static void print(List<Appliance> appliances) {
		if (appliances == null){
			throw new NullPointerException("appliance is null");
		}

		for	(var appliance : appliances){
			System.out.println(appliance.toString());
		}
	}

}
