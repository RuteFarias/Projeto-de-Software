package edu.ccc.pharma.util;

import java.util.Comparator;

import edu.ccc.pharma.model.Produto;

public class ComparadorCategorias implements Comparator<Produto> {

	public ComparadorCategorias() {
		
	}
	
	@Override
	public int compare(Produto p1, Produto p2) {
		return p1.getCategoria().compareTo(p2.getCategoria());
	}

}