#!/bin/python

import ldap
from ldap.modlist import addModlist, modifyModlist


class UserManagement(object):
    def __init__(self, binddn, password):
        self.con=ldap.initialize('ldap://localhost')
        self.con.simple_bind_s(binddn,password)

    def addUser(self, name, forname, signum, mail, password):
        dn = 'uid={},ou=people,dc=example,dc=com'.format(signum)
        entry = {
          "objectClass" : [ "top", "person", "organizationalPerson", "inetOrgPerson" ],
          "uid" : [signum],
          "mail": [mail] ,
          "sn": [forname],
          "cn": ["{} {}".format(forname,name)],
          "displayName": ["{} {}".format(forname,name)],
          "userPassword": [password]
        }
        self.con.add_s(dn,addModlist(entry))

    def changePassword(self,signum,oldPassword,newPassword):
        dn = 'uid={},ou=people,dc=example,dc=com'.format(signum)
        old_value = {"userPassword":[oldPassword]}
        new_value = {"userPassword":[newPassword]} 
        return  self.con.modify_s(dn,modifyModlist(old_value,new_value))

    def deleteUser(self,signum):
        dn = 'uid={},ou=people,dc=example,dc=com'.format(signum)
        self.con.delete(dn)


          


