package nosaksh.me.examplechromecast.listener

import com.google.android.gms.cast.framework.Session
import com.google.android.gms.cast.framework.SessionManagerListener
import nosaksh.me.examplechromecast.LogUtil

/**
 * Simple [SessionManagerListener]
 */
open class SimpleSessionManagerListener<T : Session> : SessionManagerListener<T> {

    override fun onSessionStarting(session: T?) {
        LogUtil.d("onSessionStarting")
    }

    override fun onSessionStarted(session: T?, sessionId: String?) {
        LogUtil.d("onSessionStarted")
    }

    override fun onSessionStartFailed(session: T?, sessionId: Int) {
        LogUtil.d("onSessionSuspended")
    }

    override fun onSessionEnding(session: T?) {
        LogUtil.d("onSessionEnding")
    }

    override fun onSessionEnded(session: T?, sessionId: Int) {
        LogUtil.d("onSessionEnded")
    }

    override fun onSessionResuming(session: T?, sessionId: String?) {
        LogUtil.d("onSessionResuming")
    }

    override fun onSessionResumed(session: T?, sessionId: Boolean) {
        LogUtil.d("onSessionResumed")
    }

    override fun onSessionResumeFailed(session: T?, sessionId: Int) {
        LogUtil.d("onSessionResumeFailed")
    }

    override fun onSessionSuspended(session: T?, sessionId: Int) {
        LogUtil.d("onSessionSuspended")
    }

}