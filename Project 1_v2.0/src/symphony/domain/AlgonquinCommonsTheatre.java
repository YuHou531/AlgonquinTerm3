package symphony.domain;

/**
 * class AlgonquinCommonsTheatre in symphony.domain package
 */
public class AlgonquinCommonsTheatre extends Venue {

	/**
	 * constructor
	 * @param address
	 */
	public AlgonquinCommonsTheatre(String address) {
		super(address);
	}

	@Override
	public boolean hasDiscount() {
		return true;
	}

}
