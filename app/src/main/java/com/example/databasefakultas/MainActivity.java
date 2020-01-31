package com.example.databasefakultas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHandler myDB;
    EditText edIdFakultas, edNamaFakultas;
    Button btnInsert, btnUpdate, btnDelete, btnView;
    TextView labelFakultas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHandler(this);

        edIdFakultas = findViewById(R.id.edIdFk);
        edNamaFakultas = findViewById(R.id.edNamaFk);
        btnInsert = findViewById(R.id.insert);
        btnDelete = findViewById(R.id.delete);
        btnUpdate = findViewById(R.id.update);
        btnView = findViewById(R.id.view);
        labelFakultas = findViewById(R.id.datas);

        btnView.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        Fakultas newFakultas = new Fakultas();

        String idFakultas = edIdFakultas.getText().toString();
        String namaFakultas = edNamaFakultas.getText().toString();

        newFakultas.setIdFk(idFakultas);
        newFakultas.setFakName(namaFakultas);

        FakultasHelper fakultasHelper = new FakultasHelper(this);

        switch (btn.getId()){
            case R.id.insert :
                int resInsert = fakultasHelper.insertFakultas(newFakultas);

                if (resInsert > 0) {
                    Toast.makeText(MainActivity.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Gagal disimpan", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.update :
                int resUpdate = fakultasHelper.updateFakultas(newFakultas);

                if (resUpdate > 0) {
                    Toast.makeText(MainActivity.this, "Data berhasil diubah", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Gagal disimpan", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.delete :
                Boolean resDelete = fakultasHelper.deleteFakultas(idFakultas);

                if (resDelete == true) {
                    Toast.makeText(MainActivity.this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Gagal disimpan", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.view :
                ArrayList<Fakultas> fakultasList = fakultasHelper.getFakultasData();

                StringBuilder fakultasListData = new StringBuilder();

                int i = 1;
                for (Fakultas fakultas : fakultasList){
                    fakultasListData.append(i + "\n" + "Kode Fakultas : " + fakultas.getIdFk() +
                            "\n" + "Nama Fakultas : " + fakultas.getFakName() + "\n \n");
                    i++;
                }

                labelFakultas.setText(fakultasListData.toString());

                break;
        }

    }
}
