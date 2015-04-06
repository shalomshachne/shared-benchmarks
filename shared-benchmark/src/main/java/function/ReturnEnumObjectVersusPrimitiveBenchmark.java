package function;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class ReturnEnumObjectVersusPrimitiveBenchmark {
	
	enum Category {
		CATEGORY1,
		CATEGORY2,
	}
	
	
	
	@Param( {"3" , "2", "1" })
	String value;
	
	int param;
	
	@Setup
	public void setUp() {
		param = Integer.parseInt(value);
	}
	
	@Benchmark
	public int benchmarkReturnOrdinal() {
		if (param < 2) {
			return Category.CATEGORY1.ordinal();
		}
		return Category.CATEGORY2.ordinal();		
	}
	
	/*
	 *   if (msgType == Category.SESSION) {
	 *   
	 *   }
	 *   
	 *   or
	 *   
	 *   if (msgType == Category.SESSION.ordinal())
	 *   
	 *   
	 *   if (msg == Category.SESSION /* this is an int constant */
	 
	
	

	@Benchmark
	public Category benchmarkReturnReference() {
		if (param < 2) {
			return Category.CATEGORY1;
		}
		return Category.CATEGORY2;		
	}


	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(ReturnEnumObjectVersusPrimitiveBenchmark.class.getName()).warmupIterations(5)
				.measurementIterations(4).forks(1).build();
		new Runner(opt).run();
	}

}
