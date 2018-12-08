package com.ayvytr.ktx.context

import android.accounts.AccountManager
import android.app.*
import android.app.job.JobScheduler
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.*
import android.content.RestrictionsManager
import android.content.pm.LauncherApps
import android.hardware.ConsumerIrManager
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.hardware.fingerprint.FingerprintManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.media.midi.MidiManager
import android.media.session.MediaSessionManager
import android.net.nsd.NsdManager
import android.nfc.NfcManager
import android.os.*
import android.os.storage.StorageManager
import android.print.PrintManager
import android.support.annotation.RequiresApi
import android.telecom.TelecomManager
import android.telephony.CarrierConfigManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager


/**
 * 各种管理类的获取，在Context类中可直接调用获取管理类实例.
 * <p>
 *
 * @author ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */

/**
 * @see [AccountManager]
 */
fun Context.getAccountManager(): AccountManager
{
    return getSystemService(ACCOUNT_SERVICE) as AccountManager
}

/**
 * @see [ClipboardManager]
 */
fun Context.getClipboardManager(): ClipboardManager
{
    return getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
}

/**
 * @see [WindowManager]
 */
fun Context.getWindowManager(): WindowManager
{
    return getSystemService(WINDOW_SERVICE) as WindowManager
}

/**
 * @see [KeyguardManager]
 */
fun Context.getKeyguardManager(): KeyguardManager
{
    return getSystemService(KEYGUARD_SERVICE) as KeyguardManager
}

/**
 * @see [PowerManager]
 */
fun Context.getPowerManager(): PowerManager
{
    return getSystemService(POWER_SERVICE) as PowerManager
}

/**
 * @see [LayoutInflater]
 */
fun Context.getLayoutInflater(): LayoutInflater
{
    return getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
}

/**
 * @see [ActivityManager]
 */
fun Context.getActivityManager(): ActivityManager
{
    return getSystemService(ACTIVITY_SERVICE) as ActivityManager
}

/**
 * @see [AlarmManager]
 */
fun Context.getAlarmManager(): AlarmManager
{
    return getSystemService(ALARM_SERVICE) as AlarmManager
}

/**
 * @see [NotificationManager]
 */
fun Context.getNotificationManager(): NotificationManager
{
    return getSystemService(NOTIFICATION_SERVICE) as NotificationManager
}

/**
 * @see [AccessibilityManager]
 */
fun Context.getAccessibilityManager(): AccessibilityManager
{
    return getSystemService(ACCESSIBILITY_SERVICE) as AccessibilityManager
}

/**
 * @see [CaptioningManager]
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Context.getCaptioningManager(): CaptioningManager
{
    return getSystemService(CAPTIONING_SERVICE) as CaptioningManager
}

/**
 * @see [LocationManager]
 */
fun Context.getLocationManager(): LocationManager
{
    return getSystemService(LOCATION_SERVICE) as LocationManager
}

/**
 * @see [SensorManager]
 */
fun Context.getSensorManager(): SensorManager
{
    return getSystemService(SENSOR_SERVICE) as SensorManager
}

/**
 * @see [StorageManager]
 */
fun Context.getStorageManage(): StorageManager
{
    return getSystemService(STORAGE_SERVICE) as StorageManager
}

/**
 * @see [WallpaperManager]
 */
fun Context.getWallpaperManager(): WallpaperManager
{
    return getSystemService(WALLPAPER_SERVICE) as WallpaperManager
}

/**
 * @see [Vibrator]
 */
fun Context.getVibrator(): Vibrator
{
    return getSystemService(VIBRATOR_SERVICE) as Vibrator
}

/**
 * @see [NsdManager]
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
fun Context.getNsdManager(): NsdManager
{
    return getSystemService(NSD_SERVICE) as NsdManager
}

/**
 * @see [AudioManager]
 */
fun Context.getAudioManager(): AudioManager
{
    return getSystemService(AUDIO_SERVICE) as AudioManager
}

/**
 * @see [FingerprintManager]
 */
@RequiresApi(Build.VERSION_CODES.M)
fun Context.getFingerprintManager(): FingerprintManager
{
    return getSystemService(FINGERPRINT_SERVICE) as FingerprintManager
}

/**
 * @see [MediaRouter]
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
fun Context.getMediaRouter(): MediaRouter
{
    return getSystemService(MEDIA_ROUTER_SERVICE) as MediaRouter
}

/**
 * @see [TelecomManager]
 */
