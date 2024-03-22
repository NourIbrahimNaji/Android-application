package com.example.finalproject_1190270_1190768;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    // the current user that uses the system
    public static User inputUser = new User();
    // to get one random destination from user preferred continent
    public static Destination homeDes = new Destination();
    public static String cityDescription;
    public static String imageDescription;
    public static Destination distObj , ASEobj , DESobj;
    public static Destination favDes = new Destination();
    // users table
    // define the names of tables columns
    public static final String USER_TABLE_NAME = "User";
    public static final String COLUMN_EMAIL_ID = "user_email";
    public static final String COLUMN_FNAME = "fist_name";
    public static final String COLUMN_LNAME = "last_name";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_CPASSWORD_ = "cpassword";
    public static final String COLUMN_PTDESTINATIONS = "ptdestinations";

    // destinations table.
    public static final String DESTINATION_TABLE_NAME = "destination";
    public static final String DESTINATION_ID = "d_id";
    public static final String COLUMN_DES_CITY = "dcity";
    public static final String COLUMN_DES_COUNTRY = "dcountry";
    public static final String COLUMN_DES_CONTINENT = "dcontinant";
    public static final String COLUMN_DES_LONGITUDE = "dlogitude";
    public static final String COLUMN_DES_LATITUDE = "dlatitude";
    public static final String COLUMN_DES_COST = "dcost";
    public static final String COLUMN_DES_IMAGE_URL = "dimage";
    public static final String COLUMN_DES_DESCRIPTION = "ddescription";


    // define database name and version.
    private static final String DATABASE_NAME = "finalProDB";
    private static final int DATABASE_VERSION = 1;

    // SQL statements for creating the two table.
    private static final String SQL_CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE_NAME + "("
            + COLUMN_EMAIL_ID + " TEXT PRIMARY KEY, "
            + COLUMN_FNAME + " TEXT, "
            + COLUMN_LNAME + " TEXT, "
            + COLUMN_PASSWORD + " TEXT, "
            + COLUMN_CPASSWORD_ + " TEXT, "
            + COLUMN_PTDESTINATIONS + " TEXT);";

    private static final String SQL_CREATE_TABLE_DESTINATIONS = "CREATE TABLE " + DESTINATION_TABLE_NAME + "("
            + DESTINATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DES_CITY + " TEXT, "
            + COLUMN_DES_COUNTRY + " TEXT, "
            + COLUMN_DES_CONTINENT + " TEXT, "
            + COLUMN_DES_LONGITUDE + " REAL, "
            + COLUMN_DES_LATITUDE + " REAL, "
            + COLUMN_DES_COST + " INTEGER, "
            + COLUMN_DES_IMAGE_URL + " TEXT, "
            + COLUMN_DES_DESCRIPTION + " TEXT);";

    //constructors.
    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // create the database with required database name and version.
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // create database tables.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_USERS);
        db.execSQL(SQL_CREATE_TABLE_DESTINATIONS);
    }

    // define function to insert user
    public boolean addUser(User user) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL_ID, user.getUser_email());
        values.put(COLUMN_FNAME, user.getFist_name());
        values.put(COLUMN_LNAME, user.getLast_name());
        values.put(COLUMN_PASSWORD, user.getPassword());
        values.put(COLUMN_CPASSWORD_, user.getCpassword());
        values.put(COLUMN_PTDESTINATIONS, user.getPtdestinations());
        inputUser = user;
        sqLiteDatabase.insert(USER_TABLE_NAME, null, values);
        return true;
    }

    // define function to get all users in database.
    public Cursor getAllUsers() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + USER_TABLE_NAME, null);
    }

    // define function to get all courses in database.
    public Boolean checkEmailSignIn(String email) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + USER_TABLE_NAME + " where user_email = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                inputUser.setUser_email(cursor.getString(0));
                inputUser.setFist_name(cursor.getString(1));
                inputUser.setLast_name(cursor.getString(2));
                inputUser.setPassword(cursor.getString(3));
                inputUser.setCpassword(cursor.getString(4));
                inputUser.setPtdestinations(cursor.getString(5));
            }
            return true;
        } else
            return false;
    }

    // define a function to check input password.
    public Boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from user where user_email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    // define function to insert destination
    public boolean addDestination(Destination destination) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DES_CITY, destination.getCity());
        values.put(COLUMN_DES_COUNTRY, destination.getCountry());
        values.put(COLUMN_DES_CONTINENT, destination.getContinent());
        values.put(COLUMN_DES_LONGITUDE, destination.getLongitude());
        values.put(COLUMN_DES_LATITUDE, destination.getLatitude());
        values.put(COLUMN_DES_COST, destination.getCost());
        values.put(COLUMN_DES_IMAGE_URL, destination.getImage());
        values.put(COLUMN_DES_DESCRIPTION, destination.getDescription());
        sqLiteDatabase.insert(DESTINATION_TABLE_NAME, null, values);
        return true;
    }

    // delete the existing destinations, to avoid repeating
    public void deleteExistsDes() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + DESTINATION_TABLE_NAME + ";");

    }

    // get the country according to the continent
    public Boolean getCountryByContinent(String des_continant) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DESTINATION_TABLE_NAME + " WHERE " + COLUMN_DES_CONTINENT + " = ? " + " ORDER BY RANDOM() "
                + " LIMIT 1 ;", new String[]{des_continant});
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                homeDes.setDestination_id(cursor.getInt(0));
                homeDes.setCity(cursor.getString(1));
                homeDes.setCountry(cursor.getString(2));
                homeDes.setContinent(cursor.getString(3));
                homeDes.setLongitude(cursor.getDouble(4));
                homeDes.setLatitude(cursor.getDouble(5));
                homeDes.setCost(cursor.getInt(6));
                homeDes.setImage(cursor.getString(7));
                homeDes.setDescription(cursor.getString(8));
            }
        }
        return true;
    }

    // to get user favorite destination
    public boolean getFavoriteDes(List<Destination> destinationList) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        for (int i = 0; i < destinationList.size(); i++) {
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT " + COLUMN_DES_CITY + ", " + COLUMN_DES_COUNTRY + " FROM " + DESTINATION_TABLE_NAME + " WHERE " + COLUMN_DES_CITY + "= ?;", new String[]{destinationList.get(i).toString()});
        }
        return true;
    }

    // to get all information about destination depends on continent
    public Boolean getAllInfo() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DESTINATION_TABLE_NAME + " GROUP BY dcontinant , dcity", null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                distObj = new Destination();
                distObj.setDestination_id(cursor.getInt(0));
                distObj.setCity(cursor.getString(1));
                distObj.setCountry(cursor.getString(2));
                distObj.setContinent(cursor.getString(3));
                distObj.setLongitude(cursor.getDouble(4));
                distObj.setLatitude(cursor.getDouble(5));
                distObj.setCost(cursor.getInt(6));
                distObj.setImage(cursor.getString(7));
                distObj.setDescription(cursor.getString(8));
                if (Part2.allDesList.contains(distObj)) {
                    System.out.print("Destination already exists in the list!");
                } else {
                    Part2.allDesList.add(distObj);

                }
            }
        }
        return true;
    }

    // to get a city description
    public boolean findCityDescription(String cityName) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT " + COLUMN_DES_DESCRIPTION + " FROM " + DESTINATION_TABLE_NAME + " WHERE " + COLUMN_DES_CITY + "= ?;", new String[]{cityName});
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                cityDescription = cursor.getString(0);
            }
            return true;
        } else {
            return false;
        }
    }

    // to get a specific city image
    public boolean findImageDescription(String cityName) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT " + COLUMN_DES_IMAGE_URL + " FROM " + DESTINATION_TABLE_NAME + " WHERE " + COLUMN_DES_CITY + "= ?;", new String[]{cityName});
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                imageDescription = cursor.getString(0);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean AscendingOrder(){
        SQLiteDatabase sqLiteDatabase  = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT dcity,dcost FROM " +DESTINATION_TABLE_NAME + " ORDER BY dcost DESC;" ,null );
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                ASEobj = new Destination();
                ASEobj.setCity(cursor.getString(0));
                ASEobj.setCost(cursor.getInt(1));
                Part2.allASEOrder.add(ASEobj);
            }
        }
        return true;
    }
    public boolean DecendingOrder(){
        SQLiteDatabase sqLiteDatabase  = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT  dcity,dcost FROM " +DESTINATION_TABLE_NAME + " ORDER BY dcost ASC;" ,null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                DESobj = new Destination();
                DESobj.setCity(cursor.getString(0));
                DESobj.setCost(cursor.getInt(1));
                Part2.allDESOrder.add(DESobj);
            }
        }
        return true;
    }

    public boolean updateUser(User user){
        SQLiteDatabase sqLiteDatabase  = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL_ID, Edit.EditUser.getUser_email());
        values.put(COLUMN_FNAME, Edit.EditUser.getFist_name());
        values.put(COLUMN_LNAME, Edit.EditUser.getLast_name());
        values.put(COLUMN_PASSWORD, Edit.EditUser.getPassword());
        values.put(COLUMN_CPASSWORD_, Edit.EditUser.getCpassword());
        values.put(COLUMN_PTDESTINATIONS, Edit.EditUser.getPtdestinations());
        sqLiteDatabase.update(USER_TABLE_NAME, values, COLUMN_EMAIL_ID + " = ?", new String[]{DataBaseHelper.inputUser.getUser_email()});
        return true;
    }

    // all data about destination
    public boolean allInfo(String cityName) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DESTINATION_TABLE_NAME + " WHERE " + COLUMN_DES_CITY + "= ?;", new String[]{cityName});
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                favDes = new Destination();
                favDes.setDestination_id(cursor.getInt(0));
                favDes.setCity(cursor.getString(1));
                favDes.setCountry(cursor.getString(2));
                favDes.setContinent(cursor.getString(3));
                favDes.setLongitude(cursor.getDouble(4));
                favDes.setLatitude(cursor.getDouble(5));
                favDes.setCost(cursor.getInt(6));
                favDes.setImage(cursor.getString(7));
                favDes.setDescription(cursor.getString(8));

            }
            favDes = favDes;
            return true;
        } else {
            return false;
        }
    }
    // for updating purpose
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


