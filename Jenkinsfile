pipeline {
    agent any

    stages {
    
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn test'
                }
            }
        }

        stage ('Package Stage') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn package'
                }
            }
        }


        stage ('Run Stage') {

            steps {
                sh """
                docker ps -a \
                    | awk '{ print \$1,\$2 }' \
                    | grep fish-seller \
                    | awk '{print \$1 }' \
                    | xargs -I {} docker rm -f {}
                """
                sh 'docker build -t fish-seller .'
                sh 'docker run -dp 8080:8080 fish-seller'
            }
        }
    }
}