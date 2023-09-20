def info(message) {
    echo "INFO: ${message}"
}

def warning(message) {
    echo "WARNING: ${message}"
}

def call() {
    pipeline {
        agent any

        stages {
            stage('Compile') {
                steps {
                    echo 'Hello World'
                    script {
                        info 'Starting'
                        warning 'Nothing to do!'
                    }
                }
            }



            stage('Test') {
                steps {
                    echo 'Hello World'
                }
            }

            stage('Code Quality') {
                steps {
                    echo 'Hello World'
                }
            }

            stage('Code Security') {
              when {
                  allof {
                      expression {BRANCH_NAME=="main"}
                      expression {BRANCH_NAME=="test1"}
                  }

                }
                steps {
                    echo 'Hello World'
                    sh 'env'
                }
            }

            stage('release') {
                when {
                    expression {env.TAG_NAME==~".*"}
                }
                steps {
                    echo 'Hello World'
                }
            }

        }
    }
}