import jenkins.*
import hudson.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import hudson.plugins.sshslaves.*;
import hudson.model.*
import jenkins.model.*
import hudson.security.*
import jenkins.security.plugins.ldap.*
import hudson.util.Secret
import hudson.security.*
import jenkins.security.s2m.*
import jenkins.model.JenkinsLocationConfiguration

def jlc = JenkinsLocationConfiguration.get();
jlc.setUrl("https://jenkins.mela.labs")

def instance = Jenkins.getInstance()

String server = 'ldap://ldap'
String rootDN = 'dc=example,dc=com'
String userSearchBase = 'ou=people'
String userSearch = 'uid={0}'
/*String groupSearchBase = 'ou=group'
String groupSearchFilter = 'cn={0}'
LDAPGroupMembershipStrategy groupMembershipStrategy = new FromGroupSearchLDAPGroupMembershipStrategy('member={0}')
*/
groupSearchBase = null
groupSearchFilter = null
groupMembershipStrategy=null
String managerDN = 'cn=admin,dc=example,dc=com'
Secret managerPasswordSecret = Secret.fromString('password')
boolean inhibitInferRootDN = true
boolean disableMailAddressResolver =false
LDAPSecurityRealm.CacheConfiguration cache = null
LDAPSecurityRealm.EnvironmentProperty[] environmentProperties = null
String displayNameAttributeName = 'displayName'
String mailAddressAttributeName = 'name'
IdStrategy userIdStrategy = IdStrategy.CASE_INSENSITIVE
IdStrategy groupIdStrategy = IdStrategy.CASE_INSENSITIVE


SecurityRealm ldap_realm = new LDAPSecurityRealm(
  server,
  rootDN,
  userSearchBase,
  userSearch,
  groupSearchBase,
  groupSearchFilter,
  groupMembershipStrategy,
  managerDN,
  managerPasswordSecret,
  inhibitInferRootDN,
  disableMailAddressResolver,
  cache,
  environmentProperties,
  displayNameAttributeName,
  mailAddressAttributeName,
  userIdStrategy,
  groupIdStrategy
)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
/*strategy = new hudson.security.ProjectMatrixAuthorizationStrategy()
userPermissions = [
  "hudson.model.Hudson.Read",
  "hudson.model.Item.Build",
  "hudson.model.Item.Configure",
  "hudson.model.Item.Create",
  "hudson.model.Item.Delete",
  "hudson.model.Item.Discover",
  "hudson.model.Item.Read",
  "hudson.model.Item.Workspace",
  "hudson.model.Run.Delete",
  "hudson.model.Run.Update",
  "hudson.model.View.Configure",
  "hudson.model.View.Create",
  "hudson.model.View.Delete",
  "hudson.model.View.Read",
  "hudson.model.Item.Cancel"
]

adminPermissions = [
  "hudson.model.Hudson.Administer",
  "hudson.model.Hudson.ConfigureUpdateCenter",
  "hudson.model.Hudson.Read",
  "hudson.model.Hudson.RunScripts",
  "hudson.model.Hudson.UploadPlugins",
  "hudson.model.Computer.Build",
  "hudson.model.Computer.Build",
  "hudson.model.Computer.Configure",
  "hudson.model.Computer.Connect",
  "hudson.model.Computer.Create",
  "hudson.model.Computer.Delete",
  "hudson.model.Computer.Disconnect",
  "hudson.model.Run.Delete",
  "hudson.model.Run.Update",
  "hudson.model.View.Configure",
  "hudson.model.View.Create",
  "hudson.model.View.Read",
  "hudson.model.View.Delete",
  "hudson.model.Item.Create",
  "hudson.model.Item.Delete",
  "hudson.model.Item.Configure",
  "hudson.model.Item.Read",
  "hudson.model.Item.Discover",
  "hudson.model.Item.Build",
  "hudson.model.Item.Workspace",
  "hudson.model.Item.Cancel"
]

userPermissions.each {
    strategy.add(Permission.fromId(it), 'developers')
}

adminPermissions.each {
    strategy.add(Permission.fromId(it), 'admin')
}*/

instance.setAuthorizationStrategy(strategy)
instance.setSecurityRealm(ldap_realm)
instance.save()
