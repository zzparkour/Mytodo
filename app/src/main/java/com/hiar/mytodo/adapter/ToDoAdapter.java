package com.hiar.mytodo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hiar.mytodo.R;
import com.hiar.mytodo.db.TaskDb;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qq923 on 2016-7-11.
 * 主要任务的适配器
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    private List<TaskDb> taskDbs;

    public ToDoAdapter(List<TaskDb> taskDbs) {
        this.taskDbs = taskDbs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_adapter_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(root);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(taskDbs.get(position).getTaskName());
        holder.textView.setTag(1, taskDbs.get(position).getId());
    }
    @Override
    public int getItemCount() {
        return taskDbs.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.taskName)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
