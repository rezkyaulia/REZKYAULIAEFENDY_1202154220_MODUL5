package com.example.android.rezkyauliaefendy_1202154220_modul5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDo extends AppCompatActivity {
    //mendeklarasi variable
    private EditText todo, Description, Priority;
    private Database dbTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
        //set title menjadi add to do
        setTitle("Add To Do");

        //merefer semua variabel yang ada
        todo = (EditText) findViewById(R.id.edt_Todo);
        Description = (EditText) findViewById(R.id.edt_Desc);
        Priority = (EditText) findViewById(R.id.edt_Priority);
        dbTodo = new Database(this);
    }

    @Override
    public void onBackPressed() {
        //intent menuju MainActivity
        Intent intent = new Intent(AddToDo.this, MainActivity.class);
        //memulai intent
        startActivity(intent);
        //menutup aktivitas setelah intent dijalankan
        this.finish();
    }

    public void addTodo(View view) {
        //apabila data todoname, deskripsi dan prioritas di isi,
        if (dbTodo.inputdata(new AddData(todo.getText().toString(), Description.getText().toString(), Priority.getText().toString()))){
            //maka akan menampilkan toast bawha data berhasil di tambahkan ke dalam list
            Toast.makeText(this, "To Do List Ditambahkan !", Toast.LENGTH_SHORT).show();
            //intent ke mainActivity
            startActivity(new Intent(AddToDo.this, MainActivity.class));
            //menutup aktivitas agar tidak kembali ke activity yang dijalankan setelah intent
            this.finish();
        }else {
            //apabila edit text kosong maka akan muncul toast
            Toast.makeText(this, "List tidak boleh kosong", Toast.LENGTH_SHORT).show();
            //set semua edit text menjadi kosong
            todo.setText(null);
            Description.setText(null);
            Priority.setText(null);
        }
    }

}

