def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // now build, based on the configuration provided
    node {
        stage("1. Git Checkout") {
            git url: "https://github.com/yogeshkumararora/${config.name}.git"
        }
        stage("2. Build using Maven") { 
            sh "export JAVA_HOME=${tool 'Java8'};${tool 'M3'}/bin/mvn -o install"
        }
        stage("3. Send Email") { 
        //mail to: "", subject: "${config.name} plugin build", body: "Jenkins Shared Library!"
        }
    }
}
