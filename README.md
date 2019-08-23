# TeamCity Auto Agent Manager
Team City server plugin to automatically authorize agents on register, and cleanup on unregister.

For organizations that heavily automate their build agent infrastructure, the manual step of authorizing and unauthorizing agents can become an issue. For example, agents setup in an AWS Auto Scaling Group could appear and disappear multiple times a day.

"Agent Auto Authorize/Manage" listen for agent registrations/unregistrations and automatically authorize, unauthorize, and cleanup agents with the following configuration parameters:
  1. `autoAuthorize=true` for authorizing/unauthorizing agents on registration/unregistration.
  1. `autoManage=true` for cleaning up agents in addition to authorization/unauthorization.

NOTE: Because this plugin circumvents the manual agent authorization step which is guarded by TeamCity authentication, only use this if your TeamCity server is inaccessible to the public Internet. 

# Installation

1. Upload `AutoManage.zip` to your TeamCity plugin directory. (If you're doing this through the UI, you can find it at https://your-teamcity/admin/admin.html?item=plugins)
2. Instruct the TeamCity server load the plugin without a restart.
3. Add `autoAuthorize` or `autoManage` to your agent properties (located at `$agentDir/conf/buildAgent.properties`).
4. Start your build agent.
5. Note that as soon as the agent is registered, it will also be authorized.

# Latest Build

[AutoManage.zip](https://github.com/FLGMwt/team-city-agent-auto-auth/raw/master/dist/AutoManage.zip)
