package com.hiar.mytodo.db;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.util.Date;

/**
 * Created by qq923 on 2016-7-11.
 */

@Table(name = "doneListDb")
public class DoneListDb {

    @Column(name = "id", isId = true)
    public int id;

    @Column(name = "taskId")
    public long taskId;//所属的任务id,可重复

    @Column(name = "closeTime")
    public Date closeTime;//完成的时间

    @Column(name = "doneDescription")
    public String doneDescription;//简要描述

}
