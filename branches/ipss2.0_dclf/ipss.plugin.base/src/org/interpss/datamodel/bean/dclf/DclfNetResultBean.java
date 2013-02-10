package org.interpss.datamodel.bean.dclf;

import java.util.ArrayList;
import java.util.List;

import org.interpss.datamodel.bean.BaseNetBean;
import org.interpss.datamodel.bean.aclf.AclfBusBean;
import org.interpss.datamodel.bean.datatype.ComplexBean;
import org.interpss.datamodel.bean.datatype.MismatchResultBean;

public class DclfNetResultBean extends BaseNetBean {	
	

	public List<DclfBusResultBean> bus_list; // bus bean list
	public List<DclfBranchResultBean> branch_list; // branch bean list

	public DclfNetResultBean() {
		bus_list = new ArrayList<DclfBusResultBean>();
		branch_list = new ArrayList<DclfBranchResultBean>();
	}
}
