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
  * use mock(serviceName.class) to declare the service or use @Mock to declare the service
  * Use "when(...).thenReturn(...)" to mock a service's return value
* Difference between doReturn() and when(): 
```
https://stackoverflow.com/questions/20353846/mockito-difference-between-doreturn-and-when#:~:text=5%20Answers&text=The%20two%20syntaxes%20for%20stubbing%20are%20roughly%20equivalent.&text=Others%20include%20use%20with%20Mockito,re%20returning%2C%20at%20compile%20time.
```
  * use doReturn() where when() has issues
* anyString(), eq
* when...thenThrow..., AssertThrow
* doThrow...when... for a void method
* Difference between Mockito.mock(), @Mock and @MockBean: https://www.baeldung.com/java-spring-mockito-mock-mockbean
* @RunWith is replaced by @ExtendWith in JUnit5 (junit-jupiter-engine): https://www.baeldung.com/junit-5-runwith

### Module 4
* Argument matcher for verification
* Argument Captor

### Module 5
* verifyNoMoreInteractions(mocks)
* Spies are partial mocks
* doReturn(...) when (...)
