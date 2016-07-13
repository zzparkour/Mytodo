package com.hiar.mytodo.mode;

import java.util.List;

/**
 * Created by qq923 on 2016-7-11.
 */

public class Task {
    private int taskId;
    private String taskName;
    private String taskDescription;
    private int taskState;//任务状态
    private float taskProcess;//任务进度
    private float task_time;//任务累计时间

    private List<Task> subTaskList;
    private List<DoneList> doneList;//完成的列表
    private List<TimeList> timeList;//时间列表

    public Task(String taskName) {
        this.taskName = taskName;
    }

}

