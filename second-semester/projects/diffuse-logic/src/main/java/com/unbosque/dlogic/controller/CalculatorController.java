
package com.unbosque.dlogic.controller;

import com.unbosque.dlogic.model.OperatorToken;
import java.util.Stack;

import com.unbosque.dlogic.model.Constants;

public class CalculatorController {

  // properties
  private Stack<Object> stack;
  private Stack<Object> output;

  // constructor
  public CalculatorController() {
    this.stack = new Stack<Object>();
    this.output = new Stack<Object>();
  }

  private String calculate(String expression) {

    // Divide the expression by the allowed tokens
    String[] tokens = expression.split("(?<=[∧∨~→↔=≤≥<>/])|(?=[∧∨~→↔=≤≥<>/])");

    // clean the stacks
    this.stack.clear();
    this.output.clear();

    // calculation for the output stack
    for (String token : tokens) {
      if (token.matches("[0-9]*\\.?[0-9]*")) {
        this.output.push(Double.parseDouble(token));
      } else if (Constants.OPERATORS.containsKey(token)) {

        // actual operators
        OperatorToken o1 = Constants.OPERATORS.get(token);
        OperatorToken o2;

        while (stack.peek() instanceof OperatorToken) {
          o2 = (OperatorToken) stack.peek();
          if (o1.getPrecedence() <= o2.getPrecedence()) {
            this.output.push(o2);
            this.stack.pop();
          }
        }

        this.stack.push(o1);

      } else if (token == "(") {
        this.stack.push(token);
      } else if (token == ")") {

        while (this.stack.peek() != "(") {
          this.output.push(this.stack.pop());
          if (this.stack.empty()) {
            return "there are unpaired parentheses";
          }
        }
        this.stack.pop();

      }

      while (!this.stack.empty()) {
        while (this.stack.peek().toString().matches("[()]")) {
          return "there are unpaired parentheses";
        }
        this.output.push(this.stack.pop());
      }

    }

    // If there aren't any problem return null
    return null;
  }















}
