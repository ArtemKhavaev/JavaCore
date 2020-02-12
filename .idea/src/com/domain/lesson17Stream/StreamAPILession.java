package com.domain.lesson17Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamAPILesson{
    public static void main(String[] args) {
      // StreamAPI начиная с 8 версии
      // для работы с потоками данных
      // промежуточные операции обрабатывают данные и возвращают stream объект
        // терминальные метод обрабатывает данные и завершает работу стрима


//        stream.промежуточный1 ();
//                .промежуточный2 ();
//                .промежуточный3 ();
//                .промежуточный4 ();
//                терминальный();

//        методы получения stream объектов
//                из коллекций collections.stream();
//                из массива Arrays.stream(arr);
//                из файла Files.lines(path_to_File);
//                из строки string.chars();
//                исплользуя builder
//                        Stream.builder().add(obj1).add(obj2).add(objN).build();
//                       Stream.of(1, 4, 7);

         Stream<Integer> integerStream = Stream.of(6, 8, 90, -34, 0, -12);
         integerStream.filter(num -> num < 0)// промежуточный (возврашает stream в котором элементы, прошедшие проверку)
                 .map(num -> num * 10)// промежуточный функция умнож. оставшиеся после фильтра эл-ты на 10 и возвр. stream)
                 .limit(1)// оставляет в stream переданное количество чисел(1)
                 .forEach(System.out::println); // терминальный  вывод -340


        integerStream = Stream.of(5, 7, 89, 89, 21, 34, 21, -89);
        integerStream.distinct() // 5 7 89 21 34 -89
                .sorted() // -89 5 7 21 34 89
                .forEach(System.out::println);// -89 5 7 21 34 89

        // anyMatch | allMatch | noneMatch
        integerStream = Stream.of(6,8,90,-34,0,-12);
        System.out.println(integerStream.anyMatch(num -> num == 0)); //терминальный т.к. возвращает true (если что-то соотв. условию) и закрывает Stream
                // поэтому заново создаем Stream
        integerStream = Stream.of(6,8,90,-34,0,-12);
        System.out.println(integerStream.allMatch(num -> num > 100)); //возвращает true (если все соотв. условию)

        integerStream = Stream.of(6,8,90,-34,0,-12);
        System.out.println(integerStream.noneMatch(num -> num > 100)); //возвращает true (если ни один не соотв. условию)

        String [] stringsArr = {"aa", "bb", "cc", "dd"};

        //findFirst -берет первый эл-т| findAny  -берет любой эл-т
        Arrays.stream(stringsArr).findFirst().get();//возвращает Optional<T> get вернет null если ничего не осталось
        Arrays.stream(stringsArr).findFirst().orElse("default");//возвращает Optional<T> orElse вернет default если ничего не осталось
        Arrays.stream(stringsArr).findFirst().isPresent(); // вернет true если в  массиве stringsArr не null

        // skip();
        Arrays.stream(stringsArr).skip(2).filter(str -> str.startsWith("c")).forEach(System.out::println);


        ArrayList<User>users = new ArrayList<>();
        users.add(new User ("qwe", 34));
        users.add(new User ("asd", 56));
        users.add(new User ("zxc", 18));
        users.add(new User ("qwe", 34));
        users.add(new User ("tiu", 22));

        User [] usersArr = users.stream().filter(user -> user.getAge() >25).toArray(User[]::new); // new User[]

        List<User> userList = users.stream().filter(user -> user.getAge() <25).peek(user -> user.setActive(true)).collect(Collectors.toList());
        Set<User> userSet = users.stream().collect(Collectors.toSet());
        ArrayList<User> userArrayList = users.stream()
                .distinct()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toCollection(ArrayList::new));

        User minUser = users.stream().min(Comparator.comparing(User::getName)).orElse(new User("default", 0));
        User maxUser = users.stream().max(Comparator.comparing(User::getName)).orElse(new User("default", 0));

        String [] stringsArr2 = {"aaa", "bb", "cc", "dddd", "f"};
        // ключ- строка знач -ее длина
        Map<String, Integer> map = Arrays.stream(stringsArr2).collect(Collectors.toMap(
                Function.identity(), // определяет ключ
                String::length,// определяет длину
                (item1, item2) -> item1));// определяем что делать если ключи дублируются
        List<String> stringList  = Arrays.asList("34", "53", "99");
        stringList.stream()
                .flatMap(num -> Stream.of(Integer.parseInt(num)))
                .forEach(System.out::println);

        // reduce
        Stream<Integer>IntegerStream1 = Stream.of(1, 2, 3, 4 );
        Optional<Integer> optional = IntegerStream1.reduce((x, y)-> (x+y));
        System.out.println(optional.get());//10

        Stream<String> stringStream = Stream.of("Java",  "Junior");
        String res = stringStream.reduce("result: ", (x, y)-> x + " "+ y);
        System.out.println(res);

        IntegerStream1 = Stream.of(1, -2, -3, 4 );
        int result = IntegerStream1.reduce(0, (x,y)->{
            if (x < 0 || y < 0 ) return 0;
            else return x+ y;
        }, (x, y)->x+y);
        System.out.println(result);


    }
}

class User{
    private String name;
    private int age;
    private boolean active;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() &&
                isActive() == user.isActive() &&
                Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), isActive());
    }
}
