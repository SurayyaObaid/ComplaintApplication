package com.example.complaintapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Currency;

public class DBHandler extends AppCompatActivity {

    private Button btn_add_complaint;
    private EditText insert_title;
    MyHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b_handler);

        helper = new MyHelper(this);
        SQLiteDatabase database = helper.getWritableDatabase();

        btn_add_complaint=findViewById(R.id.btn_add_complaint);
        insert_title=findViewById(R.id.insert_title);

        btn_add_complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry=insert_title.getText().toString();
                if (insert_title.length()!=0){
                    AddData(newEntry);
                    insert_title.setText("");
                }
                else {
                    toastMessage("Empty Title can't be Added");
                }
            }
        });
        /*Cursor cursor = database.rawQuery("SELECT NAME,PRICE FROM PRODUCTS", new String[]{});

        if (cursor != null) {
            cursor.moveToFirst();
        }
        StringBuilder builder = new StringBuilder();
        do {
            String name = cursor.getString(0);
            double price = cursor.getDouble(1);

            builder.append("Name: " + name + " Price: " + price+ "\n");
        } while (cursor.moveToNext());

       // TextView tv = findViewById(R.id.textData);
        //tv.setText(builder.toString());
    */
    }

    public void AddData(String newEntry){
        boolean insertData=helper.addData(newEntry);

        if(insertData){
            toastMessage("Data Added Successfully");
        }
        else {
            toastMessage("Failed to Enter Data");
        }
    }

    public void toastMessage(String message){
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Toast.makeText(getApplicationContext(), "Item: " + id + " Selected", Toast.LENGTH_LONG).show();

        return true;
    }*/

}
