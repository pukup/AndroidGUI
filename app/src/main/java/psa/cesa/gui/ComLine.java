package psa.cesa.gui;

import java.util.Map;

public class ComLine {

    private int id;
    private String portDir;
    private Map<Integer, Heliostat> heliostats;

    public ComLine(ComLine comLine) {
    }

    public ComLine(int id) {
        this.id = id;
    }

    public ComLine(int id, Map<Integer, Heliostat> heliostats) {
        this.id = id;
        this.heliostats = heliostats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, Heliostat> getHeliostats() {
        return heliostats;
    }

    public void setHeliostats(Map<Integer, Heliostat> heliostats) {
        this.heliostats = heliostats;
    }
}
