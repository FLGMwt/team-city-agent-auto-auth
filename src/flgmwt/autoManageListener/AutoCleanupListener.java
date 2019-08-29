/*
 * Copyright 2000-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package flgmwt.autoManageListener;

import jetbrains.buildServer.serverSide.BuildServerAdapter;
import jetbrains.buildServer.serverSide.SBuildAgent;
import jetbrains.buildServer.serverSide.BuildAgentManager;
import jetbrains.buildServer.serverSide.SBuildServer;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


/**
 * Authorizes agents as soon as they're registered
 */
public class AutoCleanupListener extends BuildServerAdapter {
  private final SBuildServer myBuildServer;

  public AutoCleanupListener(SBuildServer sBuildServer) {
    myBuildServer = sBuildServer;
  }

  public void register() {
    myBuildServer.addListener(this);
  }

  @Override
  public void agentUnregistered(@NotNull SBuildAgent sBuildAgent) {
    Map<String,String> parameters = sBuildAgent.getAvailableParameters();
    if (parameters.containsKey("autoManage") &&
        parameters.get("autoManage").equals("true") &&
        !sBuildAgent.isUpgrading()) {
      BuildAgentManager bam = this.myBuildServer.getBuildAgentManager();
      bam.removeAgent(sBuildAgent, null);
    }
  }
}
