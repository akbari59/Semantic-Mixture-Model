/*
 * Copyright (c) 2012, Søren Atmakuri Davidsen
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package dk.aaue.sna.generate;

import org.jgrapht.Graph;
import org.jgrapht.VertexFactory;
import org.jgrapht.generate.GraphGenerator;

import java.util.Map;

/**
 * @author Soren <soren@tanesha.net>
 */
public class ErdosRenyiGraphGenerator<V, E> implements GraphGenerator<V, E, V> {

    protected GraphGenerator<V, E, V> inner;

    public ErdosRenyiGraphGenerator(int n, double p, Long seed) {
        if (p < 0.10)
            inner = new SparseErdosRenyiGraphGenerator(n, p, seed);
        else
            inner = new DenseErdosRenyiGraphGenerator(n, p, seed);
    }

    @Override
    public void generateGraph(Graph<V, E> veGraph, VertexFactory<V> vVertexFactory, Map<String, V> map) {
        inner.generateGraph(veGraph, vVertexFactory, map);
    }
}
