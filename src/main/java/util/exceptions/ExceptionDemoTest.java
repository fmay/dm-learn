/*
* DO NOT MODIFY THIS COMMENT
* Generated by devmate
* Test model: 2f98fe05-8690-47a9-9ee0-1512ee00eb2e
*/
package util.exceptions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@SuppressWarnings("unused")
public class ExceptionDemoTest {
	
//region Scenarios
	//A new scenario
	@ParameterizedTest(name = "{1} [{index}] {2}")
	@MethodSource({"Scenario1Source"})
	public void Scenario1Test(Scenario1TestData data, String TestName, String TestDescription) {
		ActualResultStorage.setStorage(); //saves the results of the called Methods
		
		assertion(data, data.S1M1.methodName, null, data.S1M1.expectedResult, data.S1M1.call());
	}
//endregion

//region Data

//=========================================================================================================================
//Please modify this section only in the Modeleditor not here in the code, because otherwise it will cause merge conflicts!
//=========================================================================================================================
	//A new scenario
	private static Stream<Arguments> Scenario1Source() {
		return Stream.of(
			Arguments.of(
				new Scenario1TestData(
					/* S1M1 = */ new S1M1Parameters<>(
						/* Integer number = */ 100,
						/* Integer divisor = */ 20,
						/* referencingMethodName = */ new String[2],
						/* expectedResult = */ new Result<>(
							/* assertType = */ AssertType.EXPECTED_VALUE,
							/* expectedReturnValue = */ 5d
						)
					)
				),
				/* testCaseName = */ "p1",
				/* testCaseDescription = */ ""
			),
			Arguments.of(
				new Scenario1TestData(
					/* S1M1 = */ new S1M1Parameters<>(
						/* Integer number = */ 100,
						/* Integer divisor = */ 0,
						/* referencingMethodName = */ new String[2],
						/* expectedResult = */ new Result<>(
							/* assertType = */ AssertType.EXCEPTION,
							/* expectedException = */ DivideByZeroException.class
						)
					)
				),
				/* testCaseName = */ "n1",
				/* testCaseDescription = */ "M1:divisor: invalid"
			)
		);
	}
//endregion

//region Types

//=========================================================================================================================
//Please modify this section only in the Modeleditor not here in the code, because otherwise it will cause merge conflicts!
//=========================================================================================================================
	static class Scenario1TestData {
	    public final S1M1Parameters<Scenario1TestData> S1M1;
	    
	    public Scenario1TestData(S1M1Parameters<Scenario1TestData> S1M1) {
	    	this.S1M1 = S1M1;
	    }
	}

	static class S1M1Parameters<TestData> {
		public final String methodName = "S1M1";
	    public final ObjectWrapper<Integer> number;
	    public final ObjectWrapper<Integer> divisor;
	    public final Result<TestData, Object, Double> expectedResult;
		public S1M1Parameters(Integer number, Integer divisor, String[] referencingMethodName, Result<TestData, Object, Double> expectedResult) {
			this.number = new ObjectWrapper<>(number, referencingMethodName[0]);
			this.divisor = new ObjectWrapper<>(divisor, referencingMethodName[1]);
	   		this.expectedResult = expectedResult;
	    }
	    
	    public ExceptionFunction<Object, Double> call() {
	    	return i ->
	    	 util.exceptions.ExceptionDemo.userException(number.get(), divisor.get());
		}
	}
//endregion

//region Utility Classes

//=========================================================================================================================
//Please modify this section only in the Modeleditor not here in the code, because otherwise it will cause merge conflicts!
//=========================================================================================================================
	public static class ObjectWrapper<T> {
		public T object;
		public String referencingMethodName;
		
		public ObjectWrapper(T object, String referencingMethodName) {
			this.object = object;
			this.referencingMethodName = referencingMethodName;
		}
		
		public T get() {
			return ActualResultStorage.getOrDefault(referencingMethodName, object);
		}
	}
	
	public static class ActualResultStorage {
		private static Map<String, Object> actualResultMap = new HashMap<>();
		
		public static void setStorage() {
			actualResultMap = new HashMap<>();
		}
		
		public static <T> void put(String key, T value) {
			actualResultMap.put(key, value);
		}
		
		@SuppressWarnings("unchecked")
		public static <T> T getOrDefault(String key, T defaultValue) {
			return (T) actualResultMap.getOrDefault(key, defaultValue);
		}
	}
	
	static class Result<TestData, TInstance, TReturn> {
		public final AssertType assertType;
		public final TReturn expectedReturnValue;
		public final Class<? extends Throwable> expectedException;
		public final BiConsumer<TInstance, TReturn> customAction;
		public final List<SideEffect<TestData>> sideEffects;
		
		public Result(AssertType assertType) {
			this(assertType, (TReturn) null, null);
		}
	
		public Result(AssertType assertType, List<SideEffect<TestData>> sideEffects) {
			this(assertType, (TReturn) null, sideEffects);
		}
	
		public Result(AssertType assertType, TReturn expectedReturnValue) {
			this(assertType, expectedReturnValue, null);
		}
	
