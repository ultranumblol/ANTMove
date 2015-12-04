package com.wgz.ant.antmove.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wgz.ant.antmove.R;
import com.wgz.ant.antmove.adapter.RecycleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by qwerr on 2015/11/25.
 */
public class Fragment2 extends Fragment {
    private TextView tuotou,untuotou;
    private RecyclerView tuotoulv,untuotoulv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,null);

        intiview(view);
        return  view;
    }

    private void intiview(View view) {
        tuotou = (TextView) view.findViewById(R.id.tuotou_tv);
        untuotou = (TextView) view.findViewById(R.id.untuotou_tv);
        tuotoulv = (RecyclerView) view.findViewById(R.id.tuotou_lv);
        untuotoulv = (RecyclerView) view.findViewById(R.id.untuotou_lv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        // 设置布局管理器
        tuotoulv.setLayoutManager(layoutManager);
        tuotoulv.setAdapter(new RecycleAdapter(data()));
        untuotoulv.setLayoutManager(layoutManager2);
        untuotoulv.setAdapter(new RecycleAdapter(data()));
        tuotou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tuotou.setBackgroundResource(R.drawable.bordergray_table_leftradius_ontrans_pressed);
                untuotou.setBackgroundResource(R.drawable.bordergray_table_rightradius_ontrans);
                tuotou.setTextColor(Color.WHITE);
                untuotou.setTextColor(android.graphics.Color.parseColor("#ff0000"));
                tuotoulv.setVisibility(View.VISIBLE);
                untuotoulv.setVisibility(View.GONE);
            }
        });
        untuotou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                untuotou.setBackgroundResource(R.drawable.bordergray_table_rightradius_ontrans_pressed);
                tuotou.setBackgroundResource(R.drawable.bordergray_table_leftradius_ontrans);
                untuotou.setTextColor(Color.WHITE);
                tuotou.setTextColor(android.graphics.Color.parseColor("#ff0000"));
                tuotoulv.setVisibility(View.GONE);
                untuotoulv.setVisibility(View.VISIBLE);
            }
        });

    }

    private List<Map<String, Object>> data(){
        List<Map<String,Object>> da1 = new ArrayList<Map<String, Object>>();
        for (int i = 0 ; i<20;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("ceshi","测试数据"+i);
            da1.add(map);



        }

        return da1;
    }
}
