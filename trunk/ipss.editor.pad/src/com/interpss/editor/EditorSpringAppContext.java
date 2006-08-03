package com.interpss.editor;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.io.IProjectDataManager;
import com.interpss.common.io.IRefDataManager;
import com.interpss.common.io.ISimuRecManager;
import com.interpss.editor.app.AppContext;
import com.interpss.editor.coreframework.GPGraphpad;
import com.interpss.editor.jgraph.ui.app.IAppStatus;
import com.interpss.editor.resources.Translator;
import com.interpss.editor.util.Utilities;

public class EditorSpringAppContext extends SpringAppContext {
	/**
	 * Get the GEditor(singleton) from the SpringAppContext.
	 */
	public static GPGraphpad getGraphicEditor() {
		return (GPGraphpad)SpringAppCtx.getBean(Constants.SID_IpssGraphicEditor);
	}
	
	/**
	 * Get the AppContext(singleton) from the SpringAppContext.
	 */
	public static AppContext getAppContext() {
		return (AppContext)SpringAppCtx.getBean(Constants.SID_IpssAppContext);
	}

	/**
	 * Get the DB RefDataManager(singleton) object.
	 */
	public static IAppStatus getStatusPanel() {
		return (IAppStatus)SpringAppCtx.getBean(Constants.SID_StatusPanel);
	}

	/**
	 * Get the DB RefDataManager(singleton) object.
	 */
	public static IRefDataManager getRefDataManager() {
		return (IRefDataManager)SpringAppCtx.getBean(Constants.SID_RefDataManager);
	}

	/**
	 * Get the DB ProjectDataManager(singleton) object.
	 */
	public static IProjectDataManager getProjectDataManager() {
		return (IProjectDataManager)SpringAppCtx.getBean(Constants.SID_ProjectDataManager);
	}

	/**
	 * Get the DB SimuRecManager(singleton) object.
	 */
	public static ISimuRecManager getSimuRecManager() {
		return (ISimuRecManager)SpringAppCtx.getBean(Constants.SID_SimuRecManager);
	}

	/**
	 * Init the SpringFramework application context
	 */
	public static void springAppContextSetup() {
		// Set the SpringAppContext to all ApplicationContextAware objects.
		SpringAppContext.SpringAppCtx = new FileSystemXmlApplicationContext(SpringAppCtxConfigXmlFile);

		EditorSpringAppContext.getAppContext().setWorkspaceDir(
				Utilities.getInstallLocation() + Translator.getString("WorkSpace.Location"));
	}	
}
