package bl0.demo;

import android.view.Window;
import bl0.jp.kyocera.kcfp.util.KCfpSoftkeyGuide;

public class SetSoftkeys {

    public static void invoke(Window window) {
        KCfpSoftkeyGuide softkeyGuide = KCfpSoftkeyGuide.getProxyInstance(window);

        softkeyGuide.setText(KCfpSoftkeyGuide.INDEX_SK1, "LEFT");
        softkeyGuide.setText(KCfpSoftkeyGuide.INDEX_SK2, "RIGHT");
        softkeyGuide.setText(KCfpSoftkeyGuide.INDEX_CSK, "CENTER");
        softkeyGuide.invalidate();
    }
}
