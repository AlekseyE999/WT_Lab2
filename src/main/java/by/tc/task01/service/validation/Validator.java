package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.ApplianceTypes;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.dao.impl.exception.ApplianceException;

import java.util.Set;

public class Validator {

	/**
	 * Criteria validator boolean.
	 *
	 * @param criteria the criteria
	 * @return the boolean
	 */
	public static boolean criteriaValidator(Criteria criteria) throws ApplianceException {
		Set<String> propertySet = criteria.getCriteria().keySet();
		switch (ApplianceTypes.valueOf(getFormattedApplianceType(criteria.getGroupSearchName()))) {
			case OVEN -> {
				return checkOvenCriteria(propertySet, criteria);
			}
			case LAPTOP -> {
				return checkLaptopCriteria(propertySet, criteria);
			}
			case REFRIGERATOR -> {
				return checkRefrigeratorCriteria(propertySet, criteria);
			}
			default -> {
				return false;
			}
		}
	}

	private static String getFormattedApplianceType(String applianceType) {
		final String UNDERSCORE = "_";
		final String HYPHEN = "-";
		return applianceType.toUpperCase().replace(HYPHEN, UNDERSCORE);
	}

	private static boolean checkOvenCriteria(Set<String> propertySet, Criteria criteria) throws ApplianceException {
		for (String property : propertySet) {
			String propertyValue = (String) criteria.getCriteria().get(property);
			switch (SearchCriteria.Oven.valueOf(getFormattedApplianceType(property))) {
				case CAPACITY, WIDTH, HEIGHT, DEPTH -> {
					try {
						Integer.parseInt(propertyValue);
					} catch (NumberFormatException e) {
						throw new ApplianceException("Invalid criteria");
					}
				}
				default -> {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean checkLaptopCriteria(Set<String> propertySet, Criteria criteria) throws ApplianceException {
		for (String property : propertySet) {
			String propertyValue = (String) criteria.getCriteria().get(property);
			try {
				switch (SearchCriteria.Laptop.valueOf(getFormattedApplianceType(property))) {
					case PRICE, SYSTEM_MEMORY, CPU -> {
						Integer.parseInt(propertyValue);
					}
				}
			} catch (IllegalArgumentException e) {
				throw new ApplianceException("Invalid criteria");
			}
		}
		return true;
	}

	private static boolean checkRefrigeratorCriteria(Set<String> propertySet, Criteria criteria) throws ApplianceException {
		for (String property : propertySet) {
			String propertyValue = (String) criteria.getCriteria().get(property);
			try {
				switch (SearchCriteria.Refrigerator.valueOf(getFormattedApplianceType(property))) {
					case WIDTH, HEIGHT, OVERALL_CAPACITY -> {
						Integer.parseInt(propertyValue);
					}
					default -> {
						return false;
					}
				}
			} catch (IllegalArgumentException e) {
				throw new ApplianceException("Invalid criteria");
			}
		}
		return true;
	}
}