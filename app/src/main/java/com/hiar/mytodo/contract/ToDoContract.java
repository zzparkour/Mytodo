package com.hiar.mytodo.contract;

import com.hiar.mytodo.BasePresenter;
import com.hiar.mytodo.BaseView;

/**
 * Created by qq923 on 2016-7-8.
 */

public interface ToDoContract {
    interface View extends BaseView<Presenter>{

    }
    interface Presenter extends BasePresenter{

    }
}
