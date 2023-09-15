/*
 * SPDX-FileCopyrightText: 2007, The Android Open Source Project
 * SPDX-FileCopyrightText: 2014, microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package android.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

/**
 * A data class representing a geographic location.
 * <p/>
 * <p>A location can consist of a latitude, longitude, timestamp,
 * and other information such as bearing, altitude and velocity.
 * <p/>
 * <p>All locations generated by the {@link LocationManager} are
 * guaranteed to have a valid latitude, longitude, and timestamp
 * (both UTC time and elapsed real-time since boot), all other
 * parameters are optional.
 */
public class Location implements Parcelable {
    /**
     * Constant used to specify formatting of a latitude or longitude
     * in the form "[+-]DDD.DDDDD where D indicates degrees.
     */
    public static final int FORMAT_DEGREES = 0;

    /**
     * Constant used to specify formatting of a latitude or longitude
     * in the form "[+-]DDD:MM.MMMMM" where D indicates degrees and
     * M indicates minutes of arc (1 minute = 1/60th of a degree).
     */
    public static final int FORMAT_MINUTES = 1;

    /**
     * Constant used to specify formatting of a latitude or longitude
     * in the form "DDD:MM:SS.SSSSS" where D indicates degrees, M
     * indicates minutes of arc, and S indicates seconds of arc (1
     * minute = 1/60th of a degree, 1 second = 1/3600th of a degree).
     */
    public static final int FORMAT_SECONDS = 2;

    /**
     * Bundle key for a version of the location that has been fed through
     * LocationFudger. Allows location providers to flag locations as being
     * safe for use with ACCESS_COARSE_LOCATION permission.
     *
     * @hide
     */
    public static final String EXTRA_COARSE_LOCATION = "coarseLocation";

    /**
     * Bundle key for a version of the location containing no GPS data.
     * Allows location providers to flag locations as being safe to
     * feed to LocationFudger.
     *
     * @hide
     */
    public static final String EXTRA_NO_GPS_LOCATION = "noGPSLocation";
    public static final Parcelable.Creator<Location> CREATOR =
            new Parcelable.Creator<Location>() {
                @Override
                public Location createFromParcel(Parcel in) {
                    return null;
                }

                @Override
                public Location[] newArray(int size) {
                    return null;
                }
            };

    /**
     * Construct a new Location with a named provider.
     * <p/>
     * <p>By default time, latitude and longitude are 0, and the location
     * has no bearing, altitude, speed, accuracy or extras.
     *
     * @param provider the name of the provider that generated this location
     */
    public Location(String provider) {
    }

    /**
     * Construct a new Location object that is copied from an existing one.
     */
    public Location(Location l) {
    }

    /**
     * Converts a coordinate to a String representation. The outputType
     * may be one of FORMAT_DEGREES, FORMAT_MINUTES, or FORMAT_SECONDS.
     * The coordinate must be a valid double between -180.0 and 180.0.
     *
     * @throws IllegalArgumentException if coordinate is less than
     *                                  -180.0, greater than 180.0, or is not a number.
     * @throws IllegalArgumentException if outputType is not one of
     *                                  FORMAT_DEGREES, FORMAT_MINUTES, or FORMAT_SECONDS.
     */
    public static String convert(double coordinate, int outputType) {
        return null;
    }

    /**
     * Converts a String in one of the formats described by
     * FORMAT_DEGREES, FORMAT_MINUTES, or FORMAT_SECONDS into a
     * double.
     *
     * @throws NullPointerException     if coordinate is null
     * @throws IllegalArgumentException if the coordinate is not
     *                                  in one of the valid formats.
     */
    public static double convert(String coordinate) {
        return 0;
    }

    private static void computeDistanceAndBearing(double lat1, double lon1,
                                                  double lat2, double lon2, float[] results) {
    }

    /**
     * Computes the approximate distance in meters between two
     * locations, and optionally the initial and final bearings of the
     * shortest path between them.  Distance and bearing are defined using the
     * WGS84 ellipsoid.
     * <p/>
     * <p> The computed distance is stored in results[0].  If results has length
     * 2 or greater, the initial bearing is stored in results[1]. If results has
     * length 3 or greater, the final bearing is stored in results[2].
     *
     * @param startLatitude  the starting latitude
     * @param startLongitude the starting longitude
     * @param endLatitude    the ending latitude
     * @param endLongitude   the ending longitude
     * @param results        an array of floats to hold the results
     * @throws IllegalArgumentException if results is null or has length < 1
     */
    public static void distanceBetween(double startLatitude, double startLongitude,
                                       double endLatitude, double endLongitude, float[] results) {
    }

    /**
     * Sets the contents of the location to the values from the given location.
     */
    public void set(Location l) {
    }

    /**
     * Clears the contents of the location.
     */
    public void reset() {
    }

