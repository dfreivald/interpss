package org.interpss.test.ui.editor.bus;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;

import org.interpss.editor.EditorSpringAppContext;
import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.app.AppSimuContextImpl;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.form.IGFormContainer;
import org.interpss.test.TestConstants;

import com.interpss.common.SpringAppContext;

public class TestBusEditorBase extends JFCTestCase {
	protected IGFormContainer netContainer = null;
	protected AppSimuContextImpl appSimuCtx = null;

    protected void setUp( ) throws Exception {
        super.setUp( );        // Choose the text Helper
        
        setHelper( new JFCTestHelper( ) ); // Uses the AWT Event Queue.
        //setHelper( new RobotTestHelper( ) ); // Uses the OS Event Queue.        

		if (SpringAppContext.SpringAppCtx == null) {
			SpringAppContext.SpringAppCtxConfigXmlFile = TestConstants.SpringConfigXmlFile;
			EditorSpringAppContext.springAppContextSetup();
		}	
		
		appSimuCtx = (AppSimuContextImpl)SimuAppSpringAppContext.getAppSimuContext(); 
		
		netContainer = GraphSpringAppContext.getEditorFormContainer();
	}

	protected void tearDown( ) throws Exception {
	    TestHelper.cleanUp( this );
	    super.tearDown( );
	}
}

