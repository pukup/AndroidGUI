package psa.cesa.gui.model;

import java.io.Serializable;
import java.util.HashMap;

public class ComLine implements Serializable {

    private int id;
    private HashMap<Integer, Heliostat> heliostats;

    public ComLine(ComLine comLine) {
    }

    public ComLine(int id) {
        this.id = id;
    }

    public ComLine(int id, HashMap<Integer, Heliostat> heliostats) {
        this.id = id;
        this.heliostats = heliostats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, Heliostat> getHeliostats() {
        return heliostats;
    }

    public void setHeliostats(HashMap<Integer, Heliostat> heliostats) {
        this.heliostats = heliostats;
    }
}
