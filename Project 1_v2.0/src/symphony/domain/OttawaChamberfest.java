package symphony.domain;

/**
 * class OttawaChamberfest in symphony.domain package
 */
public class OttawaChamberfest extends Venue {

	/**
	 * constructor
	 * @param address
	 */
	public OttawaChamberfest(String address) {
		super(address);
	}

	@Override
	public boolean hasDiscount() {
		return false;
	}

}
