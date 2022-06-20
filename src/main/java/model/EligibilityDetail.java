package model;

import com.opencsv.bean.CsvBindByName;

public class EligibilityDetail {
    @CsvBindByName
    String EL1;
    @CsvBindByName
    String EL2;
    @CsvBindByName
    String EL3;
    @CsvBindByName
    String EL4;
    @CsvBindByName
    String EL5;

    public String getEL1() {
        return EL1;
    }

    public void setEL1(String EL1) {
        this.EL1 = EL1;
    }

    public String getEL2() {
        return EL2;
    }

    public void setEL2(String EL2) {
        this.EL2 = EL2;
    }

    public String getEL3() {
        return EL3;
    }

    public void setEL3(String EL3) {
        this.EL3 = EL3;
    }

    public String getEL4() {
        return EL4;
    }

    public void setEL4(String EL4) {
        this.EL4 = EL4;
    }

    public String getEL5() {
        return EL5;
    }

    public void setEL5(String EL5) {
        this.EL5 = EL5;
    }

    public EligibilityDetail() {
    }

    public EligibilityDetail(String EL1, String EL2, String EL3, String EL4, String EL5) {
        this.EL1 = EL1;
        this.EL2 = EL2;
        this.EL3 = EL3;
        this.EL4 = EL4;
        this.EL5 = EL5;
    }
}


