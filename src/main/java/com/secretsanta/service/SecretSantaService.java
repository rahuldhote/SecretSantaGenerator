package com.secretsanta.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;


import com.secretsanta.exceptions.NameAlreadyExistsException;
import com.secretsanta.exceptions.NameNotFoundException;
import com.secretsanta.pojo.Pair;
import com.secretsanta.pojo.PairList;
import com.secretsanta.pojo.SecretSantaMember;
import com.secretsanta.utils.MailUtils;

public class SecretSantaService {

	private PairList references;
	private ArrayList<SecretSantaMember> people;
	private String fileLocation;

	public SecretSantaService() {
		this.references = new PairList();
		this.people = new ArrayList<SecretSantaMember>();
	}

	public SecretSantaService(ArrayList<SecretSantaMember> secretSantaMembers) {
		this.references = new PairList();
		this.people = secretSantaMembers;
	}

	public static void main(String[] argv) {

	}

	public void sendMail(ArrayList<SecretSantaMember> people2, PairList pairList) {
		String email;
		String n = "null";
		for (SecretSantaMember p : people2) {
			email = p.getEmail();
			try {
				n = pairList.findRecipient(p.getName());
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
			if (email != null && !email.isEmpty()) {
				MailUtils.sendMail(email, "Twinkle Twinkle Little Star",
						"Hello "+p.getName()+",\n Your Participation is appreciated in Secret Santa Game.\n We alway's believe in giving. On the Ocassion of Christmas, you share your blessing's and good wishes to Mr/Mrs: " +n+ "\n\n\n God Bless you!!");
			}
		}
		MailUtils.sendMailRecord(MailUtils.username, "Secret Santa Event Occured On :: "+new Date(),pairList.toString());

	}

	public void setName(String name) throws NameAlreadyExistsException {
		if (this.people.contains(name))
			throw new NameAlreadyExistsException(
					"Tried to add a name that already exists.");
		else
			this.people.add(new SecretSantaMember(name));
	}

	public ArrayList<SecretSantaMember> getPeople() {
		return this.people;
	}

	public void setFileLocation(String location) {
		this.fileLocation = location;
	}

	public String getFileLocation() {
		return this.fileLocation;

	}

	public int getPeopleSize() {
		return people.size();
	}

	public Iterator<SecretSantaMember> getPeopleIterator() {
		return this.people.iterator();
	}

	public PairList getReferences() {
		return this.references;
	}

	private boolean isUniquePair(Pair p) {
		if (p.getSantaName().equals(p.getRecipientName()))
			return false;
		else
			return true;
	}

	private boolean isUniqueLocation(Pair p) {
		if (p.getSantaLocation().equals(p.getRecipientLocation()))
			return false;
		else
			return true;
	}

	private void clearReferences() {
		this.references.clear();
	}

	public void setPairs() {
		boolean ok = false;
		ArrayList<SecretSantaMember> shuffle = null;
		while (!ok) {
			shuffle = shufflePeople(people);
			clearReferences();
			int size = getPeopleSize();
			int i = 0;
			ok = false;

			for (i = 0; i < size; i++) {
				Pair p = new Pair(people.get(i), shuffle.get(i));
				references.add(p);

			}
			boolean dupes = checkForDuplicates(references);
			if (checkForDuplicates(references)
					&& checkForDuplicateLocation(references))
				ok = true;
	       }
               sendMail(people,references);

	}

	private ArrayList<SecretSantaMember> shufflePeople(
			ArrayList<SecretSantaMember> p) {
		long seed = System.nanoTime();
		ArrayList<SecretSantaMember> shuffle = (ArrayList<SecretSantaMember>) p
				.clone();
		Collections.shuffle(shuffle, new Random(seed));
		return shuffle;
	}

	private boolean checkForDuplicates(PairList p) {
		// true = no duplicates, false = duplicates
		Iterator<Pair> it = p.iterator();
		boolean goodtogo = true;
		while (it.hasNext()) {
			Pair pair = it.next();
			if (!isUniquePair(pair)) {
				goodtogo = false;
			}
		}
		return goodtogo;
	}

	private boolean checkForDuplicateLocation(PairList p) {
		// true = no duplicates, false = duplicates
		Iterator<Pair> it = p.iterator();
		boolean goodtogo = true;
		while (it.hasNext()) {
			Pair pair = it.next();
			if (!isUniqueLocation(pair)) {
				goodtogo = false;
			}
		}
		return goodtogo;
	}

	public String toString(ArrayList<SecretSantaMember> p) {

		StringBuffer sb = new StringBuffer("[");
		int size = p.size();
		for (int i = 0; i < size; i++) {
			sb.append(p.get(i).getName());
			if (i != size - 1)
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}

	private void clearPeople() {
		// references.clear();
		people.clear();
	}

}
