package finalTest.libraryManagement.functions;

import java.time.LocalDate;

import static finalTest.libraryManagement.constants.Constants.LOANDURATIONDAYS;

public class Functions {

    public static LocalDate dueDate(LocalDate loanDate) {
        return loanDate.plusDays(LOANDURATIONDAYS);
    }

    public static Double penaltyPrice(LocalDate dueDate, LocalDate devolutionDate, Double penaltyPrice) {
        double penalty = 0;
        if (devolutionDate.isAfter(dueDate)) {
            double daysLate = devolutionDate.toEpochDay() - dueDate.toEpochDay();
            penalty = daysLate * penaltyPrice;
        }
        return penalty;
    }
}
