package bl0.jp.kyocera.kcfp.util;

import bl0.sdk.kyocera701.annotations.Untested;
import bl0.sdk.kyocera701.utils.KyoceraProxy;

public interface KCfpSharedResources {
    @Untested
    int getIdentifier(String name, String type);

    static KCfpSharedResources getProxyInstance() {
        return KyoceraProxy.bindByName(KCfpSharedResources.class, "jp.kyocera.kcfp.util.KCfpSharedResources");
    }
}
