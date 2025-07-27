package bl0.demo;

import android.app.Notification;
import android.content.Context;
import android.util.Log;
import bl0.jp.kyocera.sublcd.SubLcdManager;

public class SubLcdWakeUp {
    public static void invoke(Context context) {
        SubLcdManager m = SubLcdManager.getProxyInstance(context);
        m.wakeUp();
        Notification.Builder builder = new Notification.Builder(context)
                .setContentTitle("Kyocera SDK")
                .setContentText("This is a SubLCD test.")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setPriority(SubLcdManager.PRIORITY_NORMAL);

        Notification notification = builder.build();
        notification.extras.putInt("sublcd.category", SubLcdManager.CATEGORY_INFOSIGN);
        notification.extras.putInt("sublcd.priority", SubLcdManager.PRIORITY_NORMAL);
        notification.extras.putString("sublcd.title", "Test Title");
        notification.extras.putString("sublcd.text", "Hello SubLCD");
        Log.i("SubLcdWakeUp", "before");
        m.notify("demo_tag", SubLcdManager.CATEGORY_INFOSIGN, notification);
        Log.i("SubLcdWakeUp", "after");
    }
}
