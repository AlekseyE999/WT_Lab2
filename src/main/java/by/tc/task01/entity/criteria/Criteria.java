package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

	private final String groupSearchName;
	private Map<String, Object> criteria = new HashMap<String, Object>();

	/**
	 * Instantiates a new Criteria.
	 *
	 * @param groupSearchName the group search name
	 */
	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}

	/**
	 * Gets group search name.
	 *
	 * @return the group search name
	 */
	public String getGroupSearchName() {
		return groupSearchName;
	}

	/**
	 * Gets criteria.
	 *
	 * @return the criteria
	 */
	public Map<String, Object> getCriteria() {
		return criteria;
	}

	/**
	 * Sets criteria.
	 *
	 * @param criteria the criteria
	 */
	public void setCriteria(Map<String, Object> criteria) {
		this.criteria = criteria;
	}

}
