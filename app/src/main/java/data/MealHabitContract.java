package data;

import android.provider.BaseColumns;

public final class MealHabitContract {

    //An empty private constructor makes sure that the class is not going to be initialised.
    private MealHabitContract() {
    }

    public static class MealHabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "mealHabits";
        
        public static final String COLUMN_HABIT_NAME = "nameOfTheMeal";
        public static final String COLUMN_HABIT_DESCRIPTION = "descriptionOfTheMeal";
        public static final String COLUMN_HABIT_MINUTE_DURATION = "durationOfTheMeal";

        /*
        *  Duration increments in minutes
        *  S = 10, M = 15, L = 30, XL = 60
        */
        public static final int HABIT_MINUTE_DURATION_S = 0;
        public static final int HABIT_MINUTE_DURATION_M = 1;
        public static final int HABIT_MINUTE_DURATION_L = 2;
        public static final int HABIT_MINUTE_DURATION_XL = 3;
    }
}
