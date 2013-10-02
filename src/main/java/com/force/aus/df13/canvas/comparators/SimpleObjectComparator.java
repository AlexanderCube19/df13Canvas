package com.force.aus.df13.canvas.comparators;

import java.util.Comparator;

import com.force.aus.df13.canvas.entity.SimpleObject;

public class SimpleObjectComparator implements Comparator<SimpleObject>{

	@Override
	public int compare(SimpleObject o1, SimpleObject o2) {
		
		if(o1.getObjectName() != null && o2.getObjectName() != null)	
			return o1.getObjectName().toLowerCase().compareTo(o2.getObjectName().toLowerCase());
		if(o1.getObjectName() == null && o2.getObjectName() != null) 
			return -1;
		if(o1.getObjectName() != null && o2.getObjectName() == null) 
			return 1;
		
		return 0;
	}

}
