package nosaksh.me.examplechromecast

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.MediaRouteButton
import com.google.android.gms.cast.MediaInfo
import com.google.android.gms.cast.MediaLoadOptions
import com.google.android.gms.cast.MediaQueueItem
import com.google.android.gms.cast.MediaStatus
import com.google.android.gms.cast.framework.CastButtonFactory
import com.google.android.gms.cast.framework.CastContext
import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.cast.framework.CastState
import com.google.android.gms.cast.framework.CastStateListener
import nosaksh.me.examplechromecast.listener.SimpleSessionManagerListener
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {


    companion object {
        private val DURATION = TimeUnit.SECONDS.toMillis(20)
    }

    private lateinit var castContext: CastContext

    private val sessionManagerListener =
            SimpleSessionManagerListener<CastSession>()

    private val handler: Handler = Handler()

    private val images = mutableListOf(
            "https://img.gifmagazine.net/gifmagazine/images/2894295/original.gif",
            "https://img.gifmagazine.net/gifmagazine/images/2894294/original.gif",
            "https://img.gifmagazine.net/gifmagazine/images/2894293/original.gif",
            "https://img.gifmagazine.net/gifmagazine/images/2894292/original.gif",
            "https://img.gifmagazine.net/gifmagazine/images/2894291/original.gif",
            "https://img.gifmagazine.net/gifmagazine/images/2894290/original.gif",
            "https://img.gifmagazine.net/gifmagazine/images/2894289/original.gif",
            "https://img.gifmagazine.net/gifmagazine/images/2894288/original.gif",
            "https://img.gifmagazine.net/gifmagazine/images/2894287/original.gif",
            "https://img.gifmagazine.net/gifmagazine/images/2894286/original.gif",
            "https://img.gifmagazine.net/gifmagazine/images/2894285/original.gif",
            "https://img.gifmagazine.net/gifmagazine/images/2894284/original.gif",
            "https://img.gifmagazine.net/gifmagazine/images/2894283/original.gif"
    )


    private val videos = mutableListOf(
            "https://img.gifmagazine.net/gifmagazine/images/2894295/original.mp4",
            "https://img.gifmagazine.net/gifmagazine/images/2894294/original.mp4",
            "https://img.gifmagazine.net/gifmagazine/images/2894293/original.mp4",
            "https://img.gifmagazine.net/gifmagazine/images/2894292/original.mp4",
            "https://img.gifmagazine.net/gifmagazine/images/2894291/original.mp4",
            "https://img.gifmagazine.net/gifmagazine/images/2894290/original.mp4",
            "https://img.mp4magazine.net/gifmagazine/images/2894289/original.mp4",
            "https://img.gifmagazine.net/gifmagazine/images/2894288/original.mp4",
            "https://img.gifmagazine.net/gifmagazine/images/2894287/original.mp4",
            "https://img.gifmagazine.net/gifmagazine/images/2894286/original.mp4",
            "https://img.gifmagazine.net/gifmagazine/images/2894285/original.mp4",
            "https://img.gifmagazine.net/gifmagazine/images/2894284/original.mp4",
            "https://img.gifmagazine.net/gifmagazine/images/2894283/original.mp4"
    )

    private var runnable: Runnable = object : Runnable {
        override fun run() {
            // load(images.shuffled().take(1).first())
            handler.postDelayed(this, DURATION)
        }
    }

    private val castStateListener = CastStateListener {
        LogUtil.d("onCastStateChanged state:=${CastState.toString(it)}")
        when (it) {
            CastState.CONNECTED -> {
                queueLoadVideos()
            }
            else -> Unit
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        castContext = CastContext.getSharedInstance(this)
        setContentView(R.layout.activity_main)

        val mediaRouteButton = findViewById<MediaRouteButton>(R.id.media_route_button)
        CastButtonFactory.setUpMediaRouteButton(applicationContext, mediaRouteButton)

    }

    override fun onResume() {
        castContext.addCastStateListener(castStateListener)
        castContext.sessionManager.addSessionManagerListener(sessionManagerListener, CastSession::class.java)
        super.onResume()
        handler.post(runnable)
    }

    override fun onPause() {
        handler.removeCallbacks(runnable)
        super.onPause()
        castContext.sessionManager.removeSessionManagerListener(sessionManagerListener, CastSession::class.java)
        castContext.removeCastStateListener(castStateListener)
    }

    private fun load(url: String) {
        val castSession = castContext.sessionManager.currentCastSession ?: return
        val mediaInfo = MediaInfo.Builder(url)
                .setStreamType(MediaInfo.STREAM_TYPE_BUFFERED)
                .setContentType("image/gif")
                .build()


        val result = castSession.remoteMediaClient?.load(mediaInfo, MediaLoadOptions.Builder().setAutoplay(true).build())
        result?.setResultCallback {
            LogUtil.d("@@@", "${it.status}")
        }
        result?.addStatusListener {
            LogUtil.d("@@@", "$it")
        }
    }

    private fun queueLoadVideos() {
        val castSession = castContext.sessionManager.currentCastSession ?: return
        val queueItems = videos.asSequence().map {
            MediaInfo.Builder(it)
                    .setStreamType(MediaInfo.STREAM_TYPE_BUFFERED)
                    .setContentType("video/mp4")
                    .build()
        }.map {
            MediaQueueItem.Builder(it)
                    .setAutoplay(true)
                    .build()
        }.toList().toTypedArray()

//        val result = castSession.remoteMediaClient?.queueLoad(queueItems, 0, MediaStatus.REPEAT_MODE_REPEAT_ALL, null)
        castSession.remoteMediaClient?.requestStatus()
        val result = castSession.remoteMediaClient?.load(MediaInfo.Builder("https://img.gifmagazine.net/gifmagazine/images/2894287/original.gif")
                .setStreamType(MediaInfo.STREAM_TYPE_NONE)
                .build(), MediaLoadOptions.Builder().build())
        result?.setResultCallback {
            LogUtil.d("@@@", "${it.status}")
        }
        result?.addStatusListener {
            LogUtil.d("@@@", "$it")
        }
    }

    private fun queueLoadImages() {
        val castSession = castContext.sessionManager.currentCastSession ?: return
        val queueItems = images.asSequence().map {
            MediaInfo.Builder(it)
                    .setStreamType(MediaInfo.STREAM_TYPE_BUFFERED)
                    .setContentType("image/gif")
                    .build()
        }.map {
            MediaQueueItem.Builder(it)
                    .setPlaybackDuration(TimeUnit.SECONDS.toMillis(5).toDouble())
                    .setAutoplay(true)
                    .build()
        }.toList().toTypedArray()


        val result = castSession.remoteMediaClient?.queueLoad(queueItems, 0, MediaStatus.REPEAT_MODE_REPEAT_ALL, null)
        result?.setResultCallback {
            LogUtil.d("@@@", "${it.status}")
        }
        result?.addStatusListener {
            LogUtil.d("@@@", "$it")
        }
    }


}
