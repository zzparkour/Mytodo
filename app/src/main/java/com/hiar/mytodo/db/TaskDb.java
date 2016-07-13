package com.hiar.mytodo.db;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.util.Date;

/**
 * Created by qq923 on 2016-7-11.
 */

@Table(name = "taskdb")
public class TaskDb {
    @Column(name = "id", isId = true)
    private int id;

    @Column(name = "taskName")
    public String taskName;

    @Column(name = "parentTaskId")
    public int parentTaskId;

    @Column(name = "taskDescription")
    public String taskDescription;

    @Column(name = "taskState")
    public int taskState;

    @Column(name = "taskProcess")
    public float taskProcess;

    @Column(name = "taskTime")
    public Date taskTime;

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskDescription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public int getTaskState() {
        return taskState;
    }
    public void setTaskState(int taskState) {
        this.taskState = taskState;
    }
    public float getTaskProcess() {
        return taskProcess;
    }
    public void setTaskProcess(float taskProcess) {
        this.taskProcess = taskProcess;
    }
    public Date getTaskTime() {
        return taskTime;
    }
    public void setTaskTime(Date taskTime) {
        this.taskTime = taskTime;
    }

    public int getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(int parentTaskId) {
        this.parentTaskId = parentTaskId;
    }
//需要一个subTaskList的表

    //需要一个doneList的表
    //需要一个timeList的表

}
