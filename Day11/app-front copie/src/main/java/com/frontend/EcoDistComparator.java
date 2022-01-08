package com.frontend;

import java.util.Comparator;
import java.util.IdentityHashMap;

import com.frontend.Model.ProductionSite;

public class EcoDistComparator implements Comparator<Integer> {
	IdentityHashMap<Integer, IdentityHashMap<Integer, Integer>> base;
public EcoDistComparator(IdentityHashMap<Integer, IdentityHashMap<Integer, Integer>> listEco_dist) {
this.base = listEco_dist;
}

public int compare(Integer a,Integer b) {
	if (a>=b) {
		return -1;
		} else {
		return 1;
		}
}
}