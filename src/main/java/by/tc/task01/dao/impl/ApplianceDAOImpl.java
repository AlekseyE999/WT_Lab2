package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.dao.impl.exception.ApplianceException;

import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ApplianceDAOImpl implements ApplianceDAO {


	private final String PATH;
	private List<Appliance> Appliances;
	private DocumentBuilder DocumentBuilder;

	/**
	 * Initialize instance of class ApplianceDAOImpl.
	 */
	public ApplianceDAOImpl() {
		this.PATH = "src/main/resources/ApplianceInfo.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			this.DocumentBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	private void LoadAppliance() throws ApplianceException {
		List<Appliance> appliances = new ArrayList<>();
		NodeList applianceNodeList = parseXml();
		ApplianceFactory factory = ApplianceFactory.getInstance();
		String applianceType;
		for (int i = 0; i < applianceNodeList.getLength(); i++) {
			Node node = applianceNodeList.item(i);
			if (node.getNodeType() == node.ELEMENT_NODE) {
				Element applianceElement = (Element) node;
				applianceType = applianceElement.getTagName();
				Appliance appliance = factory.getAppliance(applianceType, applianceElement);
				appliances.add(appliance);
			}
		}

		this.Appliances = appliances;
	}

	private NodeList parseXml() throws ApplianceException {
		Document document;
		Element root;
		try {
			document = this.DocumentBuilder.parse(this.PATH);
			root = document.getDocumentElement();
		} catch (IOException e) {
			System.err.printf("Error while reading file %s. %s%n", this.PATH, e.getMessage());
			throw new ApplianceException("Error while reading file %s. %s%n" + this.PATH, e);
		} catch (SAXException e) {
			System.err.printf("Error while parsing file %s. %s%n", this.PATH, e.getMessage());
			throw new ApplianceException("Error while parsing file %s. %s%n" + this.PATH, e);
		}

		return root.getChildNodes();
	}

	/**
	 *
	 * @param category - name of appliance category looking for.
	 * @return appliances founded.
	 * @throws ApplianceException - if there are mistakes while finding appliances
	 */
	@Override
	public List<Appliance> findByCriteria(Criteria category) throws ApplianceException {
		if (this.Appliances == null) {
			LoadAppliance();
		}

		return this.Appliances.stream().
				filter(appliance -> appliance.getClass().getSimpleName().
						equals(category)).toList();
	}

	/**
	 *
	 * @return appliances founded.
	 * @throws ApplianceException - if there are mistakes while finding appliances.
	 */
	@Override
	public List<Appliance> findCheapest() throws ApplianceException {
		if (this.Appliances == null) {
			LoadAppliance();
		}

		var list = new ArrayList<Appliance>();
		int smallerPrice = Integer.MAX_VALUE;
		for (var appliance : this.Appliances){
			if (smallerPrice > appliance.getPrice()){
				smallerPrice = (int) appliance.getPrice();
				list = new ArrayList<Appliance>();
				list.add(appliance);
			}
			else if (smallerPrice == appliance.getPrice()){
				list.add(appliance);
			}
		}
		return list;
	}

	@Override
	public List<Appliance> retrieveAppliances() throws ApplianceException {
		List<Appliance> appliances = new ArrayList<>();
		NodeList applianceNodeList = parseXml();
		ApplianceFactory factory = ApplianceFactory.getInstance();
		ApplianceTypes applianceType;
		for (int i = 0; i < applianceNodeList.getLength(); i++) {
			Node node = applianceNodeList.item(i);
			if (node.getNodeType() == node.ELEMENT_NODE) {
				Element applianceElement = (Element) node;
				applianceType = ApplianceTypes.valueOf(getFormattedApplianceType(applianceElement.getTagName()));
				Appliance appliance = factory.getAppliance(String.valueOf(applianceType), applianceElement);
				appliances.add(appliance);
			}
		}
		return appliances;
	}

	private static String getFormattedApplianceType(String applianceType) {
		final String UNDERSCORE = "_";
		final String HYPHEN = "-";
		return applianceType.toUpperCase().replace(HYPHEN, UNDERSCORE);
	}
}