    /**
     * Returns the approximate distance in meters between this
     * location and the given location.  Distance is defined using
     * the WGS84 ellipsoid.
     *
     * @param dest the destination location
     * @return the approximate distance in meters
     */
    public float distanceTo(Location dest) {
        return 0;
    }

    /**
     * Returns the approximate initial bearing in degrees East of true
     * North when traveling along the shortest path between this
     * location and the given location.  The shortest path is defined
     * using the WGS84 ellipsoid.  Locations that are (nearly)
     * antipodal may produce meaningless results.
     *
     * @param dest the destination location
     * @return the initial bearing in degrees
     */
    public float bearingTo(Location dest) {
        return 0;
    }

    /**
     * Returns the name of the provider that generated this fix.
     *
     * @return the provider, or null if it has not been set
     */
    public String getProvider() {
        return null;
    }

    /**
     * Sets the name of the provider that generated this fix.
     */
    public void setProvider(String provider) {
    }

    /**
     * Return the UTC time of this fix, in milliseconds since January 1, 1970.
     * <p/>
     * <p>Note that the UTC time on a device is not monotonic: it
     * can jump forwards or backwards unpredictably. So always use
     * {@link #getElapsedRealtimeNanos} when calculating time deltas.
     * <p/>
     * <p>On the other hand, {@link #getTime} is useful for presenting
     * a human readable time to the user, or for carefully comparing
     * location fixes across reboot or across devices.
     * <p/>
     * <p>All locations generated by the {@link LocationManager}
     * are guaranteed to have a valid UTC time, however remember that
     * the system time may have changed since the location was generated.
     *
     * @return time of fix, in milliseconds since January 1, 1970.
     */
    public long getTime() {
        return 0;
    }

    /**
     * Set the UTC time of this fix, in milliseconds since January 1,
     * 1970.
     *
     * @param time UTC time of this fix, in milliseconds since January 1, 1970
     */
    public void setTime(long time) {
    }

    /**
     * Return the time of this fix, in elapsed real-time since system boot.
     * <p/>
     * <p>This value can be reliably compared to
     * {@link android.os.SystemClock#elapsedRealtimeNanos},
     * to calculate the age of a fix and to compare Location fixes. This
     * is reliable because elapsed real-time is guaranteed monotonic for
     * each system boot and continues to increment even when the system
     * is in deep sleep (unlike {@link #getTime}.
     * <p/>
     * <p>All locations generated by the {@link LocationManager}
     * are guaranteed to have a valid elapsed real-time.
     *
     * @return elapsed real-time of fix, in nanoseconds since system boot.
     */
    public long getElapsedRealtimeNanos() {
        return 0;
    }

    /**
     * Set the time of this fix, in elapsed real-time since system boot.
     *
     * @param time elapsed real-time of fix, in nanoseconds since system boot.
     */
    public void setElapsedRealtimeNanos(long time) {
    }

    /**
     * Get the latitude, in degrees.
     * <p/>
     * <p>All locations generated by the {@link LocationManager}
     * will have a valid latitude.
     */
    public double getLatitude() {
        return 0;
    }

    /**
     * Set the latitude, in degrees.
     */
    public void setLatitude(double latitude) {
    }

    /**
     * Get the longitude, in degrees.
     * <p/>
     * <p>All locations generated by the {@link LocationManager}
     * will have a valid longitude.
     */
    public double getLongitude() {
        return 0;
    }

    /**
     * Set the longitude, in degrees.
     */
    public void setLongitude(double longitude) {
    }

    /**
     * True if this location has an altitude.
     */
    public boolean hasAltitude() {
        return false;
    }

    /**
     * Get the altitude if available, in meters above the WGS 84 reference
     * ellipsoid.
     * <p/>
     * <p>If this location does not have an altitude then 0.0 is returned.
     */
    public double getAltitude() {
        return 0;
    }

    /**
     * Set the altitude, in meters above the WGS 84 reference ellipsoid.
     * <p/>
     * <p>Following this call {@link #hasAltitude} will return true.
     */
    public void setAltitude(double altitude) {
    }

    /**
     * Remove the altitude from this location.
     * <p/>
     * <p>Following this call {@link #hasAltitude} will return false,
     * and {@link #getAltitude} will return 0.0.
     */
    public void removeAltitude() {
    }

    /**
     * True if this location has a speed.
     */
    public boolean hasSpeed() {
        return false;
    }

    /**
     * Get the speed if it is available, in meters/second over ground.
     * <p/>
     * <p>If this location does not have a speed then 0.0 is returned.
     */
    public float getSpeed() {
        return 0;
    }

    /**
     * Set the speed, in meters/second over ground.
     * <p/>
     * <p>Following this call {@link #hasSpeed} will return true.
     */
    public void setSpeed(float speed) {
    }

    /**
     * Remove the speed from this location.
     * <p/>
     * <p>Following this call {@link #hasSpeed} will return false,
     * and {@link #getSpeed} will return 0.0.
     */
    public void removeSpeed() {
    }

