package nosaksh.me.examplechromecast

import android.app.Application
import com.google.android.gms.cast.CastMediaControlIntent


/**
 *
 */
class AppApplication : Application() {

    private lateinit var applicationId: String

    override fun onCreate() {
        super.onCreate()
        // Receiverはデフォルトアプリを利用する
        applicationId = CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID


    }

}