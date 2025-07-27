package bl0.demo;

import android.app.Activity;
import bl0.jp.kyocera.kcfp.app.KCfpActivityManagerUtil;

public class EndDialogConfirm {
    public static void invoke(Activity activity) {
        KCfpActivityManagerUtil activityUtil = KCfpActivityManagerUtil.getProxyInstance();
        activityUtil.setEndKeyBehavior(activity, KCfpActivityManagerUtil.ENDKEY_SHOW_DIALOG_AND_FINISH, "sure?");
    }
}
