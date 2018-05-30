package com.example.pc.kotlindemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzhw on 2018/5/28.
 */
public class TestActivity extends Activity {
    public static final String TAG = "TestActivity";

    List<ByWorkBean> allList = new ArrayList<>();
    List<ByWorkBean> checkedList = new ArrayList<>();
    List<ByWorkBean> unCheckedList = new ArrayList<>();
    XjAdapter adapter;
    private ListView lv;
    private XjAdapter.OnPlayClickListener onItemActionClick;
    boolean hasChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        onItemActionClick = new XjAdapter.OnPlayClickListener() {
            @Override
            public void onItemClick(int position) {
                ByWorkBean byWorkBean = allList.get(position);
                checkedList.add(byWorkBean);

                Log.e(TAG, "onItemClick :" + checkedList.size());
            }
        };
        adapter.setOnPlayClickListener(onItemActionClick);

    }

    private void initView() {
        ShSwitchView switchUnchecked = findViewById(R.id.switch_zxswjx);
        switchUnchecked.setOn(false);
        lv = findViewById(R.id.lv);
        for (int i = 0; i < 101; i++) {
            ByWorkBean bean = new ByWorkBean();
            allList.add(bean);
        }

        switchUnchecked.setOnSwitchStateChangeListener(new ShSwitchView.OnSwitchStateChangeListener() {
            @Override
            public void onSwitchStateChange(boolean isOn) {
                if (isOn) {
//                    checkedList.clear();
//                    checkedList.addAll(checkedList);
                    Log.e(TAG, "switchUnchecked :" + checkedList.size());
                    adapter = new XjAdapter(TestActivity.this, checkedList);
                    adapter.notifyDataSetChanged();
                    lv.setAdapter(adapter);

//                    onDataChange(checkedList);

                } else {
                    adapter = new XjAdapter(TestActivity.this, allList);
                    lv.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });


        adapter = new XjAdapter(this, allList);
        lv.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }

    void onDataChange(List<ByWorkBean> listAfterChange) {
        checkedList.clear();
        checkedList.addAll(listAfterChange);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}
