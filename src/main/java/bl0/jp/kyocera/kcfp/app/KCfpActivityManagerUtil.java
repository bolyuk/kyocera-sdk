package bl0.jp.kyocera.kcfp.app;

import bl0.sdk.kyocera701.annotations.Untested;
import bl0.sdk.kyocera701.utils.KyoceraProxy;

public interface KCfpActivityManagerUtil {
    @Untested
    void resetEndKeyBehavior(android.app.Activity activity);

    @Untested
    void setEndKeyBehavior(android.app.Activity activity, int keyCode);

    void setEndKeyBehavior(android.app.Activity activity, int keyCode, String msg);

    int ENDKEY_FINISH_TASK = 0x0;
    int ENDKEY_MOVE_TASK_TO_BACK = 0x1;
    int ENDKEY_REASON_FINISH_TASK = 0x3;
    int ENDKEY_REASON_FINISH_TASK_WITHOUT_CONFIRM = 0x1;
    int ENDKEY_REASON_MOVE_TASK_TO_BACK = 0x4;
    int ENDKEY_REASON_MOVE_TASK_TO_BACK_WITHOUT_CONFIRM = 0x2;
    int ENDKEY_REASON_NON = 0x0;
    int ENDKEY_SHOW_DIALOG_AND_FINISH = 0x2;
    int ENDKEY_SHOW_DIALOG_AND_MOVE_TO_BACK = 0x3;

    static KCfpActivityManagerUtil getProxyInstance() {
        return KyoceraProxy.bindByName(KCfpActivityManagerUtil.class, "jp.kyocera.kcfp.app.KCfpActivityManagerUtil");
    }
}
