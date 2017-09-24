// vars/windows.groovy
def call(Closure body) {
    node('mac') {
        body()
    }
}
