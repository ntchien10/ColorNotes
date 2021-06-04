package com.example.sqlite_1st.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.sqlite_1st.Model.Person;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    private final String TAG="DBManager: ";
    private final String DATABASE_NAME="database_name";
    private final String TABLE_NAME="table_name";

    private static final String ID="id";
    private static final String NAME="name";
    private static final String AGE="age";
    private static final String PHONE_NUMBER="phone";
    private static final String ADDRESS="address";
    private static int VERSION=1;

    private Context context;

    private String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            NAME + " TEXT, " +
            AGE + " TEXT, " +
            PHONE_NUMBER + " TEXT, " +
            ADDRESS + " TEXT)";

    public DBManager(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
        Log.d(TAG,"Manager: ");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery);
        Log.d(TAG,"onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG,"onUpgrade: ");
    }
    public void addPerson(Person person){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(NAME,person.getmName());
        values.put(AGE,person.getmAge());
        values.put(PHONE_NUMBER,person.getmPhone());
        values.put(ADDRESS,person.getmAddress());

        db.insert(TABLE_NAME,null,values);
        db.close();
        Log.d(TAG,"add person successfully");
    }
    public List<Person> getAllPerson(){
        List<Person> list=new ArrayList<>();

        String selectQuery="SELECT * FROM "+DATABASE_NAME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do {
                Person person=new Person();
                person.setmID(cursor.getInt(0));
                person.setmName(cursor.getString(1)+"");
                person.setmAge(cursor.getInt(2));
                person.setmPhone(cursor.getInt(3));
                person.setmAddress(cursor.getString(4));
                list.add(person);
            }
            while (cursor.moveToNext());
        }
        db.close();
        return list;
    }
    public int updateStudent(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,person.getmName());
        contentValues.put(ADDRESS,person.getmAddress());
        contentValues.put(AGE,person.getmAge());
        contentValues.put(PHONE_NUMBER,person.getmPhone());
        return db.update(TABLE_NAME,contentValues,ID+"=?",new String[]{String.valueOf(person.getmID())});
    }

    public int deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID+"=?",new String[] {String.valueOf(id)});
    }
}
