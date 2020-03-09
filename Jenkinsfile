pipeline {
  agent any
  stages {
    stage('Clone') {
      parallel {
        stage('Clone') {
          steps {
            git(url: 'https://github.com/GomesDosSantos/api-restful.git', branch: 'master')
          }
        }

        stage('') {
          steps {
            sleep 5
          }
        }

      }
    }

    stage('Install') {
      steps {
        mail(subject: 'Teste Jenkins CI', body: 'Isto é um teste de e-mail automatizado pelo Jenkins quando houver algum commit/pull-request', to: 'guilherme.santos165@fatec.sp.gov.br', from: 'jenkins@msteams.com')
      }
    }

    stage('Teste') {
      environment {
        MENSAGEM = 'legal'
      }
      steps {
        echo '${env.MENSAGEM}'
      }
    }

  }
}