package models;

/**
 * Class describe a home darling
 * It may be more than one.
 */
public class Pet {

	private String nick;
	private int ownId;
	private int petId;

	/**
	 * @param type - type of home pet, catm dog, bird, ...
	 */
	private String type;

	public Pet() {}
	public Pet(int ownId, int petId, String type, String nick) {
		this();
		this.ownId = ownId;
		this.type = type;
		this.petId = petId;
		this.nick = nick;
	}



	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getOwnId() {
		return ownId;
	}

	public void setOwnId(int ownId) {
		ownId = ownId;
	}
}
