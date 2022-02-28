/**
 * Small spec with one group
 */
spec ExampleSpec {

    set exampleLev;
    set exampleTiming;

    action exampleAction;

//    var String someText = "Hello world";
    var Voltage someVoltage = 0.5 V;
//    var Frequency someFrequency = 15 Hz;
    var Time somePeriod = 5.0 ns;
    group ExampleGroup = IO_0 + IO_1;

    setup digInOut ExampleGroup {
        wavetable wvt1 {
          xModes = 1;

          0 : d1:0 d2:0;
          1 : d1:1 d2:0;
          L : r1:L;
          H : r1:H;
          X : r1:X;
        }

        set level exampleLev {
            vih = someVoltage * 2;
            vil = someVoltage / 2;
        }

        set timing exampleTiming {
            period = somePeriod + 5 ns;
            d1 = 2.1 ns;
            d2 = 4.2 ns;
            r1 = 0 ns;
        }
    }

    setup dcVI VCC {
        level.vrange = 5 V;
        level.irange = 25 mA;

        action vforce exampleAction {
            forceValue = 5 V;
            iclamp = 25 mA;
        }
    }
}
