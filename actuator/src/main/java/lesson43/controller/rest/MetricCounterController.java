package lesson43.controller.rest;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.*;
import io.micrometer.core.instrument.binder.BaseUnits;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class MetricCounterController {

    private final MeterRegistry registry;
    private final List<Object> objects = new ArrayList<>();
    private final DistributionSummary distribution;
    private final Timer timer;

    public MetricCounterController(MeterRegistry registry) {
        this.registry = registry;
        Counter.builder("counter.example")
                .baseUnit(BaseUnits.EVENTS)
                .description("The number of method calls")
                .register(registry);
        Gauge.builder("gauge.example", objects, Collection::size)
                .baseUnit(BaseUnits.OBJECTS)
                .description("The number of events from the array")
                .register(registry);
        distribution = DistributionSummary.builder("distribution.example")
                .baseUnit("milliliters")
                .description("Milliliters of the teacher tears")
                .distributionStatisticBufferLength(1000)
                .register(registry);
        timer = Timer.builder("timer.example")
                .description("Time of the method execution")
                .publishPercentiles(0.50, 0.90, 0.95, 1.00)
                .publishPercentileHistogram()
                .register(registry);
    }

    @PostMapping("/counter")
    public void counter() {
        registry.counter("counter.example").increment();
    }

    @PostMapping("/gauge")
    public void gauge() {
        objects.add(new Object());
    }

    @PostMapping("/distribution")
    public void distribution() {
        distribution.record(Math.random());
    }

    @PostMapping("/timer")
    public void timer() throws InterruptedException {
        Timer.Sample sample = Timer.start();
        Thread.sleep((long) (Math.random() * 500));
        sample.stop(timer);
    }

    @Timed("annotation.timer.example")
    @PostMapping("/annotation-timer")
    public void timer2() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 5000));
    }
}
