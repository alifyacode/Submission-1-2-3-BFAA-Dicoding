package com.alifyacode.aplikasigithubuser.ProviderReceiver;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.alifyacode.aplikasigithubuser.UsersConfiguration.UGthbHelp;

import java.util.Objects;

import static com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbContract.AUTHENTICAT;
import static com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbContract.UGthbClmn.UGthb_Table;
import static com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbContract.UGthbClmn.U_Gthb_KONTEN_URI;


public class DeUGthbProvider extends ContentProvider {

    UGthbHelp UgthbH;
    Cursor crsr;
    Uri cntntU_r_i = null;
    private static final UriMatcher UrMatch = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        UrMatch.addURI(AUTHENTICAT,UGthb_Table,0);
        UrMatch.addURI(AUTHENTICAT,UGthb_Table + "/#",1);
    }

    @Override
    public boolean onCreate() {
        UgthbH = UGthbHelp.getInstance(getContext());
        UgthbH.open();
        return true;
    }

    @Override
    public Cursor query(Uri u_r_i, String[] prjctn, String slctn, String[] slctnA, String srtrdr) {

        switch (UrMatch.match(u_r_i)){
            case 0:
                crsr = UgthbH.queryAll();
                break;
            case 1:
                crsr = UgthbH.queryById(u_r_i.getLastPathSegment());
                break;
            default:
                crsr = null;
                break;
        }

        if (crsr != null){
            crsr.setNotificationUri(Objects.requireNonNull(getContext()).getContentResolver(),u_r_i);
        }
        return crsr;
    }

    @Override
    public String getType(Uri u_r_i) {
        return null;
    }

    @Override
    public Uri insert(Uri u_r_i, ContentValues points) {
        long added;
        if (UrMatch.match(u_r_i) == 0) {
            added = UgthbH.InsertKonten(points);
            if (added > 0) {
                cntntU_r_i = ContentUris.withAppendedId(U_Gthb_KONTEN_URI, added);
            }
        } else {
            added = 0;
        }

        if (added > 0) {
            Objects.requireNonNull(getContext()).getContentResolver().notifyChange(u_r_i, null);
        }
        return cntntU_r_i;
    }


    @Override
    public int update(Uri u_r_i, ContentValues points, String selection, String[] selectionArgs) {
        int update;
        if (UrMatch.match(u_r_i) == 1) {
            update = UgthbH.UpdateKonten(u_r_i.getLastPathSegment(), points);
        } else {
            update = 0;
        }

        if (update > 0) {
            Objects.requireNonNull(getContext()).getContentResolver().notifyChange(u_r_i, null);
        }
        return update;
    }


    @Override
    public int delete(Uri u_r_i, String selection, String[] selectionArgs) {
        int delete;
        if (UrMatch.match(u_r_i) == 1) {
            delete = UgthbH.DeleteKonten(u_r_i.getLastPathSegment());
        } else {
            delete = 0;
        }
        if (delete > 0) {
            Objects.requireNonNull(getContext()).getContentResolver().notifyChange(u_r_i, null);

        }
        return delete;
    }

}