pipeline {
  agent any
  stages {
    stage('Clone') {
      steps {
        git(url: 'https://github.com/GomesDosSantos/api-restful.git', branch: 'master')
      }
    }

    stage('Install') {
      steps {
        echo 'Aagawgaw'
      }
    }

    stage('Teste') {
      steps {
        withGradle() {
          sh 'gradlew test'
        }

      }
    }

  }
}