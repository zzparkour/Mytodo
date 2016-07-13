package com.hiar.mytodo.db;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.util.Date;

/**
 * Created by qq923 on 2016-7-11.
 */

@Table(name = "timeListDb")
public class TimeListDb {

    @Column(name = "id")
    public long id;

    @Column(name = "taskId")//所属任务的id
    public long taskId;

    @Column(name = "startTime")//开始时间
    public Date startTime;

    @Column(name = "closeTime")//关闭时间
    public Date closeTime;


}
