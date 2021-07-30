package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

//    @Test
//    public void test(){
//        Alarm alarm = new Alarm(new Sensor());
//        alarm.check();
//        assertTrue(alarm.getAlarmOn());
//    }


    @Test
    public void when_pressureLowerThenLowPressureThreshold_then_alarmShouldBeOn() {
        // mock sensor

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(15.5);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void when_pressureGreaterThanHighPressureThreshold_then_alarmShouldBeOn() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(125.5);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void when_normalPressure_then_alarmShouldBeOff() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(18.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

}