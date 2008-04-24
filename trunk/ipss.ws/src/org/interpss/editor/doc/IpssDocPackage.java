/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.interpss.editor.doc.IpssDocFactory
 * @model kind="package"
 * @generated
 */
public interface IpssDocPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "doc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/interpss/editor/doc";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ipss";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IpssDocPackage eINSTANCE = org.interpss.editor.doc.impl.IpssDocPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssDocumentImpl <em>Ipss Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssDocument()
	 * @generated
	 */
	int IPSS_DOCUMENT = 0;

	/**
	 * The number of structural features of the '<em>Ipss Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_DOCUMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssDocumentItemImpl <em>Ipss Document Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssDocumentItemImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssDocumentItem()
	 * @generated
	 */
	int IPSS_DOCUMENT_ITEM = 1;

	/**
	 * The number of structural features of the '<em>Ipss Document Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_DOCUMENT_ITEM_FEATURE_COUNT = IPSS_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssEditorDocumentImpl <em>Ipss Editor Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssEditorDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssEditorDocument()
	 * @generated
	 */
	int IPSS_EDITOR_DOCUMENT = 2;

	/**
	 * The number of structural features of the '<em>Ipss Editor Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_EDITOR_DOCUMENT_FEATURE_COUNT = IPSS_DOCUMENT_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssEditableDocumentImpl <em>Ipss Editable Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssEditableDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssEditableDocument()
	 * @generated
	 */
	int IPSS_EDITABLE_DOCUMENT = 3;

	/**
	 * The number of structural features of the '<em>Ipss Editable Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_EDITABLE_DOCUMENT_FEATURE_COUNT = IPSS_EDITOR_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssSimuDocumentImpl <em>Ipss Simu Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssSimuDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssSimuDocument()
	 * @generated
	 */
	int IPSS_SIMU_DOCUMENT = 4;

	/**
	 * The number of structural features of the '<em>Ipss Simu Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_SIMU_DOCUMENT_FEATURE_COUNT = IPSS_EDITABLE_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssCustomDocumentImpl <em>Ipss Custom Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssCustomDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssCustomDocument()
	 * @generated
	 */
	int IPSS_CUSTOM_DOCUMENT = 5;

	/**
	 * The number of structural features of the '<em>Ipss Custom Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_CUSTOM_DOCUMENT_FEATURE_COUNT = IPSS_SIMU_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssGraphicDocumentImpl <em>Ipss Graphic Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssGraphicDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssGraphicDocument()
	 * @generated
	 */
	int IPSS_GRAPHIC_DOCUMENT = 6;

	/**
	 * The number of structural features of the '<em>Ipss Graphic Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_GRAPHIC_DOCUMENT_FEATURE_COUNT = IPSS_SIMU_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.interpss.editor.doc.impl.IpssReportDocumentImpl <em>Ipss Report Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.interpss.editor.doc.impl.IpssReportDocumentImpl
	 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssReportDocument()
	 * @generated
	 */
	int IPSS_REPORT_DOCUMENT = 7;

	/**
	 * The number of structural features of the '<em>Ipss Report Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPSS_REPORT_DOCUMENT_FEATURE_COUNT = IPSS_EDITOR_DOCUMENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssDocument <em>Ipss Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Document</em>'.
	 * @see org.interpss.editor.doc.IpssDocument
	 * @generated
	 */
	EClass getIpssDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssDocumentItem <em>Ipss Document Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Document Item</em>'.
	 * @see org.interpss.editor.doc.IpssDocumentItem
	 * @generated
	 */
	EClass getIpssDocumentItem();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssEditorDocument <em>Ipss Editor Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Editor Document</em>'.
	 * @see org.interpss.editor.doc.IpssEditorDocument
	 * @generated
	 */
	EClass getIpssEditorDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssEditableDocument <em>Ipss Editable Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Editable Document</em>'.
	 * @see org.interpss.editor.doc.IpssEditableDocument
	 * @generated
	 */
	EClass getIpssEditableDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssSimuDocument <em>Ipss Simu Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Simu Document</em>'.
	 * @see org.interpss.editor.doc.IpssSimuDocument
	 * @generated
	 */
	EClass getIpssSimuDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssCustomDocument <em>Ipss Custom Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Custom Document</em>'.
	 * @see org.interpss.editor.doc.IpssCustomDocument
	 * @generated
	 */
	EClass getIpssCustomDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssGraphicDocument <em>Ipss Graphic Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Graphic Document</em>'.
	 * @see org.interpss.editor.doc.IpssGraphicDocument
	 * @generated
	 */
	EClass getIpssGraphicDocument();

	/**
	 * Returns the meta object for class '{@link org.interpss.editor.doc.IpssReportDocument <em>Ipss Report Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipss Report Document</em>'.
	 * @see org.interpss.editor.doc.IpssReportDocument
	 * @generated
	 */
	EClass getIpssReportDocument();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IpssDocFactory getIpssDocFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssDocumentImpl <em>Ipss Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssDocument()
		 * @generated
		 */
		EClass IPSS_DOCUMENT = eINSTANCE.getIpssDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssDocumentItemImpl <em>Ipss Document Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssDocumentItemImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssDocumentItem()
		 * @generated
		 */
		EClass IPSS_DOCUMENT_ITEM = eINSTANCE.getIpssDocumentItem();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssEditorDocumentImpl <em>Ipss Editor Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssEditorDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssEditorDocument()
		 * @generated
		 */
		EClass IPSS_EDITOR_DOCUMENT = eINSTANCE.getIpssEditorDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssEditableDocumentImpl <em>Ipss Editable Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssEditableDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssEditableDocument()
		 * @generated
		 */
		EClass IPSS_EDITABLE_DOCUMENT = eINSTANCE.getIpssEditableDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssSimuDocumentImpl <em>Ipss Simu Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssSimuDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssSimuDocument()
		 * @generated
		 */
		EClass IPSS_SIMU_DOCUMENT = eINSTANCE.getIpssSimuDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssCustomDocumentImpl <em>Ipss Custom Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssCustomDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssCustomDocument()
		 * @generated
		 */
		EClass IPSS_CUSTOM_DOCUMENT = eINSTANCE.getIpssCustomDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssGraphicDocumentImpl <em>Ipss Graphic Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssGraphicDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssGraphicDocument()
		 * @generated
		 */
		EClass IPSS_GRAPHIC_DOCUMENT = eINSTANCE.getIpssGraphicDocument();

		/**
		 * The meta object literal for the '{@link org.interpss.editor.doc.impl.IpssReportDocumentImpl <em>Ipss Report Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.interpss.editor.doc.impl.IpssReportDocumentImpl
		 * @see org.interpss.editor.doc.impl.IpssDocPackageImpl#getIpssReportDocument()
		 * @generated
		 */
		EClass IPSS_REPORT_DOCUMENT = eINSTANCE.getIpssReportDocument();

	}

} //IpssDocPackage
