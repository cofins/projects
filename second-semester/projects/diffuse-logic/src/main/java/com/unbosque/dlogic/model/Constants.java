package com.unbosque.dlogic.model;

import java.util.HashMap;

public class Constants {

  public static final HashMap<String, OperatorToken> OPERATORS;

  static {
    // Initialize operators
    OPERATORS = new HashMap<String, OperatorToken>();

    OPERATORS.put("∧", new OperatorToken(4, Math::min));
    OPERATORS.put("∨", new OperatorToken(3, Math::max));
    OPERATORS.put("~", new OperatorToken(5, (a, b) -> 1 - a));
    OPERATORS.put("→", new OperatorToken(2, (a, b) -> Math.min(1, 1 - a + b)));
    OPERATORS.put("↔", new OperatorToken(1, (a, b) -> (a == b) ? 1.0 : 0.0));
    OPERATORS.put("=", new OperatorToken(5, (a, b) -> (a == b) ? 1.0 : 0.0));
    OPERATORS.put("≤", new OperatorToken(5, (a, b) -> (a <= b) ? 1.0 : 0.0));
    OPERATORS.put("≥", new OperatorToken(5, (a, b) -> (a >= b) ? 1.0 : 0.0));
    OPERATORS.put("<", new OperatorToken(5, (a, b) -> (a < b) ? 1.0 : 0.0));
    OPERATORS.put(">", new OperatorToken(5, (a, b) -> (a > b) ? 1.0 : 0.0));
    OPERATORS.put("/", new OperatorToken(5, (a, b) -> a / b));
  }
}
