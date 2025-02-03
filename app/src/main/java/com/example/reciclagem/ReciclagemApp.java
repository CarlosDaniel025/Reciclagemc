package com.example.reciclagem;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ReciclagemApp extends AppCompatActivity {

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);

        Button btnAdicionarPonto = findViewById(R.id.btnAdicionarPonto);
        Button btnAdicionarMaterial = findViewById(R.id.btnAdicionarMaterial);

        btnAdicionarPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarPontoColeta("Ponto A", "Rua X, 123", "Plástico, Papel");
            }
        });

        btnAdicionarMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarMaterial("Garrafas PET", "Plástico", 1);
            }
        });
    }

    private void adicionarPontoColeta(String nome, String endereco, String tipoMaterialAceito) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("endereco", endereco);
        values.put("tipo_material_aceito", tipoMaterialAceito);

        db.insert("pontos_coleta", null, values);
        db.close();
    }

    private void adicionarMaterial(String nome, String tipo, int idPontoColeta) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("tipo", tipo);
        values.put("id_ponto_coleta", idPontoColeta);

        db.insert("materiais", null, values);
        db.close();
    }
}
