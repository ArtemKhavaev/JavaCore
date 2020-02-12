package com.domain.lesson8Static;

import java.util.Objects;

public class Car implements Cloneable {

    private String brand;
    private String color;
    private Owner owner;

        public Car(String brand, String color, Owner owner) {
        setBrand(brand);// проверка вх данных конструктора через сеттор
       setColor(color);
       this.owner = owner;

   }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getBrand(), car.getBrand()) &&
                Objects.equals(getColor(), car.getColor()) &&
                Objects.equals(owner, car.owner);
    }

    @Override
    public int hashCode() {

        return Objects.hash(getBrand(), getColor(), owner);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

            // реализация копирования для owner
        return super.clone();
    }
}


