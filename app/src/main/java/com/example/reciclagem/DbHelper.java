package com.example.reciclagem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "reciclagem.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_PONTOS = "CREATE TABLE pontos_coleta (" +
            "idpontos_coleta INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT NOT NULL," +
            "endereco TEXT NOT NULL," +
            "tipo_material_aceito TEXT NOT NULL);";

    private static final String CREATE_TABLE_MATERIAIS = "CREATE TABLE materiais (" +
            "idmateriais INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT NOT NULL," +
            "tipo TEXT NOT NULL," +
            "id_ponto_coleta INTEGER," +
            "FOREIGN KEY(id_ponto_coleta) REFERENCES pontos_coleta(id));";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PONTOS);
        db.execSQL(CREATE_TABLE_MATERIAIS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS pontos_coleta ");
    }
}