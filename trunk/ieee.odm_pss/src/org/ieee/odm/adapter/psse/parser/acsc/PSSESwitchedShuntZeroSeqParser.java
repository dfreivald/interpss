package org.ieee.odm.adapter.psse.parser.acsc;

import org.ieee.odm.adapter.psse.PSSEAdapter.PsseVersion;
import org.ieee.odm.adapter.psse.parser.aclf.BasePSSEDataParser;

public class PSSESwitchedShuntZeroSeqParser extends BasePSSEDataParser {
	public PSSESwitchedShuntZeroSeqParser(PsseVersion ver) {
		super(ver);
	}
	
	@Override 
	public String[] getMetadata() {
		/*
		 * PSS/E ver. 30-32 zero sequence Switched SHUNT  data
		 * 
		 * 
		 * I,  BZ1, BZ2, ... BZ8
		 * where:
		 * BZi  Zero sequence reactance increment for each of the steps in block i; entered in pu. 
		 *      BZi= 0.0 by default.
		 *      
		 * # of blocks should be consistent with  that of positive sequence   
		 */
		
		return new String[]{
			//  0----------1----------2----------3----------4
				"I",     "BZ1",     "BZ2",      "BZ3",   "BZ4", 
			//  5----------6----------7----------8----------9	
				"BZ5",    "BZ6",    "BZ7",    "BZ8"
		};
		
	}

}
