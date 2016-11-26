package symphony.domain;

public class AlgonquinCommonsTheatre extends Venue {

	public AlgonquinCommonsTheatre(String address) {
		super(address);
	}

	@Override
	public boolean hasDiscount() {
		return true;
	}

}
