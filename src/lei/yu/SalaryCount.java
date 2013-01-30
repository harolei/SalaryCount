package lei.yu;

public class SalaryCount {
    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    private int workDays;
    private double dailyWage = 200.0;

    public SalaryCount(int workDays){
        this.workDays = workDays;
    }

    public double getWage() {
        return workDays* dailyWage;
    }

    public double getBonus() {
        double wage = getWage();
        return wage * 0.1;
    }

    public double getTaxOfWage() {
        double wage = getWage();
        if(wage > 3500){
            return (wage-3500)*0.1;
        }
        else{
            return 0;
        }
    }

    public double getTaxOfBonus() {
        double bonus = getBonus();
        return bonus*0.05;
    }

    public double getTotalSalary() {
        double totalSalary = 4802.0;
        return totalSalary;
    }
}
