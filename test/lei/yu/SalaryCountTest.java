package lei.yu;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SalaryCountTest {

    private SalaryCount count;
    private int workDays;

    @Before
    public void setUp() throws Exception {
        workDays = 20;
        count = new SalaryCount(workDays);
    }

    @Test
    public void should_count_wage_when_input_work_days() throws Exception {
        assertThat(count.getWage(),is(workDays * 200.0));
    }

    @Test
    public void should_count_bonus_when_input_work_days() throws Exception {
        assertThat(count.getBonus(),is(workDays * 200.0 * 0.1));
    }

    @Test
    public void should_count_the_tax_of_wage_when_wage_is_more_than_3500() throws Exception {
        double wage = workDays*200;
        if(wage >= 3500){
            assertThat(count.getTaxOfWage(),is((wage-3500)*0.1));
        }
    }

    @Test
    public void should_output_0_when_wage_is_less_than_3500() throws Exception {
        count.setWorkDays(10);
        double wage = 10*200;
        if(wage < 3500){
            assertThat(count.getTaxOfWage(),is(0.0));
        }
    }

    @Test
    public void should_output_the_tax_of_bonus() throws Exception {
        assertThat(count.getTaxOfBonus(),is(workDays * 200 *0.1*0.05));
    }

    @Test
    public void should_output_the_total_salary() throws Exception {
        double wage = 200*workDays;
        double bonus = wage*0.1;
        double taxOfWage;
        if(wage>3500)
            taxOfWage=wage*0.1;
        else
            taxOfWage=0;
        double taxOfBonus = bonus*0.005;
        assertThat(count.getTotalSalary(),is(wage+bonus+taxOfWage+taxOfBonus));
    }
}
