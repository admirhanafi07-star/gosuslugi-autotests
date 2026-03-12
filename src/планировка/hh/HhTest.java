package hh;


import org.junit.jupiter.api.Test;
import ПервыйАвтотестНаСеленид.BaseTest;

public class HhTest extends BaseTest {

    private final static String URL = "https://hh.ru/resume/15d3390cff0b6fd6f60039ed1f544354793141";
    private final static String NUMBER = "9640309803";
    private final static String CMC = "345458";


    @Test
    public void test(){
        new HhResumePage(URL)
                .clickResumeButton()
                .clickSearchButton()
                .applyFilter(NUMBER).applyCode(CMC);
    }

}