		public Result(AssertType assertType, Class<? extends Throwable> expectedException) {
			this(assertType, expectedException, null);
		}
	
		public Result(AssertType assertType, BiConsumer<TInstance, TReturn> customAction) {
			this(assertType, customAction, null);
		}
	
		public Result(AssertType assertType, TReturn expectedReturnValue, List<SideEffect<TestData>> sideEffects) {
			this(assertType, expectedReturnValue, null, null, sideEffects);
		}
	
		public Result(AssertType assertType, Class<? extends Throwable> expectedException, List<SideEffect<TestData>> sideEffects) {
			this(assertType, null, expectedException, null, sideEffects);
		}
	
		public Result(AssertType assertType, BiConsumer<TInstance, TReturn> customAction, List<SideEffect<TestData>> sideEffects) {
			this(assertType, null, null, customAction, sideEffects);
		}
	
		public Result(AssertType assertType, TReturn expectedReturnValue, Class<? extends Throwable> expectedException,
			BiConsumer<TInstance, TReturn> customAction, List<SideEffect<TestData>> sideEffects) {
			this.assertType = assertType;
			this.expectedReturnValue = expectedReturnValue;
			this.expectedException = expectedException;
			this.customAction = customAction;
			this.sideEffects = sideEffects;
		}
	}
	
	static class SideEffect<TestData> {
	    public final Object expectedValue;
	    public final Function<TestData, Object> actualValueAccessor;
	    
		public SideEffect(Object expectedValue, Function<TestData, Object> actualValueAccessor) {
			this.expectedValue = expectedValue;
			this.actualValueAccessor = actualValueAccessor;
		}
	}
	
	public enum AssertType {
	    EXCEPTION, EXPECTED_VALUE, CUSTOM_ASSERTION
	}
	
	static class VoidR {
	}
	
	private static <I> ExceptionFunction<I, VoidR> asFunc(ExceptionConsumer<I> action) {
		return i -> {
			action.accept(i);
			return null;
		};
	}
	
	@FunctionalInterface
	public interface ExceptionFunction<I, R> {
		R apply(I i) throws Exception;
	}
	
	@FunctionalInterface
	public interface ExceptionConsumer<I> {
		void accept(I i) throws Exception;
	}
	
	private <TestData, I, R> void assertion(TestData data, String methodName, I instance, Result<TestData, I, R> expectedResult, ExceptionFunction<I, R> toApply) {
		if (expectedResult == null) {
			ActualResultStorage.put(methodName, assertDoesNotThrow(() -> toApply.apply(instance)));
			return;
		}
		R actualResult = null;
		if (expectedResult.assertType.equals(AssertType.EXCEPTION)) {
			assertThrows(expectedResult.expectedException, () -> toApply.apply(instance));
		} else {
			actualResult = assertDoesNotThrow(() -> toApply.apply(instance));
			if (expectedResult.assertType.equals(AssertType.EXPECTED_VALUE) &&
					!(expectedResult.expectedReturnValue instanceof VoidR)) {
				assertEquals(expectedResult.expectedReturnValue, actualResult);
			} else if (expectedResult.assertType.equals(AssertType.CUSTOM_ASSERTION)) {
				expectedResult.customAction.accept(instance, actualResult);
			}
			if (expectedResult.sideEffects != null) {
				for (var sideEffect : expectedResult.sideEffects) {
					var sideEffectResult = sideEffect.actualValueAccessor.apply(data);
					assertEquals(sideEffect.expectedValue, sideEffectResult);
				}
			}
		}
		ActualResultStorage.put(methodName, actualResult);
	}
//endregion
}

