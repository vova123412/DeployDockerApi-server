job('flask') {
  steps {
     dockerBuildAndPublish {
            repositoryName('amir2023/flask-server')
            tag('1.0')
            registryCredentials('docker_hub_credentials_id')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
            
     }
  }
  scm {
    git {
      remote {
        url('https://github.com/vova123412/flask-dockerengine.git')
        branch( 'nginx')
      }
    }
  }
}

job('nginx') {
  steps {
     dockerBuildAndPublish {
            repositoryName('amir2023/my-proxy')
            tag('1.0')
            registryCredentials('docker_hub_credentials_id')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
            
     }
  }
  scm {
    git {
      remote {
        url('https://github.com/vova123412/nginx.git')
        branch( 'main')
      }
    }
  }
}

job('deploy flusk and nginx') {
  steps {
        batchFile('docker-compose -f .\\dockerfileCompose.yaml up -d')
     }

  
    scm {
    git {
      remote {
        url('https://github.com/vova123412/flask-dockerengine.git')
        branch( 'nginx')
      }
    }
    }

}
