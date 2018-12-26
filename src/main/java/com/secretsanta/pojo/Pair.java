package com.secretsanta.pojo;

public class Pair {
	private SecretSantaMember santa;
	private SecretSantaMember recipient;

	public Pair(SecretSantaMember santa, SecretSantaMember recipient) {
		this.santa = santa;
		this.recipient = recipient;
	}

	public void setPair(SecretSantaMember s, SecretSantaMember r) {
		this.santa = s;
		this.recipient = r;
	}

	public String getSantaName() {
		return this.santa.getName();
	}

	public String getRecipientName() {
		return this.recipient.getName();
	}

	public String getSantaEmail() {
		return this.santa.getEmail();
	}

	public String getRecipientEmail() {
		return this.recipient.getEmail();
	}

	public SecretSantaMember getSanta() {
		return this.santa;
	}

	public SecretSantaMember getRecipient() {
		return this.recipient;
	}

	public String getSantaLocation() {
		return this.santa.getLocation();
	}

	public String getRecipientLocation() {
		return this.recipient.getLocation();
	}

}
