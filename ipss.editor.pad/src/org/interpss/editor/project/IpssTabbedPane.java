package org.interpss.editor.project;

import org.interpss.editor.swing.tabbedpane.CloseAndMaxTabbedPane;

public class IpssTabbedPane extends CloseAndMaxTabbedPane{

	public IpssTabbedPane() {
		super(CloseAndMaxTabbedPane.UI_IPSS);
	}
	
//	 public String getToolTipTextAt(int i){
//		 
//		 GPDocFrame frame = (GPDocFrame)getComponentAt(i);
//		 
//		 if (frame!=null)
//			 return frame.getDocument().getName();
//		 return null;
//
//	 }
}
