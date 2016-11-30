# team-city-agent-auto-auth
Team City server plugin to automatically authorize agents on register

For organizations that heavily automate their build agent infrastructure, the manual step of authorizing and unauthorizing agents can become an issue. For example, agents setup in an AWS Auto Scaling Group could appear and disappear multiple times a day.

"Agent Auto Authorize" listens for agent registrations and automatically authorizes them if they have the `auto_authorize` agent property. Additionally, if they become unregistered for any reason, they will also be unauthorized.

# Installation

1. Upload `AutoAuthorize.zip` to your TeamCity plugin directory. (If you're doing this through the UI, you can find it at https://your-teamcity/admin/admin.html?item=plugins)
2. Restart your TeamCity server
3. Add the following to your agent properties (located at `$agentDir/conf/buildAgent.properties`): `auto_authorize=true`
4. Start your build agent
5. Note that as soon as it's registered, it will also be authorized.

# Lastest Build

[AutoAuthorize.zip](https://github.com/FLGMwt/team-city-agent-auto-auth/raw/master/dist/AutoAuthorize.zip)