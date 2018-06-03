package personal.system.com.dhwanitaskabhinav.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

import personal.system.com.dhwanitaskabhinav.R;
import personal.system.com.dhwanitaskabhinav.model.StateResponseModel;

public class StateAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<StateResponseModel.State> mList;
    public StateAdapter(Context context, List<StateResponseModel.State> list){
        this.context=context;
        this.mList=list;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyHolder holder=new MyHolder();
        View v=inflater.inflate(R.layout.item_state,null,false);
        holder.txt_state_name=(TextView)v.findViewById(R.id.txt_state_name);
        StateResponseModel.State model=mList.get(i);
        holder.txt_state_name.setText(model.getStateName());
        return v;
    }

    public class MyHolder {
        TextView txt_state_name;

    }
}
