package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String year, String month, int day) {
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day.react-datepicker__day--0" + reformat(day) + ":not(.react-datepicker__day--outside-month)").click();
    }
    private String reformat (int day) {
        return day < 10 ? "0" + day : String.format("%d",day);
    }
}