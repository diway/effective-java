package com.diway.BuilderPattern;

public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int carbohydrate;
    private final int protein;

    public NutritionFacts(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.carbohydrate = builder.carbohydrate;
        this.protein = builder.protein;
    }

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int protein = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            this.fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            this.carbohydrate = val;
            return this;
        }

        public Builder protein(int val) {
            this.protein = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    @Override
    public String toString() {
        return "Builder{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate +
                ", protein=" + protein +
                '}';
    }

    public static void main(String[] args) {
        NutritionFacts casein = new Builder(30, 45).
                calories(110).fat(1).carbohydrate(2).protein(25).build();
        System.out.println(casein.toString());
    }
}
