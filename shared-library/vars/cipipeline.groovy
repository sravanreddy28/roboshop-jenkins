def call() {
    node ('workstation') {
        sh "find . | sed -e '1d' |xargs rm -rf"
        git branch: 'main', url: "https://github.com/sravanreddy28/${component}"
////        if (env.TAG_NAME ==~ "'*") {
//            env.branch_name = "refs/tags/${env.TAG_NAME}"
//        } else {
//            env.branch_name = "${env.BRANCH_NAME}"
//        }
//        checkout scmGit(
//                branches: [[name: branch_name]],
//                userRemoteConfigs: [[url: "https://github.com/sravanreddy28/${component}"]]
//        )
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