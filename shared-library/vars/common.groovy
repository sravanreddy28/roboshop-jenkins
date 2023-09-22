def compile() {
    if (env.codeType == "python" || env.codeType == "static") {
        return "Return, Do not need compilation"
    }

    stage ('compile code'){
        if (env.codeType == "maven") {
            sh '/home/centos/maven/bin/mvn package'
        }
        if (env.codeType == "nodejs") {
            sh 'npm install'
        }
    }
}

def test() {
    stage ('test cases'){
        if (env.codeType == "maven") {
//            sh '/home/centos/maven/bin/mvn test'
        }    }

    if (env.codeType == "nodejs") {
//        sh 'npm test'
    }

    if (env.codeType == "python") {
//        sh 'python3.6 -m unittest'
    }
}

def codequality() {
    stage('Code Quality') {
        env.sonaruser = sh(script: 'aws ssm get-parameter --name "sonarqube.user" --with-decryption --query="Parameter.Value" |xargs', returnStdout: true).trim()

        env.sonarpass = sh(script: 'aws ssm get-parameter --name "sonarqube.pass" --with-decryption --query="Parameter.Value" |xargs', returnStdout: true).trim()

        wrap([$class: "MaskPasswordsBuildWrapper", varPasswordPairs: [[password: sonarpass]]]) {

//            sh 'sonar-scanner -Dsonar.host.url=http://172.31.41.185:9000 -Dsonar.login=${sonaruser} -Dsonar.password=${sonarpass} -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true'
        }
    }
}

def codesecurity() {
    stage ('code security'){
        print 'code security'
    }
}

def release() {
    stage ('release'){
        print 'release'
    }
}