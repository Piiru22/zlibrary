package xuqk.github.zlibrary.basekit.zlog;

import android.text.TextUtils;
import android.util.Log;


/**
 * ClassName: ZLog <br/>
 * PackageName: xuqk.github.zlibrary.basekit.zlog <br/>
 * Create On: 12/24/17 4:22 PM <br/>
 * Site:https://github.XuQK <br/>
 * @author 徐乾琨 <br/>
 */

public class ZLog {

    public static boolean LOG = true;
    private static String TAG_ROOT = "ZLibrary: ";

    public static void init(Boolean isLog, String logTag) {
        if (isLog != null) {
            LOG = isLog;
        }
        if (TextUtils.isEmpty(logTag)) {
            TAG_ROOT = logTag;
        }
    }

    public static void json(String json) {
        json(Log.DEBUG, null, json);
    }

    public static void json(int logLevel, String tag, String json) {
        if (LOG) {
            String formatJson = LogFormat.formatBorder(new String[]{LogFormat.formatJson(json)});
            XPrinter.println(logLevel, TextUtils.isEmpty(tag) ? TAG_ROOT : tag, formatJson);
        }
    }

    public static void xml(String xml) {
        xml(Log.DEBUG, null, xml);
    }


    public static void xml(int logLevel, String tag, String xml) {
        if (LOG) {
            String formatXml = LogFormat.formatBorder(new String[]{LogFormat.formatXml(xml)});
            XPrinter.println(logLevel, TextUtils.isEmpty(tag) ? TAG_ROOT : tag, formatXml);
        }
    }

    public static void error(Throwable throwable) {
        error(null, throwable);
    }

    public static void error(String tag, Throwable throwable) {
        if (LOG) {
            String formatError = LogFormat.formatBorder(new String[]{LogFormat.formatThrowable(throwable)});
            XPrinter.println(Log.ERROR, TextUtils.isEmpty(tag) ? TAG_ROOT : tag, formatError);
        }
    }

    private static void msg(int logLevel, String tag, String format, Object... args) {
        if (LOG) {
            String formatMsg = LogFormat.formatBorder(new String[]{LogFormat.formatArgs(format, args)});
            XPrinter.println(logLevel, TextUtils.isEmpty(tag) ? TAG_ROOT : tag, formatMsg);
        }
    }

    public static void d(String msg, Object... args) {
        msg(Log.DEBUG, null, msg, args);
    }

    public static void d(String tag, String msg, Object... args) {
        msg(Log.DEBUG, tag, msg, args);
    }

    public static void e(String msg, Object... args) {
        msg(Log.ERROR, null, msg, args);
    }

    public static void e(String tag, String msg, Object... args) {
        msg(Log.ERROR, tag, msg, args);
    }
}
