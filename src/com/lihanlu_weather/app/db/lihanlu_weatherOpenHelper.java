package com.lihanlu_weather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class lihanlu_weatherOpenHelper extends SQLiteOpenHelper{
//将三条建表语句定义为常量
	/*省份表建表语句*/
	public static final String CREATE_PROVINCE="create table Province("
			+ "id integer primary key autoincrement, "//自增长主键
			+ "province_name text, "//省名
			+ "province_code text)";//省级代号
	/*城市表建表语句*/
	public static final String CREATE_CITY="create table City("
			+ "id integer primary key autoincrement, "
			+ "city_name text, "
			+ "city_code text," 
			+ "province_id integer)";//City关联Province表的外键
	/*县表建表语句*/
	public static final String CREATE_COUNTY="create table County("
			+ "id integer primary key autoincrement, "
			+ "county_name text, "
			+ "county_code text"
			+ "city_id integer)";//County表关联City表的外键

	public lihanlu_weatherOpenHelper(Context context,String name,CursorFactory factory,int version)
	{
		super(context,name,factory,version);
	}
//onCreate方法执行创建	
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL(CREATE_PROVINCE);//
		db.execSQL(CREATE_CITY);//
		db.execSQL(CREATE_COUNTY);//
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
	}
}
