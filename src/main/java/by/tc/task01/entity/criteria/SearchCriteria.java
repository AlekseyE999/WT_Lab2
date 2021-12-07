package by.tc.task01.entity.criteria;

public final class SearchCriteria {

	private static final String UNDERSCORE = "_";
	private static final String HYPHEN = "-";

	private static String makeString(Enum o) {
		String result = o.name();
		result = result.toLowerCase();
		result = result.replace(UNDERSCORE, HYPHEN);
		return result;
	}

	/**
	 * The enum Oven.
	 */
	public static enum Oven{
		CAPACITY, DEPTH, HEIGHT, WIDTH, PRICE;

		/**
		 * Gets tag name.
		 *
		 * @return the tag name
		 */
		public static String getTagName() {
			return "oven";
		}

		@Override
		public String toString() {
			return makeString(this);
		}
	}

	/**
	 * The enum Laptop.
	 */
	public static enum Laptop{
		SYSTEM_MEMORY, CPU, PRICE;

		public static String getTagName() {
			return "laptop";
		}

		@Override
		public String toString() {
			return makeString(this);
		}
	}

	/**
	 * The enum Refrigerator.
	 */
	public static enum Refrigerator{
		OVERALL_CAPACITY, HEIGHT, WIDTH, PRICE;

		public static String getTagName() {
			return "refrigerator";
	}

		@Override
		public String toString() {
			return makeString(this);
		}

	}
	private void SearchCriteria() {
	}
}

