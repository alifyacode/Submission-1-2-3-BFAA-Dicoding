package com.alifyacode.aplikasigithubuser.UsersConfiguration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbHlpr;

import java.util.ArrayList;

import static com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbContract.UGthbClmn.UGthb_Table;
import static com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbContract.UGthbClmn.U_Gthb_Id;
import static com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbContract.UGthbClmn.U_Gthb_Name;
import static com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbContract.UGthbClmn.U_Gthb_Sasshin;
import static com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbContract.UGthbClmn.U_Gthb_URL;

public class UGthbHelp {
    private static final String UGTHBDBTABLE = UGthb_Table;
    private static UGthb_DbHlpr usrgthbDbHlpr;
    private static SQLiteDatabase usrgthbDB;
    private static UGthbHelp usrgthbINST;
    ContentValues cntntvls;

    public UGthbHelp(Context cntx) {
        usrgthbDbHlpr = new UGthb_DbHlpr(cntx);
    }

    public static UGthbHelp getInstance(Context cntx) {
        if (usrgthbINST == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (usrgthbINST == null) {
                    usrgthbINST = new UGthbHelp(cntx);
                }
            }
        }
        return usrgthbINST;
    }

    public void open() throws SQLException {
        usrgthbDB = usrgthbDbHlpr.getWritableDatabase();
    }

    public void close() {
        usrgthbDbHlpr.close();
        if (usrgthbDB.isOpen())
            usrgthbDB.close();
    }

    public Cursor queryAll() {
        return usrgthbDB.query(UGTHBDBTABLE,
                null,
                null,
                null,
                null,
                null,
                U_Gthb_Id + " ASC");
    }

    public Cursor queryById(String id) {
        return usrgthbDB.query(UGTHBDBTABLE, null
                , U_Gthb_Id  + " = ?"
                , new String[]{id}
                , null
                , null
                , null
                , null);
    }
    public static ArrayList<UsrGthb> getDataUsrGthb(){
        ArrayList<UsrGthb> usrlst= new ArrayList<>();
        Cursor crsr = usrgthbDB.query(UGTHBDBTABLE,null,
                null,
                null,
                null,
                null,
                U_Gthb_Name + " ASC",
                null);
        crsr.moveToFirst();
        if (crsr.getCount() > 0){
            do {
                UsrGthb usr = new UsrGthb();
                usr.setId(crsr.getInt(crsr.getColumnIndexOrThrow(U_Gthb_Id)));
                usr.setLogin(crsr.getString(crsr.getColumnIndexOrThrow(U_Gthb_Name)));
                usr.setAvatarUrl(crsr.getString(crsr.getColumnIndexOrThrow(U_Gthb_Sasshin)));
                usr.setHtmlUrl(crsr.getString(crsr.getColumnIndexOrThrow(U_Gthb_URL)));
                usrlst.add(usr);
                crsr.moveToNext();
            }while (!crsr.isAfterLast());
        }crsr.close();
        return usrlst;
    }
    public void userInsert(UsrGthb user){
        cntntvls = new ContentValues();
        cntntvls.put(U_Gthb_Id ,user.getId());
        cntntvls.put(U_Gthb_Name,user.getLogin());
        cntntvls.put(U_Gthb_URL,user.getHtmlUrl());
        cntntvls.put(U_Gthb_Sasshin,user.getAvatarUrl());

        usrgthbDB.insert(UGTHBDBTABLE, null, cntntvls);

    }
    public long InsertKonten(ContentValues vls) {
        return usrgthbDB.insert(UGTHBDBTABLE, null, vls);
    }
    public void userDelete(String id){
        usrgthbDB.delete(UGthb_Table, U_Gthb_Id  + " = '" + id + "'", null);
    }
    public int DeleteKonten(String id) {
        return usrgthbDB.delete(UGthb_Table, U_Gthb_Id + "=?",new String[]{id});
    }
    public int UpdateKonten(String id, ContentValues vls) {
        return usrgthbDB.update(UGTHBDBTABLE, vls, U_Gthb_Id  + " =?", new String[]{id});
    }
}

