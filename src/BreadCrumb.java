import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BreadCrumb extends Material {
    private double quantity;
    public BreadCrumb(){

    }
    public BreadCrumb(int id, String branch, String mfd, double quality,double weight, double cost) {
        super(id, branch, mfd, weight, cost);
        this.quantity = quality;

    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public double countCost() {
        return getCost()*getQuantity();
    }

    @Override
    public String getEXP() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse(getMfd());
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.YEAR,1);
        return calendar.get(Calendar.DAY_OF_MONTH) + "-"+(Integer)(calendar.get(Calendar.MONTH)+1)+
        "-"+calendar.get(Calendar.YEAR);
    }

    @Override
    public double getDiscount() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date now = dateFormat.parse("20-04-2020");
        Date exp = dateFormat.parse(getEXP());
        Calendar today = GregorianCalendar.getInstance();
        Calendar expDate = GregorianCalendar.getInstance();

        today.setTime(now);
        int months = today.get(GregorianCalendar.MONTH) + today.get(GregorianCalendar.YEAR)*12;
        expDate.setTime(exp);
        int monthsEXP = expDate.get(GregorianCalendar.MONTH) + expDate.get(GregorianCalendar.YEAR)*12;
        if(monthsEXP - months <= 2)
            return 0.4;
        else if( monthsEXP - months <= 4)
            return 0.2;
        else
            return 0.05;
    }
}
