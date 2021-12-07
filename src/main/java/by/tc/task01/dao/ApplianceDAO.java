package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.dao.impl.exception.ApplianceException;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {
	/**
	 *
	 * @param category - name of appliance category looking for.
	 * @return appliances founded.
	 * @throws ApplianceException - if there are mistakes while finding appliances
	 */
	List<Appliance> findByCriteria(Criteria category) throws ApplianceException;

	/**
	 *
	 * @return appliances founded.
	 * @throws ApplianceException - if there are mistakes while finding appliances.
	 */
	List<Appliance> findCheapest() throws ApplianceException;

	/**
	 * Ret appliances list.
	 *
	 * @return all appliances.
	 * @throws ApplianceException while extracting appliances
	 */
	List<Appliance> retrieveAppliances() throws ApplianceException;
}
