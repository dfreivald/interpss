package com.interpss.editor.project;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;

import javax.swing.filechooser.FileFilter;


import com.interpss.common.SpringAppContext;
import com.interpss.editor.SimuAppSpringAppContext;
import com.interpss.editor.coreframework.GPGraphpad;
import com.interpss.editor.coreframework.IpssCustomDocument;
import com.interpss.editor.io.FileUtility;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.editor.resources.Translator;
import com.interpss.simu.SimuContext;

public class IpssCustomDataCodec {
	private static IpssCustomDataCodec _instance;
	
	public static String TextFileProjExt = "_ipssproj";
	/**
	 * file filter for this file format
	 */
	FileFilter fileFilter;
	
	public static IpssCustomDataCodec getInstance(GPGraphpad pad) {
		if (null == _instance) {
			_instance = new IpssCustomDataCodec(pad);
		}
		return _instance;
	}
	
	
	protected IpssCustomDataCodec(GPGraphpad pad) {
		fileFilter = new FileFilter() {
			/**
			 * @see javax.swing.filechooser.FileFilter#accept(File)
			 */
			public boolean accept(File f) {
				if (f == null)
					return false;
				if (f.getName() == null)
					return false;
				if (f.getName().endsWith(Translator.getString("CustomDataFileExtension")))
					return true;
				if (f.isDirectory())
					return true;

				return false;
			}

			/**
			 * @see javax.swing.filechooser.FileFilter#getDescription()
			 */
			public String getDescription() {
				return Translator.getString("CustomDataFileExtensionDescription"); 
			}
		};
	}
	
	public void write(OutputStream out, IpssCustomDocument doc) throws Exception {

		// don't try / catch this command
		// sothat we get error messages at the
		// frontend.
		// e.g. I you have not permissions to
		// write a file you should get an error message

		out = new BufferedOutputStream(out);
		out.write(doc.getText().getBytes());
		out.flush();
		out.close();
	}
	
// Mike	public static IAppSimuContext read(String abpath) { since this a singleton, no need to static
	public IAppSimuContext read(String abpath) {
		IAppSimuContext appSimuContext = SimuAppSpringAppContext.getAppSimuContext();
		SimuContext simuCtx = (SimuContext)appSimuContext.getSimuCtx();
		boolean ok = FileUtility.loadCustomFile(abpath, simuCtx);
		if (ok) {
			appSimuContext.setSimuNetDataDirty(false);
		}
		else {
			appSimuContext.setSimuCtx(null);
			SpringAppContext.getIpssMsgHub().sendWarnMsg("Custom data file loading error, filename: " + abpath);
		}
		return appSimuContext;
	}
}
