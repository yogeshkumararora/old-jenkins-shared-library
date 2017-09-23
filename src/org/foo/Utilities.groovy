package org.foo
class Utilities implements Serializable {
  def steps
  Utilities(steps) {this.steps = steps}
  def mvn(args) {
    steps.sh "${steps.tool 'Java8'}" "${steps.tool 'M3'}/bin/mvn -o ${args}"
  }
}
