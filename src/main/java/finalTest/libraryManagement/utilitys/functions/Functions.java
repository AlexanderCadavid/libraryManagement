package finalTest.libraryManagement.utilitys.functions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import finalTest.libraryManagement.domain.models.libraryServices.LibraryServices;

import static finalTest.libraryManagement.utilitys.constants.Constants.DAILYPENALTYPRICE;
import static finalTest.libraryManagement.utilitys.constants.Constants.LOANDURATIONDAYS;

public class Functions {

    public static LocalDate dueDate(LocalDate loanDate) {
        return loanDate.plusDays(LOANDURATIONDAYS);
    }

    public static Double penaltyPrice(LocalDate devolutionDate, LocalDate loanDate) {
        double penalty = 0;
        LocalDate dueDate = dueDate(loanDate);
        if (devolutionDate.isAfter(dueDate)) {
            double daysLate = devolutionDate.toEpochDay() - dueDate.toEpochDay();
            penalty = daysLate * DAILYPENALTYPRICE;
        }
        return penalty;
    }

    public static List<LibraryServices> penaltyPriceList(List<LibraryServices> penaltyList) {
        List<LibraryServices> penaltyPrices = new ArrayList<>();
        for (LibraryServices i : penaltyList) {
            if (i
                                                                 .getPenaltyPrice()
                                                                 .getPenaltyPrice() > 0) {
                penaltyPrices.add(i);

            }
        }
        return penaltyPrices;
    }
}
