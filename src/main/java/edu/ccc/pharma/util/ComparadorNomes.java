package edu.ccc.pharma.util;

import java.util.Comparator;

import edu.ccc.pharma.model.Produto;

public class ComparadorNomes implements Comparator<Produto> {
	
	public ComparadorNomes() {
				
}

	@Override
	public int compare(Produto p1, Produto p2) {
		return p1.getNome().compareTo(p2.getNome());

	}

}