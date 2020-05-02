package psa.cesa.gui;

import java.util.Map;

public class ComLine {

    private int id;
    private String portDir;
    private Map<Integer, Heliostat> heliostats;

    public ComLine() {
        this(0, null, null);
    }

    public ComLine(int id, String portDir, Map<Integer, Heliostat> heliostats) {
        this.id = id;
        this.portDir = portDir;
        this.heliostats = heliostats;
    }

    public ComLine(ComLine comLine) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPortDir() {
        return portDir;
    }

    public void setPortDir(String portDir) {
        this.portDir = portDir;
    }

    public Map<Integer, Heliostat> getHeliostats() {
        return heliostats;
    }

    public void setHeliostats(Map<Integer, Heliostat> heliostats) {
        this.heliostats = heliostats;
    }
}
