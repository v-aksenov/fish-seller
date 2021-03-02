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
                sh 'docker run'
            }
        }
    }
}