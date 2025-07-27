package bl0.jp.kyocera.kcfp.util;

import android.app.Dialog;
import bl0.sdk.kyocera701.utils.KyoceraProxy;

public interface KCfpDialogUtil {
    void assignButtonToSoftkey(Dialog dialog, boolean value);

    int getTextScrollMode(Dialog dialog);

    void setTextScrollMode(Dialog dialog, int var2);

    static KCfpDialogUtil getProxyInstance() {
        return KyoceraProxy.bindByName(KCfpDialogUtil.class, "jp.kyocera.kcfp.util.KCfpDialogUtil");
    }
}
