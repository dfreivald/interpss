/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JPanel for editing the model's data. It implements the IControllerEditor interface, which will be called from
 * the parent editor dialog.
 * 
 * @author  mzhou
 */

package com.interpss.dstab.control.exc.ieee.y1968Type1;

import java.util.Vector;

import com.interpss.common.ui.IControllerEditor;
import com.interpss.common.ui.VerifyUtil;
import com.interpss.common.util.Num2Str;
import com.interpss.dstab.control.common.ui.InputVerifyUtil;

public class NBY1968Type1ExciterEditPanel extends javax.swing.JPanel implements IControllerEditor {
	private static final long serialVersionUID = 1;

	// define data to be edited
	Y1968Type1ExciterData _data;

    /** Creates new form FaultLocDataPanel */
    public NBY1968Type1ExciterEditPanel() {
        initComponents();

        // associate the editing fields with the verifier class defined at the end of this calss
  		DataVerifier verifier = new DataVerifier();
  	    kaTextField.setInputVerifier(verifier);
  	    keTextField.setInputVerifier(verifier);
  	    kfTextField.setInputVerifier(verifier);
  	    se0_75TextField.setInputVerifier(verifier);
  	    se1_0TextField.setInputVerifier(verifier);
  	    taTextField.setInputVerifier(verifier);
  	    teTextField.setInputVerifier(verifier);
  	    tfTextField.setInputVerifier(verifier);
  	    vrmaxTextField.setInputVerifier(verifier);
  	    vrminTextField.setInputVerifier(verifier);
    }
    
    /**
     * Init the editor panel, which will be called from its parent editor
     */
	public void init(Object controller) {
		// init the data object from the bus object being edited
		_data = ((Y1968Type1Exciter)controller).getData();
	}
	
