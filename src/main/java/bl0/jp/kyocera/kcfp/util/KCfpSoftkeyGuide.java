package bl0.jp.kyocera.kcfp.util;

import android.graphics.Bitmap;
import android.view.Window;
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

    Object getCarrierSoftkeyGuide();

    void setCarrierSoftkeyGuide(Object value);

    boolean getEnabled(int index);

    CharSequence getText(int index);

    void hide();

    void invalidate();

    void pendingApply(boolean value);

    void setDrawable(int index, int resKey);

    void setDrawable(int index, Bitmap value);

    void setEnabled(int index, boolean value);

    void setPriority(int index, int value);

    void setResource(int resKey);

    void setText(int index, int resKey);

    void setText(int index, CharSequence value);

    void setTextDrawable(int index, int textResKey, int drawableResKey);

    void setTextDrawable(int index, int textResKey, Bitmap value);

    void setTextDrawable(int index, CharSequence value, int drawableResKey);

    void setTextDrawable(int index, CharSequence text, Bitmap drawable);

    void show();

    void translucent(boolean value);

    static KCfpSoftkeyGuide getProxyInstance(Window window) {
        return KyoceraProxy.bindWithConstructor(KCfpSoftkeyGuide.class,
                "jp.kyocera.kcfp.util.KCfpSoftkeyGuide",
                new Class[]{Window.class},
                new Object[]{window}
        );
    }
}
