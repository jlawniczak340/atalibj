package edu.first.module.sensors;

import edu.first.module.Module;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Gyro;

/**
 * Module implementation of the KoP gyroscope. Composes and wraps {@link Gyro},
 * giving it module properties to fit with the standard in atalibj.
 *
 * @since May 22 13
 * @author Joel Gallant
 */
public class GyroscopeModule extends Module.StandardModule implements Gyroscope {

    private final Gyro gyro;

    /**
     * Constructs the module with the gyro object underneath this class to
     * call methods from.
     *
     * @param gyro the composing instance which will return values
     */
    protected GyroscopeModule(Gyro gyro) {
        if(gyro == null) {
            throw new NullPointerException("Null gyro given");
        }
        this.gyro = gyro;
    }

    /**
     * Constructs the module with the port on the analog sidecar.
     *
     * @param channel port on sidecar
     */
    public GyroscopeModule(int channel) {
        this(new AnalogChannel(channel));
    }

    /**
     * Constructs the module with the port on the analog sidecar and which slot
     * the sidecar is in.
     *
     * @param channel port on sidecar
     * @param slot slot in cRIO (1 = default)
     */
    public GyroscopeModule(int channel, int slot) {
        this(new AnalogChannel(slot, channel));
    }

    /**
     * Constructs the module with the channel of the gyroscope.
     *
     * @param channel analog channel to find gyro on
     */
    public GyroscopeModule(AnalogChannel channel) {
        this(new Gyro(channel));
    }

    /**
     * Resets the gyro to zero.
     */
    public void init() {
        gyro.reset();
    }

    /**
     * Resets the gyro to zero.
     */
    protected void enableModule() {
        gyro.reset();
    }

    /*
     * Does not do anything.
     */
    protected void disableModule() {
    }

    /**
     * Resets the cumulative angle to zero.
     *
     * @throws IllegalStateException when module is not enabled
     */
    public void reset() {
        ensureEnabled();
        gyro.reset();
    }

    /**
     * {@inheritDoc}
     */
    public void setSensitivity(double voltsPerDegreePerSecond) {
        gyro.setSensitivity(voltsPerDegreePerSecond);
    }

    /**
     * Returns the angle of the gyroscope, provided this method is enabled.
     *
     * @return cumulative angle given by gyroscope
     * @throws IllegalStateException when module is not enabled
     */
    public double getAngle() {
        ensureEnabled();
        return gyro.getAngle();
    }

    /**
     * Returns the angle of the gyroscope, provided this method is enabled.
     *
     * @return cumulative angle given by gyroscope
     * @throws IllegalStateException when module is not enabled
     */
    public double getPosition() {
        return getAngle();
    }

    /**
     * Returns the angle of the gyroscope, provided this method is enabled.
     *
     * @return cumulative angle given by gyroscope
     * @throws IllegalStateException when module is not enabled
     */
    public double get() {
        return getAngle();
    }
}
