package com.interpss.editor.data.aclf;

import com.interpss.common.rec.BaseDataBean;
import com.interpss.editor.jgraph.ui.form.IGBranchForm;

/**
*	AclfBranchForm class for storing aclf branch data.
*/

public class AclfBranchData extends BaseDataBean  {
    private String  lfCode = IGBranchForm.TransBranchLfCode_Line;    
    private double  halfShuntB = 0d;     
    private String  halfShuntBUnit = "PU";
    private double  phaseShiftAngle = 0d;
    private String  phaseShiftAngleUnit = "Deg";
    private double  xfrTapFromSideTap = 1.0d;
    private double  xfrTapToSideTap = 1.0d;
    private String  xfrTapUnit = "PU";
    private double  zX = 0d;                
    private double  zR = 0d;
    private String  zUnit = "PU";
    private double  rating1 = 0.0d;
    private double  rating2 = 0.0d;
    private double  rating3 = 0.0d;
    private String  ratingUnit = "PU";

    public String getLfCode() { return this.lfCode;     }
    public void setLfCode(String value) { this.lfCode = value;     }

    public double getHalfShuntB() { return this.halfShuntB;    }
    public void setHalfShuntB(double value) { this.halfShuntB = value;     }

    public String getHalfShuntBUnit() { return this.halfShuntBUnit;    }
    public void setHalfShuntBUnit(String value) { this.halfShuntBUnit = value;     }

    public double getPhaseShiftAngle() { return this.phaseShiftAngle;     }
    public void setPhaseShiftAngle(double value) { this.phaseShiftAngle = value;    }

    public String getPhaseShiftAngleUnit() { return this.phaseShiftAngleUnit;    }
    public void setPhaseShiftAngleUnit(String value) { this.phaseShiftAngleUnit = value;     }

    public double getXfrTapFromSideTap() { return  this.xfrTapFromSideTap;     }
    public double getXfrTapToSideTap() { return this.xfrTapToSideTap;     }

    public String getXfrTapUnit() { return this.xfrTapUnit;     }
    public void setXfrTapFromSideTap(double value) { this.xfrTapFromSideTap = value;     }

    public void setXfrTapToSideTap(double value) { this.xfrTapToSideTap = value;     }
    public void setXfrTapUnit(String value) { this.xfrTapUnit = value;     }

    public double getZR() { return this.zR;     }
    public void setZR(double value) { this.zR = value;    }

    public double getZX() { return this.zX;     }
    public void setZX(double value) { this.zX = value;     }

    public String getZUnit() { return this.zUnit;     }
    public void setZUnit(String value) { this.zUnit = value;     }

    public double getRating1() { return this.rating1;     }
    public void setRating1(double value) { this.rating1 = value;    }

    public double getRating2() { return this.rating2;     }
    public void setRating2(double value) { this.rating2 = value;    }
    
    public double getRating3() { return this.rating3;     }
    public void setRating3(double value) { this.rating3 = value;    }

    public String getRatingUnit() { return this.ratingUnit;     }
    public void setRatingUnit(String value) { this.ratingUnit = value;     }
}