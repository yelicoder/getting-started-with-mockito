# getting-started-with-mockito

### Module 2
* Mockito dependency
```
<groupId>org.mockito</groupId>
<artifactId>mockito-core</artifactId>
<scope>test</scope>
```
* Testing Doubles: Double is a generic term for any case where you replace a production object for testing purpose. There are five types of test doubles
  * Dummy: Not userd in the test
  * Fake: In-memory DB, Fake web service.
  * Stub: provides 'canned' answers. Not intelligent enough to respond with anything else
  * Spy: like a more intelligent stub. Keeps track of how it was used.
  * Mock: uses expectations. Can fail the test if unexpected calls are made. The focus is on behavior verification.
* Mockito can mock either a class or an interface. In general, we should mock interface.
* The code will fail because we did not mock the return value

### Module 3
* Steps to mock a service
  * use mock(serviceName.class) or @Mock to declare the service
  * Use "when(...).thenReturn(...)" to mock a service's return value
* Difference between doReturn() and when(): 
```
https://stackoverflow.com/questions/20353846/mockito-difference-between-doreturn-and-when#:~:text=5%20Answers&text=The%20two%20syntaxes%20for%20stubbing%20are%20roughly%20equivalent.&text=Others%20include%20use%20with%20Mockito,re%20returning%2C%20at%20compile%20time.
```
  * use doReturn() where when() has issues
* anyString(), eq
* Mock an exception thrown by a service
  * when(...)thenThrow(...)
  * assertThrows(xxxx.class, () -> serviceObject.method)
* doThrow...when... for a void method
* Difference between Mockito.mock(), @Mock and @MockBean: https://www.baeldung.com/java-spring-mockito-mock-mockbean
  * Need add the following dependency to use @Mock
  ```
  <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>2.28.2</version>
            <scope>test</scope>
   </dependency>
   ```
   * Need add the following annotation to use @Mock: @ExtendWith(MockitoExtension.class)
* @RunWith is replaced by @ExtendWith in JUnit5 (junit-jupiter-engine): https://www.baeldung.com/junit-5-runwith

### Module 4
* Argument Matcher: 
```
https://javadoc.io/doc/org.mockito/mockito-core/2.7.0/org/mockito/ArgumentMatchers.html
https://javadoc.io/doc/org.mockito/mockito-core/2.7.0/org/mockito/ArgumentMatcher.html
```
  * When using argument matchers, all arguments have to be provided by matchers. "eq" should be used for the argument that has a value.
  * Since Mockito any(Class) and anyInt family matchers perform a type check, thus they won't match null arguments. Instead use the isNull matcher
* Verify is used to confirm certain method using certain arguments is called: https://www.baeldung.com/mockito-verify 
  * Argument matcher can be used in the verified method 
  * Argument Captor can be used to specify the argument of the verify method. It is treated as an argument matcher.

### Module 5
* verifyNoMoreInteractions(mocks)
* Spies are partial mocks: https://www.baeldung.com/mockito-spy
  * Use @Spy annotation to mock the service
  * Difference between @Spy and @Mock: @Spy service will call the real method. @Mock service will not call the real method.
* Testing code deals with time

### Module 6
* Behavior-driven development (BDD) is another style of mocking the service
  * Mock: BDDMockito.given(...).willReturn(...);
  * Verify: BDDMockito.then(...).should().xxx(....);
