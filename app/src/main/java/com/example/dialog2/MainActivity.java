package com.example.dialog2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Spinner spin, spin2;
    ArrayList<String> arrayList, tumanList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = findViewById(R.id.spinner1);
        spin2 =findViewById(R.id.spinner2);

        arrayList = new ArrayList<>();
        arrayList.add("Viloyatingizni kiriting");
        arrayList.add("Xorazm");
        arrayList.add("Buxoro");
        arrayList.add("Toshkent");
        arrayList.add("Samarqand");
        arrayList.add("Navoiy");
        arrayList.add("Namangan");
        arrayList.add("Jizzax");
        tumanList = new ArrayList<>();
        tumanList.add("Tuman");
        tumanList.add("Xonqa");
        tumanList.add("Xiva");
        tumanList.add("Urganch");
        tumanList.add("Bogot");
        tumanList.add("Yangiariq");
        tumanList.add("Yangibozoor");
        tumanList.add("Chakka");

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        spin.setAdapter(arrayAdapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if(position==1){
                    arrayAdapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,tumanList);
                    spin2.setAdapter(arrayAdapter);
                }

                Toast.makeText(MainActivity.this, arrayList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

        dialog.setTitle("Ilovadan Chiqish");
        dialog.setMessage("Rostan ham ilovadan chiqmoqchimisiz");
        dialog.setIcon(R.drawable.ic_android_black_24dp);
        dialog.setPositiveButton("HA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Chiqaman", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        dialog.setNegativeButton("YO'Q", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Chiqmiman", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNeutralButton("Orqaga", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Orqaga", Toast.LENGTH_SHORT).show();
            }



        });
        dialog.show();
        dialog.create();





    }
}