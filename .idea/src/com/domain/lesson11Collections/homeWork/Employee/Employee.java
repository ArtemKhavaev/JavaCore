package com.domain.lesson11Collections.homeWork.Employee;

import java.util.*;

// Создать список объетов List<Employee>
// и сортировать по:
// имени
// имени и зарплете
// имени, зарплете, возрасту и компании
//??? implements Comparable<Employee>
public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    public Employee(String name, String company, int salary, int age) {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}'+ "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getSalary() == employee.getSalary() &&
                getAge() == employee.getAge() &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(getCompany(), employee.getCompany());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getCompany(), getSalary(), getAge());
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(names[(int)(Math.random()*10)],companies[(int)(Math.random()*6 )], ((int)(Math.random()*1000 + 1)), ((int)(Math.random()*40 + 21)))); // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
        }
        return employees;
    }



    public static void printEmployee(List<Employee> employees){
        System.out.println(employees);

    }

    public static List<Employee> SortByName (List<Employee> employees) {
        Collections.sort(employees, new Comparator() {
            public int compare(Object o1, Object o2) {
                String x1 = ((Employee) o1).getName();
                String x2 = ((Employee) o2).getName();
                    return x1.compareTo(x2);
            }});
        return employees;
    }

    public static List<Employee> SortByNameSal (List<Employee> employees) {
        Collections.sort(employees, new Comparator() {
            public int compare(Object o1, Object o2) {
                int res = (((Employee) o1).getName()).compareTo(((Employee) o2).getName());
                if (res != 0) return res;
                return ((Integer)((Employee) o1).getSalary()).compareTo(((Employee) o2).getSalary());
            }});
        return employees;
    }

    public static List<Employee> SortByNameSalAge (List<Employee> employees) {
        Collections.sort(employees, new Comparator() {
            public int compare(Object o1, Object o2) {
                int resName = (((Employee) o1).getName()).compareTo(((Employee) o2).getName());
                if (resName != 0)  return resName;
                int resSal = ((Integer)((Employee) o1).getSalary()).compareTo(((Employee) o2).getSalary());
                if (resSal != 0) return resSal;
                return ((Integer)((Employee) o1).getAge()).compareTo(((Employee) o2).getAge());
            }});
        return employees;
    }

    public static List<Employee> SortByNameSalAgeCo (List<Employee> employees) {
        Collections.sort(employees, new Comparator() {
            public int compare(Object o1, Object o2) {
                int resName = (((Employee) o1).getName()).compareTo(((Employee) o2).getName());
                if (resName != 0)  return resName;
                int resSal = ((Integer)((Employee) o1).getSalary()).compareTo(((Employee) o2).getSalary());
                if (resSal != 0) return resSal;
                int resAge = ((Integer)((Employee) o1).getAge()).compareTo(((Employee) o2).getAge());
                if (resAge != 0) return resAge;
                return (((Employee) o1).getCompany()).compareTo(((Employee) o2).getCompany());
            }});
        return employees;
    }


}
