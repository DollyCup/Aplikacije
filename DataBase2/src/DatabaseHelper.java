package com.example.myapplication10;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;




public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String TABLE_NAME = "Raspored";
    private static final String COL1 = "ID";
    private static final String COL2 = "prvi";
    private static final String COL3 = "drugi";
    private static final String COL4 = "treci";
    private static final String COL5 = "cetvrti";
    private static final String COL6 = "peti";
    private static final String COL7 = "sesti";
    private static final String COL8 = "sedmi";

    DatabaseHelper(Context context){
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY, " +
                COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " TEXT, " + COL6 + " TEXT, " + COL7 + " TEXT, " + COL8 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addData(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL1, 1);
        contentValues.put(COL2, "Mat");
        contentValues.put(COL3, "TPK");
        contentValues.put(COL4, "Ej");
        contentValues.put(COL5, "SIS");
        contentValues.put(COL6, "NiOPr");
        contentValues.put(COL7, "NiOPr");
        contentValues.put(COL8, "NiOPr");

        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(COL1, 2);
        contentValues.put(COL2, "SkWEB/KRMiS");
        contentValues.put(COL3, "SkWEB/KRMiS");
        contentValues.put(COL4, "KRMiS/SkWEB");
        contentValues.put(COL5, "KRMiS/SkWEB");
        contentValues.put(COL6, "Hj");
        contentValues.put(COL7, "Fiz");
        contentValues.put(COL8, "TZK");

        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(COL1, 3);
        contentValues.put(COL2, "Fiz");
        contentValues.put(COL3, "Mat");
        contentValues.put(COL4, "Mat");
        contentValues.put(COL5, "Vjer/Et");
        contentValues.put(COL6, "PiG");
        contentValues.put(COL7, "");
        contentValues.put(COL8, "");

        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(COL1, 4);
        contentValues.put(COL2, "PMat");
        contentValues.put(COL3, "PMat");
        contentValues.put(COL4, "PMU");
        contentValues.put(COL5, "Hj");
        contentValues.put(COL6, "Ej");
        contentValues.put(COL7, "TPK/niš");
        contentValues.put(COL8, "niš/TPK");

        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(COL1, 5);
        contentValues.put(COL2, "SIS/URS");
        contentValues.put(COL3, "URS/SIS");
        contentValues.put(COL4, "Ej");
        contentValues.put(COL5, "PiG");
        contentValues.put(COL6, "URS");
        contentValues.put(COL7, "Hj");
        contentValues.put(COL8, "");

        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(COL1, 6);
        contentValues.put(COL2, "");
        contentValues.put(COL3, "n");
        contentValues.put(COL4, "i");
        contentValues.put(COL5, "š");
        contentValues.put(COL6, "t");
        contentValues.put(COL7, "a");
        contentValues.put(COL8, "");

        db.insert(TABLE_NAME, null, contentValues);

    }


    @SuppressLint("Range")
    void getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] tableColumns = new String[] {
                COL2, COL3, COL4, COL5, COL6, COL7, COL8
        };
        Cursor cursor = db.query(TABLE_NAME, tableColumns, null, null, null, null, null);

        int i = 0;
        try {
            while (cursor.moveToNext()) {
                Log.e("#######", "############### " + i);
                Appdata.dan[i] = new Day();
                Appdata.dan[i].setPredmeti(1, cursor.getString(cursor.getColumnIndex(COL2)));
                Appdata.dan[i].setPredmeti(2, cursor.getString(cursor.getColumnIndex(COL3)));
                Appdata.dan[i].setPredmeti(3, cursor.getString(cursor.getColumnIndex(COL4)));
                Appdata.dan[i].setPredmeti(4, cursor.getString(cursor.getColumnIndex(COL5)));
                Appdata.dan[i].setPredmeti(5, cursor.getString(cursor.getColumnIndex(COL6)));
                Appdata.dan[i].setPredmeti(6, cursor.getString(cursor.getColumnIndex(COL7)));
                Appdata.dan[i].setPredmeti(7, cursor.getString(cursor.getColumnIndex(COL8)));
                i++;
            }
        } finally {
            cursor.close();
        }
    }


}
}
