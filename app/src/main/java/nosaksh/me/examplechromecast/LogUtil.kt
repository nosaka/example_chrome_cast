package nosaksh.me.examplechromecast

import android.util.Log

/**
 * LogUtil
 */
@Suppress("unused")
object LogUtil {

    private const val OUTPUT_FLAG = true

    /**
     * デフォルトログタグ
     */
    private val LOG_TAG_DEFAULT = LogUtil::class.java.name

    /**
     * 呼出元スタックトレース行番号
     */
    private const val CALLER_STACK_TRACE = 4

    /**
     * デバッグログ出力
     *
     * @param tag ログタグ
     * @param msg メッセージ
     */
    fun d(tag: String, msg: String) {
        if (OUTPUT_FLAG) {
            Log.d(tag, msg)
        }
    }

    /**
     * デバッグログ出力
     *
     * @param tag ログタグ
     * @param msg メッセージ
     * @param t   [Throwable]
     */
    fun d(tag: String, msg: String, t: Throwable) {
        if (OUTPUT_FLAG) {
            Log.d(tag, msg, t)
        }
    }

    /**
     * デバッグログ出力
     *
     * @param msg メッセージ
     */
    fun d(msg: String) {
        if (OUTPUT_FLAG) {
            Log.d(callerClass, msg)
        }
    }

    /**
     * デバッグログ出力
     *
     * @param msg メッセージ
     * @param t   [Throwable]
     */
    fun d(msg: String, t: Throwable) {
        if (OUTPUT_FLAG) {
            Log.d(callerClass, msg, t)
        }
    }

    /**
     * デバッグログ出力
     *
     * @param t [Throwable]
     */
    fun d(t: Throwable?) {
        if (OUTPUT_FLAG) {
            val tag = callerClass
            if (t != null) {
                Log.d(tag, t.message, t)
            } else {
                Log.d(callerClass, "null")
            }
        }
    }

    /**
     * インフォメーションログ出力
     *
     * @param tag ログタグ
     * @param msg メッセージ
     */
    fun i(tag: String, msg: String) {
        if (OUTPUT_FLAG) {
            Log.i(tag, msg)
        }
    }

    /**
     * インフォメーションログ出力
     *
     * @param tag ログタグ
     * @param msg メッセージ
     * @param t   [Throwable]
     */
    fun i(tag: String, msg: String, t: Throwable) {
        if (OUTPUT_FLAG) {
            Log.i(tag, msg, t)
        }
    }

    /**
     * インフォメーションログ出力
     *
     * @param msg メッセージ
     */
    fun i(msg: String) {
        if (OUTPUT_FLAG) {
            Log.i(callerClass, msg)
        }
    }

    /**
     * インフォメーションログ出力
     *
     * @param msg メッセージ
     * @param t   [Throwable]
     */
    fun i(msg: String, t: Throwable) {
        if (OUTPUT_FLAG) {
            Log.i(callerClass, msg, t)
        }
    }

    /**
     * インフォメーションログ出力
     *
     * @param t [Throwable]
     */
    fun i(t: Throwable?) {
        if (OUTPUT_FLAG) {
            if (t != null) {
                Log.i(callerClass, t.message, t)
            } else {
                Log.i(callerClass, "null")
            }
        }
    }

    /**
     * VERBOSEログ出力
     *
     * @param tag ログタグ
     * @param msg メッセージ
     */
    fun v(tag: String, msg: String) {
        if (OUTPUT_FLAG) {
            Log.v(tag, msg)
        }
    }

    /**
     * VERBOSEログ出力
     *
     * @param tag ログタグ
     * @param msg メッセージ
     * @param t   [Throwable]
     */
    fun v(tag: String, msg: String, t: Throwable) {
        if (OUTPUT_FLAG) {
            Log.v(tag, msg, t)
        }
    }

