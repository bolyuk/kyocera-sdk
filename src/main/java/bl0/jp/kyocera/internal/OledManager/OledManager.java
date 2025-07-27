package bl0.jp.kyocera.internal.OledManager;

import bl0.sdk.kyocera701.utils.KyoceraProxy;

public interface OledManager {
    void setBrightness(int var1, int var2);

    static OledManager getProxyInstance() {
        return KyoceraProxy.bindByName(OledManager.class, "jp.kyocera.internal.OledManager.OledManager");
    }
}
