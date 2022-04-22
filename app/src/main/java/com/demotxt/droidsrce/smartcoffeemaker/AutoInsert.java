package com.demotxt.droidsrce.welcomescreen;

import android.content.Context;

public class AutoInsert {
    public AutoInsert(Context context){
        DatabaseManager manager = new DatabaseManager(context);
        manager.insert("Espresso");
        manager.insert("Cream");
        manager.insert("Filter");
    }
}
