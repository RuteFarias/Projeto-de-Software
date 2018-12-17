package edu.ccc.pharma.util;

import java.util.Comparator;

import edu.ccc.pharma.model.Produto;

public class ComparadorPrecos implements Comparator<Produto>{
	
	public ComparadorPrecos() {
		
	}
	
	@Override
	public int compare(Produto p1, Produto p2) {
		return p1.getPreco().compareTo(p2.getPreco());
	}

}
