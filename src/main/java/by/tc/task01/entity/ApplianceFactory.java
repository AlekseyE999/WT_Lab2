package by.tc.task01.entity;

import by.tc.task01.dao.impl.exception.ApplianceException;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.sql.Ref;
import java.util.Locale;

public class ApplianceFactory {

    private static final ApplianceFactory instance = new ApplianceFactory();

    /**
     * gets appliance factory.
     * @return appliance factory.
     */
    public static ApplianceFactory getInstance() {
        return instance;
    }

    private ApplianceFactory() {
    }

    /**
     * gets appliance instance.
     * @param applianceType the type of creating appliance.
     * @param element which appliance properties are got from.
     * @return appliance
     * @throws ApplianceException whether the document format is invalid
     */
    public Appliance getAppliance(String applianceType, Object element) throws ApplianceException {
        Appliance appliance;
        if (element.getClass().getSimpleName().equals("DeferredElementImpl")) {
            appliance = getApplianceFromXml(applianceType, (Element) element);
        } else {
            System.err.println("Invalid format");
            throw new ApplianceException("Invalid format");
        }
        return appliance;
    }

    private Appliance getApplianceFromXml(String applianceType, Element element) {
        Appliance appliance;
        switch (applianceType) {
            case "oven" -> {
                appliance = (Oven) createOven(element);
            }
            case "laptop" -> {
                appliance = (Laptop) createLaptop(element);
            }
            case "refrigerator" -> {
                appliance = (Refrigerator) createRefrigerator(element);
            }
            default -> {
                appliance = null;
            }
        }
        return appliance;
    }

    private Appliance createLaptop(Element element) {
        var price = Integer.parseInt(getElementTextContent(element, SearchCriteria.Laptop.PRICE.toString().toLowerCase()));
        var sysMemory = Integer.parseInt(getElementTextContent(element, SearchCriteria.Laptop.SYSTEM_MEMORY.toString().toLowerCase()));
        var cpu = getElementTextContent(element, SearchCriteria.Laptop.CPU.toString().toLowerCase());
        return new Laptop(sysMemory, price, cpu);
    }

    private Appliance createOven(Element element) {
        var price = Integer.parseInt(getElementTextContent(element, SearchCriteria.Oven.PRICE.toString().toLowerCase()));
        var capacity = Integer.parseInt(getElementTextContent(element, SearchCriteria.Oven.CAPACITY.toString().toLowerCase()));
        var depth = Integer.parseInt(getElementTextContent(element, SearchCriteria.Oven.DEPTH.toString().toLowerCase()));
        var height = Integer.parseInt(getElementTextContent(element, SearchCriteria.Oven.HEIGHT.toString().toLowerCase()));
        var width = Integer.parseInt(getElementTextContent(element, SearchCriteria.Oven.WIDTH.toString().toLowerCase()));
        return new Oven(capacity, depth, width, price, height);
    }

    private Appliance createRefrigerator(Element element) {
        var price = Integer.parseInt(getElementTextContent(element, SearchCriteria.Refrigerator.PRICE.toString().toLowerCase()));
        var width = Integer.parseInt(getElementTextContent(element, SearchCriteria.Refrigerator.WIDTH.toString().toLowerCase()));
        var height = Integer.parseInt(getElementTextContent(element, SearchCriteria.Refrigerator.HEIGHT.toString().toLowerCase()));
        var capacity = Integer.parseInt(getElementTextContent(element, SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString().toLowerCase()));
        return new Refrigerator(price, capacity, height, width);
    }

    private static String getElementTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() == 0) {
            System.err.printf("Element %s doesn't contain tag %s%n", element, tagName);
        }
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
