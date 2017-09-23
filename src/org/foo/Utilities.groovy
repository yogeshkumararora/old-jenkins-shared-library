package org.foo
class Utilities implements Serializable {
  def steps
  Utilities(steps) {
    this.steps = steps
  }
  def checkOutFrom(repo) {
    steps.sh "rm -rf experiments"
    steps.sh "git clone 'https://github.com/yogeshkumararora/${repo}'"
  }
  def mvn(args) {
    //M3 is configured to MAVEN_HOME in Jenkins > Manage Jenkins > Global Tool Configuration > Maven 
    //> Click on "Add Maven", then give name as "M3" and MAVEN_HOME as "path/to/your/maven"
    steps.sh "cd experiments;export JAVA_HOME=${steps.tool 'Java8'};${steps.tool 'M3'}/bin/mvn -o ${args}"
  }
}
