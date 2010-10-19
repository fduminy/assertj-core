/*
 * Created on Oct 18, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.assertions.internal;

import static org.fest.assertions.error.IsEqual.isEqual;
import static org.fest.assertions.error.IsNotEqual.isNotEqual;

import org.fest.assertions.core.AssertionInfo;
import org.fest.util.VisibleForTesting;

/**
 * Reusable assertions for <code>{@link Integer}</code>s.
 *
 * @author Alex Ruiz
 */
public class Integers {

  private static final Integer ZERO = 0;

  private static final Integers INSTANCE = new Integers();

  /**
   * Returns the singleton instance of this class.
   * @return the singleton instance of this class.
   */
  public static Integers instance() {
    return INSTANCE;
  }

  @VisibleForTesting Comparables comparables = Comparables.instance();
  @VisibleForTesting Failures failures = Failures.instance();

  @VisibleForTesting Integers() {}

  /**
   * Asserts that the actual value is equal to zero.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not equal to zero.
   */
  public void assertIsZero(AssertionInfo info, Integer actual) {
    comparables.assertEqual(info, actual, ZERO);
  }

  /**
   * Asserts that the actual value is not equal to zero.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is equal to zero.
   */
  public void assertIsNotZero(AssertionInfo info, Integer actual) {
    comparables.assertNotEqual(info, actual, ZERO);
  }

  /**
   * Asserts that the actual value is negative.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not negative: it is either equal to or greater than zero.
   */
  public void assertIsNegative(AssertionInfo info, Integer actual) {
    comparables.assertLessThan(info, actual, ZERO);
  }

  /**
   * Asserts that the actual value is positive.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not positive: it is either equal to or less than zero.
   */
  public void assertIsPositive(AssertionInfo info, Integer actual) {
    comparables.assertGreaterThan(info, actual, ZERO);
  }

  /**
   * Asserts that two integers are equal.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @param expected the expected value.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not equal to the expected one. This method will throw a
   * {@code org.junit.ComparisonFailure} instead if JUnit is in the classpath and the expected and actual values are not
   * equal.
   */
  public void assertEqual(AssertionInfo info, Integer actual, int expected) {
    assertNotNull(info, actual);
    if (actual.intValue() == expected) return;
    failures.failure(info, isNotEqual(actual, expected));
  }

  /**
   * Asserts that two integers are not equal.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @param other the value to compare the actual value to.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is equal to the other one.
   */
  public void assertNotEqual(AssertionInfo info, Integer actual, int other) {
    assertNotNull(info, actual);
    if (actual.intValue() != other) return;
    failures.failure(info, isEqual(actual, other));
  }

  private void assertNotNull(AssertionInfo info, Integer actual) {
    Objects.instance().assertNotNull(info, actual);
  }
}
