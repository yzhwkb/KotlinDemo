package com.example.pc.kotlindemo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yzhw on 2018/5/28.
 */
public class XjAdapter extends BaseAdapter {

    private Context context;
    List<ByWorkBean> list;
    HashMap<String, Boolean> states = new HashMap<String, Boolean>();
    boolean haschecked = false;

    public XjAdapter(Context context, List<ByWorkBean> channelInfoList) {
        this.context = context;
        this.list = channelInfoList;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list == null ? null : list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
//            view = layoutInflater.inflate(R.layout.xj_item, null);
            view = View.inflate(context, R.layout.xj_item, null);
            holder = new ViewHolder();
            holder.tv_title = view.findViewById(R.id.text_title);
            holder.radioGroup = view.findViewById(R.id.radiogroup);
            holder.btn_normal = view.findViewById(R.id.btn_normal);
            holder.btn_exption = view.findViewById(R.id.btn_exption);
            view.setTag(holder);
//            holder.radioGroup.setTag(i);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_title.setText("" + i);


        holder.radioGroup.setOnCheckedChangeListener(null);

        switch (list.get(i).checked) {
            case 1:
                holder.radioGroup.check(R.id.btn_normal);
                break;
            case 2:
                holder.radioGroup.check(R.id.btn_exption);
                break;
            default:
                holder.radioGroup.clearCheck();
                break;
        }
        holder.radioGroup.setId(i);
        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ByWorkBean byWorkBean = list.get(group.getId());
                switch (checkedId) {
                    case R.id.btn_normal:
                        haschecked = true;
                        byWorkBean.checked = 1;
                        Log.e("radioGroup", i + "");
                        break;
                    case R.id.btn_exption:
                        haschecked = true;
                        byWorkBean.checked = 2;
                        Log.e("radioGroup", i + "");
                        break;
                }
            }
        });


        setAction(holder.btn_normal, i);
        setAction(holder.btn_exption, i);

        return view;
    }

    private void setAction(final View view, final int position) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemPlayClick != null) {
                    haschecked = true;
                    onItemPlayClick.onItemClick(position);
                }
            }
        });
    }

//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        ByWorkBean byWorkBean = list.get(group.getId());
//        switch (checkedId) {
//            case R.id.btn_normal:
//                byWorkBean.checked = 1;
//                break;
//            case R.id.btn_exption:
//                byWorkBean.checked = 2;
//                break;
//        }
//    }


    public interface OnPlayClickListener {
        // true add; false cancel
        void onItemClick(int position);

    }

    // add click callback
    OnPlayClickListener onItemPlayClick;

    public void setOnPlayClickListener(OnPlayClickListener onItemPlayClick) {
        this.onItemPlayClick = onItemPlayClick;
    }


    class ViewHolder {
        TextView tv_title;
        RadioGroup radioGroup;
        RadioButton btn_normal;
        RadioButton btn_exption;

    }

}
