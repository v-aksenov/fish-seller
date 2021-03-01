pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn clean compile'
                }
                stash includes: 'target/*.jar', name: 'targetfiles'
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Run Stage') {
            steps {
                unstash 'targetfiles'
                sh 'nohup java -jar fish-seller-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}