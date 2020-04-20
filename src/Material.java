import java.text.ParseException;

interface Discount{
    public double getDiscount() throws ParseException;
}




public abstract class Material implements Discount {
    private int id;
    private double weight;
    private String name;
    private String mfd ;
    private double cost;
    public Material(){

    }

    public Material(int id, String name, String mfd, double cost,double weight) {
        this.id = id;
        this.name = name;
        this.mfd = mfd;
        this.cost = cost;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMfd() {
        return this.mfd;
    }

    public void setMfd(String mfd) {
        this.mfd = mfd;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public abstract double countCost();
    public abstract String getEXP() throws ParseException;
}