/*
WARNING: Modification of this comment will make it impossible to merge user-defined changes

BEGIN_CODEGEN_DATA
H4sIAAAAAAAA/+0a227TSPQ5lfoPQx6QjYxLkPaFpNmGNqutRGnVhLLaCqHBmbQDju312IFulX/fMxePZ+xxacoieKA
Sjj0+99ucMybD0Sd8RVBZ0DgkXyKSFTRN2HB3Z3eHrrI0LxArcEEjlOZX4ccyoQVcM1qQPMQZDSeMkVyghFjcHqWEvU
6L+XWefh4+kMb0nxLH7KHYgrWlwUe8xqHQ8E/Mrk9wNnS8ekVZ4VrvAF+WScS5hi/pIfAuVyS/E+wPdeMCYkVO8Cqci
R9T8LbGGc7xioVn/IfAAv2XLObElLwTJ8vTNV3A8yS/AnGTgm2DdEKK63QxS8s8IkLEg1mZZTlh7C3OE5pcMa9fJiUj
i76/u5OVH2LwWBSDS9C0Cqsjskq5sOh2d6e3u7O3l5MrWEaziCQ4pymD5b29CUrIZ8TUGiwdtLT1EnhG+6h/O9igy1u
aLMiXzTt0+3zDmfcOTGG9235FfyBX+hsOpERcp3ShBRgI4tbTES4wWsAlQOAf0BPx1dfA31o4IizKqdDSF+r1JlEBUX
xOWBkXsyLNIctCRqpbzx+ivT2G14Sh4pqgXMAxlC7FY4TjmCyQ1IObpcf/4SrUPSkQv4azwckgXAlAKVVSxrH5jnzJS
FSQhRTFfMO5eL4P7uxtuDtIspAe4f7V3uEWkAv7P+qPMz+LCWYErdIFXd6AkShDjIiUQmkS3yCaCMudpAsCpqNgZpSk
BbomOaneRfAuQB9IhCFOUQpL+WcKd7RAn2kcI7kOmXzFYZMlxEfBHv1gzV0ZkeV0jQtSFUZZOEY6r8eoEfGeismcFGW
eKPgwXXp8safx9EqP82ulgXrX23uCePhA/j3ZE5LxJ52jbDSuADnkcVKQKwK+KFcf4EfgDJ49CxwgC7qmLFUwzy2QnC
zBj0kE6XaiQ90QQCTi5fN3Jo4d9zWwfDak5MBq67jJFNWJfg6nf51ND+fTo/cXk1dvpoGJVbPgdr3AcanQf6ugfHWjf
n2FDrgFWPUQIrrWpJ8N+u33RmVRYH0Bo0j9lM77iXx3OD2bH5++drpNb0wS74jyre7lzd8kT/WrUOxhD3Jncj93ngxe
KOO9gEK1xjFdKA/z69eqM1eT/SrPP0zznqrBstVptw687iL4U+3GkiY4buZcC2ssIIYK1abQzuz7UfO1KD3unVBVAZP
RRoZaSymbfk1W7Cm2YrIjWpl53uf4/aHLDqcfPkKMvM1xlpF8pErJWJWbbTBUAjlRVM2oxA4UjQAdpQBGxo1iMzSUsj
X37HIYNGtf1RBevnPXvGBbUdSuLf2lazCvg7YZxl4lkZPv5bN3ooooQnWldlHSurhJDSQpHkWSWqtSt61ZhVY7lnWVr
aajUdMgskWtQ1d1MBQ9HVdLzdk1tOaNEGpGrleUocIrUnh+UDlOPkobbe4ut2+AFy1u0CHPjF+F9wdqXuWoVarsaJ7b
JWqOUvHaynBZsJzBPqzmLgVrEfcqasGdNKwUlgiQI4Yc8k1Xj9Qt16Yh3ByJIFbsVJq4ZlAAO82PyBLDmtdRp6R8VkL
0OizuYKGMbs8oJzgbSUNVVW+MsIEL71VFUmc0UIv8pgcULTGzm7O00vp+9JqWU0R5tAjCWVl4yqWfyE0All3zxr6DSc
jBBZyEslk4D0miaxJ9kuckLiGEJ2sX2aIs5OqFKZFytjf3mxa1nS1IWASaDrY829qs5scJACQRBMhcTjyuFqDuvo3Gf
NgCUxRcI1QbWFTb0e8AXEBZZkgc8WFrx9Qlvo1dn9CNXCpEJSvS1SRyI/NjwdEM5oLpcgmM6u5njJheZc1AlbbznLYw
S4JXLwfgQCmSr45w+LV20T2pB/eU+N5SmDjbC3OHmzslcMA+2BjbRM5XBdKQDxZni1DslMYEerAgd/jlmyOo03/B/xJ
S27j0m3WRAncEwLdqskU0/E+KyKtN+Lsl+JauEnJ/Z5OE2DwrauxPzYHGPNPr2qZsHPNAyb0xSXhTDQBt7UASytABgJ
q7Tde27bKH+xRCtmFaUK1UC1BPZ83BtWrhBOokiqDRqYdws8vWMnkupsGWHCyPWpQMuzd95KDDQ8Atv6PrJTA6ms1NZ
dL6iBE1TorR4ZvZ/PTk/WQ2m55ziA6PXUDXeS7oVRzt1nl0PHZMyseBRAQLMb7oaRCdQcfCevVeYgzPdTPLzzhxxFE9
qo4JFBwvFtIYw1q2g0oAHPPjj3yJI1IbiVZLboHPFd9zBDNUfOMdI+rDBMq/1yIrTx7KzFRdcBIdvVLva9wqsxtBKGW
WRPTHN/dnQfMTHHDStavVRkuaza9yXfYq0gk3lfIgXSKveeKyL3sA5VHXyMdHFFO89pd6D2aop5pZKL1T6eD7VlzUE8
65NW+g/Tpi2nIalTck4vu+saPU5/S+HrOMb/lNUo7t+G75pciIxIw4pji9E2xhEWmQ7dU0C4SPHj/eld8THnWpaO5CF
fd0KTNf26pn/reJe1AKLL8pXZR5tlWpWeNqoRpUzE1OFxydJS6Bukxs7ouP7OjvLaGqe2ucG9sleoG6CWjEno2kI6Ne
cu0gKi54IVBSN5xhoDe2vCavCn9TKy8u90ropvWaJ5jw/B/2H6GO6iMAAA==
END_CODEGEN_DATA
*/
