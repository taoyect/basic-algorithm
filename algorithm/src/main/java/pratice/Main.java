package pratice;

import java.text.DecimalFormat;

public class Main {
    static DecimalFormat df = new DecimalFormat("#.##");
    public static void main(String[] args) {
        double currYear = 1362;
        double rate = 32;
        ssYanSuan(currYear, rate);
    }

    public static void ssYanSuan(double currYear, double rate) {
        double preYearMoney = preYearMoney(currYear, rate);
        double delta = currYear - preYearMoney;
        System.out.println(df.format(preYearMoney) + " : " + df.format(delta));
    }

    public static double preYearMoney(double currYear, double rate) {
        return currYear / (1 + rate / 100);
    }
}
