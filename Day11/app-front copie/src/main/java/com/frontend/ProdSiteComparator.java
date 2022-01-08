package com.frontend;

import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import com.frontend.Model.Production;
import com.frontend.Model.ProductionSite;

public class ProdSiteComparator implements Comparator<Integer> {
	List<Production> base;
public ProdSiteComparator(List<Production> list_prod) {
this.base = list_prod;
}

public int compare(Integer a,Integer b) {
return base.get(a).compareTo(base.get(b));
}
}