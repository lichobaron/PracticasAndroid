package co.edu.javeriana.sesion16;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class HelloIntentService extends IntentService {
    public HelloIntentService() {
        super("HelloIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        // Trabajo que debe hacer el servicio
        // Por ahora solo esperar 5 segundos
        try {
            Thread.sleep(5000);
            Log.i("SERVICE", "Servicio en ejecución" );
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
    }
}
