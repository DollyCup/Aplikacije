package com.example.myapplication10;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Table_name="raspored";
    public static final String COL1 ="ID";
    public static final String COL2 ="prvi";
    public static final String COL3 ="drugi";
    public static final String COL4 ="treci";
    public static final String COL5 ="cetvrti";
    public static final String COL6 ="peti";
    public static final String COL7 ="sesti";
    public static final String COL8 ="sedmi";

    DatabaseHelper(Context context){
        super(context, Table_name,null,1);

    }
    @Override
    public void onCreate (SQLiteDatabase db)
    {
        String createTable="CREATE TABLE " + Table_name + " ( " + COL1 + " INTEGER PRIMARY KEY ," + COL2 +" TEXT ," + COL3 +" TEXT ," +COL4 +" TEXT ,"+
                COL5 +" TEXT ,"+ COL6 +" TEXT ,"+ COL7 +" TEXT ," + COL8 +" TEXT )";
        db.execSQL(createTable);
        String addValues = "INSERT INTO " + Table_name + "(" + COL1 + "," +COL2 + "," + COL3 + "," + COL4 + "," +COL5 + "," + COL6 + "," + COL7 +"," + COL8 +")"
    + "VALUES (1, \"MAt\", \"TZK\", \"EJ\", \"FIZ\", \"HJ\",\"HJ\" ,\"KEM\")";
          db.execSQL(addValues);}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ Table_name);
        onCreate(db);
    }


    void getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] tableColumns = new String[] {
                COL2, COL3, COL4, COL5, COL6, COL7, COL8
        };
        Cursor cursor = db.query(Table_name, tableColumns, null, null, null, null, null);

        int i = 0;
        try {
            while (cursor.moveToNext()) {
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

    void saveData() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL1, Appdata.lastclickedId+1);
        contentValues.put(COL2, Appdata.dan[Appdata.lastclickedId].getPredmet(1));
        contentValues.put(COL3, Appdata.dan[Appdata.lastclickedId].getPredmet(2));
        contentValues.put(COL4, Appdata.dan[Appdata.lastclickedId].getPredmet(3));
        contentValues.put(COL5, Appdata.dan[Appdata.lastclickedId].getPredmet(4));
        contentValues.put(COL6, Appdata.dan[Appdata.lastclickedId].getPredmet(5));
        contentValues.put(COL7, Appdata.dan[Appdata.lastclickedId].getPredmet(6));
        contentValues.put(COL8, Appdata.dan[Appdata.lastclickedId].getPredmet(7));

        db.update(Table_name, contentValues, COL1+"="+(Appdata.lastclickedId+1), null);

    }


}
