package symphony.domain;

/**
 * class AlgonquinCommonsTheatre in symphony.domain package
 */
public class AlgonquinCommonsTheatre extends Venue {

	/**
	 * constructor for AlgonquinCommonsTheatre class
	 * @param address AlgonquinCommonsTheatre address
	 */
	public AlgonquinCommonsTheatre(String address) {
		super(address);
	}

	/**
	 * @return true for AlgonquinCommonsTheatre with discount
	 */
	@Override
	public boolean hasDiscount() {
		return true;
	}

}
