package org.foo
class Utilities implements Serializable {
  def steps
  Utilities(steps) {
    this.steps = steps
  }
  def checkOutFrom(repo) {
   //steps.sh "git clone 'https://github.com/yogeshkumararora/${repo}'"
    steps.sh "git url: 'https://github.com/yogeshkumararora/${repo}'"
   //steps.sh "cd experiments"
    
    
  }
  def mvn(args) {
    //M3 is configured to MAVEN_HOME in Jenkins > Manage Jenkins > Global Tool Configuration > Maven 
    //> Click on "Add Maven", then give name as "M3" and MAVEN_HOME as "path/to/your/maven"
    
    steps.sh "export JAVA_HOME=${steps.tool 'Java8'};${steps.tool 'M3'}/bin/mvn -o ${args}"
  }
}
