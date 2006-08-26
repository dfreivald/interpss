package org.interpss.editor.ui.edit.dist.bus;

import java.util.Vector;

import org.interpss.editor.data.dist.DistBusData;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.ui.UISpringAppContext;

import com.interpss.common.ui.VerifyUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;
import com.interpss.editor.jgraph.ui.edit.IFormDataDialog;
import com.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import com.interpss.editor.jgraph.ui.form.IGFormContainer;


public class NBMotorInputPanel extends javax.swing.JPanel  implements IFormDataPanel {
	private static final long serialVersionUID = 1;

	private GFormContainer netContainer = null;
	private DistBusData  _data = null;

	public void initPanel() {
		DataVerifier verifier = new DataVerifier();
    	this.ratedHPField.setInputVerifier(verifier);
    	this.ratedVTextField.setInputVerifier(verifier);
    	this.pfField.setInputVerifier(verifier);
    	this.effTextField.setInputVerifier(verifier);
    	this.loadingTextField.setInputVerifier(verifier);
	}
    
	public void init(Object aNetContainer, Object form) {
		IpssLogger.getLogger().info("NBMotorInputPanel init() called");

		this.netContainer = (GFormContainer)aNetContainer;
		this._data = ((GBusForm)form).getDistBusData();
	}
	
    public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBMotorInputPanel setForm2Editor() called");

		this.ratedHPField.setText(Num2Str.toStr(this._data.getBusRating(), "#0.0#"));
		this.ratedHPUnitComboBox.setSelectedItem(this._data.getBusRatingUnit());
		this.ratedVTextField.setText(Num2Str.toStr(this._data.getRatedVolt(), "#0.0##"));
		this.ratedVUnitComboBox.setSelectedItem(this._data.getRatedVoltUnit());
    	this.pfField.setText(Num2Str.toStr(this._data.getPFactor(), "#0.0#"));
		this.pfUnitComboBox.setSelectedItem(this._data.getPFactorUnit());
		this.effTextField.setText(Num2Str.toStr(this._data.getEff(), "#0.##"));
		this.loadingTextField.setText(Num2Str.toStr(this._data.getLoading(), "#0.##"));

        includeLScheduleCheckBox.setSelected(_data.isHasLoadSchedule());
        
