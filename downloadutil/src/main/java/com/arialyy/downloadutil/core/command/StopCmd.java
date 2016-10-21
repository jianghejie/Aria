package com.arialyy.downloadutil.core.command;

import android.content.Context;
import android.util.Log;
import com.arialyy.downloadutil.core.DownloadEntity;
import com.arialyy.downloadutil.core.Task;

/**
 * Created by lyy on 2016/9/20.
 * 停止命令
 */
class StopCmd extends IDownloadCmd {

  /**
   * @param context context
   * @param entity 下载实体
   */
  StopCmd(Context context, DownloadEntity entity) {
    super(context, entity);
  }

  @Override public void executeComment() {
    Task task = target.getTask(mEntity);
    if (task == null) {
      if (mEntity.getState() == DownloadEntity.STATE_DOWNLOAD_ING) {
        task = target.createTask(mEntity);
        target.stopTask(task);
      } else {
        Log.w(TAG, "停止命令执行失败，【调度器中没有该任务】");
      }
    } else {
      target.stopTask(task);
    }
  }
}