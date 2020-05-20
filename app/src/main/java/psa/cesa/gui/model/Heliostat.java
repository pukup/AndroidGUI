package psa.cesa.gui.model;

import java.io.Serializable;

public class Heliostat implements Serializable {

    private int comLineId;
    private int id;
    private int state;
    private int event;
    private int diagnosisAZ, diagnosisEL;
    private int positionAZ, positionEL;
    private int setPointAZ, setPointEL;

    public Heliostat(int comLineId, int id) {
        this.comLineId = comLineId;
        this.id = id;
    }

    public Heliostat() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public Heliostat(int comLineId, int id, int state, int event, int diagnosisAZ, int diagnosisEL, int positionAZ, int positionEL, int setPointAZ, int setPointEL) {
        this.comLineId = comLineId;
        this.id = id;
        this.state = state;
        this.event = event;
        this.diagnosisAZ = diagnosisAZ;
        this.diagnosisEL = diagnosisEL;
        this.positionAZ = positionAZ;
        this.positionEL = positionEL;
        this.setPointAZ = setPointAZ;
        this.setPointEL = setPointEL;
    }

    public int getComLineId() {
        return comLineId;
    }

    public void setComLineId(int comLineId) {
        this.comLineId = comLineId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public int getDiagnosysAZ() {
        return diagnosisAZ;
    }

    public void setDiagnosysAZ(int diagnosisAZ) {
        this.diagnosisAZ = diagnosisAZ;
    }

    public int getDiagnosysEL() {
        return diagnosisEL;
    }

    public void setDiagnosysEL(int diagnosisEL) {
        this.diagnosisEL = diagnosisEL;
    }

    public int getPositionAZ() {
        return positionAZ;
    }

    public void setPositionAZ(int positionAZ) {
        this.positionAZ = positionAZ;
    }

    public int getPositionEL() {
        return positionEL;
    }

    public void setPositionEL(int positionEL) {
        this.positionEL = positionEL;
    }

    public int getSetPointAZ() {
        return setPointAZ;
    }

    public void setSetPointAZ(int setPointAZ) {
        this.setPointAZ = setPointAZ;
    }

    public int getSetPointEL() {
        return setPointEL;
    }

    public void setSetPointEL(int setPointEL) {
        this.setPointEL = setPointEL;
    }

    public void setAttributes(Heliostat heliostat) {
        id = heliostat.getId();
        state = heliostat.getState();
        event = heliostat.getEvent();
        diagnosisAZ = heliostat.getDiagnosysAZ();
        diagnosisEL = heliostat.getDiagnosysEL();
        positionAZ = heliostat.getPositionAZ();
        positionEL = heliostat.getPositionEL();
        setPointAZ = heliostat.getSetPointAZ();
        setPointEL = heliostat.getSetPointEL();
    }

    public String state0ToString() {
        StringBuilder state0 = new StringBuilder();
        int nibble0 = 0x0f & state;
        switch (nibble0) {
            case 0x0:
                state0.append("Operación local");
                break;
            case 0x1:
                state0.append("Consigna fija");
                break;
            case 0x2:
                state0.append("Busqueda ceros");
                break;
            case 0x3:
                state0.append("Fuera servicio");
                break;
            case 0x4:
                state0.append("Posición defensa");
                break;
            case 0x5:
                state0.append("Abatimiento");
                break;
            case 0x6:
                state0.append("Blanco tierra");
                break;
            case 0x7:
                state0.append("Blanco pasillo 1");
                break;
            case 0x8:
                state0.append("Blanco pasillo 2");
                break;
            case 0x9:
                state0.append("Blanco pasillo 3");
                break;
            case 0xa:
                state0.append("Blanco pasillo 4");
                break;
            case 0xb:
                state0.append("Seguimiento desfasado");
                break;
            case 0xc:
                state0.append("Blanco emergencia");
                break;
            case 0xd:
                state0.append("Seguimiento caldera");
                break;
            case 0xe:
                state0.append("Foco");
                break;
            case 0xf:
                state0.append("Seguimiento solar");
                break;
        }
        return state0.toString();
    }

}
