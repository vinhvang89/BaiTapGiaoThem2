import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Meat extends Material{
    private double unit;

    public Meat() {
    }

    public Meat(int id, String name, String mfd, double costPerKg, double weight,double unit) {
        super(id, name, mfd, weight, costPerKg);
        this.unit = unit;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    @Override
    public double countCost() {
        return getUnit()*getWeight()*getCost();
    }

    @Override
    public String getEXP() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse(getMfd());
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.DAY_OF_MONTH, 15);
        return calendar.get(GregorianCalendar.DAY_OF_MONTH) + "-"+ (Integer)(calendar.get(GregorianCalendar.MONTH)+1)+
                "-"+calendar.get(GregorianCalendar.YEAR);
    }

    @Override
    public double getDiscount() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        Date now = dateFormat.parse("20-04-2020");
        Date exp = dateFormat.parse(getEXP());
        Calendar expDate = GregorianCalendar.getInstance();
        Calendar today = GregorianCalendar.getInstance();
        today.setTime(now);
        expDate.setTime(exp);
        if( expDate.get(GregorianCalendar.DAY_OF_YEAR) -  today.get(GregorianCalendar.DAY_OF_YEAR)  <= 3)
            return 0.5;
        else if (expDate.get(GregorianCalendar.DAY_OF_YEAR)-  today.get(GregorianCalendar.DAY_OF_YEAR) <= 5)
            return 0.3;
        else
            return 0.1;

    }
}
