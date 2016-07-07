package com.chat.kenneth.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kenneth on 6/18/2016.
 */
public class CustomListViewAdapter  extends BaseAdapter {

    private Context mContext;
    private ArrayList<HashMap<String, String>> books;
    private static LayoutInflater inflater = null; // to get xml files


    public CustomListViewAdapter(Context context, ArrayList<HashMap<String, String>> data)
    {
        mContext = context;
        books = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount()
    {
        return books.size();
    }

    @Override
    public Object getItem(int i)
    {
        return i;
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup)
    {
        View view = convertView;

        if (convertView == null)
        {
            view = inflater.inflate(R.layout.list_row, null); // inflate listview ... listview contains the list row

            TextView title = (TextView) view.findViewById(R.id.title); // view holds out listrow xml
            TextView author = (TextView) view.findViewById(R.id.author);
            TextView pages = (TextView) view.findViewById(R.id.pages);
            ImageView img = (ImageView) view.findViewById(R.id.img);

            HashMap<String, String> mBook = new HashMap<>();

            mBook = books.get(i);

            title.setText(mBook.get("title")); // for each book set a title, setting a "title" key
            author.setText(mBook.get("author"));
            pages.setText(mBook.get("pages"));
            img.setImageDrawable(mContext.getResources().getDrawable(R.drawable.book_icon));

        }
        return view;
    }
}
