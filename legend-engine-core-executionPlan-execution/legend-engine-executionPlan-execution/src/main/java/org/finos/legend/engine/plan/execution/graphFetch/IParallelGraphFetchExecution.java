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

package org.finos.legend.engine.plan.execution.graphFetch;

import org.finos.legend.engine.plan.execution.concurrent.ParallelGraphFetchExecutionExecutorPool;

public interface IParallelGraphFetchExecution
{
    public boolean acquireThreads(ParallelGraphFetchExecutionExecutorPool graphFetchExecutionNodeExecutorPool, String threadIdentifierKey, int threadsToAcquire, Object... extra);
    public void releaseThreads(ParallelGraphFetchExecutionExecutorPool graphFetchExecutionNodeExecutorPool, String threadIdentifierKey, int threadsToRelease);
}
