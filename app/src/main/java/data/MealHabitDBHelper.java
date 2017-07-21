package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import data.MealHabitContract.MealHabitEntry;

public class MealHabitDBHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = MealHabitDBHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "meal_habit.db";
    private static final int DATABASE_VERSION = 1;

    public MealHabitDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MEAL_HABIT_LOG_TABLE = "CREATE TABLE " + MealHabitEntry.TABLE_NAME + " ("
                + MealHabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MealHabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + MealHabitEntry.COLUMN_HABIT_DESCRIPTION + " TEXT, "
                + MealHabitEntry.COLUMN_HABIT_MINUTE_DURATION + " INTEGER NOT NULL DEFAULT 0);";
        Log.i(LOG_TAG, CREATE_MEAL_HABIT_LOG_TABLE);
        db.execSQL(CREATE_MEAL_HABIT_LOG_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertMealHabit(String name, String description, int duration) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues MealHabitValues = new ContentValues();
        MealHabitValues.put(MealHabitEntry.COLUMN_HABIT_NAME, name);
        MealHabitValues.put(MealHabitEntry.COLUMN_HABIT_DESCRIPTION, description);
        MealHabitValues.put(MealHabitEntry.COLUMN_HABIT_MINUTE_DURATION, duration);
        db.insert(MealHabitEntry.TABLE_NAME, null, MealHabitValues);
    }

    public Cursor queryAllHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                MealHabitEntry._ID,
                MealHabitEntry.COLUMN_HABIT_NAME,
                MealHabitEntry.COLUMN_HABIT_DESCRIPTION,
                MealHabitEntry.COLUMN_HABIT_MINUTE_DURATION
        };

        return db.query(
                MealHabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
    }
}
