def call() {
    node ('workstation') {
        git branch: "${BRANCH_NAME}", url: "https//github.com/sravanreddy28/${component}"
        stage ('compile code') {
            common.compile()
        }
        stage ('test') {
            print 'hello'
        }
        stage ('code quality') {
            print 'hello'
        }
        stage ('code security') {
            print 'hello'
        }
        stage ('release') {
            print 'hello'
        }
    }
}