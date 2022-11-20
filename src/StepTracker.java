import java.util.Scanner;

public class StepTracker {

    MonthData[] monthToData;
    Converter converter;
    int planStep;
    Scanner scanner;
    int steps;
    int idDay;
    int idMonth;

    public StepTracker() {
        this.planStep = 10_000;
        this.converter = new Converter();
        scanner = new Scanner(System.in);
        int[] numMonth = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        this.monthToData = new MonthData[12];

        for (int i = 0; i < monthToData.length; i++) {
            this.monthToData[i] = new MonthData(numMonth[i]);
        }
    }

    class MonthData {
        int[] days;

        public MonthData(int i) {
            this.days = new int[30];
            for (int j = 0; j < days.length; j++) {
                days[i] = steps;
            }
        }
    }

    public void changeDaySteps(int planStep) {
        this.planStep = planStep;
        System.out.println("Ваша новая цель за день составила " + this.planStep + " шагов");
    }

    public void getDaySteps(int idMonth, int idDay, int steps) {
        this.idMonth = idMonth;
        if (idMonth < 0 && idMonth >= 12) {
            System.out.println("Вы ввели некорректное число! Попробуйте еще раз!");
            return;
        }
        this.idDay = idDay;
        if (idDay < 0 && idDay > 30) {
            System.out.println("Вы ввели некорректное число! Попробуйте еще раз!");
            return;
        }

        while (true) {
            this.steps = steps;
            if (steps < 0) {
                System.out.println("Вы ввели некорректное число! Попробуйте еще раз!");
                return;
            } else {
                monthToData[idMonth].days[idDay] = steps;
                System.out.println("Пройденное вами количество шагов составило " + this.steps + " за " + this.idDay + " день " + "в " + this.idMonth + " месяце");
                break;
            }

        }
    }

    public void printMenuUser() {
        System.out.println("0 -  Январь \n1 -  Февраль \n2 -  Март \n3 -  Апрель \n4 -  Май \n5 -  Июнь " +
                "\n6 -  Июль \n7 -  Август \n8 -  Сентябрь \n9 -  Октябрь \n10 - Ноябрь \n11 - Декабрь");
    }

    public void getStatistic(int month) {

        for (int i = 0; i < monthToData[idMonth].days.length; i++) {
            System.out.println("Количество пройденных шагов за " + (i + 1) + "  день составляет: " + monthToData[idMonth].days[i]);
        }
        System.out.println("Количество пройденных шагов за месяц составляет " + getTotalStepsbyMonth(month));
        System.out.println("Максимально пройденное количество шагов в этом месяце составляет " + getMaxStep());
        System.out.println("Среднее количество пройденных шагов составляет " + getAvgSteps(month));
        System.out.println("Пройденная вами дистанция за месяц составляет " + converter.getDistance(getTotalStepsbyMonth(month)) + " км.");
        System.out.println("Вы сожгли за месяц " + converter.getSumKlc(this.steps) + " килокалорий");
        System.out.println("Лучшая серия шагов " + "в " + month + " месяце составляет: " + getBestSeria(month));
    }

    public int getTotalStepsbyMonth(int idMonth) {
        int totalstep = 0;
        for (int i = 0; i < monthToData[idMonth].days.length; i++) {
            totalstep += monthToData[idMonth].days[i];
        }
        return totalstep;
    }


    public int getMaxStep() {
        int max = monthToData[idMonth].days[0];
        for (int i = 0; i < monthToData[idMonth].days.length; i++) {
            if (max < monthToData[idMonth].days[i]) {
                max = monthToData[idMonth].days[i];
            }
        }
        return max;
    }

    public double getAvgSteps(int month) {
        double avgSteps = 0.0;
        avgSteps = getTotalStepsbyMonth(month) / monthToData[month].days.length;
        return avgSteps;
    }

    public int getBestSeria(int idMonth) {
        int currentCount = 0;
        int bestCount = 0;
        for (int i = 0; i < monthToData[idMonth].days.length; i++) {
            if (monthToData[idMonth].days[i] > planStep) {
                currentCount = currentCount + 1;
            } else {
                currentCount = 0;
            }
            if (currentCount > bestCount) {
                bestCount = currentCount;
            }
        }
        return bestCount;
    }
}
