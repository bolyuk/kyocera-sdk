package bl0.jp.kyocera.kcfp.util;

import android.graphics.Bitmap;
import android.view.Window;
import bl0.sdk.kyocera701.annotations.UnclearBehavior;
import bl0.sdk.kyocera701.annotations.Untested;
import bl0.sdk.kyocera701.utils.KyoceraProxy;

public interface KCfpSoftkeyGuide {
    int INDEX_CSK = 0;
    int INDEX_SK1 = 1;
    int INDEX_SK2 = 2;
    int INDEX_SK3 = 3;
    int INDEX_SK4 = 4;
    String SK_AUTO = "@SK_AUTO";
    String SK_AUTO_ENTER = "@SK_AUTO_ENTER";
    String SK_AUTO_MENU = "@SK_AUTO_MENU";
    String SK_AUTO_SELECT = "@SK_AUTO_SELECT";
    int SK_PRIORITY_DEFAULT = 0;
    int SK_PRIORITY_DIALOG = 3;
    int SK_PRIORITY_FW = 1;
    int SK_PRIORITY_LIST = 2;
    int SK_PRIORITY_TEXT = 4;
    String TAG = "KCfpSoftkeyGuide";

    @Untested
    Object getCarrierSoftkeyGuide();

    @Untested
    void setCarrierSoftkeyGuide(Object value);

    @Untested
    boolean getEnabled(int index);

    @Untested
    CharSequence getText(int index);

    @Untested
    void hide();

    void invalidate();

    @UnclearBehavior
    void pendingApply(boolean value);

    @Untested
    void setDrawable(int index, int resKey);

    @Untested
    void setDrawable(int index, Bitmap value);

    @Untested
    void setEnabled(int index, boolean value);

    @Untested
    void setPriority(int index, int value);

    @Untested
    void setResource(int resKey);

    @Untested
    void setText(int index, int resKey);

    void setText(int index, CharSequence value);

    @Untested
    void setTextDrawable(int index, int textResKey, int drawableResKey);

    @Untested
    void setTextDrawable(int index, int textResKey, Bitmap value);

    @Untested
    void setTextDrawable(int index, CharSequence value, int drawableResKey);

    @Untested
    void setTextDrawable(int index, CharSequence text, Bitmap drawable);

    @Untested
    void show();

    @UnclearBehavior
    void translucent(boolean value);

    static KCfpSoftkeyGuide getProxyInstance(Window window) {
        return KyoceraProxy.bindWithConstructor(KCfpSoftkeyGuide.class,
                "jp.kyocera.kcfp.util.KCfpSoftkeyGuide",
                new Class[]{Window.class},
                new Object[]{window}
        );
    }
}
