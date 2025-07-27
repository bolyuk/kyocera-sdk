package bl0.jp.kyocera.internal.kyoceralights;

import bl0.sdk.kyocera701.annotations.Untested;
import bl0.sdk.kyocera701.utils.KyoceraProxy;

public interface KyoceraLights {

    int KC_BACKLIGHT_KEYILLUMI_PATT_0 = -1033476506;
    int KC_BACKLIGHT_KEYILLUMI_PATT_1 = -1031700095;
    int KC_BACKLIGHT_KEYILLUMI_PATT_2 = -1031634302;
    int KC_BACKLIGHT_KEYILLUMI_PATT_3 = -1031568509;
    int KC_BACKLIGHT_KEYILLUMI_PATT_4 = -1031502716;
    int KC_BACKLIGHT_KEYILLUMI_PATT_5 = -1031436923;
    int KC_BRIGHTNESS_MODE_SENSOR = 1;
    int KC_BRIGHTNESS_MODE_USER = 0;
    int KC_COMB_ILLUMI_PATT_1 = -2105441919;
    int KC_INCOM_KEYILLUMI_PATT_1 = -1014922879;
    int KC_LIGHT_FLASH_HARDWARE = 2;
    int KC_LIGHT_FLASH_NONE = 0;
    int KC_LIGHT_FLASH_TIMED = 1;
    int KC_LIGHT_ID_ATTENTION = 5;
    int KC_LIGHT_ID_BACKLIGHT = 0;
    int KC_LIGHT_ID_BATTERY = 3;
    int KC_LIGHT_ID_BLUETOOTH = 6;
    int KC_LIGHT_ID_BUTTONS = 2;
    int KC_LIGHT_ID_COUNT = 16;
    int KC_LIGHT_ID_KEYBOARD = 1;
    int KC_LIGHT_ID_MOBILELIGHT = 13;
    int KC_LIGHT_ID_NOTIFICATIONS = 4;
    int KC_LIGHT_ID_NOTIFICATIONS_EX = 12;
    int KC_LIGHT_ID_SHARELINK = 15;
    int KC_LIGHT_ID_WIFI = 7;
    int KC_MAILRECEIV_KEYILLUMI_PATT_1 = -964591231;
    int KC_MISSEDCALL_KEYILLUMI_PATT_1 = -998145663;
    int KC_NEWMAIL_KEYILLUMI_PATT_1 = -981368447;
    int KC_WAKEUP_KEYILLUMI_PATT_1 = -1048477311;

    @Untested
    void pulse(int var1, int var2, int var3);

    @Untested
    void setBrightness(int var1, int var2, int var3);

    @Untested
    void setColor(int var1, int var2);

    @Untested
    void setFlashing(int var1, int var2, int var3, int var4, int var5);

    @Untested
    void turnOff(int var1);

    static KyoceraLights getProxyInstance() {
        return KyoceraProxy.bindByName(KyoceraLights.class, "jp.kyocera.internal.kyoceralights.KyoceraLights");
    }
}
