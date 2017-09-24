package com.example.darren.q3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button clear, retrieve, create, add, remove, update, showAll;
    TextView listName, showData;
    EditText id, task, description;
    RelativeLayout main, changeDatabase;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting all the buttons up
        clear = (Button)findViewById(R.id.clear);
        retrieve = (Button)findViewById(R.id.retrieve);
        create = (Button)findViewById(R.id.create);
        add = (Button)findViewById(R.id.add);
        remove = (Button)findViewById(R.id.remove);
        update = (Button)findViewById(R.id.update);
        showAll = (Button)findViewById(R.id.showAll);

        //setting all the textViews up
        listName = (TextView)findViewById(R.id.listName);
        showData = (TextView)findViewById(R.id.showData);

        //setting all the editText up
        id = (EditText)findViewById(R.id.id);
        task = (EditText)findViewById(R.id.task);
        description = (EditText)findViewById(R.id.description);

        //setting all the relativeLayouts up
        main = (RelativeLayout)findViewById(R.id.mainView);
        changeDatabase = (RelativeLayout)findViewById(R.id.changeDatabase);

        //Setting a relativeLayout to default gone mode
        changeDatabase.setVisibility(View.GONE);

        db = openOrCreateDatabase("toDo", Context.MODE_PRIVATE, null);

        db.execSQL("DELETE FROM toDo");
        db.execSQL("DROP TABLE IF EXISTS toDo");

        db.execSQL("CREATE TABLE IF NOT EXISTS toDo(ID INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, description VARCHAR);");
        db.execSQL("INSERT INTO toDo (name,description) VALUES('Darren','This is a person')");

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData.setText("");
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setVisibility(View.GONE);
                changeDatabase.setVisibility(View.VISIBLE);
            }
        });

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("SELECT * FROM toDo",null);
                if(c.getCount()==0) {
                    showData.setText("Error : No records found!!");
                } else {
                    StringBuffer buffer = new StringBuffer();
                    c.moveToFirst();

                    buffer.append("Id: "+c.getString(0)+"\n");
                    buffer.append("Name: "+c.getString(1)+"\n");
                    buffer.append("Description: "+c.getString(2)+"\n\n");

                    while(c.moveToNext()) {
                        buffer.append("Id: "+c.getString(0)+"\n");
                        buffer.append("Name: "+c.getString(1)+"\n");
                        buffer.append("Description: "+c.getString(2)+"\n\n");
                    }
                    //showData.setText("List of Tasks\n"+ buffer.toString());
                    showData.setText(""+c.getCount());
                }
            }
        });

        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setVisibility(View.VISIBLE);
                changeDatabase.setVisibility(View.GONE);

                Cursor c = db.rawQuery("SELECT * FROM toDo",null);
                if(c.getCount()==0) {
                    showData.setText("Error : No records found!!");
                } else {
                    StringBuffer buffer = new StringBuffer();
                    c.moveToFirst();

                    buffer.append("Id: "+c.getString(0)+"\n");
                    buffer.append("Name: "+c.getString(1)+"\n");
                    buffer.append("Description: "+c.getString(2)+"\n\n");

                    while(c.moveToNext()) {
                        buffer.append("Id: "+c.getString(0)+"\n");
                        buffer.append("Name: "+c.getString(1)+"\n");
                        buffer.append("Description: "+c.getString(2)+"\n\n");
                    }
                    showData.setText("List of Tasks\n"+ buffer.toString());

                    //showData.setText(c.getCount());
                }
//                showData.setText(c.getCount());
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("INSERT INTO toDo (name,description) VALUES('"+task.getText().toString()+"','"+description.getText().toString()+"')");
                Toast.makeText(getApplicationContext(),"Item has been added to database", Toast.LENGTH_SHORT).show();
        }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("UPDATE toDo SET name='"+task.getText().toString()+"',description='"+ description.getText().toString()+"' WHERE ID='"+id.getText().toString()+"'");
                Toast.makeText(getApplicationContext(),"Item has been updated", Toast.LENGTH_SHORT).show();
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("DELETE FROM toDo WHERE ID='"+id.getText()+"'");
                Toast.makeText(getApplicationContext(),"Item has been removed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}