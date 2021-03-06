package com.example.mohit31.workouttracker.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mohit31 on 8/29/17.
 */
public class WorkoutViewDbHelper extends SQLiteOpenHelper {

    public final String CREATE_WORKOUT_TABLE = "CREATE TABLE " + WorkoutListContract.WorkoutListEntry.TABLE_NAME + " ("
            + WorkoutListContract.WorkoutListEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + WorkoutListContract.WorkoutListEntry.COLUMN_WORKOUT_NAME + " TEXT, "
            + WorkoutListContract.WorkoutListEntry.COLUMN_WORKOUT_KEY + " INTEGER)";

    public final String CREATE_EXERCISE_TABLE = "CREATE TABLE " + WorkoutViewContract.WorkoutViewEntry.TABLE_NAME + " ("
            + WorkoutViewContract.WorkoutViewEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + WorkoutViewContract.WorkoutViewEntry.COLUMN_EXERCISE_NAME + " TEXT, "
            + WorkoutViewContract.WorkoutViewEntry.COLUMN_REPS + " INTEGER, "
            + WorkoutViewContract.WorkoutViewEntry.COLUMN_SETS + " INTEGER, "
            + WorkoutViewContract.WorkoutViewEntry.COLUMN_REST_TIME + " INTEGER, "
            + WorkoutViewContract.WorkoutViewEntry.COLUMN_WEIGHT + " REAL, "
            + WorkoutViewContract.WorkoutViewEntry.COLUMN_WORKOUT_KEY + " INTEGER)";

    public final String DELETE_EXERCISE_TABLE = "DROP TABLE " + WorkoutViewContract.WorkoutViewEntry.TABLE_NAME;

    public final String DELETE_WORKOUT_TABLE = "DROP TABLE " + WorkoutListContract.WorkoutListEntry.TABLE_NAME;

    private static final String DATABASE_NAME = "workoutInfo.db";
    public static int DATABASE_VERSION = 1;


    public WorkoutViewDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_WORKOUT_TABLE);
        sqLiteDatabase.execSQL(CREATE_EXERCISE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(DELETE_EXERCISE_TABLE);
        sqLiteDatabase.execSQL(CREATE_EXERCISE_TABLE);
        sqLiteDatabase.execSQL(DELETE_WORKOUT_TABLE);
        sqLiteDatabase.execSQL(CREATE_WORKOUT_TABLE);
        DATABASE_VERSION = newVersion;
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(DELETE_EXERCISE_TABLE);
        sqLiteDatabase.execSQL(DELETE_WORKOUT_TABLE);
        sqLiteDatabase.execSQL(CREATE_WORKOUT_TABLE);
        sqLiteDatabase.execSQL(CREATE_EXERCISE_TABLE);
        DATABASE_VERSION = newVersion;
    }
}