    /**
     * True if this location has a bearing.
     */
    public boolean hasBearing() {
        return false;
    }

    /**
     * Get the bearing, in degrees.
     * <p/>
     * <p>Bearing is the horizontal direction of travel of this device,
     * and is not related to the device orientation. It is guaranteed to
     * be in the range (0.0, 360.0] if the device has a bearing.
     * <p/>
     * <p>If this location does not have a bearing then 0.0 is returned.
     */
    public float getBearing() {
        return 0;
    }

    /**
     * Set the bearing, in degrees.
     * <p/>
     * <p>Bearing is the horizontal direction of travel of this device,
     * and is not related to the device orientation.
     * <p/>
     * <p>The input will be wrapped into the range (0.0, 360.0].
     */
    public void setBearing(float bearing) {
    }

    /**
     * Remove the bearing from this location.
     * <p/>
     * <p>Following this call {@link #hasBearing} will return false,
     * and {@link #getBearing} will return 0.0.
     */
    public void removeBearing() {
    }

    /**
     * True if this location has an accuracy.
     * <p/>
     * <p>All locations generated by the {@link LocationManager} have an
     * accuracy.
     */
    public boolean hasAccuracy() {
        return false;
    }

    /**
     * Get the estimated accuracy of this location, in meters.
     * <p/>
     * <p>We define accuracy as the radius of 68% confidence. In other
     * words, if you draw a circle centered at this location's
     * latitude and longitude, and with a radius equal to the accuracy,
     * then there is a 68% probability that the true location is inside
     * the circle.
     * <p/>
     * <p>In statistical terms, it is assumed that location errors
     * are random with a normal distribution, so the 68% confidence circle
     * represents one standard deviation. Note that in practice, location
     * errors do not always follow such a simple distribution.
     * <p/>
     * <p>This accuracy estimation is only concerned with horizontal
     * accuracy, and does not indicate the accuracy of bearing,
     * velocity or altitude if those are included in this Location.
     * <p/>
     * <p>If this location does not have an accuracy, then 0.0 is returned.
     * All locations generated by the {@link LocationManager} include
     * an accuracy.
     */
    public float getAccuracy() {
        return 0;
    }

    /**
     * Set the estimated accuracy of this location, meters.
     * <p/>
     * <p>See {@link #getAccuracy} for the definition of accuracy.
     * <p/>
     * <p>Following this call {@link #hasAccuracy} will return true.
     */
    public void setAccuracy(float accuracy) {
    }

    /**
     * Remove the accuracy from this location.
     * <p/>
     * <p>Following this call {@link #hasAccuracy} will return false, and
     * {@link #getAccuracy} will return 0.0.
     */
    public void removeAccuracy() {
    }

    /**
     * Return true if this Location object is complete.
     * <p/>
     * <p>A location object is currently considered complete if it has
     * a valid provider, accuracy, wall-clock time and elapsed real-time.
     * <p/>
     * <p>All locations supplied by the {@link LocationManager} to
     * applications must be complete.
     *
     * @hide
     * @see #makeComplete
     */
    public boolean isComplete() {
        return false;
    }

    /**
     * Helper to fill incomplete fields.
     * <p/>
     * <p>Used to assist in backwards compatibility with
     * Location objects received from applications.
     *
     * @hide
     * @see #isComplete
     */
    public void makeComplete() {
    }

    /**
     * Returns additional provider-specific information about the
     * location fix as a Bundle.  The keys and values are determined
     * by the provider.  If no additional information is available,
     * null is returned.
     * <p/>
     * <p> A number of common key/value pairs are listed
     * below. Providers that use any of the keys on this list must
     * provide the corresponding value as described below.
     * <p/>
     * <ul>
     * <li> satellites - the number of satellites used to derive the fix
     * </ul>
     */
    public Bundle getExtras() {
        return null;
    }

    /**
     * Sets the extra information associated with this fix to the
     * given Bundle.
     */
    public void setExtras(Bundle extras) {
    }

    public void dump(Printer pw, String prefix) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
    }

    /**
     * Returns one of the optional extra {@link Location}s that can be attached
     * to this Location.
     *
     * @param key the key associated with the desired extra Location
     * @return the extra Location, or null if unavailable
     * @hide
     */
    public Location getExtraLocation(String key) {
        return null;
    }

    /**
     * Attaches an extra {@link Location} to this Location.
     *
     * @param key      the key associated with the Location extra
     * @param location the Location to attach
     * @hide
     */
    public void setExtraLocation(String key, Location value) {
    }

    /**
     * Returns true if the Location came from a mock provider.
     *
     * @return true if this Location came from a mock provider, false otherwise
     */
    public boolean isFromMockProvider() {
        return false;
    }

    /**
     * Flag this Location as having come from a mock provider or not.
     *
     * @param isFromMockProvider true if this Location came from a mock provider, false otherwise
     * @hide
     */
    public void setIsFromMockProvider(boolean isFromMockProvider) {
    }
}
