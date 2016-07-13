package com.hiar.mytodo.db;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by qq923 on 2016-7-11.
 */

@Table(name = "subTaskListDb")
public class SubTaskListDb {
    @Column(name = "id", isId = true)
    public int id;

    @Column(name = "parentId")
    public long parentId;

    @Column(name = "subTaskName")//subTask本身也是task,可以存在taskdb表里
    public String subTaskName;

}
