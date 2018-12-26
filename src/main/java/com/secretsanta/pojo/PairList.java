package com.secretsanta.pojo;

import java.util.ArrayList;
import java.util.Iterator;

import com.secretsanta.exceptions.NameNotFoundException;

public class PairList {
	private ArrayList<Pair> pairs;

	public PairList() {
		this.pairs = new ArrayList<Pair>();

	}

	public void add(Pair p) {
		this.pairs.add(p);

	}

	public void remove(int index) {
		this.pairs.remove(index);
	}

	public String findSanta(String recipient) {
		for (Pair p : this.pairs) {
			if (p.getRecipientName().equals(recipient)) {
				return p.getSantaName();
			}
		}
		return null;
	}

	public String findRecipient(String santa) throws NameNotFoundException {
		for (Pair p : this.pairs) {
			if (p.getSantaName().equals(santa)) {
				return p.getRecipientName();
			}
		}
		throw new NameNotFoundException("Name could not be found");
	}

	public ArrayList<Pair> getPairs() {
		return this.pairs;
	}

	public void clear() {
		pairs.clear();
	}

	public Iterator<Pair> iterator() {
		return pairs.iterator();
	}
	
	@Override
	public String toString() {
		for (Pair p:pairs){
			System.out.println("Santa Clause  "+p.getSantaName()+ "("+p.getSantaLocation()+")" +":  Receipient Name " +p.getRecipientName()+ "("+ p.getRecipientLocation()+")");
		}
		return "PairList [pairs=" + pairs + "]";
	}
}
