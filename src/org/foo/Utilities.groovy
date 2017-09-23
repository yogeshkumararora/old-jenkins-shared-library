package org.foo
class Utilities implements Serializable {
  def steps
  Utilities(steps) {
    this.steps = steps
  }
  def mvn(args) {
    //M3 is configured to MAVEN_HOME in Jenkins > Manage Jenkins > Global Tool Configuration > Maven 
    //> Click on "Add Maven", then give name as "M3" and MAVEN_HOME as "path/to/your/maven"
    steps.sh "echo $JAVA_HOME"
    steps.sh "${steps.tool 'M3'}/bin/mvn -o ${args}"
  }
}
