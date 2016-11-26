package symphony.domain;

public class OttawaChamberfest extends Venue {

	public OttawaChamberfest(String address) {
		super(address);
	}

	@Override
	public boolean hasDiscount() {
		return false;
	}

}