		return true;
	}
    
    public boolean saveEditor2Form(Vector errMsg) throws Exception {
		IpssLogger.getLogger().info("NBMotorInputPanel saveEditor2Form() called");

		boolean ok = true;

		if (!VerifyUtil.largeThan(this.ratedHPField, 0.0d)) {
			errMsg.add("Motor rating <= 0.0");
			ok = false;
		}
    	this._data.setBusRating(VerifyUtil.getDouble(this.ratedHPField));

		this._data.setBusRatingUnit((String)this.ratedHPUnitComboBox.getSelectedItem());

		if (!VerifyUtil.largeThan(this.ratedVTextField, 0.0d)) {
			errMsg.add("Motor rated voltage <= 0.0");
			ok = false;
		}
    	this._data.setRatedVolt(VerifyUtil.getDouble(this.ratedVTextField));

		this._data.setRatedVoltUnit((String)this.ratedVUnitComboBox.getSelectedItem());

    	this._data.setPFactor(VerifyUtil.getDouble(this.pfField));   // SynMotor PF may be < 0.0

		this._data.setPFactorUnit((String)this.pfUnitComboBox.getSelectedItem());

      if (!VerifyUtil.largeThan(this.effTextField, 0.0d)) {
			errMsg.add("Motor efficiency <= 0.0");
			ok = false;
		}
    	this._data.setEff(VerifyUtil.getDouble(this.effTextField));

      if (!VerifyUtil.largeThan(this.loadingTextField, 0.0d)) {
			errMsg.add("Motor loading <= 0.0");
			ok = false;
		}
    	this._data.setLoading(VerifyUtil.getDouble(this.loadingTextField));

    	_data.setHasLoadSchedule(includeLScheduleCheckBox.isSelected());

    	return ok;
    }

    /** Creates new form NBMotorInputPanel */
    public NBMotorInputPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        ratedHPLabel = new javax.swing.JLabel();
        ratedHPField = new javax.swing.JTextField();
        ratedHPUnitComboBox = new javax.swing.JComboBox();
        ratedVLabel = new javax.swing.JLabel();
        ratedVTextField = new javax.swing.JTextField();
        ratedVUnitComboBox = new javax.swing.JComboBox();
        pfLabel = new javax.swing.JLabel();
        pfField = new javax.swing.JTextField();
        pfUnitComboBox = new javax.swing.JComboBox();
        effLabel = new javax.swing.JLabel();
        effTextField = new javax.swing.JTextField();
        loadingLabel = new javax.swing.JLabel();
        loadingTextField = new javax.swing.JTextField();
        includeLScheduleCheckBox = new javax.swing.JCheckBox();
        loadScheduleButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        ratedHPLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        ratedHPLabel.setText("Rated HP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(ratedHPLabel, gridBagConstraints);

        ratedHPField.setColumns(8);
        ratedHPField.setText("0.0");
        ratedHPField.setName("ratedHPTextField");
        add(ratedHPField, new java.awt.GridBagConstraints());

        ratedHPUnitComboBox.setFont(new java.awt.Font("Dialog", 0, 10));
        ratedHPUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HP", "KW" }));
        ratedHPUnitComboBox.setName("ratedHPUnitComboBox");
        add(ratedHPUnitComboBox, new java.awt.GridBagConstraints());

        ratedVLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        ratedVLabel.setText("Rated V");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 5);
        add(ratedVLabel, gridBagConstraints);

        ratedVTextField.setColumns(8);
        ratedVTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        ratedVTextField.setText("1.0");
        ratedVTextField.setName("ratedVTextField");
        add(ratedVTextField, new java.awt.GridBagConstraints());

        ratedVUnitComboBox.setFont(new java.awt.Font("Dialog", 0, 10));
        ratedVUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PU", "Volt", "KV" }));
        ratedVUnitComboBox.setName("ratedVUnitComboBox");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(ratedVUnitComboBox, gridBagConstraints);

        pfLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pfLabel.setText("PFactor  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(pfLabel, gridBagConstraints);

        pfField.setColumns(4);
        pfField.setText("0.8");
        pfField.setName("pfTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(pfField, gridBagConstraints);

        pfUnitComboBox.setFont(new java.awt.Font("Dialog", 0, 10));
        pfUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PU", "%" }));
        pfUnitComboBox.setName("pfUnitComboBox");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(pfUnitComboBox, gridBagConstraints);

        effLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        effLabel.setText("Efficiency(%)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 5);
        add(effLabel, gridBagConstraints);

        effTextField.setColumns(4);
        effTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        effTextField.setText("100");
        effTextField.setName("effTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(effTextField, gridBagConstraints);

        loadingLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        loadingLabel.setText("Loading(%)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(loadingLabel, gridBagConstraints);

        loadingTextField.setColumns(4);
        loadingTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        loadingTextField.setText("100");
        loadingTextField.setName("loadingTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(loadingTextField, gridBagConstraints);

        includeLScheduleCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        includeLScheduleCheckBox.setText("Include Load Schedule");
        includeLScheduleCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        includeLScheduleCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        includeLScheduleCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                includeLScheduleCheckBoxItemStateChanged(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        add(includeLScheduleCheckBox, gridBagConstraints);

        loadScheduleButton.setFont(new java.awt.Font("Dialog", 0, 10));
        loadScheduleButton.setText("Load Schedule ...");
        loadScheduleButton.setEnabled(false);
        loadScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadScheduleButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        add(loadScheduleButton, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void loadScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadScheduleButtonActionPerformed
    	IFormDataDialog dialog = UISpringAppContext.getLoadScheduleDialog();
    	dialog.init(netContainer, _data);
    }//GEN-LAST:event_loadScheduleButtonActionPerformed

    private void includeLScheduleCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_includeLScheduleCheckBoxItemStateChanged
    	if (includeLScheduleCheckBox.isSelected())
    		loadScheduleButton.setEnabled(true);
    	else
    		loadScheduleButton.setEnabled(false);
    }//GEN-LAST:event_includeLScheduleCheckBoxItemStateChanged
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel effLabel;
    private javax.swing.JTextField effTextField;
    private javax.swing.JCheckBox includeLScheduleCheckBox;
    private javax.swing.JButton loadScheduleButton;
    private javax.swing.JLabel loadingLabel;
    private javax.swing.JTextField loadingTextField;
    private javax.swing.JTextField pfField;
    private javax.swing.JLabel pfLabel;
    private javax.swing.JComboBox pfUnitComboBox;
    private javax.swing.JTextField ratedHPField;
    private javax.swing.JLabel ratedHPLabel;
    private javax.swing.JComboBox ratedHPUnitComboBox;
    private javax.swing.JLabel ratedVLabel;
    private javax.swing.JTextField ratedVTextField;
    private javax.swing.JComboBox ratedVUnitComboBox;
    // End of variables declaration//GEN-END:variables
    
	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			if (input == ratedHPField || input == ratedVTextField || input == effTextField || input == loadingTextField )
 	       			return VerifyUtil.getDouble((javax.swing.JTextField)input) > 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
