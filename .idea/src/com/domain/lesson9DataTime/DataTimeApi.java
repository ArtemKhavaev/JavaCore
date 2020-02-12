package com.domain.lesson9DataTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DataTimeApi {
    public static void main(String[] args) {
        // DataTime Api начиная с 8 версии
        // потокобезопасны

        // работа сдатой
        // текущая дата
        LocalDate dateNow = LocalDate.now();
        System.out.println(dateNow);

        LocalDate someDate = LocalDate.of(2018, Month.OCTOBER, 20);

        String strDate = "14/05/2017"; // 2017-05-14  -формат LocalDate
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/yyyy");
        // 8- d | 08 - dd  || MMMM - месяц (октябрь) | MMM - месяц (окт)| MM - месяц (10) || yyyy - 2017 | yy - 17

        LocalDate parseDate = LocalDate.parse(strDate, dtf);
        System.out.println(parseDate);


        //убавить годаб месяцыб недели дни
        System.out.println(parseDate.minusYears(1));
        System.out.println(parseDate.minusMonths(2));
        System.out.println(parseDate.minusWeeks(5));
        System.out.println(parseDate.minusDays(400));

        //добавить годаб месяцыб недели дни
        System.out.println(parseDate.plusYears(1));
        System.out.println(parseDate.plusMonths(2));
        System.out.println(parseDate.plusWeeks(5));
        System.out.println(parseDate.plusDays(400));

        DayOfWeek dayOfWeek = parseDate.getDayOfWeek();
        System.out.println(dayOfWeek);

        // позже?

        boolean isAfteer = parseDate.isAfter(dateNow);
        System.out.println(isAfteer);

        // раньше?

        boolean isBefore = parseDate.isBefore(dateNow);
        System.out.println(isBefore);

        // соответствие?

        boolean isEqual = parseDate.isEqual(dateNow);
        System.out.println(isEqual);


        List<LocalDate> dates = dateNow.datesUntil(LocalDate.parse("2020-03-01")).collect(Collectors.toList());
        for (LocalDate date: dates) {
            System.out.println(date);
            System.out.println(date.getDayOfWeek());
        }


        // разница
        long between = ChronoUnit.YEARS.between(parseDate, dateNow);
        System.out.println(between);

        // тоже для времени
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

        LocalTime localTime1 = LocalTime.of(7, 20);
        LocalTime localTime2 = LocalTime.of(22, 20);
        // 1 вар
        long btn1 = ChronoUnit.HOURS.between(localTime1, localTime2);
        System.out.println(btn1);
        // 2 вар
        long btn2 = Duration.between(localTime1, localTime2).toMinutes();
        System.out.println(btn2);


        // временные зоны
        Set<String> allZone = ZoneId.getAvailableZoneIds();
        System.out.println(allZone);

        // привести к заданному формату
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy / HH:mm");
        LocalDateTime localDateTime = LocalDateTime.of(2019, Month.NOVEMBER, 15, 16,23);
        System.out.println(formatter.format(localDateTime));

        // привязка даты и времени к временной зоне
        ZonedDateTime msk = localDateTime.atZone(ZoneId.of("Europe/Moscow"));
        System.out.println(msk);
        // определение времени в другой временной зоне
        ZonedDateTime ny = msk.withZoneSameInstant(ZoneId.of("America/New_York")).plusHours(4);


        // ЗАДАЧА
        System.out.println("ЗАДАЧА");
        LocalDateTime flyUp = LocalDateTime.of(2019, Month.DECEMBER, 31, 19,00);
        ZonedDateTime fly = flyUp.atZone(ZoneId.of("Australia/Sydney"));

        ZonedDateTime hustonDown = fly.withZoneSameInstant(ZoneId.of("Australia/Sydney")).plusHours(15).plusMinutes(35);
        ZonedDateTime hustonUp = hustonDown.plusHours(1).plusMinutes(45);
        ZonedDateTime washingtonDown = hustonUp.withZoneSameInstant(ZoneId.of("America/New_York")).plusHours(2).plusMinutes(49);
        ZonedDateTime washingtonUp = washingtonDown.plusHours(1).plusMinutes(6);
        ZonedDateTime ottavaDown = washingtonUp.withZoneSameInstant(ZoneId.of("America/Toronto")).plusHours(1).plusMinutes(39);

        DateTimeFormatter formatMy = DateTimeFormatter.ofPattern("dd MMMM yyyy / HH:mm");



        System.out.println("Время прибытия в Хьюстон по местному времени: ");
        System.out.println(formatMy.format(hustonDown));

        System.out.println("Время отправления из Хьюстона по местному времени: ");
        System.out.println(formatMy.format(hustonUp));

        System.out.println("Время прибытия в Вашингтон по местному времени: ");
        System.out.println(formatMy.format(washingtonDown));

        System.out.println("Время отправления из Вашингтона по местному времени: ");
        System.out.println(formatMy.format(washingtonUp));

        System.out.println("Время прибытия в Оттаву по местному времени: ");
        System.out.println(formatMy.format(ottavaDown));


        ZonedDateTime flyThisYear = LocalDateTime.of(2019, Month.DECEMBER, 31, 23,59).atZone(ZoneId.of("America/Toronto"));
        long sid = ChronoUnit.MINUTES.between(fly, ottavaDown);

        System.out.println("чтобы приземлиться в этом году самолет должен взлететь в Сиднее: ");
        System.out.println(formatMy.format(flyThisYear.minusMinutes(sid).withZoneSameInstant(ZoneId.of("Australia/Sydney"))));




        // до 8 версии (не потокобезопасные методы!!)

        Date date = new Date();
        System.out.println(date);
        Date other = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy HH:mm");
        System.out.println(sdf.format(date));
        // boolean сравнение
        System.out.println(date.before(other));
        System.out.println(date.after(other));
        System.out.println(date.compareTo(other));

        Calendar calendar1 = new GregorianCalendar();
        Calendar calendar2 = new GregorianCalendar(2016, Calendar.OCTOBER, 12);
        System.out.println(calendar2.getTime());

        calendar2.add(Calendar.DAY_OF_MONTH, 4);
        //calendar2.add(Calendar.DAY_OF_MONTH, -90);
        System.out.println(calendar2.getTime());

        System.out.println(calendar1.get(Calendar.MONTH));
        System.out.println(calendar1.getTime()); // return Date
        calendar1.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // calendar -> LocalDateTime












    }
}
