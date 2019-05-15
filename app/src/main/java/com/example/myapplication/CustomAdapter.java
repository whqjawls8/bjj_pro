package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.models.MarkerItem;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private List<MarkerItem> listViewItemList = new ArrayList<MarkerItem>();

    // ListViewAdapter의 생성자
    public CustomAdapter(List<MarkerItem> sample) {
        listViewItemList = sample;
    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.map_list, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView titleTextView = (TextView) convertView.findViewById(R.id.map_title);
        TextView latTextView = (TextView) convertView.findViewById(R.id.map_lat);
        TextView lonTextView = (TextView) convertView.findViewById(R.id.map_lon);


        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        MarkerItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        titleTextView.setText(listViewItem.getTitle());
        latTextView.setText(Double.toString(listViewItem.getLat()));
        lonTextView.setText(Double.toString(listViewItem.getLon()));

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }


    public void addItem(String title, Double lat, Double lon) {
        MarkerItem item = new MarkerItem();

        item.setTitle(title);
        item.setLat(lat);
        item.setLon(lon);

        listViewItemList.add(item);
    }

}