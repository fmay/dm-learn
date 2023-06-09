/*
* DO NOT MODIFY THIS COMMENT
* Generated by devmate
* Test model: 2fa13dbd-5e24-44d2-be7a-d6bf6a2f2e4e
*/
package util.simplesteps;

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
public class SimpleStepsTest {
	
//region Scenarios
	//A new scenario
	@ParameterizedTest(name = "{1} [{index}] {2}")
	@MethodSource({"Scenario1Source"})
	public void Scenario1Test(Scenario1TestData data, String TestName, String TestDescription) {
		ActualResultStorage.setStorage(); //saves the results of the called Methods
		
		assertion(data, data.S1M1.methodName, data.C1, data.S1M1.expectedResult, data.S1M1.call());
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
					/* SimpleSteps C1 = */ new SimpleSteps(100),
					/* S1M1 = */ new S1M1Parameters<>(
						/* Integer steps = */ 10,
						/* referencingMethodName = */ "",
						/* expectedResult = */ new Result<>(
							/* assertType = */ AssertType.EXPECTED_VALUE,
							/* sideEffects = */ List.of(
								new SideEffect<>(
									/* expectedValue = */ new SimpleSteps(110),
									/* actualValueAccessor = */ t -> t.C1
								)
							)
						)
					)
				),
				/* testCaseName = */ "p1",
				/* testCaseDescription = */ ""
			)
		);
	}
//endregion

//region Types

//=========================================================================================================================
//Please modify this section only in the Modeleditor not here in the code, because otherwise it will cause merge conflicts!
//=========================================================================================================================
	static class Scenario1TestData {
	    public final SimpleSteps C1;
	    public final S1M1Parameters<Scenario1TestData> S1M1;
	    
	    public Scenario1TestData(SimpleSteps C1, S1M1Parameters<Scenario1TestData> S1M1) {
	    	this.C1 = C1;
	    	this.S1M1 = S1M1;
	    }
	}

	static class S1M1Parameters<TestData> {
		public final String methodName = "S1M1";
	    public final ObjectWrapper<Integer> steps;
	    public final Result<TestData, SimpleSteps, VoidR> expectedResult;
		public S1M1Parameters(Integer steps, String referencingMethodName, Result<TestData, SimpleSteps, VoidR> expectedResult) {
			this.steps = new ObjectWrapper<>(steps, referencingMethodName);
	   		this.expectedResult = expectedResult;
	    }
	    
	    public ExceptionFunction<SimpleSteps, VoidR> call() {
	    	return asFunc(i ->
	    	 i.addSteps(steps.get()));
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
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
pvaaJ5jw/D8YgDtRNSIAAA==
END_CODEGEN_DATA
*/
