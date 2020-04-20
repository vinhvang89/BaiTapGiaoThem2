import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) throws ParseException {
        final double TON = 1000;
        final double KG = 1;
        final double G = 0.001;

       Material meat1 = new Meat(1000,"Dragon","18-04-2020",200000,1.5,KG);
       Material meat2 = new Meat(1001,"Unicorn","12-04-2020",80000,126000,G);
       Material meat3 = new Meat(1002,"Phoenix","08-04-2020",250000,200,G);
       Material meat4 = new Meat(1003,"Sphinx","14-4-2020",110000,10000,G);
       Material meat5 = new Meat(1004,"Pegasus","6-04-2020",90000,20000,G);

       Material flour1 = new BreadCrumb(1005,"Colgate","26-06-2019",30,0.5,5);
       Material flour2 = new BreadCrumb(1006,"P/S","14-11-2019",78,0.25,3);
       Material flour3 = new BreadCrumb(1007,"Listerine","23-03-2020",20,1,8);
       Material flour4 = new BreadCrumb(1008,"Dr Care","31-07-2019",42,0.5,6);
       Material flour5 = new BreadCrumb(1009,"Dạ Hương","23-05-2019",12,2,15);

       Material[] materials = {meat1,meat2,meat3,meat4,meat5,flour1,flour2,flour3,flour4,flour5};
       double totalOfCountCost = 0;
       double totalOfDiscount = 0;
       for(Material material : materials){
           totalOfCountCost += material.countCost();
           totalOfDiscount += material.getDiscount()*material.countCost();
       }
        System.out.println("Total of cost without discount : " + (Math.round(totalOfCountCost*100)/100)+ " USD ");
        System.out.println("Total of discount is : "+(Math.round(totalOfDiscount*100)/100) + " USD ");
    }
}
