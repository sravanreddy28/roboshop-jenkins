def compile() {
    stage ('compile code'){
        if (env.codeType == "maven") {
            sh '/home/centos/maven/bin/mvn package'
        }
        if (env.codeType == "nodejs") {
            print 'nodejs'
        }
        if (env.codeType == "python") {
            print 'python'
        }
        if (env.codeType == "static") {
            print 'static'
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