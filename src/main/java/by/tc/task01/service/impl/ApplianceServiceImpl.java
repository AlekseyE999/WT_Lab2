package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.dao.impl.exception.ApplianceException;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class ApplianceServiceImpl implements ApplianceService{

	public List<Appliance> findByCriteria(Criteria criteria) throws ApplianceException {
		if (!Validator.criteriaValidator(criteria)) {
			throw new ApplianceException("Invalid criteria");
		}

		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		return applianceDAO.findByCriteria(criteria);
	}

	public List<Appliance> findCheapest() throws ApplianceException {
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		List<Appliance> appliances = applianceDAO.retrieveAppliances();
		if (appliances.isEmpty()) {
			return appliances;
		} else {
			return getCheapest(appliances);
		}
	}

	private List<Appliance> getCheapest(List<Appliance> appliances) {
		List<Appliance> appliancesWithMinCost = new ArrayList<>();
		Appliance appliance = appliances.get(0);
		float minimalCost = appliance.getPrice();
		int i = 1;
		while (appliance.getPrice() == minimalCost) {
			appliancesWithMinCost.add(appliance);
			appliance = appliances.get(i);
			i++;
		}
		return appliancesWithMinCost;
	}

}
