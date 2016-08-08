package com.hiar.mytodo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hiar.mytodo.R;
import com.hiar.mytodo.db.TaskDb;

import java.util.List;

/**
 * Created by rubing on 2016/8/8.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.VH>{
    private Context context;
    private List<TaskDb> taskDbs;

    public TaskAdapter(Context context, List<TaskDb> taskDbs) {
        this.context = context;
        this.taskDbs = taskDbs;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(View.inflate(context, R.layout.todo_adapter_item, null));
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.taskName.setText(taskDbs.get(position).getTaskName());
    }

    @Override
    public int getItemCount() {
        return taskDbs.size();
    }

    public static class VH extends RecyclerView.ViewHolder{
        TextView taskName;
        public VH(View itemView) {
            super(itemView);

            taskName = (TextView) itemView.findViewById(R.id.taskName);

        }
    }
}
