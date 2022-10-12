package uOtt.seg.mealer.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

import uOtt.seg.mealer.users.MealerUserClinet;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mealer";
    private static final String TABLE_CLIENTS = "client";
    private static final String TABLE_COOK = "cook";

    //private static final short USERID = 'uID';
    private static final String EMAIL = "email";
    private static final String PWD = "password";

    private static final String FNAME = "fName";
    private static final String LNAME = "lName";
    private static final String ADDR = "address";





    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CLIENT_TABLE = "CREATE TABLE " + TABLE_CLIENTS+ "("

                + EMAIL + " TEXT PRIMARY KEY," + PWD + " TEXT," + FNAME + " TEXT," + LNAME + " TEXT,"
                + ADDR + " TEXT" + ")";

        db.execSQL(CREATE_CLIENT_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTS);

        // Create tables again
        onCreate(db);
    }

    // Add a client account
    public void addClient(MealerUserClinet client) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EMAIL, client.getEmail());
        values.put(PWD, client.getPwd());

        values.put(FNAME, client.getfName());
        values.put(LNAME, client.getlName());
        values.put(ADDR, client.getAddr());

        db.insert(TABLE_CLIENTS, null, values);
        db.close(); // Closing database connection
    }

    /*public MealerUserClinet getClient(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CLIENTS, new String[] { EMAIL, PWD, FNAME, LNAME }, EMAIL + "=?",
                new String[] { String.valueOf(EMAIL) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return contact;
    }*/
}