def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // now build, based on the configuration provided
    node {
        //git url: "https://github.com/jenkinsci/${config.name}-plugin.git"
        git url: "https://github.com/yogeshkumararora/${config.name}.git"
        //sh "mvn install"
        
        sh "export JAVA_HOME=${tool 'Java8'};${tool 'M3'}/bin/mvn -o install"
        mail to: "yogesh.arora@gmail.com", subject: "${config.name} plugin build", body: "Jenkins Shared Library!"
    }
}
