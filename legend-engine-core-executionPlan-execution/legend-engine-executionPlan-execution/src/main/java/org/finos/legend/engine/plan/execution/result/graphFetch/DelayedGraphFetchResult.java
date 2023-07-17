// Copyright 2023 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.plan.execution.result.graphFetch;

import org.finos.legend.engine.plan.execution.result.Result;
import org.finos.legend.engine.plan.execution.result.ResultVisitor;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class DelayedGraphFetchResult extends Result
{
    private final Runnable parentAdder;
    private final Callable<List<DelayedGraphFetchResultWithExecInfo>> childVisitor;

    public DelayedGraphFetchResult(Runnable parentAdder, Callable<List<DelayedGraphFetchResultWithExecInfo>> executeTempTableChild)
    {
        super("success");
        this.parentAdder = parentAdder;
        this.childVisitor = executeTempTableChild;
    }

    @Override
    public <T> T accept(ResultVisitor<T> resultVisitor)
    {
        return null;
    }

    public void addNodeToParent()
    {
        parentAdder.run();
    }

    public List<DelayedGraphFetchResultWithExecInfo> visitChildren() throws Exception
    {
        return childVisitor.call();
    }
}

