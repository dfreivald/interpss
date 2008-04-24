/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.ws.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.interpss.editor.ws.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.interpss.editor.ws.IpssWsPackage
 * @generated
 */
public class IpssWsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IpssWsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpssWsSwitch() {
		if (modelPackage == null) {
			modelPackage = IpssWsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case IpssWsPackage.IPSS_WS_ITEM: {
				IpssWsItem ipssWsItem = (IpssWsItem)theEObject;
				T result = caseIpssWsItem(ipssWsItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssWsPackage.IPSS_WS_ITEM_CONTAINER: {
				IpssWsItemContainer ipssWsItemContainer = (IpssWsItemContainer)theEObject;
				T result = caseIpssWsItemContainer(ipssWsItemContainer);
				if (result == null) result = caseIpssWsItem(ipssWsItemContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssWsPackage.IPSS_PROJECT_ITEM: {
				IpssProjectItem ipssProjectItem = (IpssProjectItem)theEObject;
				T result = caseIpssProjectItem(ipssProjectItem);
				if (result == null) result = caseIpssWsItem(ipssProjectItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssWsPackage.IPSS_WORK_SPACE: {
				IpssWorkSpace ipssWorkSpace = (IpssWorkSpace)theEObject;
				T result = caseIpssWorkSpace(ipssWorkSpace);
				if (result == null) result = caseIpssWsItemContainer(ipssWorkSpace);
				if (result == null) result = caseIpssWsItem(ipssWorkSpace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssWsPackage.IPSS_PROJECT: {
				IpssProject ipssProject = (IpssProject)theEObject;
				T result = caseIpssProject(ipssProject);
				if (result == null) result = caseIpssWsItemContainer(ipssProject);
				if (result == null) result = caseIpssWsItem(ipssProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IpssWsPackage.IPSS_PROJECT_FORLDER: {
				IpssProjectForlder ipssProjectForlder = (IpssProjectForlder)theEObject;
				T result = caseIpssProjectForlder(ipssProjectForlder);
				if (result == null) result = caseIpssWsItemContainer(ipssProjectForlder);
				if (result == null) result = caseIpssWsItem(ipssProjectForlder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssWsItem(IpssWsItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssWsItemContainer(IpssWsItemContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Project Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Project Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssProjectItem(IpssProjectItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Work Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Work Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssWorkSpace(IpssWorkSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssProject(IpssProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ipss Project Forlder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ipss Project Forlder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIpssProjectForlder(IpssProjectForlder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //IpssWsSwitch
