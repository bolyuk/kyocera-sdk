package bl0.jp.kyocera.kcfp.app;

import android.content.Context;
import bl0.sdk.kyocera701.permissions.RootNeeded;
import bl0.sdk.kyocera701.utils.KyoceraProxy;

public interface KCfpKeyNotifier {
    static KCfpKeyNotifier getProxyInstance(Context context) {
        return KyoceraProxy.bindWithConstructor(KCfpKeyNotifier.class,
                "jp.kyocera.kcfp.app.KCfpKeyNotifier",
                new Class[]{Context.class},
                new Object[]{context});
    }

    @RootNeeded
    void setOnKeyListener(OnKeyListener var1) throws SecurityException;

    interface OnKeyListener {
        void OnKeyDown();
    }
}
