package com.domain.lesson9DataTime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class HomeWork {
    public static void main(String[] args) {
        // 1. Рабочие смены
        System.out.println("Задача № 1  КАКАЯ СЕЙЧАС СМЕНА?");

        // задаем временные параметры для первой и второй смены (третью смену задавать не требуется -это то время, что осталось от 1 и 2)
        LocalTime FirstStreamStart = LocalTime.of(07, 00);
        LocalTime FirstStreamEnd = LocalTime.of(14, 59);
        LocalTime SecondStreamStart = LocalTime.of(15,00);
        LocalTime SecondStreamEnd = LocalTime.of(22,59);

        // определяем формат времени с которым будем работать
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

        // определяем время в текущий момент
        String strTimeNow = LocalTime.now().format(dtf);
        System.out.print("В текущее время " + "(" + strTimeNow + "):");
        // используем метод parse(); чтобы привести значение localTime к нужному формату !!!(отбрасывает секунды и наносекунды)
        LocalTime timeNow = LocalTime.parse(strTimeNow, dtf);

        // путем проверок попадания значения текущего времени в заданные врем. интервалы определяем номер рабочей смены
        boolean isAfter = timeNow.isAfter(FirstStreamStart);
        boolean isBefore = timeNow.isBefore(FirstStreamEnd);
        if (isAfter && isBefore) System.out.println(" первая смена");
        else{
            isAfter = timeNow.isAfter(SecondStreamStart);
            isBefore = timeNow.isBefore(SecondStreamEnd);
            if (isAfter && isBefore) System.out.println(" вторая смена");
            else System.out.println(" третья смена");
        }

        // 2. Сколько занятий осталось
        System.out.println("Задача № 2  СКОЛЬКО ЗАНЯТИЙ ОСТАЛОСЬ?");

        // задаем дату окончания курсов
        LocalDate endDate = LocalDate.of(2020, Month.JANUARY, 20);

        // задаем текущую дату
        LocalDate dateNow = LocalDate.now();

        int studyDays = 0; //счетчик для учебных дней

        //через цикл перебираем все даты до окончания курсов
        // проверяем является ли текущий день пн, ср, пт. Если да - инкрементируем счетчик
        // в конце цикла к текущей дате добавляем день
        while (!(endDate.isEqual(dateNow))){
            if((dateNow.getDayOfWeek() == DayOfWeek.MONDAY) || (dateNow.getDayOfWeek() == DayOfWeek.WEDNESDAY) ||(dateNow.getDayOfWeek() == DayOfWeek.FRIDAY)) studyDays++;
            dateNow = dateNow.plusDays(1);
        }

        System.out.println("До окончания курсов осталось " + studyDays + " учебных занятий!");

    }
}
