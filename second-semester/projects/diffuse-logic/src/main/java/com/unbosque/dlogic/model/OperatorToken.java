package com.unbosque.dlogic.model;

import java.util.function.BiFunction;

public class OperatorToken
{
   // properties
   private int precedence;
   private BiFunction<Double, Double, Double> process;

   // constructor
   public OperatorToken(int precedence, BiFunction<Double, Double,
                                                   Double> process)
   {
      this.precedence = precedence;
      this.process    = process;
   }

   public int getPrecedence()
   {
      return this.precedence;
   }

   public BiFunction<Double, Double, Double> getProcess()
   {
      return this.process;
   }
}