    /**
     * VERBOSEログ出力
     *
     * @param msg メッセージ
     */
    fun v(msg: String) {
        if (OUTPUT_FLAG) {
            Log.v(callerClass, msg)
        }
    }

    /**
     * VERBOSEログ出力
     *
     * @param msg メッセージ
     * @param t   [Throwable]
     */
    fun v(msg: String, t: Throwable) {
        if (OUTPUT_FLAG) {
            Log.v(callerClass, msg, t)
        }
    }

    /**
     * VERBOSEログ出力
     *
     * @param t [Throwable]
     */
    fun v(t: Throwable?) {
        if (OUTPUT_FLAG) {
            if (t != null) {
                Log.v(callerClass, t.message, t)
            } else {
                Log.v(callerClass, "null")
            }

        }
    }

    /**
     * WARNログ出力
     *
     * @param tag ログタグ
     * @param msg メッセージ
     */
    fun w(tag: String, msg: String) {
        if (OUTPUT_FLAG) {
            Log.w(tag, msg)
        }
    }

    /**
     * WARNログ出力
     *
     * @param tag ログタグ
     * @param msg メッセージ
     * @param t   [Throwable]
     */
    fun w(tag: String, msg: String, t: Throwable) {
        if (OUTPUT_FLAG) {
            Log.w(tag, msg, t)
        }
    }

    /**
     * WARNログ出力
     *
     * @param msg メッセージ
     */
    fun w(msg: String) {
        if (OUTPUT_FLAG) {
            Log.w(callerClass, msg)
        }
    }

    /**
     * WARNログ出力
     *
     * @param msg メッセージ
     * @param t   [Throwable]
     */
    fun w(msg: String, t: Throwable) {
        if (OUTPUT_FLAG) {
            Log.w(callerClass, msg, t)
        }
    }

    /**
     * WARNログ出力
     *
     * @param t [Throwable]
     */
    fun w(t: Throwable?) {
        if (OUTPUT_FLAG) {
            if (t != null) {
                Log.w(callerClass, t.message, t)
            } else {
                Log.w(callerClass, "null")
            }
        }
    }

    /**
     * エラーログ出力
     *
     * @param tag ログタグ
     * @param msg メッセージ
     */
    fun e(tag: String, msg: String) {
        if (OUTPUT_FLAG) {
            Log.e(tag, msg)
        }

    }

    /**
     * エラーログ出力
     *
     * @param tag ログタグ
     * @param msg メッセージ
     * @param t   [Throwable]
     */
    fun e(tag: String, msg: String, t: Throwable) {
        if (OUTPUT_FLAG) {
            Log.e(tag, msg, t)
        }
    }

    /**
     * エラーログ出力
     *
     * @param msg メッセージ
     */
    fun e(msg: String) {
        if (OUTPUT_FLAG) {
            Log.e(callerClass, msg)
        }
    }

    /**
     * エラーログ出力
     *
     * @param msg メッセージ
     * @param t   [Throwable]
     */
    fun e(msg: String, t: Throwable?) {
        if (OUTPUT_FLAG) {
            Log.e(callerClass, msg, t)
        }
    }

    /**
     * エラーログ出力
     *
     * @param t [Throwable]
     */
    fun e(t: Throwable?) {
        if (OUTPUT_FLAG) {
            if (t != null) {
                Log.e(callerClass, t.message, t)
            } else {
                Log.e(callerClass, "null")
            }
        }
    }

    /**
     * 呼出元クラス名取得処理
     *
     *
     * Threadのスタックとレースから呼出元クラス名を取得する
     *
     *
     * @return 呼出元クラス名
     */
    private val callerClass: String
        get() {

            val stackTraceElements = Thread.currentThread().stackTrace
            return if (stackTraceElements != null && stackTraceElements.size >= CALLER_STACK_TRACE) {
                Thread.currentThread().stackTrace[CALLER_STACK_TRACE].className
            } else {
                LOG_TAG_DEFAULT
            }

        }

}
