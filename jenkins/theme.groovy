import jenkins.model.Jenkins;
import org.jenkinsci.plugins.simpletheme.CssUrlThemeElement;

Jenkins jenkins = Jenkins.get()

def themeDecorator = jenkins.getExtensionList(org.codefirst.SimpleThemeDecorator.class).first()

themeDecorator.setElements([
  new CssUrlThemeElement('https://cdn.rawgit.com/afonsof/jenkins-material-theme/gh-pages/dist/material-indigo.css')
])

jenkins.save()