fun Context.getTelephonyManager(): TelephonyManager
{
    return getSystemService(TELEPHONY_SERVICE) as TelephonyManager
}

/**
 * @see [CarrierConfigManager]
 */
@RequiresApi(Build.VERSION_CODES.M)
fun Context.getCarrierConfigManager(): CarrierConfigManager
{
    return getSystemService(CARRIER_CONFIG_SERVICE) as CarrierConfigManager
}

/**
 * @see [TelecomManager]
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Context.getTelecomManager(): TelecomManager
{
    return getSystemService(TELECOM_SERVICE) as TelecomManager
}

/**
 * @see [InputMethodManager]
 */
fun Context.getInputMethodManager(): InputMethodManager
{
    return getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
}

/**
 * @see [TextServicesManager]
 */
fun Context.getTextServicesManager(): TextServicesManager
{
    return getSystemService(TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager
}

/**
 * @see [AppWidgetManager]
 */
fun Context.getAppWidgetManager(): AppWidgetManager
{
    return getSystemService(APPWIDGET_SERVICE) as AppWidgetManager
}

/**
 * @see [UiModeManager]
 */
fun Context.getUiModeManager(): UiModeManager
{
    return getSystemService(UI_MODE_SERVICE) as UiModeManager
}

/**
 * @see [DownloadManager]
 */
fun Context.getDownloadManager(): DownloadManager
{
    return getSystemService(DOWNLOAD_SERVICE) as DownloadManager
}

/**
 * @see [NfcManager]
 */
fun Context.getNfcManager(): NfcManager
{
    return getSystemService(NFC_SERVICE) as NfcManager
}

/**
 * @see [BluetoothManager]
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
fun Context.getBluetoothManager(): BluetoothManager
{
    return getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
}

/**
 * @see [LauncherApps]
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Context.getLauncherApps(): LauncherApps
{
    return getSystemService(LAUNCHER_APPS_SERVICE) as LauncherApps
}

/**
 * @see [DisplayManager]
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun Context.getDisplayManagerCompat(): DisplayManager
{
    return getSystemService(DISPLAY_SERVICE) as DisplayManager
}

/**
 * @see [UserManager]
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun Context.getUserManager(): UserManager
{
    return getSystemService(USER_SERVICE) as UserManager
}

/**
 * @see [RestrictionsManager]
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Context.getRestrictionsManager(): RestrictionsManager
{
    return getSystemService(RESTRICTIONS_SERVICE) as RestrictionsManager
}

/**
 * @see [AppOpsManager]
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Context.getAppOpsManager(): AppOpsManager
{
    return getSystemService(APP_OPS_SERVICE) as AppOpsManager
}

/**
 * @see [CameraManager]
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Context.getCameraManager(): CameraManager
{
    return getSystemService(CAMERA_SERVICE) as CameraManager
}

/**
 * @see [PrintManager]
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Context.getPrintManager(): PrintManager
{
    return getSystemService(PRINT_SERVICE) as PrintManager
}

/**
 * @see [ConsumerIrManager]
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Context.getConsumerIrManager(): ConsumerIrManager
{
    return getSystemService(CONSUMER_IR_SERVICE) as ConsumerIrManager
}

/**
 * @see [MediaSessionManager]
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Context.getMediaSessionManager(): MediaSessionManager
{
    return getSystemService(MEDIA_SESSION_SERVICE) as MediaSessionManager
}

/**
 * @see [BatteryManager]
 */
fun Context.getBatteryManager(): BatteryManager
{
    return getSystemService(BATTERY_SERVICE) as BatteryManager
}

/**
 * @see [JobScheduler]
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Context.getJobScheduler(): JobScheduler
{
    return getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
}

/**
 * @see [MidiManager]
 */
@RequiresApi(Build.VERSION_CODES.M)
fun Context.getMidiManager(): MidiManager
{
    return getSystemService(MIDI_SERVICE) as MidiManager
}

/**
 * @see [HardwarePropertiesManager]
 */
@RequiresApi(Build.VERSION_CODES.N)
fun Context.getHardwarePropertiesManager(): HardwarePropertiesManager
{
    return getSystemService(HARDWARE_PROPERTIES_SERVICE) as HardwarePropertiesManager
}