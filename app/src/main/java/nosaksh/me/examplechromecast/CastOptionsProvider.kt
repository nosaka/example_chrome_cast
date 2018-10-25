package nosaksh.me.examplechromecast

import android.content.Context
import com.google.android.gms.cast.framework.CastOptions
import com.google.android.gms.cast.framework.OptionsProvider
import com.google.android.gms.cast.framework.SessionProvider

/**
 *
 */
class CastOptionsProvider : OptionsProvider {
    override fun getCastOptions(context: Context?): CastOptions {
        return CastOptions.Builder()
                .setReceiverApplicationId("256F7881")
                .build()
    }

    override fun getAdditionalSessionProviders(p0: Context?): MutableList<SessionProvider>? {
        return null
    }

}