	/**
	*	Set controller data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor() {
  	    kaTextField.setText(Num2Str.toStr(_data.getKa(), "#0.00"));
  	    taTextField.setText(Num2Str.toStr(_data.getTa(), "#0.000"));
  	    vrmaxTextField.setText(Num2Str.toStr(_data.getVrmax(), "#0.00"));
  	    vrminTextField.setText(Num2Str.toStr(_data.getVrmin(), "#0.00"));
  	    keTextField.setText(Num2Str.toStr(_data.getKe(), "#0.00"));
  	    teTextField.setText(Num2Str.toStr(_data.getTe(), "#0.000"));
  	    kfTextField.setText(Num2Str.toStr(_data.getKf(), "#0.00"));
  	    tfTextField.setText(Num2Str.toStr(_data.getTf(), "#0.000"));
  	    se0_75TextField.setText(Num2Str.toStr(_data.getSe0_75(), "#0.000"));
  	    se1_0TextField.setText(Num2Str.toStr(_data.getSe1_0(), "#0.000"));
        return true;
	}
    
	/**
	*	Save editor screen data to the controller data object
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditorData(Vector errMsg) throws Exception {
		boolean ok = true;
		if (!VerifyUtil.largeThan(this.kaTextField, 0.0d)) {
			errMsg.add("Ka <= 0.0");
			ok = false;
		}
    	_data.setKa(InputVerifyUtil.getDouble(kaTextField));

		if (!VerifyUtil.largeThan(this.taTextField, 0.0d)) {
			errMsg.add("Ta <= 0.0");
			ok = false;
		}
    	_data.setTa(InputVerifyUtil.getDouble(taTextField));

    	if (!VerifyUtil.largeThan(this.vrmaxTextField, 0.0d)) {
			errMsg.add("Vrmax <= 0.0");
			ok = false;
		}
    	_data.setVrmax(InputVerifyUtil.getDouble(vrmaxTextField));

    	_data.setVrmin(InputVerifyUtil.getDouble(vrminTextField));
		
    	if (_data.getVrmax() <= _data.getVrmin()) {
			errMsg.add("Vrmax <= Vrmin");
			ok = false;
		}

		if (!VerifyUtil.largeThan(this.keTextField, 0.0d)) {
			errMsg.add("Ke <= 0.0");
			ok = false;
		}
    	_data.setKe(InputVerifyUtil.getDouble(keTextField));

		if (!VerifyUtil.largeThan(this.teTextField, 0.0d)) {
			errMsg.add("Te <= 0.0");
			ok = false;
		}
    	_data.setTe(InputVerifyUtil.getDouble(teTextField));

		if (!VerifyUtil.largeThan(this.kfTextField, 0.0d)) {
			errMsg.add("Kf <= 0.0");
			ok = false;
		}
    	_data.setKf(InputVerifyUtil.getDouble(kfTextField));

		if (!VerifyUtil.largeThan(this.tfTextField, 0.0d)) {
			errMsg.add("Tf <= 0.0");
			ok = false;
		}
    	_data.setTf(InputVerifyUtil.getDouble(tfTextField));

		if (!VerifyUtil.largeThan(this.se0_75TextField, 0.0d)) {
			errMsg.add("Se(0.75) <= 0.0");
			ok = false;
		}
    	_data.setSe0_75(InputVerifyUtil.getDouble(se0_75TextField));

		if (!VerifyUtil.largeThan(this.se1_0TextField, 0.0d)) {
			errMsg.add("Se(1.0) <= 0.0");
			ok = false;
		}
    	_data.setSe1_0(InputVerifyUtil.getDouble(se1_0TextField));

    	return ok;
	}
    
	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        kaLabel = new javax.swing.JLabel();
        kaTextField = new javax.swing.JTextField();
        taLabel = new javax.swing.JLabel();
        taTextField = new javax.swing.JTextField();
        vrmaxLabel = new javax.swing.JLabel();
        vrmaxTextField = new javax.swing.JTextField();
        vrminLabel = new javax.swing.JLabel();
        vrminTextField = new javax.swing.JTextField();
        keLabel = new javax.swing.JLabel();
        keTextField = new javax.swing.JTextField();
        teLabel = new javax.swing.JLabel();
        teTextField = new javax.swing.JTextField();
        se0_75Label = new javax.swing.JLabel();
        se0_75TextField = new javax.swing.JTextField();
        se1_0Label = new javax.swing.JLabel();
        se1_0TextField = new javax.swing.JTextField();
        kfLabel = new javax.swing.JLabel();
        kfTextField = new javax.swing.JTextField();
        tfLabel = new javax.swing.JLabel();
        tfTextField = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        kaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kaLabel.setText("Ka(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(kaLabel, gridBagConstraints);

        kaTextField.setColumns(5);
        kaTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kaTextField.setText("10.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(kaTextField, gridBagConstraints);

        taLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        taLabel.setText("Ta(s)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(taLabel, gridBagConstraints);

        taTextField.setColumns(5);
        taTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        taTextField.setText("0.05");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(taTextField, gridBagConstraints);

        vrmaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxLabel.setText("Vrmax(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(vrmaxLabel, gridBagConstraints);

        vrmaxTextField.setColumns(5);
        vrmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxTextField.setText("10.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(vrmaxTextField, gridBagConstraints);

        vrminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminLabel.setText("Vrmin(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(vrminLabel, gridBagConstraints);

        vrminTextField.setColumns(5);
        vrminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminTextField.setText("-10.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(vrminTextField, gridBagConstraints);

        keLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        keLabel.setText("Ke(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(keLabel, gridBagConstraints);

        keTextField.setColumns(5);
        keTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        keTextField.setText("1.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(keTextField, gridBagConstraints);

        teLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        teLabel.setText("Te(s)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(teLabel, gridBagConstraints);

        teTextField.setColumns(5);
        teTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        teTextField.setText("0.05");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(teTextField, gridBagConstraints);

        se0_75Label.setFont(new java.awt.Font("Dialog", 0, 12));
        se0_75Label.setText("Se(0.75)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(se0_75Label, gridBagConstraints);

        se0_75TextField.setColumns(5);
        se0_75TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        se0_75TextField.setText("1.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(se0_75TextField, gridBagConstraints);

        se1_0Label.setFont(new java.awt.Font("Dialog", 0, 12));
        se1_0Label.setText("Se(1.0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(se1_0Label, gridBagConstraints);

        se1_0TextField.setColumns(5);
        se1_0TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        se1_0TextField.setText("1.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(se1_0TextField, gridBagConstraints);

        kfLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kfLabel.setText("Kf(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(kfLabel, gridBagConstraints);

        kfTextField.setColumns(5);
        kfTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kfTextField.setText("1.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(kfTextField, gridBagConstraints);

        tfLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        tfLabel.setText("Tf(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(tfLabel, gridBagConstraints);

        tfTextField.setColumns(5);
        tfTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tfTextField.setText("0.05");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(tfTextField, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel kaLabel;
    private javax.swing.JTextField kaTextField;
    private javax.swing.JLabel keLabel;
    private javax.swing.JTextField keTextField;
    private javax.swing.JLabel kfLabel;
    private javax.swing.JTextField kfTextField;
    private javax.swing.JLabel se0_75Label;
    private javax.swing.JTextField se0_75TextField;
    private javax.swing.JLabel se1_0Label;
    private javax.swing.JTextField se1_0TextField;
    private javax.swing.JLabel taLabel;
    private javax.swing.JTextField taTextField;
    private javax.swing.JLabel teLabel;
    private javax.swing.JTextField teTextField;
    private javax.swing.JLabel tfLabel;
    private javax.swing.JTextField tfTextField;
    private javax.swing.JLabel vrmaxLabel;
    private javax.swing.JTextField vrmaxTextField;
    private javax.swing.JLabel vrminLabel;
    private javax.swing.JTextField vrminTextField;
    // End of variables declaration//GEN-END:variables

    // define data validation rules
	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			// data field verification rules
    			if ( input == kaTextField ||
             		 input == taTextField ||
             		 input == keTextField ||
             		 input == teTextField ||
             		 input == kfTextField ||
             		 input == tfTextField ||
             		 input == se1_0TextField ||
             		 input == se0_75TextField ||
             		 input == vrmaxTextField)
    	       		return InputVerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
