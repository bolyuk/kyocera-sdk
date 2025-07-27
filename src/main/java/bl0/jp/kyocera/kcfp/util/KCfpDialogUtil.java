package bl0.jp.kyocera.kcfp.util;

import android.app.Dialog;
import bl0.sdk.kyocera701.annotations.Untested;
import bl0.sdk.kyocera701.utils.KyoceraProxy;

public interface KCfpDialogUtil {
    @Untested
    void assignButtonToSoftkey(Dialog dialog, boolean value);

    @Untested
    int getTextScrollMode(Dialog dialog);

    @Untested
    void setTextScrollMode(Dialog dialog, int var2);

    static KCfpDialogUtil getProxyInstance() {
        return KyoceraProxy.bindByName(KCfpDialogUtil.class, "jp.kyocera.kcfp.util.KCfpDialogUtil");
    }
}
