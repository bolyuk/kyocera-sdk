package bl0.jp.kyocera.sublcd;

import android.app.Notification;
import android.content.Context;
import bl0.sdk.kyocera701.annotations.RootNeeded;
import bl0.sdk.kyocera701.annotations.UnclearBehavior;
import bl0.sdk.kyocera701.annotations.Untested;
import bl0.sdk.kyocera701.utils.KyoceraProxy;

import java.lang.reflect.Method;

public interface SubLcdManager {

    int CATEGORY_INFOSIGN = 1;
    int CATEGORY_INTERRUPT = 2;
    int CATEGORY_MAX = 4;
    int CATEGORY_NONE = 0;
    int CATEGORY_PREVIEW = 3;
    String EXTRA_CATEGORY = "sublcd.category";
    String EXTRA_DURATION = "sublcd.duration";
    String EXTRA_FLAGS = "sublcd.flags";
    String EXTRA_ICON = "sublcd.icon";
    String EXTRA_LAYOUT = "sublcd.layout";
    String EXTRA_PERSON = "sublcd.person";
    String EXTRA_PRIORITY = "sublcd.driority";
    String EXTRA_SUBLCD_EXTENSIONS = "sublcd.EXTENSIONS";
    String EXTRA_TEXT = "sublcd.text";
    String EXTRA_TEXT2 = "sublcd.text2";
    String EXTRA_TITLE = "sublcd.title";
    String EXTRA_VIEW = "sublcd.view";
    int FLAG_BLINK_TEXT = 2;
    int FLAG_BLINK_TITLE = 4;
    int FLAG_CANCEL_BY_SIDE_KEY = 1;
    int FLAG_PERSISTENT = 8;
    int INFOSIGN_FLAG_MASK = -65536;
    int INFOSIGN_SENDMAIL_FAILED = 65536;
    int INFOSIGN_SERVER_MAIL = 131072;
    int MASK_PRIORITY = 15;
    int PRIORITY_EMERGENCY = 3;
    int PRIORITY_HIGH = 1;
    int PRIORITY_MIN = 0;
    int PRIORITY_NORMAL = 0;
    int PRIORITY_PHONE = 4;
    int PRIORITY_PHONE2 = 2;

    @RootNeeded // probably
    @UnclearBehavior
    void notify(String var1, int var2, Notification var3);

    @RootNeeded // probably
    @UnclearBehavior
    void notify(int var1, Notification var2);

    void wakeUp();

    @Untested
    void cancel(int var1);

    @Untested
    void cancel(String var1, int var2);

    @Untested
    void cancelAll();

    static SubLcdManager getProxyInstance(Context context) {
        try {
            Method m = Class.forName("jp.kyocera.sublcd.SubLcdManager").getDeclaredMethod("getInstance", Context.class);
            return KyoceraProxy.bind(m.invoke(null, context), SubLcdManager.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
