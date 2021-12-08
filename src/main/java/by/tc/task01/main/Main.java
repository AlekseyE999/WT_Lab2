package by.tc.task01.main;

import by.tc.task01.dao.impl.exception.ApplianceException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.util.List;
/**
 * The type Main.
 */
public class Main {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		try {
			List<Appliance> appliances;
			ServiceFactory factory = ServiceFactory.getInstance();
			ApplianceService service = factory.getApplianceService();
			Criteria laptopCriteria = new Criteria(SearchCriteria.Laptop.getTagName());
			appliances = service.findByCriteria(laptopCriteria);
			System.out.println("Найдены ноутбуки: ");
			PrintApplianceInfo.print(appliances);
			System.out.println();
			appliances = service.findCheapest();
			System.out.println("Товар с минимальной стоимостью: ");
			PrintApplianceInfo.print(appliances);
		} catch (ApplianceException e) {
			System.err.println(e.getMessage());
		}
	}
}
