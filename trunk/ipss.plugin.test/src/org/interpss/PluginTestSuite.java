package org.interpss;

import org.interpss.cmd.AclfCmdRunTest;
import org.interpss.cmd.RunExecTest;
import org.interpss.core.adapter.ieee.IEEECommonFormatTest;
import org.interpss.core.adapter.ieee.IEEECommonFormat_CommaTest;
import org.interpss.core.adapter.internal.Bus1824Test;
import org.interpss.core.adapter.internal.IEEE14Test;
import org.interpss.core.adapter.ucte.UCTEFormatMarioTest;
import org.interpss.dstab.control.cml.block.DelayControlBlockTests;
import org.interpss.dstab.control.cml.block.FilterControlBlockTests;
import org.interpss.dstab.control.cml.block.IntegrationControlBlockTests;
import org.interpss.dstab.control.cml.block.PIControlBlockTests;
import org.interpss.dstab.control.cml.block.WashoutControlBlockTests;
import org.interpss.dstab.ieeeModel.IEEE11ModelTest;
import org.interpss.dstab.ieeeModel.IEEE12ModelTest;
import org.interpss.dstab.ieeeModel.IEEE21ModelTest;
import org.interpss.dstab.ieeeModel.IEEE22ModelTest;
import org.interpss.dstab.mach.EConstMachineTest;
import org.interpss.dstab.mach.Eq1Ed1MachineTest;
import org.interpss.dstab.mach.Eq1MachineCaseTest;
import org.interpss.dstab.mach.MachineSaturationTest;
import org.interpss.dstab.mach.RoundRotorMachineTest;
import org.interpss.dstab.mach.SalientPoleMachineTest;
import org.interpss.schema.DStabSchemaIEEE11ModelTest;
import org.interpss.schema.AclfSchemaIeee14BusCaseTest;
import org.interpss.schema.AcscSchemaSampleCaseTest;
import org.interpss.schema.DclfSchemaIeee14BusCaseTest;
import org.interpss.spring.CustomFileAdapterTest;
import org.interpss.spring.DStabControllerTest;
import org.interpss.spring.SimuAppCtxTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	// DStab controller building blocks
	DelayControlBlockTests.class,
	FilterControlBlockTests.class,
	IntegrationControlBlockTests.class,
	PIControlBlockTests.class,
	WashoutControlBlockTests.class,
	
	// DStab Machine
	Eq1Ed1MachineTest.class,
	EConstMachineTest.class,
	Eq1MachineCaseTest.class,
	MachineSaturationTest.class,
	RoundRotorMachineTest.class,
	SalientPoleMachineTest.class,
	
	// IEEE Models
	IEEE11ModelTest.class,
	IEEE12ModelTest.class,
	IEEE21ModelTest.class,
	IEEE22ModelTest.class,
	
	// Spring 
	CustomFileAdapterTest.class,
	DStabControllerTest.class,
	SimuAppCtxTest.class,	

	// core file adapter
	IEEECommonFormat_CommaTest.class,
	IEEECommonFormatTest.class,
	
	IEEE14Test.class,
	Bus1824Test.class,
//	Bus6384Test.class,
//	Bus11856Test.class,
	
	// run case xml scripts
	DclfSchemaIeee14BusCaseTest.class,
	AclfSchemaIeee14BusCaseTest.class,
	AcscSchemaSampleCaseTest.class,
	DStabSchemaIEEE11ModelTest.class,
	
	// cmd line 
	AclfCmdRunTest.class,
	RunExecTest.class,
	
	// UCTE format
	UCTEFormatMarioTest.class,
})
public class PluginTestSuite {
}
