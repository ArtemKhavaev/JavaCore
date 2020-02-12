package com.domain.lesson27BuilderListenerPrototypeCommand.builder;

public class NutritionFacts {
    private final int servings;
    private final int fat;
    private final int calories;

    public static class Builder{
        // обязательные параметры
        private final int servings;
        // необязательные параметры
        // инициализируются значениями по умолчанию
        private int fat = 0;
        private int calories = 0;

        public Builder(int servings){
            this.servings = servings;
        }

        public Builder calories (int val){
            calories = val;
            return this;
        }

        public Builder fat(int fat){
            this.fat = fat;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }
    public NutritionFacts(Builder builder){
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;

    }

}
