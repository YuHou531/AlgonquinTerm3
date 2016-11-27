package symphony.domain;

/**
 * class OttawaChamberfest in symphony.domain package
 */
public class OttawaChamberfest extends Venue {

	/**
	 * constructor for OttawaChamberfest
	 * @param address of OttawaChamberfest
	 */
	public OttawaChamberfest(String address) {
		super(address);
	}

	/** 
	 * @return false for OttawaChamberfest no discount
	 */
	@Override
	public boolean hasDiscount() {
		return false;
	}

}
