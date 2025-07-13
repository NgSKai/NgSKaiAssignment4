public class ManagementCompany {
    private final int MAX_PROPERTY = 5;
    private static final int MGMT_WIDTH = 10;
    private static final int MGMT_DEPTH = 10;
    private Property[] properties;
    private String name;
    private String taxID;
    private double mgmFee;
    private Plot plot;

    public ManagementCompany() {
        this("", "", 0.0);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
    }

    public int addProperty(Property property) {
        if (property == null) return -2;
        if (getPropertiesCount() >= MAX_PROPERTY) return -1;
        if (!plot.encompasses(property.getPlot())) return -3;

        for (Property p : properties) {
            if (p != null && p.getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }

        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] == null) {
                properties[i] = new Property(property);
                return i;
            }
        }

        return -1;
    }

    public int getPropertiesCount() {
        int count = 0;
        for (Property p : properties) {
            if (p != null) count++;
        }
        return count;
    }

    public double getTotalRent() {
        double total = 0;
        for (Property p : properties) {
            if (p != null) total += p.getRentAmount();
        }
        return total;
    }

    public Property getHighestRentProperty() {
        double maxRent = -1;
        Property maxProperty = null;
        for (Property p : properties) {
            if (p != null && p.getRentAmount() > maxRent) {
                maxRent = p.getRentAmount();
                maxProperty = p;
            }
        }
        return maxProperty;
    }

    public String getName() { return name; }
    public String getTaxID() { return taxID; }
    public Plot getPlot() { return new Plot(plot); }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name)
          .append(", taxID: ").append(taxID).append("\n")
          .append("______________________________________________________\n");

        for (Property p : properties) {
            if (p != null) {
                sb.append(p.toString()).append("\n");
            }
        }

        sb.append("______________________________________________________\n\n")
          .append(" total management Fee: ").append(String.format("%.2f", getTotalRent() * (mgmFee / 100)));

        return sb.toString();
    }
}