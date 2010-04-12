package org.interpss.vstab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

public enum LoadIncPatten implements Enumerator{
   BY_BUS , BY_ZONE,BY_OWNER, BY_NET;
   
   private  String literal;
   private  String name;
   private  int value;
   
   public static final int BY_BUS_VALUE=0;
   public static final int BY_ZONE_VALUE=1;
   public static final int BY_OWNER_VALUE=2;
   public static final int BY_NET_VALUE=3;
   
   private static final LoadIncPatten[] VALUES_ARRAY={BY_BUS,BY_ZONE,BY_OWNER,BY_NET};
   public static List<LoadIncPatten> VALUES=Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
  
   public LoadIncPatten getByLiteral(String objLiteral){
	   for(LoadIncPatten result: VALUES){
		   if(result.getLiteral().equals(objLiteral)){
			   return result;
		   }
	   }
	   return null ;
   }
   public LoadIncPatten getByName(String objName){
	   for(LoadIncPatten result: VALUES){
		   if(result.getName().equals(objName)){
			   return result;
		   }
	   }
	   return null ;
   }
	   

public String getLiteral() {

	return literal;
}

public String getName() {
	return name;
}

public int getValue() {
	return value;
}
}

