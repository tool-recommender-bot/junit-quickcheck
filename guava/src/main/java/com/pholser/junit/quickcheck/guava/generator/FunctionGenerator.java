/*
 The MIT License

 Copyright (c) 2010-2014 Paul R. Holser, Jr.

 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
 the following conditions:

 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.pholser.junit.quickcheck.guava.generator;

import com.google.common.base.Function;
import com.pholser.junit.quickcheck.generator.ComponentizedGenerator;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Lambdas;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

/**
 * Produces values for theory parameters of type {@code Function}.
 *
 * @param <F> parameter type of the generated functions
 * @param <T> return type of the generated functions
 */
public class FunctionGenerator<F, T> extends ComponentizedGenerator<Function> {
    public FunctionGenerator() {
        super(Function.class);
    }

    @SuppressWarnings("unchecked")
    @Override public Function<F, T> generate(SourceOfRandomness random, GenerationStatus status) {
        return (Function<F, T>) Lambdas.makeLambda(
            Function.class,
            componentGenerators().get(1),
            status);
    }

    @Override public int numberOfNeededComponents() {
        return 2;
    }
}
