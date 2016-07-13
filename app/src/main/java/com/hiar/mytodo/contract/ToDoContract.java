package com.hiar.mytodo.contract;

import com.hiar.mytodo.BasePresenter;
import com.hiar.mytodo.BaseView;
import com.hiar.mytodo.db.TaskDb;

import org.xutils.DbManager;

import java.util.List;

/**
 * Created by qq923 on 2016-7-8.
 */

public interface ToDoContract {
    interface View extends BaseView<Presenter>{
        void createAdapter(List all);
    }
    interface Presenter extends BasePresenter{
        void createNewTask(TaskDb task, DbManager dbManager);

        void findAll(DbManager dbManager);

        void createSubTask(DbManager dbManager, int parentTaskId);
    }
}
