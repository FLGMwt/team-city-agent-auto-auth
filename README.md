# team-city-agent-auto-auth
Team City server plugin to automatically authorize agents on register

Rally Choice uses AWS EC2 Spot Instances for its Team City build agents. Those instances are under an auto-scaling group which will start up a new agent instance if one dies. The transient nature of these instances means that they pop in and out all the time. Since it takes a manual authorize action to authorize a newly registered agent and considerable time for a deregistered agent to let go of an authorization, we found ourselves wanting a way to automatically authorize agents.

With this plugin, agents with the property `auto_authorize=true` will be authorized as soon as they are registered with the TeamCity server. We set this property in the launch configuration of our EC2 instances so they're ready to start building as soon as they register with TeamCity.

# Installation

1. Upload `AutoAuthorize.zip` to your TeamCity plugin directory. (If you're doing this through the UI, you can find it at https://your-teamcity/admin/admin.html?item=plugins)
2. Restart your TeamCity server
3. Add the following to your agent properties (`$agentDir/conf/buildAgent.properties`): `auto_authorize=true`
4. Start your build agent
5. Note that as soon as it's registered, it will also be authorized.
