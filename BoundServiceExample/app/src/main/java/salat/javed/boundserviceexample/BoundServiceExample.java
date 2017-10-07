package salat.javed.boundserviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

/**
 * Created by Javed.Salat on 01-Sep-17.
 */

public class BoundServiceExample extends Service {
    private static final String TAG = BoundServiceExample.class.getSimpleName();
    private LocalBinder localBinder = new LocalBinder();
    private final Random mGenerator = new Random();

    public class LocalBinder extends Binder {
        BoundServiceExample getService() {
            return BoundServiceExample.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }


    public int generateRandomNumber() {
        int random = mGenerator.nextInt(100);
        Log.e(TAG, "Random Number ::" + random);
        return random;
    }
}
