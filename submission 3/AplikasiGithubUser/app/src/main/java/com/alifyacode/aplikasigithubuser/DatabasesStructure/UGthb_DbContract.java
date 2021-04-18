package com.alifyacode.aplikasigithubuser.DatabasesStructure;

import android.net.Uri;
import android.provider.BaseColumns;

public class UGthb_DbContract {
    public static final String AUTHENTICAT = "com.alifyacode.aplikasigithubuser";
    public static final class UGthbClmn implements BaseColumns {
        public static final String UGthb_Table = "user";
        public static final String U_Gthb_Id = "id";
        public static final String U_Gthb_Name = "nama_pengguna_gthb";
        public static final String U_Gthb_URL = "url";
        public static final String U_Gthb_Sasshin = "avatar";
        public static final Uri U_Gthb_KONTEN_URI = new Uri.Builder().scheme("content")
                .authority(AUTHENTICAT)
                .appendPath(UGthb_Table)
                .build();
    }
}
