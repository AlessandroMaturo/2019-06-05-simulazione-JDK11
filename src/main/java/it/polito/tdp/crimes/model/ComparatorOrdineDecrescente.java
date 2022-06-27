package it.polito.tdp.crimes.model;

import java.util.Comparator;

public class ComparatorOrdineDecrescente implements Comparator<DistrettoDistanza> {

	@Override
	public int compare(DistrettoDistanza o1, DistrettoDistanza o2) {
		// TODO Auto-generated method stub
		return Double.compare(o2.getDistanza(), o1.getDistanza());
	}

}
