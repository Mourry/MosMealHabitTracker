package com.example.android.mosmealhabittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import data.MealHabitContract.MealHabitEntry;
import data.MealHabitDBHelper;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MealHabitDBHelper mDbHelper = new MealHabitDBHelper(this);

        mDbHelper.insertMealHabit(
                "Breakfast",
                "I had 1 cup of coffee, cereals and a muffin",
                MealHabitEntry.HABIT_MINUTE_DURATION_M);

        mDbHelper.insertMealHabit(
                "Lunch",
                "I had a Salmon and cheese bagel, a bag of chips and a glass of orange juice",
                MealHabitEntry.HABIT_MINUTE_DURATION_L);

        mDbHelper.insertMealHabit(
                "Diner",
                "I had a tomato soup, gorgonzola cheese pastas and chocolate ice cream",
                MealHabitEntry.HABIT_MINUTE_DURATION_XL);

        mDbHelper.insertMealHabit(
                "Snack",
                "Few almonds and a glass of apple juice",
                MealHabitEntry.HABIT_MINUTE_DURATION_S);

        Cursor readCursor = mDbHelper.queryAllHabits();

        try {
            while (readCursor.moveToNext()) {
                Log.i(LOG_TAG,
                        "Meal habit: " + readCursor.getInt(0) + " - "
                                + readCursor.getString(1) + " - "
                                + readCursor.getString(2) + " - "
                                + readCursor.getInt(3));
            }
        } finally {
            readCursor.close();
        }

    }
}