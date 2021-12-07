package by.tc.task01.service;

import by.tc.task01.dao.impl.exception.ApplianceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.ArrayList;
import java.util.List;

public interface ApplianceService {

	/**
	 * gets all appliances satisfy category.
	 * @param category name of category looking for.
	 * @return appliances with satisfy category.
	 * @throws ApplianceException  whether no appliances of the category.
	 */
	public List<Appliance> findByCriteria(Criteria category) throws ApplianceException;

	/**
	 * find the cheapest appliance.
	 * @return the cheapest appliances.
	 * @throws ApplianceException whether no appliance was found.
	 */
	public  List<Appliance> findCheapest() throws ApplianceException;
	
}
