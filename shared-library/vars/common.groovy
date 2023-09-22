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
        print 'test'
    }
}

def codequality() {
    stage ('code quality'){
        print 'code quality'
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