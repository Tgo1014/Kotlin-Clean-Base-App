package base.app.ui.executor

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import base.domain.executor.PostExecutionThread

class UiThread : PostExecutionThread {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}