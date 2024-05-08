package com.techroof.pkpropertyzone.Config;

import android.content.Context;
import android.content.SharedPreferences;

public class Config {

    private Context mContext;

    public static Config ourInstance;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public Config(Context mContext) {


        this.mContext = mContext;

        this.sharedPreferences=mContext.getSharedPreferences(mContext.getApplicationInfo().packageName+"pref",
                Context.MODE_PRIVATE);
        this.editor=sharedPreferences.edit();
    }

    public static void initInstance(Context mContext)
    {
        if(ourInstance==null)
        {
            ourInstance=new Config(mContext);
        }
    }

    public static Config getInstance()
    {
        return ourInstance;
    }

    public void setSpanCount(int count)
    {
        editor.putInt("spanCount",count);
        editor.commit();
        editor.apply();
    }

    public int getSpanCount()
    {
        return sharedPreferences.getInt("spancount",1);

    }
}
