package com.chat.kenneth.customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListViewAdapter customListViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] bookTitle = new String[]{
                "Gone with the Wind",
                "Memoirs of a Geisha ",
                "The Pillars of the Earth",
                "A Tale of Two Cities ",
                "The Book Thief",
                "The Thorn Birds",
                "The Historian",
                "The Name of the Rose"
        };

        final String[] bookPages = new String[]{
                "1037 pages",
                "434 pages",
                "973 pages",
                "489 pages",
                "552 pages",
                "692 pages",
                "704 pages",
                "536 pages"
        };

        final String[] bookAuthors = new String[]{
                "Margaret Mitchell",
                "Arthur Golden",
                "Ken Follett",
                "Charles Dickens et. al",
                "Markus Zusak",
                "Colleen McCullough",
                "Elizabeth Kostova",
                "Umberto Eco, William Weaver"
        };

        ArrayList<HashMap<String, String>> authorList = new ArrayList<>();

        for (int i = 0 ; i< bookAuthors.length; i++)
        {
            HashMap<String, String> data = new HashMap<>();
            data.put("title", bookTitle[i]);
            data.put("pages", bookPages[i]);
            data.put("author", bookAuthors[i]);

            authorList.add(data);
        }

        listView = (ListView) findViewById(R.id.list);

        //setup the lv adapter

        customListViewAdapter = new CustomListViewAdapter(getApplicationContext(), authorList);//contains the hashmaps that will be put on the list view
        listView.setAdapter(customListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int myPosition = i;

                String itemClickedID = listView.getItemAtPosition(myPosition).toString();
                Toast.makeText(getApplicationContext(), "Id clicked: " + itemClickedID, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
