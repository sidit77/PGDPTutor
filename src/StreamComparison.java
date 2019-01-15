import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamComparison {

    public static void main(final String[] args) {
        final StringBuilder msg = new StringBuilder();

        msg.append("\n\nUsed threads (numTasks : numThreads)\n");
        msg.append(IntStream
                .range(1, 25)
                .boxed()
                .map(i -> i+" : "+ StreamComparison.countNumThreads(i))
                .collect(Collectors.joining("\n"))
        );

        msg.append("\n\nUsed threads (numTasks : numThreads)\n");
        msg.append(IntStream
                .of(10, 1000)
                .mapToObj(i -> i+" : "+ StreamComparison.countNumThreads(i, 8))
                .collect(Collectors.joining("\n"))
        );

        msg.append("\n\nTime elapsed in ms (numPrintStatements : diffNonParallelToParallel)\n");
        msg.append(IntStream
                .of(10, 100, 1000, 10000, 100000)
                .boxed()
                .map(i -> i+" : "+ StreamComparison.printlnComparison(i))
                .collect(Collectors.joining("\n"))
        );

        msg.append("\n\nTime elapsed in ms (numCalculations : diffNonParallelToParallel)\n");
        msg.append(IntStream
                .of(10, 100, 1000, 10000, 20000)
                .boxed()
                .map(i -> i+" : "+ StreamComparison.calcComparison(i))
                .collect(Collectors.joining("\n"))
        );

        System.out.println(msg);
    }

    static long printlnComparison(final int numPrintStatements) {
        final long nonParallelStart = System.currentTimeMillis();
        IntStream.range(1, numPrintStatements).forEach(i ->
                System.out.println(i + ": " + Thread.currentThread().getName())
        );
        final long nonParallelDuration = System.currentTimeMillis() - nonParallelStart;

        final long parallelStart = System.currentTimeMillis();
        IntStream.range(1, numPrintStatements).parallel().forEach(i ->
                System.out.println(i + ": " + Thread.currentThread().getName())
        );
        final long parallelDuration = System.currentTimeMillis() - parallelStart;

        return nonParallelDuration - parallelDuration;
    }

    static long calcComparison(final int numCalculations) {
        final long nonParallelStart = System.currentTimeMillis();
        IntStream.range(1, numCalculations).forEach(i -> {
            double sum = IntStream.range(0, i).boxed().mapToDouble(Math::exp).sum();
        });
        final long nonParallelEnd = System.currentTimeMillis() - nonParallelStart;

        final long parallelStart = System.currentTimeMillis();
        IntStream.range(1, numCalculations).parallel().forEach(i -> {
            double sum = IntStream.range(0, i).boxed().mapToDouble(Math::exp).sum();
        });
        final long parallelEnd = System.currentTimeMillis() - parallelStart;

        return nonParallelEnd - parallelEnd;
    }

    static long countNumThreads(final int numTasks) {
        final long usedThreads = IntStream
                .range(0, numTasks)
                .parallel()
                .mapToObj(i -> Thread.currentThread().getName())
                .distinct()
                .count();
        return usedThreads;
    }

    static long countNumThreads(final int numTasks, final int numThreads) {
        // dies ist als "zuckerl" gedacht für diejenigen, die selber die anzahl
        // der threads für MapReduce selber explizit bestimmen wollen
        final ForkJoinPool forkJoinPool = new ForkJoinPool(numThreads);
        try {
            return forkJoinPool.submit(() ->
                    IntStream
                            .range(0, numTasks)
                            .boxed()
                            .parallel()
                            .map(i -> {
                                double sum = IntStream.range(0, i).boxed().mapToDouble(Math::exp).sum();
                                return Thread.currentThread().getName();
                            })
                            .distinct()
                            .count()
            ).get();
        } catch (InterruptedException | ExecutionException e) {
            return 0;
        }
    }

}
