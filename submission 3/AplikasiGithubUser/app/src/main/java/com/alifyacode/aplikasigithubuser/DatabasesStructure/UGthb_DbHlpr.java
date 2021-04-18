package com.alifyacode.aplikasigithubuser.DatabasesStructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbContract.UGthbClmn.UGthb_Table;

public class UGthb_DbHlpr extends SQLiteOpenHelper {

    private static final String SQL_CREATE_TABLE_USR_GTHB = String.format(
            "CREATE TABLE %s" +
                    "(%s INTEGER PRIMARY KEY," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL)",
            UGthb_Table,
            UGthb_DbContract.UGthbClmn.U_Gthb_Id ,
            UGthb_DbContract.UGthbClmn.U_Gthb_Name,
            UGthb_DbContract.UGthbClmn.U_Gthb_URL,
            UGthb_DbContract.UGthbClmn.U_Gthb_Sasshin
    );

    public UGthb_DbHlpr(Context cntx){
        super(cntx,"dbnamapengguna",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase UGthbDBs) {
        UGthbDBs.execSQL(SQL_CREATE_TABLE_USR_GTHB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase UGthbDBs, int oldVersion, int newVersion) {
        UGthbDBs.execSQL("DROP TABLE IF EXISTS " + UGthb_Table);
        onCreate(UGthbDBs);
    }

}
