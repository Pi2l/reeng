public class HumanIMB {

    private static final double UNDERWEIGHT_THRESHOLD = 18.5;
    private static final double NORMAL_THRESHOLD = 25;
    private static final double WARNING_THRESHOLD = 30;

    private double weight;
    private double height;
    private double imb;

    public HumanIMB(double weight, double height) {
        this.weight = weight;
        this.height = height;
        this.imb = weight / (height * height);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        this.imb = weight / (height * height);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        this.imb = weight / (height * height);
    }

    public double getImb() {
        return imb;
    }

    public String getResult() {
        if (imb < UNDERWEIGHT_THRESHOLD) {
            return "Deficit";
        } else if (imb >= UNDERWEIGHT_THRESHOLD && imb < NORMAL_THRESHOLD) {
            return "Norm";
        } else if (imb >= NORMAL_THRESHOLD && imb < WARNING_THRESHOLD) {
            return "Warning!";
        } else if (imb >= WARNING_THRESHOLD) {
            return "Fat";
        }
        return null;
    }
}
